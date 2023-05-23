package com.vortex.Entity;

public class Action {
    private int actionId;
    private String actionType;
    private String actionName;
    private String actionData;
    private String actionDate;
    private String actionOther;

    public Action() {
    }

    public Action(String actionData, String actionDate) {
        this.actionData = actionData;
        this.actionDate = actionDate;
    }

    public Action(String actionType, String actionName, String actionData, String actionDate, String actionOther) {
        this.actionType = actionType;
        this.actionName = actionName;
        this.actionData = actionData;
        this.actionDate = actionDate;
        this.actionOther = actionOther;
    }

    public Action(int actionId, String actionType, String actionName, String actionData, String actionDate,
                  String actionOther) {
        this.actionId = actionId;
        this.actionType = actionType;
        this.actionName = actionName;
        this.actionData = actionData;
        this.actionDate = actionDate;
        this.actionOther = actionOther;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionData() {
        return actionData;
    }

    public void setActionData(String actionData) {
        this.actionData = actionData;
    }

    public String getActionDate() {
        return actionDate;
    }

    public void setActionDate(String actionDate) {
        this.actionDate = actionDate;
    }

    public String getActionOther() {
        return actionOther;
    }

    public void setActionOther(String actionOther) {
        this.actionOther = actionOther;
    }

    @Override
    public String toString() {
        return "Action{" +
                "actionId=" + actionId +
                ", actionType='" + actionType + '\'' +
                ", actionName='" + actionName + '\'' +
                ", actionData='" + actionData + '\'' +
                ", actionDate='" + actionDate + '\'' +
                ", actionOther='" + actionOther + '\'' +
                '}';
    }
}
