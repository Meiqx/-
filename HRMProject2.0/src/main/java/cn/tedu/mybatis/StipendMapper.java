package cn.tedu.mybatis;

import java.util.List;

import cn.tedu.entity.Salary;

/**
 * 薪资stipend数据接口
 * @author JAVA
 *
 */
public interface StipendMapper {
	/**
	 * 插入新员工的薪资信息
	 * @return
	 */
	Integer insertStipend(Salary salary);
	
	/**
	 * 	根据姓名查看插入的员工的信息
	 */
	Salary findByName(String username);
		


	
	/**
	 * 查询所有员工薪资信息
	 * @return
	 */
	List<Salary> findAllStipend();
	
}
