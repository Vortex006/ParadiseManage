package com.vortex.Entity;

public class GodType {
    private int godTypeId;//神仙类型ID
    private String godTypeName;//神仙类型名称
    private String godTypeInfo;//神仙类型描述

    public GodType() {
    }

    public GodType(String godTypeName, String godTypeInfo) {
        this.godTypeName = godTypeName;
        this.godTypeInfo = godTypeInfo;
    }

    public GodType(int godTypeId, String godTypeName, String godTypeInfo) {
        this.godTypeId = godTypeId;
        this.godTypeName = godTypeName;
        this.godTypeInfo = godTypeInfo;
    }

    public int getGodTypeId() {
        return godTypeId;
    }

    public void setGodTypeId(int godTypeId) {
        this.godTypeId = godTypeId;
    }

    public String getGodTypeName() {
        return godTypeName;
    }

    public void setGodTypeName(String godTypeName) {
        this.godTypeName = godTypeName;
    }

    public String getGodTypeInfo() {
        return godTypeInfo;
    }

    public void setGodTypeInfo(String godTypeInfo) {
        this.godTypeInfo = godTypeInfo;
    }

    @Override
    public String toString() {
        return "GodType{" +
                "godTypeId=" + godTypeId +
                ", godTypeName='" + godTypeName + '\'' +
                ", godTypeInfo='" + godTypeInfo + '\'' +
                '}';
    }
}
