package com.colia.yorik.common.infrastructure.adapter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * adapter string 适配器
 * 暂时提供mapping struct使用
 *
 * @Author konglingyao
 * @Date 2020/7/25
 */
@Component
public class StringStrategy {

    public List<String> stringToList(String value) {

        if (value == null) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        res.add(value);
        return res;
    }

}
