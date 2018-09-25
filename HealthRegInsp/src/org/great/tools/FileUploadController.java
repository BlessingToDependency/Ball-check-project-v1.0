package org.great.tools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("fileUploadController")
public class FileUploadController { 
	
	@RequestMapping("fileUploadController.action")
	public String handleFormUpload(@RequestParam("name") String name, 
			@RequestParam("file") MultipartFile file)throws Exception {
		System.out.println("上传文件");
		if (!file.isEmpty()) { 
			byte[] bytes = file.getBytes(); 
			System.out.println(file);
			// store the bytes somewhere 
			return"redirect:uploadSuccess"; 
		} else { 
			return"redirect:uploadFailure"; 
		} 
	} 
}