package pers.text.bizimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import pers.text.bean.DocTypeBean;
import pers.text.bean.ParameterBean;
import pers.text.bean.UploadBean;
import pers.text.biz.MofileBiz;
import pers.text.dao.IMofileDao;
import pers.text.tool.MyBatisTool;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 下载业务实现类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-05 22:14 
*/ 
@Service
public class MofileBizImpl implements MofileBiz{

	private SqlSession session;
	private IMofileDao imofileDao;//下载文档Dao
	@Resource
	private IMofileDao iMofileDao;
	public MofileBizImpl() {
		// TODO Auto-generated constructor stub
//		session = MyBatisTool.getSession();
//		imofileDao = session.getMapper(IMofileDao.class);
	}
	//查询所有的文档类型
	@Override
	public List<DocTypeBean> docType() {
		// TODO Auto-generated method stub
		
		
	/*	List<DocTypeBean> list = imofileDao.docType();
		
		session.commit();*/
		return iMofileDao.docType();
	}
	//分页查询所有上传文件
	@Override
	public List<UploadBean> allUpload(UploadBean ulb) {
		// TODO Auto-generated method stub
		/*List<UploadBean> list = imofileDao.allUpload(ulb);
		session.commit();*/
		return iMofileDao.allUpload(ulb);
	}
	//改变上传文件审核状态
	@Override
	public boolean changeAuditStatus(UploadBean ulb) {
		// TODO Auto-generated method stub
	/*	boolean b = imofileDao.changeAuditStatus(ulb);
		session.commit();*/
		return iMofileDao.changeAuditStatus(ulb);
	}
	//查询对应条件的文件有几条数据
	@Override
	public Integer documentAount(UploadBean ulb) {
		// TODO Auto-generated method stub
		/*Integer it = imofileDao.documentAount(ulb);*/
		return iMofileDao.documentAount(ulb);
	}
	//查询文档的所有审核状态
	@Override
	public List<ParameterBean> auditType(Integer parid) {
		// TODO Auto-generated method stub
		/*List<ParameterBean> list = imofileDao.auditType(parid);*/
		return iMofileDao.auditType(parid);
	}
	//模糊查询审核通过的上传文档
	@Override
	public List<UploadBean> assignDocument(UploadBean ulb) {
		// TODO Auto-generated method stub
/*		List<UploadBean> list = imofileDao.assignDocument(ulb);*/
		return iMofileDao.assignDocument(ulb);
	}

}
