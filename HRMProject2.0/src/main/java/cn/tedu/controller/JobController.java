package cn.tedu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.entity.Job;
import cn.tedu.mybatis.JobMapper;

/**
 * 招聘版块功能控制器
 * @author JAVA
 *
 */
@Controller
public class JobController {
	
	@Autowired
	JobMapper jobMapper;
	
	/**
	 * 显示录入信息页面
	 *
	 * @return
	 */
	@RequestMapping("JobInputServlet")
	public String insertJob() {	
		return "jobInput";
	}	
	
	/**
	 * 添加应聘者信息
	 * @param job
	 * @return
	 */
	@RequestMapping("JobInputSuccessServlet")
	public String jobTalentPool(Job job) {
		jobMapper.insertJob(job);
		return "redirect:JobCheckServlet";
	}
	
	
	/**
	 * 查询所有应聘者信息
	 * @param model
	 * @return
	 */
	@RequestMapping("JobCheckServlet")
	public String jobCheck(Model model) {
		List<Job> jobs = jobMapper.findAll();
		model.addAttribute("jobs",jobs);
		return "jobCheck";
		
	}
	
	/**
	 * 查询已经入库的应聘者信息
	 * @param model
	 * @return
	 */
	@RequestMapping("JobTalentPoolServlet")
	public String jobTalentPool(Model model) {
		List<Job> jobs = jobMapper.findJoinLibrary();
		model.addAttribute("job",jobs);
		return "jobTalentPool";
	}
	
	
	
	/**
	 * 删除应聘者信息
	 * @param id
	 * @return
	 */
	@RequestMapping("JobDeleteServlet")
	public String jobDelete(int id) {
		jobMapper.deleteJob(id);
		return "redirect:JobCheckServlet";
	}
	
	/**
	 * 信息入库
	 * @param id
	 * @return
	 */
	@RequestMapping("JobInPoolServlet")
	public String jobJoinPool(int id) {
		jobMapper.jobJoinLibrary(id);
		return "redirect:JobCheckServlet";
	}
	
	/**
	 * 信息出库
	 * @param id
	 * @return
	 */
	@RequestMapping("JobOutPoolServlet")
	public String jobOutPool(int id) {
		jobMapper.jobOutLibrary(id);
		return "redirect:JobTalentPoolServlet";
	}
	
	/**
	 * 查看信息详情的方法
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("JobDetailServlet")
	public String jobCheckDetail(int id,Model model) {
		Job jobs = jobMapper.findDetail(id);
		System.out.println(jobs);
		model.addAttribute("job",jobs);
		return "jobDetail";
		
	}
	
	/**
	 * 显示要修改的信息页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("JobEditorServlet")
	public String findJobEditor(int id,Model model) {
		Job jobs = jobMapper.findJobEditor(id);
		model.addAttribute("job",jobs);
		return "jobEditor";
	}
	
	/**
	 * 提交修改的信息
	 * @param job
	 * @return
	 */
	@RequestMapping("JobEditorSuccessServlet")
	public String JobEditor(Job job) {
		System.out.println(job.toString());
		jobMapper.JobEditor(job);
		return "redirect:JobTalentPoolServlet";
	}
	
}
