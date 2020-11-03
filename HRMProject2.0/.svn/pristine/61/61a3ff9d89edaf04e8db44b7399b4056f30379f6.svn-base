package cn.tedu.hrmproject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tedu.entity.Job;
import cn.tedu.mybatis.JobMapper;

public class JobTest {
	JobMapper jobMapper;
	
	@Test
	public void insert(Job job){
		
		job.setName("哈哈哈");
		jobMapper.insertJob(job);
	}
}
