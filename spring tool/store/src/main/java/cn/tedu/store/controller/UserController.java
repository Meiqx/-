package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.controller.ex.FileEmptyException;
import cn.tedu.store.controller.ex.FileIOException;
import cn.tedu.store.controller.ex.FileSizeException;
import cn.tedu.store.controller.ex.FileStateException;
import cn.tedu.store.controller.ex.FileTypeException;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.util.JsonResult;
/**
 * 处理用户数据请求的相关类
 * @author JAVA
 *
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{
	@Autowired
	private IUserService userService;

	@RequestMapping("reg")
	public JsonResult<Void> reg(User user){			
		userService.reg(user);	
		return new JsonResult<>(OK);	
	}

	@RequestMapping("login")
	public JsonResult<User> login(String username,String password,HttpSession session) {
		User data = userService.login(username,password);
		System.err.println(username+password);
		session.setAttribute("uid", data.getUid());
		session.setAttribute("username", data.getUsername());
		return new JsonResult<>(OK,data);
	}

	@RequestMapping("changePassword")
	public JsonResult<Void> changePassword(@RequestParam("old_password")String oldPassword,@RequestParam("new_password")String newPassword,HttpSession session){
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		userService.changePassword(username,oldPassword,newPassword,uid);
		System.err.println(uid);
		return new JsonResult<>(OK);
	}

	@GetMapping("get_by_uid")
	public JsonResult<User> getByUid(HttpSession session){
		Integer uid = getUidFromSession(session);
		User data = userService.getUserByUid(uid);						
		return new JsonResult<>(OK,data);
	}

	@RequestMapping("change_info")
	public JsonResult<Void> updateUserInfo(User user,HttpSession session){
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		userService.changeInfo(uid, username, user);	
		return new JsonResult<>(OK);

	}

	@GetMapping("logout")
	public JsonResult<Void> logout(HttpSession session){
		session.invalidate();
		return new JsonResult<>(OK);

	}  

	public static final long AVATAR_MAX_SIZE = 750 * 1024;
	public static final List<String> AVATAR_CONTENT_TYPES = new ArrayList<>();
	//静态块或构造方法
	static {
		AVATAR_CONTENT_TYPES.add("image/jpg");
		AVATAR_CONTENT_TYPES.add("image/gif");
		AVATAR_CONTENT_TYPES.add("image/png");
		//AVATAR_CONTENT_TYPES.add("image/jpeg");
	}
	
	@PostMapping("change_avatar")
	public JsonResult<String> changeAvatar(
		@RequestParam("avatar") MultipartFile avatar, 
		HttpSession session) {
		// 检查上传的文件是否为空
		
		if (avatar.isEmpty()) {
			throw new FileEmptyException("请选择有效的头像文件");
		}
		System.err.println("1.FileSizeException");
		// 检查上传的文件的大小是否超出了限制
		if (avatar.getSize() > AVATAR_MAX_SIZE) {
			System.err.println("2.FileSizeException");
			throw new FileSizeException("不允许使用超过" + AVATAR_MAX_SIZE/1024 + "KB的头像文件");
		}
		System.err.println("3.FileTypeException");
		// 检查上传的文件的类型是否超出了限制
		if (!AVATAR_CONTENT_TYPES.contains(avatar.getContentType())) {
			System.err.println("不支持此类型");
			throw new FileTypeException("上传的文件类型(" + avatar.getContentType() + ")有误，仅允许上传以下格式的头像文件：" + AVATAR_CONTENT_TYPES);
		}
		System.err.println("4.FileTypeException");
		
		// 获取原始文件名
		String originalFilename = avatar.getOriginalFilename();
		
		// 文件夹
		String parentPath = session.getServletContext().getRealPath("upload");
		File parent = new File(parentPath);
		if (!parent.exists()) {
			parent.mkdirs();
		}
		
		// 文件名
		String suffix = "";
		int beginIndex = originalFilename.lastIndexOf(".");
		if (beginIndex > 0) {
			suffix = originalFilename.substring(beginIndex);
		}
		String filename = UUID.randomUUID().toString() + suffix;
		
		// 用于保存上传的文件的对象
		File dest = new File(parent, filename);
		// 保存客户端上传的文件
		try {
			avatar.transferTo(dest);
		} catch (IllegalStateException e) {
			throw new FileStateException("文件状态异常，请重新选择文件并再次上传");
		} catch (IOException e) {
			throw new FileIOException("上传时出现读写错误，请重新上传");
		}

		// 将文件的路径存储到数据表中
		String avatarPath = "/upload/" + filename;
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		userService.changeAvatar(uid, username, avatarPath);

		// 响应：OK, 头像路径
		return new JsonResult<>(OK,avatarPath);
	}


}
