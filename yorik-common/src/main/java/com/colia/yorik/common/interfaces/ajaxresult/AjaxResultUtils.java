package com.colia.yorik.common.interfaces.ajaxresult;


import com.colia.yorik.common.interfaces.jenum.ErrorEnums;
import org.apache.commons.lang3.StringUtils;

/**
 * AJAX返回值构建工厂
 *
 * @Author colia
 * @Date 2020/7/16 下午6:55
 */
public class AjaxResultUtils {

    /**
     * 执行成功 默认提示"成功"
     *
     * @return 标准格式返回
     */
    public static <T> AjaxResponse<T> renderSuccess() {
        return renderSuccess(null, null);
    }

    /**
     * 执行成功 返回自定义提示语
     *
     * @return 标准格式返回
     */
    public static <T> AjaxResponse<T> renderSuccess(String message) {
        return renderSuccess(message, null);
    }

    /**
     * 执行成功 默认提示"成功"  返回data数据体
     *
     * @param data 需要返回的数据
     * @return 标准格式返回
     */
    public static <T> AjaxResponse<T> renderSuccess(T data) {
        return renderSuccess(null, data);
    }

    /**
     * 执行成功 返回自定义提示语  返回data数据体
     *
     * @param msg  消息体
     * @param data 数据体
     * @return 标准格式返回
     */
    public static <T> AjaxResponse<T> renderSuccess(String msg, T data) {
        return new AjaxResultSuccess<T>().build(msg, data);
    }

    /**
     * 执行失败 返回默认错误编码500 默认提示语 "系统异常"  执行事件 "UNDO"
     *
     * @return 标准格式返回
     */
    public static <T> AjaxResponse<T> renderFail() {
        return renderFail(null, null, null);
    }


    /**
     * 执行失败 返回默认错误编码500 默认提示语 "系统异常"  执行事件 "UNDO"
     */
    public static <T> AjaxResponse<T> renderFail(ErrorEnums errorEnums) {
        return renderFail(errorEnums.getType(), errorEnums.getCode(), errorEnums.getMsg());

    }

    /**
     * 执行失败 返回自定义提示语  自定义执行事件
     *
     * @param message 错误信息
     */
    public static <T> AjaxResponse<T> renderFail(String message) {
        return renderFail(null, null, message);
    }

    /**
     * 执行失败 返回自定义错误编码 自定义提示语
     *
     * @param type    错误类型
     * @param message 错误消息
     * @return 标准格式返回
     */
    public static <T> AjaxResponse<T> renderFail(String message, String type) {
        return renderFail(type, null, message);
    }


    /**
     * 执行失败 返回自定义错误编码 自定义提示语 自定义异常名称  执行事件 "UNDO"
     *
     * @param type    错误类型
     * @param code    错误编码
     * @param message 错误信息
     * @return 标准格式返回
     */
    public static <T> AjaxResponse<T> renderFail(String type, String code, String message) {
        return new AjaxResultError<T>().build(type, code, message);
    }

    /**
     * 成功
     */
    static class AjaxResultSuccess<T> {

        public AjaxResponse<T> build(String message, T data) {
            AjaxResponse<T> ajaxSuccessResponse = new AjaxResponse<>(Boolean.TRUE);

            if (!StringUtils.isEmpty(message)) {

                ajaxSuccessResponse.setMsg(message);
            }

            ajaxSuccessResponse.setData(data);
            return ajaxSuccessResponse;
        }
    }

    /**
     * 异常
     */
    static class AjaxResultError<T> {

        public AjaxResponse<T> build(String type, String code, String message) {
            AjaxResponse<T> ajaxErrorResponse = new AjaxResponse<>(Boolean.FALSE);

            ajaxErrorResponse.setMsg(message);

            return ajaxErrorResponse;
        }
    }
}