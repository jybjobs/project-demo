package com.freeter.modules.room.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.room.entity.OrganizationEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.room.entity.vo.OrganizationVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.room.entity.view.OrganizationView;


/**
 * 企业管理
 *
 * @author JYB
 * @email jybjobs@sina.cn
 * @date 2018-08-19 16:35:45
 */
public interface OrganizationService extends IService<OrganizationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<OrganizationVO> selectListVO(Wrapper<OrganizationEntity> wrapper);
   	
   	OrganizationVO selectVO(@Param("ew") Wrapper<OrganizationEntity> wrapper);
   	
   	List<OrganizationView> selectListView(Wrapper<OrganizationEntity> wrapper);
   	
   	OrganizationView selectView(@Param("ew") Wrapper<OrganizationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params, Wrapper<OrganizationEntity> wrapper);
}

