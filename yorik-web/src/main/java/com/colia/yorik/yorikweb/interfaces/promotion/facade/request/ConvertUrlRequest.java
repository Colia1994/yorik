package com.colia.yorik.yorikweb.interfaces.promotion.facade.request;

import com.colia.yorik.yorikcommon.interfaces.requestBody.CommandValidate;
import com.colia.yorik.yorikcommon.interfaces.requestBody.RequestCommand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author konglingyao
 * @Date 2020/8/4
 */
@Data
@ApiModel(description = "转换推广链接请求参数")
public class ConvertUrlRequest implements RequestCommand {

    /**
     * 自定义参数，为链接打上自定义标签；自定义参数最长限制64个字节；格式为： {"uid":"11111","sid":"22222"} ，
     * 其中 uid 用户唯一标识，可自行加密后传入，每个用户仅且对应一个标识，必填； sid 上下文信息标识，例如sessionId等，非必填。
     * 该json字符串中也可以加入其他自定义的key
     */
    @ApiModelProperty("自定义参数")
    private String customParameters;

    /**
     * 原链接
     */
    @ApiModelProperty("原链接")
    private String sourceUrl;

    /**
     * 数据源类型 1 pdd 2 淘宝
     */
    @ApiModelProperty("数据源类型 1 pdd 2 淘宝")
    private Integer sourceType;

    /**
     * 指令验证
     */
    @Override
    public void validate() {
        CommandValidate.notEmpty(sourceUrl, "原链接不能为空！");
        CommandValidate.notNull(sourceType, "数据源类型不能为空！");
    }
}
