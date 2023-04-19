package com.colia.yorik.web.interfaces.user.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.ql.util.express.Operator;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


public class JSONCompararetor {
    public boolean compare(String jsonRule, String jsonRaw) throws Exception {

        JSONObject rule = JSON.parseObject(jsonRule.toString());
        JSONObject raw = JSON.parseObject(jsonRaw.toString());
        boolean result = false;
        for (String key : rule.keySet()) {
            List<String> tempRuleList = Arrays.asList(rule.getString(key).split(",").clone());
            List<String> tempRawList = Arrays.asList(raw.getString(key).split(",").clone());
            ;
            if (tempRawList.stream().anyMatch(item ->
                    tempRuleList.contains(item)
            ))
                result = true
                        ;

        }
        return result;
    }

    private Object getValueSolution(String valueType) {
        return String.class;
    }
}