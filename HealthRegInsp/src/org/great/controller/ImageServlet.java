package org.great.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.tools.ImageUtil;



/**
 * Servlet implementation class ImageServlet
 * 注解
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //map
		 Map<String, BufferedImage> imageb = ImageUtil.createImage();
		 //遍历，得到验证码
		 String code = imageb.keySet().iterator().next();
		 //取出value,得到图片
		 BufferedImage image = imageb.get(code);
		 
		 //验证码存入session
		 request.getSession().setAttribute("keyCode", code);
		 
		 //输出图片
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);//图片，扩展名，输出
		 
	}
}
