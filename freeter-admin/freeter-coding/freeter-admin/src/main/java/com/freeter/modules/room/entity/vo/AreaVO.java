package com.freeter.modules.room.entity.vo;

import com.freeter.modules.room.entity.AreaEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 区域管理
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author JYB
 * @email jybjobs@sina.cn
 * @date 2018-08-18 20:53:06
 */
@ApiModel(value = "AreaVO")
public class AreaVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	
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
