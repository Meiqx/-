package cn.tedu.store.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {
	
	@Autowired
	IAddressService service;
	
	@Autowired
	AddressMapper addressMapper;

	
	@Test
	public void insert() {
		Address address = new Address();
		address.setUid(17);
		address.setAreaName("洪山区");
		address.setCityName("武汉");
		address.setAddress("湖北第二师范学院");
		address.setCreatedTime(new Date());
		Integer rows = addressMapper.insert(address);
		System.err.println("rows="+rows);
	}
	@Test
	public void countByUid() {
		Integer uid = 17;
		Integer count = addressMapper.countByUid(uid);
		System.err.println("count="+count);
	}
	
	@Test
	public void addNew() {
		try {
			Integer uid = 14;
			String username = "root";
			Address address = new Address();
			address.setProvinceName("湖北省");
			address.setAreaCode("15315");
			address.setAreaName("江夏区");
			service.addNew(uid, username, address);
			System.err.println("OK");
		}catch(Exception e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
}
