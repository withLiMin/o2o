package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testQueryShopList(){
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0,5);
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("count is " + count);
        System.out.println("店铺列表的大小是：" +shopList.size());
    }

    @Test
    @Ignore
    public void testQueryByShopId(){
        long shopId = 2;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("areaId : " +shop.getShopId());
        System.out.println("areaName : " + shop.getArea().getAreaName());
    }

    @Test
    @Ignore
    public void testInsertShop() {
        Shop shop = new Shop();
        shop.setShopId(2L);
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        Assert.assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(2L);

        shop.setShopDesc("测试updateShop");
        shop.setShopAddr("测试updateShop");

        int effectedNum = shopDao.updateShop(shop);
        Assert.assertEquals(1,effectedNum);
    }



}
