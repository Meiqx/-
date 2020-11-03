package cn.tedu.store.mapper;

import cn.tedu.store.entity.Address;

/**
 * 处理用户收货地址的持久层
 * @author JAVA
 *
 */
public interface AddressMapper {
	/**
	 * 插入收货地址
	 * @param address
	 * @return
	 */
	Integer insert(Address address);
	
	/**
	 * 查询该用户所有地址信息的条数
	 * @param uid
	 * @return
	 */
	Integer countByUid(Integer uid);
}
