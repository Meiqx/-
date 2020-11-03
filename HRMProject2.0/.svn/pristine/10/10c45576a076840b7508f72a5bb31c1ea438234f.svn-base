package cn.tedu.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.entity.BonusPenalty;

public interface BonusPenaltyMapper {

	//获得奖惩列表
	List<BonusPenalty> listAllBP();
	//奖惩详情
	BonusPenalty detailBP(int id);
	//查询名字查看员工是否存在
	Integer findByUsername(String username);
	//添加奖惩
	void addBonusPenalty(BonusPenalty bonusPenalty);
	//修改奖惩
	void updateBonusPenalty(BonusPenalty bp);
	//删除
	void deleteById(int id);
	
}
