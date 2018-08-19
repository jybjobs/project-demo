package com.freeter.modules.room.entity.view;

import com.freeter.modules.room.entity.AreaEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 区域管理
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author JYB
 * @email jybjobs@sina.cn
 * @date 2018-08-18 20:53:06
 */
@TableName("area")
@ApiModel(value = "Area")
public class AreaView  extends AreaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AreaView(){
	}
 
 	public AreaView(AreaEntity areaEntity){
 	try {
			BeanUtils.copyProperties(this, areaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
