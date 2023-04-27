package com.vortex.Entity;

public class God {
    private int godId;
    private String godName;
    private String godSex;
    private String godType;
    private String godPosition;
    private String godPlace;
    private int godMerit;
    private String godMaster;

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

    public int getGodMerit() {
        return godMerit;
    }

    public void setGodMerit(int godMerit) {
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
                ", godPosition='" + godPosition + '\'' +
                ", godPlace='" + godPlace + '\'' +
                ", godMerit='" + godMerit + '\'' +
                ", godMaster='" + godMaster + '\'' +
                '}';
    }
}
