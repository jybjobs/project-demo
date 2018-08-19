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

import com.freeter.modules.room.dao.AreaDao;
import com.freeter.modules.room.entity.AreaEntity;
import com.freeter.modules.room.service.AreaService;
import com.freeter.modules.room.entity.vo.AreaVO;
import com.freeter.modules.room.entity.view.AreaView;


@Service("areaService")
public class AreaServiceImpl extends ServiceImpl<AreaDao, AreaEntity> implements AreaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AreaEntity> page = this.selectPage(
                new Query<AreaEntity>(params).getPage(),
                new EntityWrapper<AreaEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AreaEntity> wrapper) {
		  Page<AreaView> page =new Query<AreaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<AreaVO> selectListVO( Wrapper<AreaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AreaVO selectVO( Wrapper<AreaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<AreaView> selectListView(Wrapper<AreaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AreaView selectView(Wrapper<AreaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
