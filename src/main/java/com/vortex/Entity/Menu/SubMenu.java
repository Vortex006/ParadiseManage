package com.vortex.Entity.Menu;

public class SubMenu {
    private int subMenuId;
    private String subMenuName;
    private String subMenuIcon;
    private String subMenuIndex;
    private String subMenuRoute;

    public SubMenu() {
    }

    public SubMenu(int subMenuId, String subMenuName, String subMenuIcon, String subMenuIndex, String subMenuRoute) {
        this.subMenuId = subMenuId;
        this.subMenuName = subMenuName;
        this.subMenuIcon = subMenuIcon;
        this.subMenuIndex = subMenuIndex;
        this.subMenuRoute = subMenuRoute;
    }

    public int getSubMenuId() {
        return subMenuId;
    }

    public void setSubMenuId(int subMenuId) {
        this.subMenuId = subMenuId;
    }

    public String getSubMenuName() {
        return subMenuName;
    }

    public void setSubMenuName(String subMenuName) {
        this.subMenuName = subMenuName;
    }

    public String getSubMenuIcon() {
        return subMenuIcon;
    }

    public void setSubMenuIcon(String subMenuIcon) {
        this.subMenuIcon = subMenuIcon;
    }

    public String getSubMenuIndex() {
        return subMenuIndex;
    }

    public void setSubMenuIndex(String subMenuIndex) {
        this.subMenuIndex = subMenuIndex;
    }

    public String getSubMenuRoute() {
        return subMenuRoute;
    }

    public void setSubMenuRoute(String subMenuRoute) {
        this.subMenuRoute = subMenuRoute;
    }

    @Override
    public String toString() {
        return "SubMenu{" +
                "subMenuId=" + subMenuId +
                ", subMenuName='" + subMenuName + '\'' +
                ", subMenuIcon='" + subMenuIcon + '\'' +
                ", subMenuIndex='" + subMenuIndex + '\'' +
                ", subMenuRoute='" + subMenuRoute + '\'' +
                '}';
    }
}
