package cn.tedu.store.util;
/**
 * 封装服务器端向客户端响应结果的类
 * @author JAVA
 *
 * @param <T> 响应数据
 */
public class JsonResult<T> {
	
	private Integer state;//返回给客户端的状态
	private String message;//返回给客户端的信息
	private T data;//返回给客户端具体的数据
	
	
	public JsonResult() {
		super();
	}
	
	public JsonResult(Integer state) {
		super();
		this.state = state;
	}
	
	
	public JsonResult(Throwable e) {
		super();
		this.message = e.getMessage();
	}


	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public JsonResult(Integer state, String message, T data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}

	public JsonResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}
	
	
}
