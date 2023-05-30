/**
 * @Author: Neo
 * @Date: 2023/05/30 Tuesday 22:00:16 PM
 * @Project: design-pattern
 * @IDE: IntelliJ IDEA
 **/

package com.neo.pattern.factory02.Store.impl;

import com.alibaba.fastjson2.JSON;
import com.neo.pattern.factory00.coupon.CouponResult;
import com.neo.pattern.factory00.coupon.CouponService;
import com.neo.pattern.factory02.Store.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class CouponCommodityService implements ICommodity {
    private CouponService couponService = new CouponService();

    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        log.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        log.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }


}
