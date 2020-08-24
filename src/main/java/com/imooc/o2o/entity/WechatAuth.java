package com.imooc.o2o.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author withlimin
 * @date 2019-12-25
 */
@Data
@Alias("WechatAuth")
public class WechatAuth {
	// 主键ID
	private Long wechatAuthId;
	/**
	 * 微信获取用户信息的凭证，对于某个公众号具有唯一性
	 */
	private String openId;
	// 创建时间
	private Date createTime;
	// 用户信息
	private PersonInfo personInfo;



}
