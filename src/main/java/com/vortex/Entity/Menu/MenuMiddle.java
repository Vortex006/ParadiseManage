package com.vortex.Entity.Menu;

public class MenuMiddle extends Menu {
    private String Children;

    public MenuMiddle(String children) {
        Children = children;
    }

    public MenuMiddle(int menuId, String name, String icon, String index, String route, String children) {
        super(menuId, name, icon, index, route);
        Children = children;
    }

    public String getChildren() {
        return Children;
    }

    public void setChildren(String children) {
        Children = children;
    }

    @Override
    public String toString() {
        return "MenuMiddle{" +
                "Children='" + Children + '\'' +
                "} " + super.toString();
    }
}
