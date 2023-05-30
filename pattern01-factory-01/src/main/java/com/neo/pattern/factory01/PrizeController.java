/**
 * @Author: Neo
 * @Date: 2023/05/30 Tuesday 21:03:00 PM
 * @Project: design-pattern
 * @IDE: IntelliJ IDEA
 **/

package com.neo.pattern.factory01;

import com.alibaba.fastjson2.JSON;
import com.neo.pattern.factory00.card.IQiYiCardService;
import com.neo.pattern.factory00.coupon.CouponResult;
import com.neo.pattern.factory00.coupon.CouponService;
import com.neo.pattern.factory00.goods.DeliverReq;
import com.neo.pattern.factory00.goods.GoodsService;
import lombok.extern.slf4j.Slf4j;

/**
 * 模拟发奖服务
 *
 * @author Pengppi
 * @date 2023/05/30
 */
@Slf4j
public class PrizeController {
    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try {
            log.info("奖品发放开始{}。req:{}", req.getUserId(), reqJson);
            // 按照不同类型方法商品[1优惠券、2实物商品、3第三方兑换卡(爱奇艺)]
            if (req.getAwardType() == 1) {
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getUserId(), req.getAwardNumber(), req.getBizId());
                if ("0000".equals(couponResult.getCode())) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                }
            } else if (req.getAwardType() == 2) {
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getUserId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getUserId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", "发放失败");
                }
            } else if (req.getAwardType() == 3) {
                String bindMobileNumber = queryUserPhoneNumber(req.getUserId());
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(bindMobileNumber, req.getAwardNumber());
                awardRes = new AwardRes("0000", "发放成功");
            }
            log.info("奖品发放完成{}。", req.getUserId());
        } catch (Exception e) {
            log.info("奖品发放失败{}。req:{}", req.getUserId(), reqJson, e);
            awardRes = new AwardRes("0001", e.getMessage());
        }
        return awardRes;
    }

    private String queryUserName(String uId) {
        return "模拟用户";
    }

    private String queryUserPhoneNumber(String userId) {
        return "15200101232";
    }

}
