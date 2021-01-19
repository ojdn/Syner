package com.tinet.zl.entity;

/**
 * @Author: zhang lei
 * @Describe: All things are difficult before they are easy.
 * @CreatTime: 2021-01-18-17-20
 */


import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

public class CtiLinkEnterpriseSetting implements Serializable {

    private Integer id;
    private Integer enterpriseId;
    private String name;
    private String value;
    private String property;
    private Date createTime;

    public CtiLinkEnterpriseSetting() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnterpriseId() {
        return this.enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "EnterpriseSetting {id=" + this.id + ", enterpriseId=" + this.enterpriseId + ", name=" + this.name + ", value=" + this.value + ", property=" + this.property + ", createTime=" + this.createTime + "}";
    }
}
