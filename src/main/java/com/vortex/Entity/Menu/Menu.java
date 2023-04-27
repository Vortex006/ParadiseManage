package com.vortex.Entity.Menu;

public class Menu {
    private int MenuId;
    private String Name;
    private String Icon;
    private String Index;
    private String Route;

    public Menu() {

    }

    public Menu(int menuId, String name, String icon, String index, String route) {
        MenuId = menuId;
        Name = name;
        Icon = icon;
        Index = index;
        Route = route;
    }

    public int getMenuId() {
        return MenuId;
    }

    public void setMenuId(int menuId) {
        MenuId = menuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
        Icon = icon;
    }

    public String getIndex() {
        return Index;
    }

    public void setIndex(String index) {
        Index = index;
    }

    public String getRoute() {
        return Route;
    }

    public void setRoute(String route) {
        Route = route;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "MenuId=" + MenuId +
                ", Name='" + Name + '\'' +
                ", Icon='" + Icon + '\'' +
                ", Index='" + Index + '\'' +
                ", Route='" + Route + '\'' +
                '}';
    }
}
