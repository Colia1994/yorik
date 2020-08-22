package com.colia.yorik.yorikapplication.application.goods.request;

import com.colia.yorik.yorikcommon.interfaces.requestBody.CommonCommand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.jar.JarFile;

/**
 * @Author konglingyao
 * @Date 2020/7/19
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "推荐商品请求参数")
public class GoodsDetailRequest extends CommonCommand {


    @ApiModelProperty(value = "商品id", required = true)
    private Long goodsId;

    @ApiModelProperty("推广位id")
    private String pid;

    @ApiModelProperty("佣金优惠券对应推广类型，3：专属 4：招商")
    private Integer planType;

    @ApiModelProperty("搜索id")
    private String searchId;


    @Override
    public void validate() {

    }
}
