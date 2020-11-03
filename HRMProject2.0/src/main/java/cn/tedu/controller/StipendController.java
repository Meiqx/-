package cn.tedu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.entity.Salary;
import cn.tedu.mybatis.StipendMapper;

@Controller
public class StipendController {

	@Autowired
	StipendMapper stipendMapper;
	
	/**
	 * 显示添加员工薪资页面
	 * @return
	 */
	@RequestMapping("addStipend")
	public String insertStipend() {
		
		return "addStipend";
	}
	
	/**
	 * 执行添加员工薪资数据成功
	 * @param salary
	 * @param model
	 * @return
	 */
	@PostMapping("showAddStipend")
	public String showAddSalary(Salary salary,ModelMap model) {
	System.out.println(salary);	
	salary.setGranttime((new Date()));
	Integer rows=stipendMapper.insertStipend(salary);
	System.out.println(rows);
	Salary sal=stipendMapper.findByName(salary.getName());
	model.addAttribute("showaddstipend",sal);
		
		return "showAddStipend";
	}
	
	/**
	 * 查询所有员工薪资信息
	 * @param model
	 * @return
	 */
	@RequestMapping("getSalary")
	public String getSalary(ModelMap model) {
		List<Salary> list=stipendMapper.findAllStipend();
		for (Salary salary : list) {
			System.out.println(salary);
		}
		model.addAttribute("sallist",list);
		return "getsalary";
	}
}
