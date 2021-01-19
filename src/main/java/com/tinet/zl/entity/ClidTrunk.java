package com.tinet.zl.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class ClidTrunk implements Serializable {
    private String clid;
    private String areaCode;
    private String trunkGroup;
    private String trunkGroupKey;
    private Integer active;
    private Integer isInUse = 1;
    private Integer isObClid;
    private Integer type;
    private String bindCno;
    private String hotline;
    private Integer isDefault;
    private Integer isAxbA;
    private Integer isIntl;
    private Integer isOwned;
    private Integer isPredictiveLeft;
    private Integer isPredictiveRight;
    private Integer isIbRight;
    private Integer isPreviewRight;
    private Integer isWebCallLeft;
    private Integer callLimit;
    private String comment;
    private Date operateTime;
    private Date createTime;
    private Map<String, String> label;

    public ClidTrunk() {
    }

    public String getClid() {
        return this.clid;
    }

    public void setClid(String clid) {
        this.clid = clid;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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

    public Integer getActive() {
        return this.active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getIsInUse() {
        return this.isInUse;
    }

    public void setIsInUse(Integer isInUse) {
        this.isInUse = isInUse;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBindCno() {
        return this.bindCno;
    }

    public void setBindCno(String bindCno) {
        this.bindCno = bindCno;
    }

    public String getHotline() {
        return this.hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public Integer getIsDefault() {
        return this.isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getIsAxbA() {
        return this.isAxbA;
    }

    public void setIsAxbA(Integer isAxbA) {
        this.isAxbA = isAxbA;
    }

    public Integer getIsIntl() {
        return this.isIntl;
    }

    public void setIsIntl(Integer isIntl) {
        this.isIntl = isIntl;
    }

    public Integer getIsOwned() {
        return this.isOwned;
    }

    public void setIsOwned(Integer isOwned) {
        this.isOwned = isOwned;
    }

    public Integer getIsPredictiveLeft() {
        return this.isPredictiveLeft;
    }

    public void setIsPredictiveLeft(Integer isPredictiveLeft) {
        this.isPredictiveLeft = isPredictiveLeft;
    }

    public Integer getIsPredictiveRight() {
        return this.isPredictiveRight;
    }

    public void setIsPredictiveRight(Integer isPredictiveRight) {
        this.isPredictiveRight = isPredictiveRight;
    }

    public Integer getIsIbRight() {
        return this.isIbRight;
    }

    public void setIsIbRight(Integer isIbRight) {
        this.isIbRight = isIbRight;
    }

    public Integer getIsPreviewRight() {
        return this.isPreviewRight;
    }

    public void setIsPreviewRight(Integer isPreviewRight) {
        this.isPreviewRight = isPreviewRight;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOperateTime() {
        return this.operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Integer getIsWebCallLeft() {
        return this.isWebCallLeft;
    }

    public void setIsWebCallLeft(Integer isWebCallLeft) {
        this.isWebCallLeft = isWebCallLeft;
    }

    public Integer getCallLimit() {
        return this.callLimit;
    }

    public void setCallLimit(Integer callLimit) {
        this.callLimit = callLimit;
    }

    public Map<String, String> getLabel() {
        return this.label;
    }

    public void setLabel(Map<String, String> label) {
        this.label = label;
    }

    public Integer getIsObClid() {
        return this.isObClid;
    }

    public void setIsObClid(Integer isObClid) {
        this.isObClid = isObClid;
    }
}
