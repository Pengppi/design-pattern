/**
 * @Author: Neo
 * @Date: 2023/05/30 Tuesday 21:56:00 PM
 * @Project: design-pattern
 * @IDE: IntelliJ IDEA
 **/

package com.neo.pattern.factory02;

import com.neo.pattern.factory02.Store.ICommodity;
import com.neo.pattern.factory02.Store.impl.CardCommodityService;
import com.neo.pattern.factory02.Store.impl.CouponCommodityService;
import com.neo.pattern.factory02.Store.impl.GoodsCommodityService;

public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }
}
