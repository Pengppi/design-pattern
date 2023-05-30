/**
 * @Author: Neo
 * @Date: 2023/05/30 Tuesday 21:39:58 PM
 * @Project: design-pattern
 * @IDE: IntelliJ IDEA
 **/

package com.neo.pattern.test;

import com.alibaba.fastjson2.JSON;
import com.neo.pattern.factory01.AwardReq;
import com.neo.pattern.factory01.AwardRes;
import com.neo.pattern.factory01.PrizeController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

@Slf4j
public class ApiTest {

    private PrizeController prizeController;
    

    @Before
    public void setUp() throws Exception {
        prizeController = new PrizeController();
    }

    @Test
    public void test_awardToUser() {
        log.info("\n模拟发放优惠券测试");
        AwardReq req01 = new AwardReq();
        req01.setUserId("10001");
        req01.setAwardType(1);
        req01.setAwardNumber("EGM1023938910232121323432");
        req01.setBizId("791098764902132");
        AwardRes res01 = prizeController.awardToUser(req01);
        log.info("请求参数：{}", JSON.toJSONString(req01));
        log.info("测试结果：{}", JSON.toJSONString(res01));

        log.info("\n模拟发放实物商品");
        AwardReq req02 = new AwardReq();
        req02.setUserId("10001");
        req02.setAwardType(2);
        req02.setAwardNumber("9820198721311");
        req02.setBizId("1023000020112221113");
        req02.setExtMap(new HashMap<String, String>() {{
            put("consigneeUserName", "用户名称");
            put("consigneeUserPhone", "用户手机号");
            put("consigneeUserAddress", "用户的地址");
        }});
        AwardRes res02 = prizeController.awardToUser(req02);
        log.info("请求参数：{}", JSON.toJSONString(req02));
        log.info("测试结果：{}", JSON.toJSONString(res02));

        log.info("\n模拟发放第三方兑换卡(爱奇艺)");
        AwardReq req03 = new AwardReq();
        req03.setUserId("10001");
        req03.setAwardType(3);
        req03.setAwardNumber("AQY1xjkUodl8LO975GdfrYUio");
        AwardRes res03 = prizeController.awardToUser(req03);
        log.info("请求参数：{}", JSON.toJSONString(req03));
        log.info("测试结果：{}", JSON.toJSONString(res03));
    }
}
