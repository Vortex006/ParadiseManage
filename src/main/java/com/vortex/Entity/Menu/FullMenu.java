package com.vortex.Entity.Menu;

import java.util.ArrayList;

public class FullMenu {

    private int FullMenuId;
    private String FullMenuName;
    private String FullMenuIcon;
    private String FullMenuIndex;
    private String FullMenuRoute;
    private ArrayList<SubMenu> FullMenuChildren;

    public FullMenu() {
    }

    public FullMenu(int fullMenuId, String fullMenuName, String fullMenuIcon, String fullMenuIndex,
                    String fullMenuRoute, ArrayList<SubMenu> fullMenuChildren) {
        FullMenuId = fullMenuId;
        FullMenuName = fullMenuName;
        FullMenuIcon = fullMenuIcon;
        FullMenuIndex = fullMenuIndex;
        FullMenuRoute = fullMenuRoute;
        FullMenuChildren = fullMenuChildren;
    }

    public int getFullMenuId() {
        return FullMenuId;
    }

    public void setFullMenuId(int fullMenuId) {
        FullMenuId = fullMenuId;
    }

    public String getFullMenuName() {
        return FullMenuName;
    }

    public void setFullMenuName(String fullMenuName) {
        FullMenuName = fullMenuName;
    }

    public String getFullMenuIcon() {
        return FullMenuIcon;
    }

    public void setFullMenuIcon(String fullMenuIcon) {
        FullMenuIcon = fullMenuIcon;
    }

    public String getFullMenuIndex() {
        return FullMenuIndex;
    }

    public void setFullMenuIndex(String fullMenuIndex) {
        FullMenuIndex = fullMenuIndex;
    }

    public String getFullMenuRoute() {
        return FullMenuRoute;
    }

    public void setFullMenuRoute(String fullMenuRoute) {
        FullMenuRoute = fullMenuRoute;
    }

    public ArrayList<SubMenu> getFullMenuChildren() {
        return FullMenuChildren;
    }

    public void setFullMenuChildren(ArrayList<SubMenu> fullMenuChildren) {
        FullMenuChildren = fullMenuChildren;
    }

    @Override
    public String toString() {
        return "FullMenu{" +
                "FullMenuId=" + FullMenuId +
                ", FullMenuName='" + FullMenuName + '\'' +
                ", FullMenuIcon='" + FullMenuIcon + '\'' +
                ", FullMenuIndex='" + FullMenuIndex + '\'' +
                ", FullMenuRoute='" + FullMenuRoute + '\'' +
                ", FullMenuChildren=" + FullMenuChildren +
                '}';
    }
}
