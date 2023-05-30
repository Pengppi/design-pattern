/**
 * @Author: Neo
 * @Date: 2023/05/30 Tuesday 21:57:20 PM
 * @Project: design-pattern
 * @IDE: IntelliJ IDEA
 **/

package com.neo.pattern.factory02.Store.impl;

import com.alibaba.fastjson2.JSON;
import com.neo.pattern.factory00.card.IQiYiCardService;
import com.neo.pattern.factory02.Store.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class CardCommodityService implements ICommodity {

    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String mobile=queryUserMobile(uId);
        iQiYiCardService.grantToken(mobile, bizId);
        log.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        log.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String uId) {
        return "15200101232";
    }
}
