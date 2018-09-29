package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.ItemComBean;
import org.great.bean.LitemBean;
import org.great.bean.TermBean;
import org.great.mapper.IItemService;
import org.springframework.stereotype.Service;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description:  项目业务抽象实现类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-25 20:36 
*/ 
@Service
public class ItemBizImp implements ItemBiz{

	@Resource
	private IItemService iItemService;//项目接口
	
	//增加项目对应的细项
	@Override
	public void addItemDetail(ItemComBean itemComBean) {
		// TODO Auto-generated method stub
		iItemService.addItemDetail(itemComBean);
	}
	
	//查询项目的Id	
	@Override
	public Integer selectItemId(String itemname) {
		// TODO Auto-generated method stub
		Integer id = iItemService.selectItemId(itemname);
		return id;
	}
	
	//查询项目不包含的细项
	@Override
	public List<TermBean> selectNinTerm(LitemBean litemBean) {
		// TODO Auto-generated method stub
		List<TermBean> list = iItemService.selectNinTerm(litemBean);
		return list;
	}

	//修改项目信息
	@Override
	public void upDateTitem(LitemBean litemBean) {
		// TODO Auto-generated method stub
		iItemService.upDateTitem(litemBean);
	}

	//删除指定项目的细项
	@Override
	public void delTitem(LitemBean litemBean) {
		// TODO Auto-generated method stub
		iItemService.delTitem(litemBean);
	}

	//删除项目
	@Override
	public void deleteItem(LitemBean litemBean) {
		// TODO Auto-generated method stub
		iItemService.deleteItem(litemBean);
		
	}

	//项目名查重
	@Override
	public List<LitemBean> duplicateChecking(LitemBean litemBean) {
		// TODO Auto-generated method stub
		List<LitemBean> list = iItemService.duplicateChecking(litemBean);
		return list;
	}

}
