package com.freeter.modules.room.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.MPUtil;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.room.entity.AreaEntity;
import com.freeter.modules.room.entity.model.AreaModel;
import com.freeter.modules.room.entity.vo.AreaVO;
import com.freeter.modules.room.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;




/**
 * 区域管理
 *api接口
 * @author JYB
 * @email jybjobs@sina.cn
 * @date 2018-08-18 20:53:06
 */
@RestController
@RequestMapping("/room/area")
@Api(tags="区域管理接口")
public class AreaController {
    @Autowired
    private AreaService areaService;
 
	 /**
     * 列表
     */
    @GetMapping("/page")
    @ApiOperation("分页查询区域管理")
    public R page(@RequestParam Map<String, Object> params,AreaModel areaModel){
 
        EntityWrapper< AreaEntity> ew = new EntityWrapper< AreaEntity>();
        AreaEntity area = new  AreaEntity( areaModel);
     	ew.allEq(MPUtil.allEQMapPre( area, "area")); 
    	PageUtils page = areaService.queryPage(params, ew);
        return R.ok().put("page",  page);
        
    }
	
	
	
    /**
     * 查询
     */
    @GetMapping("/list")
    @ApiOperation("查询区域管理")
    public R list(AreaModel areaModel){
		ValidatorUtils.validateEntity(areaModel);
        EntityWrapper< AreaEntity> ew = new EntityWrapper< AreaEntity>();
		AreaEntity area = new  AreaEntity( areaModel);
     	ew.allEq(MPUtil.allEQMapPre( area, "area")); 
		List<AreaEntity>  areaVOList =  areaService.selectList(ew);
		return R.ok("查询区域管理成功").put("data", areaVOList);
    }

	 /**
     * 查询
     */
    @GetMapping("/query")
    @ApiOperation("查询区域管理")
    public R query(AreaModel areaModel){
		ValidatorUtils.validateEntity(areaModel);
        EntityWrapper< AreaEntity> ew = new EntityWrapper< AreaEntity>();
		AreaEntity area = new  AreaEntity( areaModel);
		ew.allEq(MPUtil.allEQMapPre( area, "area")); 
		AreaVO  areaVO =  areaService.selectVO(ew);
		return R.ok("查询区域管理成功").put("data",  areaVO);
    }
	

    /**
     * 信息
     */
    @GetMapping("/info/{areaId}")
    @ApiOperation("获取相应的区域管理")
    public R info(@PathVariable("areaId") Long areaId){
        AreaEntity area = areaService.selectById(areaId);

        return R.ok().put("area", area);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加区域管理数据")
    public R saveJson(@RequestBody AreaEntity area){
    	ValidatorUtils.validateEntity(area);
        areaService.insert(area);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加区域管理数据 （参数：表单格式）")
    public R saveForm(AreaEntity area){
    	ValidatorUtils.validateEntity(area);
        areaService.insert(area);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update")
    @ApiOperation("修改区域管理数据（参数：json格式）")
    public R updateJson(@RequestBody AreaEntity area){
        ValidatorUtils.validateEntity(area);
        areaService.updateAllColumnById(area);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改区域管理数据（参数：表单格式）")
    public R updateForm(AreaEntity area){
        ValidatorUtils.validateEntity(area);
        areaService.updateAllColumnById(area);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除区域管理数据")
    public R delete(@RequestBody Long[] areaIds){
        areaService.deleteBatchIds(Arrays.asList(areaIds));
        return R.ok();
    }

}
