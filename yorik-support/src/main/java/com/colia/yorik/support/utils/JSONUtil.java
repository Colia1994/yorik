package com.colia.yorik.support.utils;


import com.colia.yorik.common.infrastructure.exception.JsonParseException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.StringWriter;

/**
 * json 工具类
 *
 * @Author konglingyao
 * @Date 2020/7/31
 */
@Slf4j
public class JSONUtil {

    private static final JsonFactory jsonFactory = new JsonFactory();
    private static final ObjectMapper defaultObjectMapper = createObjectMapper();

    public static ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();

        objectMapper.registerModule(module);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, false);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    public JSONUtil() {
    }

    /**
     * 转换成方便打印的json
     *
     * @param value 待处理对象
     * @param <T>   待处理对象类型
     * @return 方便打印的json字符串
     * @throws JsonParseException 解析异常
     */
    public static <T> String transferToString(T value) throws JsonParseException {


        String res;
        try {
            res = defaultObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
        } catch (Exception e) {
            log.error("transferToJson:json parse error:{}", value, e);
            throw new JsonParseException(e);
        }
        return res;
    }

    /**
     * 转换成发方便传输的json
     *
     * @param value 待处理对象
     * @param <T>   待处理对象类型
     * @return 方便打印的json字符串
     * @throws JsonParseException 解析异常
     */
    public static <T> String transferToJson(T value) throws JsonParseException {

        StringWriter sw = new StringWriter();
        JsonGenerator gen = null;

        String res;
        try {
            gen = jsonFactory.createGenerator(sw);
            defaultObjectMapper.writeValue(gen, value);
            res = sw.toString();
        } catch (IOException e) {
            log.error("transferToJson:json parse error:{}", value, e);
            throw new JsonParseException(e);
        } finally {
            if (gen != null) {
                try {
                    gen.close();
                } catch (IOException e) {
                    log.error("transferToJson:close JsonGenerator:exception", e);
                }
            }
        }
        return res;
    }

    public static <T> T transferToObj(String jsonString, Class<T> valueType) throws JsonParseException {
        T value;
        if (StringUtils.isNotBlack(jsonString)) {
            try {
                value = defaultObjectMapper.readValue(jsonString, valueType);
                return value;
            } catch (IOException e) {
                log.error("transferToObj:json parse error:{}", jsonString, e);
                throw new JsonParseException(e);

            }
        } else {
            return null;
        }
    }

    public static <T> T transferToObj(String jsonString, TypeReference<T> typeReference) {
        if (StringUtils.isNotBlack(jsonString) && typeReference != null) {
            try {
                return defaultObjectMapper.readValue(jsonString, typeReference);
            } catch (IOException e) {
                log.error("transferToObj:json parse to type error:{}", jsonString, e);
                throw new JsonParseException(e);
            }
        } else {
            throw new JsonParseException();
        }
    }
}
