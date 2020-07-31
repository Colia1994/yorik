package com.colia.yorik.yoriksupport.utils;


import com.colia.yorik.yorikcommon.infrastructure.exception.JsonParseException;
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
