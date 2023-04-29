package com.vortex.Entity;

public class Action {
    private int ActionId;
    private String Type;
    private String Name;
    private String Data;
    private String Date;
    private String Other;

    public Action() {
    }

    public Action(String data, String date) {
        Data = data;
        Date = date;
    }

    public Action(String type, String name, String data, String date, String other) {
        Type = type;
        Name = name;
        Data = data;
        Date = date;
        Other = other;
    }

    @Override
    public String toString() {
        return "Action{" +
                "ActionId=" + ActionId +
                ", Type='" + Type + '\'' +
                ", Name='" + Name + '\'' +
                ", Data='" + Data + '\'' +
                ", Date='" + Date + '\'' +
                ", Other='" + Other + '\'' +
                '}';
    }

    public int getActionId() {
        return ActionId;
    }

    public void setActionId(int actionId) {
        ActionId = actionId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String other) {
        Other = other;
    }
}
