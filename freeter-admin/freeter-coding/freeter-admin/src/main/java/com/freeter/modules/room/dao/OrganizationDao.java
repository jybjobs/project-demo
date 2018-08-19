package com.freeter.modules.room.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.freeter.modules.room.entity.OrganizationEntity;
import com.freeter.modules.room.entity.view.OrganizationView;
import com.freeter.modules.room.entity.vo.OrganizationVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 企业管理
 * 
 * @author JYB
 * @email jybjobs@sina.cn
 * @date 2018-08-19 16:35:45
 */
public interface OrganizationDao extends BaseMapper<OrganizationEntity> {
	
	List<OrganizationVO> selectListVO(@Param("ew") Wrapper<OrganizationEntity> wrapper);
	
	OrganizationVO selectVO(@Param("ew") Wrapper<OrganizationEntity> wrapper);
	
	
	List<OrganizationView> selectListView(@Param("ew") Wrapper<OrganizationEntity> wrapper);

	List<OrganizationView> selectListView(Pagination page, @Param("ew") Wrapper<OrganizationEntity> wrapper);
	
	OrganizationView selectView(@Param("ew") Wrapper<OrganizationEntity> wrapper);
}
