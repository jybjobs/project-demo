package com.freeter.modules.room.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;



/**
 * 企业管理
 * 数据库通用操作实体类（普通增删改查）
 * @author JYB
 * @email jybjobs@sina.cn
 * @date 2018-08-19 16:35:45
 */
@TableName("organization")
@ApiModel(value = "Organization")
public class OrganizationEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public OrganizationEntity() {
		
	}
	
	public OrganizationEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 企业ID
	 */

	@TableId 
	@ApiModelProperty(value = "企业ID",hidden = true)
	private Long orgId;
	
	/**
	 * 省份
	 */

	@ApiModelProperty(value = "省份")
	private Long proId;
	
	/**
	 * 市
	 */

	@ApiModelProperty(value = "市")
	private Long cityId;
	
	/**
	 * 企业名称
	 */

	@ApiModelProperty(value = "企业名称")
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
	 * 企业代码
	 */

	@ApiModelProperty(value = "企业代码")
	private String code;
	
	/**
	 * 详细地址
	 */

	@ApiModelProperty(value = "详细地址")
	private String adress;
	
	/**
	 * 联系电话
	 */

	@ApiModelProperty(value = "联系电话")
	private String phone;
	
	/**
	 * 联系人
	 */

	@ApiModelProperty(value = "联系人")
	private String attenName;
	
	/**
	 * 官网地址
	 */

	@ApiModelProperty(value = "官网地址")
	private String website;
	
	/**
	 * 设置：企业ID
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：企业ID
	 */
	public Long getOrgId() {
		return orgId;
	}
	/**
	 * 设置：省份
	 */
	public void setProId(Long proId) {
		this.proId = proId;
	}
	/**
	 * 获取：省份
	 */
	public Long getProId() {
		return proId;
	}
	/**
	 * 设置：市
	 */
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：市
	 */
	public Long getCityId() {
		return cityId;
	}
	/**
	 * 设置：企业名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：企业名称
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
	/**
	 * 设置：企业代码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：企业代码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：联系人
	 */
	public void setAttenName(String attenName) {
		this.attenName = attenName;
	}
	/**
	 * 获取：联系人
	 */
	public String getAttenName() {
		return attenName;
	}
	/**
	 * 设置：官网地址
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * 获取：官网地址
	 */
	public String getWebsite() {
		return website;
	}
}
