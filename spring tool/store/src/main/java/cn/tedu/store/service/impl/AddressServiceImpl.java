package cn.tedu.store.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ex.AddressSizeException;
import cn.tedu.store.service.ex.InsertException;
@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	AddressMapper addressMapper;
	@Value("${project.address.max-count}")
	private Integer addressMaxCount;
	@Override
	public void addNew(Integer uid, String username, Address address) {
		Integer count = addressMapper.countByUid(uid);
		if(count>=3) {
			throw new AddressSizeException("您的地址信息数量已经满啦上限("+addressMaxCount+")");
		}
		int isDefault = count==0? 1:0;
		Date now = new Date();
		address.setUid(uid);
		address.setIsDefault(isDefault);
		address.setCreatedUser(username);
		address.setModifiedUser(username);
		address.setCreatedTime(now);
		address.setModifiedTime(now);
		Integer rows = addressMapper.insert(address);
		if(!rows.equals(1)) {
			throw new InsertException("插入数据时发生未知错误,请联系系统管理员");
		}
	}

}
