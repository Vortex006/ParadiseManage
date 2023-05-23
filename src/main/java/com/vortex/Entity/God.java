package com.vortex.Entity;

public class God {
    private int godId; //神仙ID
    private String godName; //神仙名字
    private String godSex; //神仙性别
    private String godType; //神仙类别
    private String godDepartment; //神仙部门
    private String godPosition; //神仙职位
    private String godPlace; //神仙道场
    private long godMerit; //神仙功德
    private String godMaster; //神仙尊号


    public God() {
    }

    public God(String godName, String godSex, String godType, String godDepartment, String godPosition,
               String godPlace, long godMerit, String godMaster) {
        this.godName = godName;
        this.godSex = godSex;
        this.godType = godType;
        this.godDepartment = godDepartment;
        this.godPosition = godPosition;
        this.godPlace = godPlace;
        this.godMerit = godMerit;
        this.godMaster = godMaster;
    }

    public God(int godId, String godName, String godSex, String godType, String godDepartment, String godPosition,
               String godPlace, long godMerit, String godMaster) {
        this.godId = godId;
        this.godName = godName;
        this.godSex = godSex;
        this.godType = godType;
        this.godDepartment = godDepartment;
        this.godPosition = godPosition;
        this.godPlace = godPlace;
        this.godMerit = godMerit;
        this.godMaster = godMaster;
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

    public String getGodSex() {
        return godSex;
    }

    public void setGodSex(String godSex) {
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

    public String getGodPosition() {
        return godPosition;
    }

    public void setGodPosition(String godPosition) {
        this.godPosition = godPosition;
    }

    public String getGodPlace() {
        return godPlace;
    }

    public void setGodPlace(String godPlace) {
        this.godPlace = godPlace;
    }

    public long getGodMerit() {
        return godMerit;
    }

    public void setGodMerit(long godMerit) {
        this.godMerit = godMerit;
    }

    public String getGodMaster() {
        return godMaster;
    }

    public void setGodMaster(String godMaster) {
        this.godMaster = godMaster;
    }

    @Override
    public String toString() {
        return "God{" +
                "godId=" + godId +
                ", godName='" + godName + '\'' +
                ", godSex='" + godSex + '\'' +
                ", godType='" + godType + '\'' +
                ", godDepartment='" + godDepartment + '\'' +
                ", godPosition='" + godPosition + '\'' +
                ", godPlace='" + godPlace + '\'' +
                ", godMerit=" + godMerit +
                ", godMaster='" + godMaster + '\'' +
                '}';
    }
}
