package com.freeter.modules.room.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.freeter.modules.room.entity.AreaEntity;
import com.freeter.modules.room.entity.view.AreaView;
import com.freeter.modules.room.entity.vo.AreaVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 区域管理
 * 
 * @author JYB
 * @email jybjobs@sina.cn
 * @date 2018-08-18 20:53:06
 */
public interface AreaDao extends BaseMapper<AreaEntity> {
	
	List<AreaVO> selectListVO(@Param("ew") Wrapper<AreaEntity> wrapper);
	
	AreaVO selectVO(@Param("ew") Wrapper<AreaEntity> wrapper);
	
	
	List<AreaView> selectListView(@Param("ew") Wrapper<AreaEntity> wrapper);

	List<AreaView> selectListView(Pagination page, @Param("ew") Wrapper<AreaEntity> wrapper);
	
	AreaView selectView(@Param("ew") Wrapper<AreaEntity> wrapper);
}
