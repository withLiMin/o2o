package com.imooc.o2o.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("ProductImg")
public class ProductImg {
	// 主键ID
	private Long productImgId;
	// 图片地址
	private String imgAddr;
	// 图片简介
	private String imgDesc;
	// 权重，越大越排前显示
	private Integer priority;
	// 创建时间
	private Date createTime;
	// 标明是属于哪个商品的图片
	private Long productId;

}
