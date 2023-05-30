package com.neo.pattern.factory02.Store;

import java.util.Map;

public interface ICommodity {
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
