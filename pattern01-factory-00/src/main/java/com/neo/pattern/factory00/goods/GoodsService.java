/**
 * @Author: Neo
 * @Date: 2023/05/30 Tuesday 21:12:24 PM
 * @Project: design-pattern
 * @IDE: IntelliJ IDEA
 **/

package com.neo.pattern.factory00.goods;

import com.alibaba.fastjson2.JSON;

/**
 * 模拟实物商品服务
 *
 * @author Pengppi
 * @date 2023/05/30
 */
public class GoodsService {
    public Boolean deliverGoods(DeliverReq req) {
        System.out.println("模拟发货实物商品一个：" + JSON.toJSONString(req));
        return true;
    }
}
