package com.freeter.modules.room.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.MPUtil;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.room.entity.OrganizationEntity;
import com.freeter.modules.room.entity.model.OrganizationModel;
import com.freeter.modules.room.entity.vo.OrganizationVO;
import com.freeter.modules.room.service.OrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;




/**
 * 企业管理
 *api接口
 * @author JYB
 * @email jybjobs@sina.cn
 * @date 2018-08-19 16:35:45
 */
@RestController
@RequestMapping("/room/organization")
@Api(tags="企业管理接口")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
 
	 /**
     * 列表
     */
    @GetMapping("/page")
    @ApiOperation("分页查询企业管理")
    public R page(@RequestParam Map<String, Object> params,OrganizationModel organizationModel){
 
        EntityWrapper< OrganizationEntity> ew = new EntityWrapper< OrganizationEntity>();
        OrganizationEntity organization = new  OrganizationEntity( organizationModel);
     	ew.allEq(MPUtil.allEQMapPre( organization, "organization")); 
    	PageUtils page = organizationService.queryPage(params, ew);
        return R.ok().put("page",  page);
        
    }
	
	
	
    /**
     * 查询
     */
    @GetMapping("/list")
    @ApiOperation("查询企业管理")
    public R list(OrganizationModel organizationModel){
		ValidatorUtils.validateEntity(organizationModel);
        EntityWrapper< OrganizationEntity> ew = new EntityWrapper< OrganizationEntity>();
		OrganizationEntity organization = new  OrganizationEntity( organizationModel);
     	ew.allEq(MPUtil.allEQMapPre( organization, "organization")); 
		List<OrganizationEntity>  organizationVOList =  organizationService.selectList(ew);
		return R.ok("查询企业管理成功").put("data", organizationVOList);
    }

	 /**
     * 查询
     */
    @GetMapping("/query")
    @ApiOperation("查询企业管理")
    public R query(OrganizationModel organizationModel){
		ValidatorUtils.validateEntity(organizationModel);
        EntityWrapper< OrganizationEntity> ew = new EntityWrapper< OrganizationEntity>();
		OrganizationEntity organization = new  OrganizationEntity( organizationModel);
		ew.allEq(MPUtil.allEQMapPre( organization, "organization")); 
		OrganizationVO  organizationVO =  organizationService.selectVO(ew);
		return R.ok("查询企业管理成功").put("data",  organizationVO);
    }
	

    /**
     * 信息
     */
    @GetMapping("/info/{orgId}")
    @ApiOperation("获取相应的企业管理")
    public R info(@PathVariable("orgId") Long orgId){
        OrganizationEntity organization = organizationService.selectById(orgId);

        return R.ok().put("organization", organization);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加企业管理数据")
    public R saveJson(@RequestBody OrganizationEntity organization){
    	ValidatorUtils.validateEntity(organization);
        organizationService.insert(organization);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加企业管理数据 （参数：表单格式）")
    public R saveForm(OrganizationEntity organization){
    	ValidatorUtils.validateEntity(organization);
        organizationService.insert(organization);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update")
    @ApiOperation("修改企业管理数据（参数：json格式）")
    public R updateJson(@RequestBody OrganizationEntity organization){
        ValidatorUtils.validateEntity(organization);
        organizationService.updateAllColumnById(organization);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改企业管理数据（参数：表单格式）")
    public R updateForm(OrganizationEntity organization){
        ValidatorUtils.validateEntity(organization);
        organizationService.updateAllColumnById(organization);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除企业管理数据")
    public R delete(@RequestBody Long[] orgIds){
        organizationService.deleteBatchIds(Arrays.asList(orgIds));
        return R.ok();
    }

}
