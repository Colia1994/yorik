package com.colia.yorik.yorikcommon.application.enums;

/**
 * @Author konglingyao
 * @Date 2020/8/11
 */
public enum CatsEnum {

    WOMEN("女装",8439),
    MAN("男装",239),
    FOOD("美食",6398),
    MEI_ZHUANG("美妆",18482),
    RI_YONG("日用",16989),
    SHIPING("饰品",17412),
    CHONGWU("宠物",16288);

    private String name;

    private Integer pddId;

    CatsEnum(String name,Integer pddId){
        this.name = name;
        this.pddId = pddId;
    }


}
