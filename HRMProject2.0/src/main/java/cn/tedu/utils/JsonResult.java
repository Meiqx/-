package cn.tedu.utils;

public class JsonResult {
	
	private Integer state;
	private String message;
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + "]";
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

}
