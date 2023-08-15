package com.vortex.Entity;

public class God {
    private int godId;//神仙ID
    private String godName;//神仙姓名
    private char godSex;//神仙性别
    private String godType;//神仙类型
    private String godDepartment;//神仙部门
    private String godJob;//神仙职位
    private Long godMerit;//神仙功德
    private String godLocation;//神仙住址

    public God() {
    }

    public God(String godName, char godSex, String godType, String godDepartment, String godJob, Long godMerit,
               String godLocation) {
        this.godName = godName;
        this.godSex = godSex;
        this.godType = godType;
        this.godDepartment = godDepartment;
        this.godJob = godJob;
        this.godMerit = godMerit;
        this.godLocation = godLocation;
    }

    public God(int godId, String godName, char godSex, String godType, String godDepartment, String godJob,
               Long godMerit, String godLocation) {
        this.godId = godId;
        this.godName = godName;
        this.godSex = godSex;
        this.godType = godType;
        this.godDepartment = godDepartment;
        this.godJob = godJob;
        this.godMerit = godMerit;
        this.godLocation = godLocation;
    }

    public int getGodId() {
        return godId;
    }

    public void setGodId(int godId) {
        this.godId = godId;
    }

    public String getGodName() {
        return godName;
    }

    public void setGodName(String godName) {
        this.godName = godName;
    }

    public char getGodSex() {
        return godSex;
    }

    public void setGodSex(char godSex) {
        this.godSex = godSex;
    }

    public String getGodType() {
        return godType;
    }

    public void setGodType(String godType) {
        this.godType = godType;
    }

    public String getGodDepartment() {
        return godDepartment;
    }

    public void setGodDepartment(String godDepartment) {
        this.godDepartment = godDepartment;
    }

    public String getGodJob() {
        return godJob;
    }

    public void setGodJob(String godJob) {
        this.godJob = godJob;
    }

    public Long getGodMerit() {
        return godMerit;
    }

    public void setGodMerit(Long godMerit) {
        this.godMerit = godMerit;
    }

    public String getGodLocation() {
        return godLocation;
    }

    public void setGodLocation(String godLocation) {
        this.godLocation = godLocation;
    }

    @Override
    public String toString() {
        return "God{" +
                "godId=" + godId +
                ", godName='" + godName + '\'' +
                ", godSex=" + godSex +
                ", godType='" + godType + '\'' +
                ", godDepartment='" + godDepartment + '\'' +
                ", godJob='" + godJob + '\'' +
                ", godMerit=" + godMerit +
                ", godLocation='" + godLocation + '\'' +
                '}';
    }
}
