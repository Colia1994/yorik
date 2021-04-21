package com.colia.yorik.support.utils;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author konglingyao
 * @Date 2020/8/5
 */
@Component
public class JasyptUtils {

    @Resource
    private StringEncryptor encryptBean;

    public String encrypt(String originPassword) {
        return encryptBean.encrypt(originPassword);
    }

    public String decrypt(String encryptedPassword) {
        return encryptBean.decrypt(encryptedPassword);
    }

}
