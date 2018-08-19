package com.freeter.modules.room.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.room.entity.AreaEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.room.entity.vo.AreaVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.room.entity.view.AreaView;


/**
 * 区域管理
 *
 * @author JYB
 * @email jybjobs@sina.cn
 * @date 2018-08-18 20:53:06
 */
public interface AreaService extends IService<AreaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AreaVO> selectListVO(Wrapper<AreaEntity> wrapper);
   	
   	AreaVO selectVO(@Param("ew") Wrapper<AreaEntity> wrapper);
   	
   	List<AreaView> selectListView(Wrapper<AreaEntity> wrapper);
   	
   	AreaView selectView(@Param("ew") Wrapper<AreaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params, Wrapper<AreaEntity> wrapper);
}

