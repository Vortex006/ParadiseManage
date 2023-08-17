package com.vortex.Entity.Menu;

import java.util.ArrayList;

public class FullMenu {

    private int fullMenuId;
    private String fullMenuName;
    private String fullMenuIcon;
    private String fullMenuIndex;
    private String fullMenuRoute;
    private ArrayList<SubMenuDo> fullMenuChildList;

    public FullMenu() {
    }

    public FullMenu(int fullMenuId, String fullMenuName, String fullMenuIcon, String fullMenuIndex,
                    String fullMenuRoute, ArrayList<SubMenuDo> fullMenuChildList) {
        this.fullMenuId = fullMenuId;
        this.fullMenuName = fullMenuName;
        this.fullMenuIcon = fullMenuIcon;
        this.fullMenuIndex = fullMenuIndex;
        this.fullMenuRoute = fullMenuRoute;
        this.fullMenuChildList = fullMenuChildList;
    }

    public int getFullMenuId() {
        return fullMenuId;
    }

    public void setFullMenuId(int fullMenuId) {
        this.fullMenuId = fullMenuId;
    }

    public String getFullMenuName() {
        return fullMenuName;
    }

    public void setFullMenuName(String fullMenuName) {
        this.fullMenuName = fullMenuName;
    }

    public String getFullMenuIcon() {
        return fullMenuIcon;
    }

    public void setFullMenuIcon(String fullMenuIcon) {
        this.fullMenuIcon = fullMenuIcon;
    }

    public String getFullMenuIndex() {
        return fullMenuIndex;
    }

    public void setFullMenuIndex(String fullMenuIndex) {
        this.fullMenuIndex = fullMenuIndex;
    }

    public String getFullMenuRoute() {
        return fullMenuRoute;
    }

    public void setFullMenuRoute(String fullMenuRoute) {
        this.fullMenuRoute = fullMenuRoute;
    }

    public ArrayList<SubMenuDo> getFullMenuChildList() {
        return fullMenuChildList;
    }

    public void setFullMenuChildList(ArrayList<SubMenuDo> fullMenuChildList) {
        this.fullMenuChildList = fullMenuChildList;
    }

    @Override
    public String toString() {
        return "FullMenu{" +
                "fullMenuId=" + fullMenuId +
                ", fullMenuName='" + fullMenuName + '\'' +
                ", fullMenuIcon='" + fullMenuIcon + '\'' +
                ", fullMenuIndex='" + fullMenuIndex + '\'' +
                ", fullMenuRoute='" + fullMenuRoute + '\'' +
                ", fullMenuChildList=" + fullMenuChildList +
                '}';
    }
}
