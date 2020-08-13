
package com.colia.yorik.yorikcommon.infrastructure.persistence.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * PO基类
 *
 * @Author colia
 * @Date 2020/07/15 下午3:45
 **/
@Data
public abstract class AbstractPO implements Serializable {


    @TableId(type = IdType.AUTO)
    private Long id;

}