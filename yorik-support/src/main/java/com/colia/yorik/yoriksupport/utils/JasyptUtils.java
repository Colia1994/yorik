package com.colia.yorik.yoriksupport.utils;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author konglingyao
 * @Date 2020/8/5
 */
@Component
public class JasyptUtils {

    @Resource
    private StringEncryptor encryptorBean;

    public String encrypt(String originPassword) {
        return encryptorBean.encrypt( originPassword );
    }

    public String decrypt( String encryptedPassword ) {
        return encryptorBean.decrypt( encryptedPassword );
    }
}
