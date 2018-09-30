package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.ItemComBean;
import org.great.bean.LitemBean;
import org.great.bean.TermBean;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 项目业务抽象类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-25 20:34 
*/ 
public interface ItemBiz {

	//增加项目对应的细项
	public void addItemDetail(ItemComBean itemComBean);
	
	//查询项目的Id	
	public Integer selectItemId(@Param("itemname") String itemname);
	
	//查询项目不包含的细项
	public List<TermBean> selectNinTerm(LitemBean litemBean);
	
	//修改项目信息
	public void upDateTitem(LitemBean litemBean);
	
	//删除指定项目的细项
	public void delTitem(LitemBean litemBean);
	
	//删除项目
	public void deleteItem(LitemBean litemBean);
	
	//项目名查重
	public List<LitemBean> duplicateChecking(LitemBean litemBean);
}
