/**
 * @Author: Neo
 * @Date: 2023/05/30 Tuesday 21:09:41 PM
 * @Project: design-pattern
 * @IDE: IntelliJ IDEA
 **/

package com.neo.pattern.factory00.coupon;

/**
 * 模拟优惠券服务
 *
 * @author Pengppi
 * @date 2023/05/30
 */
public class CouponService {
    public CouponResult sendCoupon(String userId,String couponNumber,String uuid)
    {
        System.out.println("模拟发放优惠券一张：" + userId + "," + couponNumber + "," + uuid);
        return new CouponResult("0000", "发放成功");
    }
}
