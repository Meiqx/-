package cn.tedu.store.service;

import cn.tedu.store.entity.Address;

public interface IAddressService {

	/**
	 * 添加新地址信息的方法
	 * @param uid
	 * @param username
	 * @param address
	 */
	void addNew(Integer uid,String username,Address address);
}
