package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	
//	单个文件上传和固定数量文件上传，只有在action中略有不同，单个文
//
//	件的file,filename,filecontenttype都是单值，而固定数量文件的这三个值均为
//
//	多值，即可采用list或数组的方式来接收，然后遍历集合或数组进行文件运读写
//
//	操作即可，但页面上的几个file控件的name要相同

	/**
	 * 
	 */

	private String username;

	private String password;

	private List<File> myfile; // 对应页面的file控件的name

	private List<String> myfileFileName; // 对应上传的文件名，命名方式：myfile(对应页面上的file控件的name)+FileName（固定）

	private List<String> myfileContentType;// 对应上传的文件类型，命名方式：myfile(对应页面上的file控件的name)+ContentType（固定）

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<File> getMyfile() {
		return myfile;
	}

	public void setMyfile(List<File> myfile) {
		this.myfile = myfile;
	}

	public List<String> getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(List<String> myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public List<String> getMyfileContentType() {
		return myfileContentType;
	}

	public void setMyfileContentType(List<String> myfileContentType) {
		this.myfileContentType = myfileContentType;
	}

	public String execute() throws Exception {
		for (int i = 0; i < this.getMyfile().size(); i++) {

			InputStream is = new FileInputStream(this.getMyfile().get(i)); // 构建输入流

			String root = ServletActionContext.getRequest().getRealPath(
					"/upload"); // 设置文件上传的路径
			System.out.println(root);
			File destFile = new File(root, this.getMyfileFileName().get(i));// 构建文件
			// root:上传路径，this.getMyfileFileName():上传后生成的文件名

			OutputStream os = new FileOutputStream(destFile); // 构建输出流

			byte[] buffer = new byte[400]; // 以下为读写文件操作

			int length = 0;

			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
		}

		return "result";
	}
}
