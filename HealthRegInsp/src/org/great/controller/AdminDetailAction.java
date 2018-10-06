package org.great.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.bean.TermBean;
import org.great.biz.ParticularBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 细项配置管理 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-26 09:43 
*/ 
@Controller
@RequestMapping("/adminDetailAction")

public class AdminDetailAction {
	
	@Resource
	private ParticularBiz particularBizImpl;//细项业务接口
	
	@Resource
	private TermBean termBean;//细项实体类
	ModelAndView mav = new ModelAndView();
	
	/*
	 * @Description:分页 模糊 条件 查询细项信息 
	* @param page 页码
	* @param termName 模糊查询细项名
	* @return（展示方法参数和返回值）
	 */
	@RequestMapping("/selectDetail.action")
	public ModelAndView selectDetail(Model model,TermBean termBean,@RequestParam Integer page,String termName) {
		
		if(termName.equals("请输入细项名")) {
			termName = "";
			termBean.setTerm("");
		}else {
			termBean.setTerm(termName);
		}
		
		//调用插叙细项总数
		Integer sum = particularBizImpl.selectTermSum(termBean);
		
		model.addAttribute("sum", sum);
		
		Integer p = (int) Math.ceil(Double.valueOf(sum)/10);
		
		model.addAttribute("p", p);
		
		if(page<1) {
			page = 1;
		}else if(page>p){
			page = page - 1;
			
		}
		//调用模糊条件分页查询细项方法
		List<TermBean> list = particularBizImpl.selectTerm(termBean, page);
		
		model.addAttribute("list", list);
		
		if(termName.equals("")) {
			termName = "请输入细项名";
		}
		
		model.addAttribute("termName", termName);
		model.addAttribute("page", page);
		mav.setViewName("BackEnd/admin_Detail");
		
		return mav;	
	}
	/*
	 * @Description:增加细项 
	* @return 返回一个跳转页面地址
	 */
	@RequestMapping("/addDetail.action")
	public ModelAndView addDetail(@RequestParam String term,String downLimit,
			String upLimit,String measur,String none) {
		TermBean tb = new TermBean();
//		System.out.println(term);
//		System.out.println(downLimit);
//		System.out.println(upLimit);
//		System.out.println(measur);
//		System.out.println(none);
		tb.setTerm(term);
		tb.setDownLimit(downLimit);
		tb.setUpLimit(upLimit);
		tb.setMeasur(measur);
		tb.setNone(none);
		
		//调用增加细项方法
		particularBizImpl.addTerm(tb);
		
		//分页 模糊 条件 查询细项信息 的action
		String url = "redirect:/adminDetailAction/selectDetail.action?page=1&termName=";
		return new ModelAndView(url);
		
	}
	/*
	 * @Description:进入修改细项界面 
	* @param termBean
	* @return 返回一个细项实体类
	 */
	@RequestMapping("/modifyInterface.action")
	@ResponseBody
	public TermBean modifyInterface(TermBean termBean) {
//		System.out.println(termBean.getTermId());
		//调用查询单个细项方法
		TermBean tb = particularBizImpl.selectOneTerm(termBean.getTermId());
		return tb;
		
	}
	/*
	 * @Description:修改细项信息 
	* @return：返回一个跳转页面地址
	 */
	@RequestMapping("/upDateDetail.action")
	public ModelAndView upDateDetail(@RequestParam String term,String downLimit,
			String upLimit,String measur,String none,Integer id) {
		TermBean tb = new TermBean();
		
		tb.setTermId(id);
		tb.setTerm(term);
		tb.setDownLimit(downLimit);
		tb.setUpLimit(upLimit);
		tb.setMeasur(measur);
		tb.setNone(none);
		
		System.out.println(tb.toString());
		//调用细项修改方法
		particularBizImpl.upDateTerm(tb);
		
		//分页 模糊 条件 查询细项信息 的action
		String url = "redirect:/adminDetailAction/selectDetail.action?page=1&termName=";
		return new ModelAndView(url);
		
	}
	
	/*
	 * @Description:删除细项 
	* @return 返回一个跳转页面地址
	 */
	@RequestMapping("/deleteDetail.action")
	public ModelAndView deleteDetail(@RequestParam Integer id) {
		
		//调用细项删除方法
		particularBizImpl.deleteTerm(id);
		
		//删除项目细项关系中关于细项的数据
		particularBizImpl.deleteTermCom(id);
		
		//分页 模糊 条件 查询细项信息 的action
		String url = "redirect:/adminDetailAction/selectDetail.action?page=1&termName=";
		return new ModelAndView(url);
	}

	/*
	 * @Description:细项查重
	* @param termBean
	* @return（展示方法参数和返回值）
	 */
	@RequestMapping("/repetitionDetail.action")
	@ResponseBody
	public Map<String,Object> repetitionDetail(TermBean termBean){
//		System.out.println(termBean.toString());
		Map<String,Object> map = new HashMap<String,Object>();
		if(!termBean.getTerm().equals("")) {
		//调用细项查重方法
		List<TermBean> list = particularBizImpl.repetitionTerm(termBean.getTerm());
		
			if(list.size()==0) {
				map.put("hint", "尚未增加");
			}else {
				map.put("hint", "已经增加");
			}
		}else {
			map.put("hint", "不能为空");
		}
		return map;
		
	}
}
