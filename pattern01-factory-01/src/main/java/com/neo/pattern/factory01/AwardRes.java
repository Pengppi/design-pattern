/**
 * @Author: Neo
 * @Date: 2023/05/30 Tuesday 21:01:58 PM
 * @Project: design-pattern
 * @IDE: IntelliJ IDEA
 **/

package com.neo.pattern.factory01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class AwardRes {
    private String code; // 编码
    private String info; // 描述
}
