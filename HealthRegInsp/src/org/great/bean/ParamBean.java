package org.great.bean;

/*
 * 参数表
 * 
 */
public class ParamBean {
      private int paramId;//参数ID
      private String param;//参数名称
      private int parId;//所属父级ID
      
      public ParamBean() {
    	  
      }
      
	public ParamBean(int paramId, String param, int parId) {
		super();
		this.paramId = paramId;
		this.param = param;
		this.parId = parId;
	}
	public int getParamId() {
		return paramId;
	}
	public void setParamId(int paramId) {
		this.paramId = paramId;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public int getParId() {
		return parId;
	}
	public void setParId(int parId) {
		this.parId = parId;
	}
      
      
}
