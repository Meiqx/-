package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BMIServlet
 */
public class BMIServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");
				
		double h = Double.valueOf(height)/100;
		double w = Double.valueOf(weight);
		
		double bmi = w/(h*h);
		
		String info = null;
		
		if(bmi<18.5) {//过轻
			info = "兄弟你瘦了";
		}else if(bmi>=18.5 && bmi<24) {//标准
			info = "恭喜你可以放心吃";
		}else if(bmi>=24 && bmi<28){//微胖
			info = "衣服变小了";
		}else {
			info = "我心中你最重";
		}
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.print(info+bmi);
		pw.close();
		
	}

}
