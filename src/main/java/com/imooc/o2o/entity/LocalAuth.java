package com.imooc.o2o.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("LocalAuth")
public class LocalAuth {
	// 主键ID
	private Long localAuthId;
	// 帐号
	private String username;
	// 密码
	private String password;
	// 创建时间
	private Date createTime;
	// 最近一次的更新时间
	private Date lastEditTime;
	// 个人信息，关系为一一对应
	private PersonInfo personInfo;



}
