package com.colia.yorik.web.infrastructure.config;



import com.colia.yorik.support.infrastructure.exception.BizProcessException;
import com.colia.yorik.support.interfaces.ajaxresult.AjaxResponse;
import com.colia.yorik.support.interfaces.ajaxresult.AjaxResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/**
 * 统一异常捕获处理
 *
 * @Author konglingyao
 * @Date 2020/10/27
 **/
@ControllerAdvice
@Slf4j
public class ExceptionWrapper {

    /**
     * 业务运行时异常统一包装
     */
    @ExceptionHandler({BizProcessException.class})
    public ResponseEntity<AjaxResponse> preBizProcessException(BizProcessException e) {
        log.error("【业务处理异常】：{}", e.getMessage(), e);
        return new ResponseEntity<>(
                AjaxResultUtils.renderFail(null, e.getClass().getSimpleName(), e.getMessage()),
                HttpHeader.buildResponseJsonHeaders(), HttpStatus.OK);
    }


    /**
     * RPC异常统一包装
     *
     */
//    @ExceptionHandler({AdapterRemoteException.class})
//    public ResponseEntity<AjaxResponse> preAdapterRemoteException(AdapterRemoteException e) {
//        logger.error("【RPC调用异常】：{}", e.getMessage(), e);
//        return new ResponseEntity(AjaxResultUtils.renderFail(e.getMessage(), e.getClass().getSimpleName(), AjaxErrorEvent.ALTER), HttpHeader.buildResponeJsonHeaders(), HttpStatus.OK);
//    }

//    /**
//     * 参数异常统一包装
//     */
//    @ExceptionHandler({ValidateException.class})
//    public ResponseEntity<AjaxResponse> preValidateException(ValidateException e) {
//        log.error("【参数校验异常】：{}", e.getMessage(), e);
//        return new ResponseEntity<>(
//                AjaxResultUtils.renderFail(e.getMessage(), e.getClass().getSimpleName(), AjaxErrorEvent.ALTER),
//                HttpHeader.buildResponseJsonHeaders(), HttpStatus.OK);
//    }

    /**
     * 参数异常统一包装，系统自带
     */
    @ExceptionHandler({InvocationTargetException.class})
    public ResponseEntity<AjaxResponse> preInvocationTargetException(InvocationTargetException e) {
        log.error("【参数校验异常-框架自身】：{}", e.getMessage(), e);
        return new ResponseEntity<>(
                AjaxResultUtils.renderFail(e.getTargetException().getMessage(), e.getTargetException().getClass().getSimpleName()),
                HttpHeader.buildResponseJsonHeaders(), HttpStatus.OK);
    }

    /**
     * 未知异常处理
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<AjaxResponse> preException(Exception e) {
        String errorID = UUID.randomUUID().toString().replace("-", "");
        log.error("【未知异常】：ID【{}】，{}请联系管理员！", errorID, e.getMessage(), e);
        return new ResponseEntity<>(AjaxResultUtils.renderFail("【未知异常】errorMessage：" + e.getMessage() + "，异常ID【" + errorID + "】，请联系管理员！", e.getClass().getSimpleName()),
                HttpHeader.buildResponseJsonHeaders(), HttpStatus.OK);
    }
}