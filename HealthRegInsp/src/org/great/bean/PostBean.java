package org.great.bean;

/*
 * 职务表
 * 
 */
public class PostBean {
     private int postId;//职务ID
     private String post;//职务
     
     public PostBean(){
    	 
     }
     
	public PostBean(int postId, String post) {
		super();
		this.postId = postId;
		this.post = post;
	}
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
     
     
}
