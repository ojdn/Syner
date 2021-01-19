package com.tinet.zl.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

public class CtiLinkEnterpriseHotline implements Serializable {
    private Integer id;
    private Integer enterpriseId;
    private String hotline;
    private Integer isMaster;
    private String areaCode;
    private String numberTrunk;
    private Integer type;
    private String name;
    private String trunkGroup;
    private String trunkGroupKey;
    private String comment;
    private Date createTime;

    public CtiLinkEnterpriseHotline() {
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

    public String getHotline() {
        return this.hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline == null ? null : hotline.trim();
    }

    public Integer getIsMaster() {
        return this.isMaster;
    }

    public void setIsMaster(Integer isMaster) {
        this.isMaster = isMaster;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumberTrunk() {
        return this.numberTrunk;
    }

    public void setNumberTrunk(String numberTrunk) {
        this.numberTrunk = numberTrunk == null ? null : numberTrunk.trim();
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTrunkGroup() {
        return this.trunkGroup;
    }

    public void setTrunkGroup(String trunkGroup) {
        this.trunkGroup = trunkGroup;
    }

    public String getTrunkGroupKey() {
        return this.trunkGroupKey;
    }

    public void setTrunkGroupKey(String trunkGroupKey) {
        this.trunkGroupKey = trunkGroupKey;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        return "EnterpriseHotline {id=" + this.id + ", enterpriseId=" + this.enterpriseId + ", hotline=" + this.hotline + ", isMaster=" + this.isMaster + ", areaCode=" + this.areaCode + ", name=" + this.name + ", numberTrunk=" + this.numberTrunk + ", type=" + this.type + ", trunkGroup=" + this.trunkGroup + ", trunkGroupKey=" + this.trunkGroupKey + ", comment=" + this.comment + ", createTime=" + this.createTime + "}";
    }
}
