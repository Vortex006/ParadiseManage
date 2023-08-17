package com.vortex.Entity;

public class DepartmentDo {
    private int departmentId;//部门ID
    private String departmentName;//部门名称
    private String departmentInfo;//部门描述

    public DepartmentDo() {
    }

    public DepartmentDo(String departmentName, String departmentInfo) {
        this.departmentName = departmentName;
        this.departmentInfo = departmentInfo;
    }

    public DepartmentDo(int departmentId, String departmentName, String departmentInfo) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentInfo = departmentInfo;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentInfo() {
        return departmentInfo;
    }

    public void setDepartmentInfo(String departmentInfo) {
        this.departmentInfo = departmentInfo;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentInfo='" + departmentInfo + '\'' +
                '}';
    }
}
