package cn.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.entity.Job;
import cn.tedu.mapper.JobMapper;

@Controller
public class JobController {
	@Autowired
	JobMapper jobMapper;
	
	
	@RequestMapping("jobCheck.do")
	public String findAll(Model model){
		List<Job> jobs = jobMapper.findJobAll();
		model.addAttribute("jobs",jobs);
		return "jobCheck";
	} 
	
}
