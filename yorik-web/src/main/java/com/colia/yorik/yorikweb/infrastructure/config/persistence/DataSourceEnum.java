package com.colia.yorik.yorikweb.infrastructure.config.persistence;

public enum DataSourceEnum {

    ADMIN_DB("admindb"), BUSSINESS_DB("bussinessdb");

    private String value;

    DataSourceEnum(String value){this.value=value;}

    public String getValue() {
        return value;
    }
}
