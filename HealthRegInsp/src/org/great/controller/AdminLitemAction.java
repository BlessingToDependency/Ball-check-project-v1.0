package org.great.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.great.bean.ItemComBean;
import org.great.bean.LitemBean;
import org.great.bean.TermBean;
import org.great.biz.AdminBiz;
import org.great.biz.ItemBiz;
import org.great.biz.ParticularBiz;
import org.great.biz.ParticularBizImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

/*
 * 项目管理
 */
@Controller
@RequestMapping("/adminLitemAction")
public class AdminLitemAction {

	@Resource
	private AdminBiz adminBizImp;
	
	@Resource
	private ParticularBiz particularBizImpl;
	
	@Resource
	private LitemBean litemBean;//项目实体类
	
	@Resource
	private ItemBiz itemBizImp;
	
	@Resource
	private TermBean termBean;//细项实体类
	
	@Resource
	private ItemComBean itemComBean;//项目细项关系实体类

	ModelAndView mav = new ModelAndView();
	/*
	 *增加项目
	 */
	@RequestMapping("/addItem.action")
	public ModelAndView addItem(HttpServletRequest request,
			@RequestParam String[] chbname,String term,String price,String introd) {
		
//		System.out.println(term);
//		System.out.println(price);
//		System.out.println(introd);
		litemBean.setItem(term);//项目名
		litemBean.setPrice(Integer.valueOf(price));//单价
		litemBean.setIntrod(introd);//简介
		
		adminBizImp.addItem(litemBean);//调用增加项目方法
//		System.out.println("进入");
		Integer id = itemBizImp.selectItemId(term);//调用查询项目id
		itemComBean.setItemId(id);
		for(int i=0;i<chbname.length;i++) {
//			System.out.println(chbname[i]);
			itemComBean.setTermId(Integer.valueOf(chbname[i]));
			itemBizImp.addItemDetail(itemComBean);//增加项目里的细项
		}

		String url = "redirect:/adminLitemAction/selectItem.action?page=1&itemName=&peakPrice=&bottomPrice=";
		return new ModelAndView(url);
		
	}
	
	/*
	 *查看项目详情
	 */
	@RequestMapping(value="/activity.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> Activity(Model model,LitemBean litemBean,HttpServletResponse response) {
		//Map<String,Object> maps = new Hashtable<String, Object>();
		//System.out.println(litemBean.getItemId());
		
		String peakPrice = "";
		String bottomPrice = "";
		String rank = "";
		Integer page = 1;
		
		//调用查询项目方法
		List<LitemBean> list = adminBizImp.selectLitem(litemBean, peakPrice, bottomPrice, rank, page);
		
		//调用查询对应项目细项信息
		List<TermBean> termList = adminBizImp.selectTerm(litemBean);
//		System.out.println(termList.toString());
		
		
		Map<String,Object> maps = new HashMap<String, Object>();
		
		maps.put("list", list);
		maps.put("termList", termList);

		return maps;
	}
	/*
	 * 查询项目(模糊 分页 条件)
	 */
	@RequestMapping("/selectItem.action")
	public ModelAndView selectItem(HttpServletRequest request,Model model,
			@RequestParam String itemName,String peakPrice,String bottomPrice,Integer page) {
//		String peakPrice = "";//最高价格
//		String bottomPrice = "";//最低价格
		String rank = "";//排列顺序
//		Integer page = 1;//页数
//		System.out.println(peakPrice);
//		System.out.println(page);
//		System.out.println(itemName);
		if(peakPrice.equals("请输入最低价格")) {
			peakPrice = "";//最高价格
		}
		if(bottomPrice.equals("请输入最高价格")) {
			bottomPrice = "";//最低价格
		}
		if(itemName.equals("请输入项目名")) {
			itemName = "";
			litemBean.setItem("");
		}else {
			litemBean.setItem(itemName);
		}
		//查询项目的总数
		Integer sum = adminBizImp.selectLitemSum(litemBean, peakPrice, bottomPrice);
		
		model.addAttribute("sum", sum);
		
		Integer p = (int) Math.ceil(Double.valueOf(sum)/10);
		model.addAttribute("p", p);
		
		if(page<1) {
			page = 1;
		}else if(page>p) {
			page = page - 1;
		}
		
		//调用查询项目方法
		List<LitemBean> list = adminBizImp.selectLitem(litemBean, peakPrice, bottomPrice, rank, page);
		
		//调用SpingMVC的封装方法  和request的返回方法一致
		model.addAttribute("list", list);
		
				
		if(peakPrice.equals("")) {
			peakPrice = "请输入最低价格";//最高价格
		}
		if(bottomPrice.equals("")) {
			bottomPrice = "请输入最高价格";//最低价格
		}
		if(itemName.equals("")) {
			itemName = "请输入项目名";
		}
		
		model.addAttribute("peakPrice", peakPrice);
		model.addAttribute("bottomPrice", bottomPrice);
		model.addAttribute("itemName", itemName);		
		model.addAttribute("page", page);
		model.addAttribute("litemBean", litemBean);
		
		mav.setViewName("BackEnd/admin_Item");
		
		return mav;
	}
	/*
	 * 进入添加项目界面
	 */
	@RequestMapping(value="/selectAllTerm.action",method=RequestMethod.POST)
	@ResponseBody
	public List<TermBean> selectAllTerm() {
		
//		System.out.println("11111");
		//调用查询所有细项方法
		List<TermBean> list = particularBizImpl.selectAllTerm();
		
//		System.out.println(list.toString());
		
		return list;
	}
	/*
	 * 进入修改项目模态框
	 */
	@RequestMapping(value="amendItem.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> amendItem(LitemBean litemBean) {
		
		String peakPrice = "";
		String bottomPrice = "";
		String rank = "";
		Integer page = 1;
		
		//调用查询项目方法
		List<LitemBean> list = adminBizImp.selectLitem(litemBean, peakPrice, bottomPrice, rank, page);
		
		//调用查询对应项目细项信息
		List<TermBean> termList = adminBizImp.selectTerm(litemBean);
		
		//查询项目不包含的细项方法
		List<TermBean> allTlist = itemBizImp.selectNinTerm(litemBean);
//		System.out.println(termList.toString());
		
		
		Map<String,Object> maps = new HashMap<String, Object>();
		
		maps.put("list", list);
		maps.put("termList", termList);
		maps.put("allTlist", allTlist);
		
		return maps;
		
	}
	
	/*
	 *增加项目
	 */
	@RequestMapping("/upDateItem.action")
	public ModelAndView upDateItem(HttpServletRequest request,
			@RequestParam String[] chbname,String item,String price,String introd,String id) {
		LitemBean lb = new LitemBean();
//		System.out.println(id);
//		System.out.println(price);
//		System.out.println(introd);
		lb.setItemId(Integer.valueOf(id));
		lb.setItem(item);//项目名
		lb.setPrice(Integer.valueOf(price));//单价
		lb.setIntrod(introd);//简介
		
		//调用更新
		itemBizImp.upDateTitem(lb);
		//调用删除
		itemBizImp.delTitem(lb);
//		
//		adminBizImp.addItem(litemBean);//调用增加项目方法
////		System.out.println("进入");
//		Integer id = itemBizImp.selectItemId(term);//调用查询项目id
		itemComBean.setItemId(Integer.valueOf(id));
		for(int i=0;i<chbname.length;i++) {
//			System.out.println(chbname[i]);
			itemComBean.setTermId(Integer.valueOf(chbname[i]));
			itemBizImp.addItemDetail(itemComBean);//增加项目里的细项
		}

//
		String url = "redirect:/adminLitemAction/selectItem.action?page=1&itemName=&peakPrice=&bottomPrice=";
		return new ModelAndView(url);

		
	}
	/*
	 *删除项目
	 */
	@RequestMapping("/delItem.action")
	public ModelAndView delItem(HttpServletRequest request,
			@RequestParam String id) {
		LitemBean lb = new LitemBean();

		lb.setItemId(Integer.valueOf(id));
		//调用删除对应项目的细项
		itemBizImp.delTitem(lb);
		
		//删除项目
		itemBizImp.deleteItem(lb);

		String url = "redirect:/adminLitemAction/selectItem.action?page=1&itemName=&peakPrice=&bottomPrice=";
		return new ModelAndView(url);

		
	}
}

