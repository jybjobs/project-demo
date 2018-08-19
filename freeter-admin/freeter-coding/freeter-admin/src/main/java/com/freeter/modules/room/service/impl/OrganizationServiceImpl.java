package com.freeter.modules.room.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;

import com.freeter.modules.room.dao.OrganizationDao;
import com.freeter.modules.room.entity.OrganizationEntity;
import com.freeter.modules.room.service.OrganizationService;
import com.freeter.modules.room.entity.vo.OrganizationVO;
import com.freeter.modules.room.entity.view.OrganizationView;


@Service("organizationService")
public class OrganizationServiceImpl extends ServiceImpl<OrganizationDao, OrganizationEntity> implements OrganizationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrganizationEntity> page = this.selectPage(
                new Query<OrganizationEntity>(params).getPage(),
                new EntityWrapper<OrganizationEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<OrganizationEntity> wrapper) {
		  Page<OrganizationView> page =new Query<OrganizationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<OrganizationVO> selectListVO( Wrapper<OrganizationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public OrganizationVO selectVO( Wrapper<OrganizationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<OrganizationView> selectListView(Wrapper<OrganizationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public OrganizationView selectView(Wrapper<OrganizationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
