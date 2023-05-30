/**
 * @Author: Neo
 * @Date: 2023/05/30 Tuesday 22:02:24 PM
 * @Project: design-pattern
 * @IDE: IntelliJ IDEA
 **/

package com.neo.pattern.factory02.Store.impl;

import com.alibaba.fastjson2.JSON;
import com.neo.pattern.factory00.goods.DeliverReq;
import com.neo.pattern.factory00.goods.GoodsService;
import com.neo.pattern.factory02.Store.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class GoodsCommodityService implements ICommodity {
    private GoodsService goodsService = new GoodsService();

    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        log.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        log.info("测试结果[优惠券]：{}", isSuccess);

        if (!isSuccess) throw new RuntimeException("实物商品发放失败");
    }

    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }

}
