package com.vortex.Entity.Menu;

public class MainMenu {

    private int mainMenuId;
    private String mainMenuName;
    private String mainMenuIcon;
    private String mainMenuIndex;
    private String mainMenuRoute;
    private String mainMenuChildren;

    public MainMenu() {
    }

    public MainMenu(int mainMenuId, String mainMenuName, String mainMenuIcon, String mainMenuIndex,
                    String mainMenuRoute, String mainMenuChildren) {
        this.mainMenuId = mainMenuId;
        this.mainMenuName = mainMenuName;
        this.mainMenuIcon = mainMenuIcon;
        this.mainMenuIndex = mainMenuIndex;
        this.mainMenuRoute = mainMenuRoute;
        this.mainMenuChildren = mainMenuChildren;
    }

    public int getMainMenuId() {
        return mainMenuId;
    }

    public void setMainMenuId(int mainMenuId) {
        this.mainMenuId = mainMenuId;
    }

    public String getMainMenuName() {
        return mainMenuName;
    }

    public void setMainMenuName(String mainMenuName) {
        this.mainMenuName = mainMenuName;
    }

    public String getMainMenuIcon() {
        return mainMenuIcon;
    }

    public void setMainMenuIcon(String mainMenuIcon) {
        this.mainMenuIcon = mainMenuIcon;
    }

    public String getMainMenuIndex() {
        return mainMenuIndex;
    }

    public void setMainMenuIndex(String mainMenuIndex) {
        this.mainMenuIndex = mainMenuIndex;
    }

    public String getMainMenuRoute() {
        return mainMenuRoute;
    }

    public void setMainMenuRoute(String mainMenuRoute) {
        this.mainMenuRoute = mainMenuRoute;
    }

    public String getMainMenuChildren() {
        return mainMenuChildren;
    }

    public void setMainMenuChildren(String mainMenuChildren) {
        this.mainMenuChildren = mainMenuChildren;
    }

    @Override
    public String toString() {
        return "MainMenu{" +
                "mainMenuId=" + mainMenuId +
                ", mainMenuName='" + mainMenuName + '\'' +
                ", mainMenuIcon='" + mainMenuIcon + '\'' +
                ", mainMenuIndex='" + mainMenuIndex + '\'' +
                ", mainMenuRoute='" + mainMenuRoute + '\'' +
                ", mainMenuChildren='" + mainMenuChildren + '\'' +
                '}';
    }
}
