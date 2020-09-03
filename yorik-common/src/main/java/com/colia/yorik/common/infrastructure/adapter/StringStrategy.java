package com.colia.yorik.common.infrastructure.adapter;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * adapter money 适配器
 * 暂时提供mapping struct使用
 *
 * @Author konglingyao
 * @Date 2020/9/3
 */
@Component
public class StringStrategy {

    /**
     * 单个字符串转list
     *
     * @param value 单个字符串
     * @return list
     */
    public List<String> stringToList(String value) {

        if (value == null) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        res.add(value);
        return res;
    }

    /**
     * 多个字符串取其一 默认第一个
     *
     * @param list 多个字符串
     * @return 取其一
     */
    public String listToString(List<String> list) {

        if (CollectionUtils.isEmpty(list)){
            return "";
        }
        return list.get(0);
    }



}
