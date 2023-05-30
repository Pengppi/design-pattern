/**
 * @Author: Neo
 * @Date: 2023/05/30 Tuesday 21:06:57 PM
 * @Project: design-pattern
 * @IDE: IntelliJ IDEA
 **/

package com.neo.pattern.factory00.card;


/**
 * 模拟爱奇艺会员卡服务
 *
 * @author Pengppi
 * @date 2023/05/30
 */
public class IQiYiCardService {
    public void grantToken(String bindMobileNumber, String cardId) {
        System.out.println("模拟发放爱奇艺会员卡一张：" + bindMobileNumber + "，" + cardId);
    }
}
