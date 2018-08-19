package com.freeter.modules.room.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;



/**
 * 区域管理
 * 数据库通用操作实体类（普通增删改查）
 * @author JYB
 * @email jybjobs@sina.cn
 * @date 2018-08-18 20:53:06
 */
@TableName("area")
@ApiModel(value = "Area")
public class AreaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public AreaEntity() {
		
	}
	
	public AreaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */

	@TableId 
	@ApiModelProperty(value = "",hidden = true)
	private Long areaId;
	
	/**
	 * 上级ID，一级为0
	 */

	@ApiModelProperty(value = "上级ID，一级为0")
	private Long parentId;
	
	/**
	 * area名称
	 */

	@ApiModelProperty(value = "area名称")
	private String name;
	
	/**
	 * 排序
	 */

	@ApiModelProperty(value = "排序")
	private Integer orderNum;
	
	/**
	 * 是否删除  -1：已删除  0：正常
	 */

	@ApiModelProperty(value = "是否删除  -1：已删除  0：正常")
	private Integer delFlag;
	
	/**
	 * 设置：
	 */
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：
	 */
	public Long getAreaId() {
		return areaId;
	}
	/**
	 * 设置：上级ID，一级为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级ID，一级为0
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：area名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：area名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：是否删除  -1：已删除  0：正常
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：是否删除  -1：已删除  0：正常
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
}
