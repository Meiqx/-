package cn.tedu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.entity.BonusPenalty;
import cn.tedu.mybatis.BonusPenaltyMapper;
import cn.tedu.utils.JsonResult;
@Controller
public class BonusPenaltyController {

//	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
//	BonusPenaltyMapper bonusPenaltyMapper = ac.getBean("bonusPenaltyMapper",BonusPenaltyMapper.class);
	
	@Autowired
	BonusPenaltyMapper bonusPenaltyMapper;
	
//	BonusPenaltyRegister 鏄剧ず鐧昏濂栨儵椤甸潰 鈭�
//	AddBonusPenalty		濂栨儵椤甸潰鍐呭娣诲姞 鈭�
//	ListBonusPenalty 	鏄剧ず濂栨儵鍒楄〃椤甸潰 鈭�
//	UpdateBonusPenalty	鏄剧ず鏇存柊濂栨儵椤甸潰
//	UpdateBP			鏇存柊鍐呭
//	DetailsBonusPenalty 鏌ョ湅璇︽儏椤甸潰
//	FindEmp				鏌ユ壘鍛樺伐鏄惁瀛樺湪ajax
	
	@RequestMapping("BonusPenaltyRegister")
	public String showBonusPenalty() {	  //鏄剧ず鐧昏濂栨儵椤甸潰
//		return "static/BonusPenaltyRegister";
//		return "redirect:/BonusPenaltyRegister.html";
		return "BonusPenaltyRegister";
	}
	 
	@RequestMapping("ListBonusPenalty")
	public String showListBP(ModelMap map) {	//鏄剧ず濂栨儵鍒楄〃椤甸潰
		List<BonusPenalty> list = bonusPenaltyMapper.listAllBP();
		map.addAttribute("list", list);
		return "ListBonusPenalty";
	}
	
	@RequestMapping("AddBonusPenalty")
	public String addBonusPenalty(BonusPenalty bp) {
		String username = bp.getUsername();
		Integer rows = bonusPenaltyMapper.findByUsername(username);
		if(rows!=1) {
			return "BonusPenaltyRegister";
		}
		Date registerTime =new Date();
		bp.setRegisterTime(registerTime);
		bonusPenaltyMapper.addBonusPenalty(bp);
		return "redirect:/ListBonusPenalty";
	}
	
	@GetMapping("DetailsBonusPenalty")
	@ResponseBody
	public BonusPenalty detailBP(int id) {
		BonusPenalty bp = bonusPenaltyMapper.detailBP(id);
		return bp;
	}
	
	@RequestMapping("DeleteBonusPenalty")
	public String deleteById(int id) {
		bonusPenaltyMapper.deleteById(id);
		return "redirect:/ListBonusPenalty";
	}
	
	@RequestMapping("UpdateBonusPenalty")
	public String updateBonusPenalty(ModelMap map,int id) {
		BonusPenalty bp = bonusPenaltyMapper.detailBP(id);
		System.out.println("updateBonusPenalty(ModelMap map,int id)");
		System.out.println(bp);
		map.addAttribute("update",bp);
		return "UpdateBonusPenalty";
	}
	
	@RequestMapping("UpdateBP")
	public String a(BonusPenalty bp,int id) {
		Date registerTime =new Date();
		bp.setRegisterTime(registerTime);
		bp.setId(id);
		bonusPenaltyMapper.updateBonusPenalty(bp);
		return "redirect:/ListBonusPenalty";
	}
	
	@GetMapping("findEmpByName")
	@ResponseBody
	public JsonResult findByName(String username) {
		JsonResult jr = new JsonResult();
		System.out.println(username);
		Integer rows = bonusPenaltyMapper.findByUsername(username);
		jr.setState(rows);
		return jr;
	}
	
	
	
	
}
