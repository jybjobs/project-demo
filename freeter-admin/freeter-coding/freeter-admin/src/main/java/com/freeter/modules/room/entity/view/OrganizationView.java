package com.freeter.modules.room.entity.view;

import com.freeter.modules.room.entity.OrganizationEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 企业管理
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author JYB
 * @email jybjobs@sina.cn
 * @date 2018-08-19 16:35:45
 */
@TableName("organization")
@ApiModel(value = "Organization")
public class OrganizationView  extends OrganizationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public OrganizationView(){
	}
 
 	public OrganizationView(OrganizationEntity organizationEntity){
 	try {
			BeanUtils.copyProperties(this, organizationEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
