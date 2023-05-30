/**
 * @Author: Neo
 * @Date: 2023/05/30 Tuesday 21:09:34 PM
 * @Project: design-pattern
 * @IDE: IntelliJ IDEA
 **/

package com.neo.pattern.factory00.coupon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CouponResult {
    private String code; // 编码
    private String info; // 描述
}
