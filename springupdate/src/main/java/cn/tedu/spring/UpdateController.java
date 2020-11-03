package cn.tedu.spring;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UpdateController {

	@RequestMapping("upload.do")
	public String handleUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		
		System.out.println("UpdateController.handele运行");
		//获取原始文件名,即所上传的文件在客户端计算机中的文件名
		String originalFileName = file.getOriginalFilename();
		System.out.println("originalFileName="+originalFileName);	
		
		long size = file.getSize();
		System.out.println("size="+size);
		
		String contextType = file.getContentType();
		System.out.println("contex tType="+contextType);
		
		InputStream is = file.getInputStream();
		
		
		is.close();
		
		//获取文件后缀名
		int beginIndex = originalFileName.lastIndexOf(".");
		
		//对没有文件扩展名和对.xxx隐藏文件的操作
		String suffix = "";
		if(beginIndex > 0) {		
			suffix = originalFileName.substring(beginIndex);
		}
		
		System.out.println("suffix="+suffix);
		
		//制定名称唯一的策略:UUID
		//保存此次上传的文件文件名
		String child = UUID.randomUUID().toString()+suffix;
		
		//保存上传文件的文件夹
		String parent = request.getServletContext().getRealPath("upload");
		System.out.println("parent path="+parent);
		File dest = new File(parent,child);
		//执行保存
		file.transferTo(dest);
		System.out.println("upload");
		return null;
	}
}
