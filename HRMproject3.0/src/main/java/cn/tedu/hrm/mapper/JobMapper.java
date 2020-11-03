package cn.tedu.hrm.mapper;

import java.util.List;

import cn.tedu.hrm.entity.Job;
/**
 * 关于招聘版块的增删改查的类
 * @author JAVA
 *
 */
public interface JobMapper {
	/**
	 * 添加应聘者信息的方法
	 * @param job
	 * @return
	 */
	Integer insertJob(Job job);
	
	/**
	 * 删除应聘者信息的方法
	 * @param id
	 * @return
	 */
	Integer deleteJob(int id);
	
	/**
	 * 查询所有应聘者信息的方法
	 * @return
	 */
	List<Job> findAll();
	
	/**
	 * 查询已经入库的应聘者信息的方法
	 * @return
	 */
	List<Job> findJoinLibrary();
	
	/**
	 * 查找要修改的信息
	 * @param id
	 * @return
	 */
	Job findJobEditor(int id);
	
	/**
	 * 修改信息
	 * @param user
	 * @return
	 */
	void JobEditor(Job job);
	
	/**
	 * 将应聘者入库的方法
	 * @param id
	 * @return
	 */
	Integer jobJoinLibrary(int id);
	
	/**
	 * 将应聘者移除人才库的方法
	 * @param id
	 * @return
	 */
	Integer jobOutLibrary(int id);

	/**
	 * 查询应聘者详情
	 * @param id
	 * @return
	 */
	Job findDetail(int id); 
}
