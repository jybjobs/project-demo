package com.freeter;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.freeter.modules.sys.shiro.ShiroUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

//@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

	    protected final static Logger logger = LoggerFactory.getLogger(AdminApplication.class);

	    @Override
	    public void insertFill(MetaObject metaObject) {
   	        logger.info("新增的时候记录操作信息");
	        setFieldValByName("createTime", new Date(), metaObject);
	        if( ShiroUtils.getUserEntity()!= null) {
	        setFieldValByName("createBy", ShiroUtils.getUserEntity().getUsername(), metaObject);
	        }
	        }

	    @Override
	    public void updateFill(MetaObject metaObject) {
	        logger.info("更新的时候记录操作信息");
	        
	        setFieldValByName("updateTime", new Date(), metaObject);
	        if( ShiroUtils.getUserEntity()!= null) {
	        setFieldValByName("updateBy", ShiroUtils.getUserEntity().getUsername(), metaObject);
	        }
	    }

}
