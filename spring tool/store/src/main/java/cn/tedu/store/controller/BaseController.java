package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;


import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.tedu.store.controller.ex.FileEmptyException;
import cn.tedu.store.controller.ex.FileIOException;
import cn.tedu.store.controller.ex.FileSizeException;
import cn.tedu.store.controller.ex.FileStateException;
import cn.tedu.store.controller.ex.FileTypeException;
import cn.tedu.store.controller.ex.FileUploadException;
import cn.tedu.store.service.ex.AddressSizeException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
import cn.tedu.store.util.JsonResult;

/**
 * 控制器的基类
 * 
 * @author JAVA
 *
 */
public class BaseController {
	/**
	 * 响应状态:成功
	 */
	protected static final int OK = 2000;
	

	/**
	 * 从session中获取uid
	 * @param session Httpsession对象
	 * @return 返回uid
	 */
	protected Integer getUidFromSession(HttpSession session) {	
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
	
	
	/**
	 * 从session中获取username
	 * @param session Httpsession对象
	 * @return 返回username
	 */
	protected String getUsernameFromSession(HttpSession session) {	
		return session.getAttribute("username").toString();
	}
	
	
	@ExceptionHandler({ServiceException.class,FileUploadException.class})
	public JsonResult<Void> handleException(Throwable e) {
		JsonResult<Void> jr = new JsonResult<Void>(e);

		if (e instanceof UsernameDuplicateException) {
			jr.setState(4000);
		} else if (e instanceof UserNotFoundException) {
			jr.setState(4001);
		} else if (e instanceof PasswordNotMatchException) {
			jr.setState(4002);
		} else if (e instanceof InsertException) {
			jr.setState(5000);
		} else if (e instanceof UpdateException) {
			jr.setState(4003);
		}else if (e instanceof FileEmptyException) {
			jr.setState(6001);
		}else if (e instanceof FileIOException) {
			jr.setState(6002);
		}else if (e instanceof FileSizeException) {
			System.out.println("BaseController");
			jr.setState(6003);
		}else if (e instanceof FileStateException) {
			jr.setState(6004);
		}else if (e instanceof FileTypeException) {
			jr.setState(6005);
		}else if (e instanceof AddressSizeException) {
			jr.setState(7000);
		}


	//	switch(e.getClass().getSimpleName()) { 
	//	case "UsernameDuplicateException":
	//		jr.setState(4000);
	//	case "UserNotFoundException":
	//		jr.setState(4001); 
	//	case "PasswordNotMatchException": 
	//		jr.setState(4002); 
	//	case "InsertException":
	//		jr.setState(5000);
	//		break; 
	//	}



		return jr;
	}

}