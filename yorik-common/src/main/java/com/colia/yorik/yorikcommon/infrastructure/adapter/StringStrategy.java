package com.colia.yorik.yorikcommon.infrastructure.adapter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * adapter string 适配器
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
