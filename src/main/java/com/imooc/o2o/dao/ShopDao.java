package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author withlimin
 * @date 2019/12/26
 */
public interface ShopDao {

    /**
     * 分页查询店铺， 可输入的条件有：店铺名（模糊），店铺状态，店铺类别，区域Id，owner
     * @param shopCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    /**
     * 返回queryShopList的总数
     * @param shopCondition
     * @return
     */
    int queryShopCount(@Param("shopCondition") Shop shopCondition);



    /**
     * 新增店铺
     * @param shop
     * @return int
     */
    int insertShop(Shop shop);

    /**
     * 根据shopId查询店铺信息
     * @param shopId
     * @return Shop
     */
    Shop queryByShopId(long shopId);
    /**
     * 更新店铺信息
     * @param shop
     * @return int
     */
    int updateShop(Shop shop);
}
