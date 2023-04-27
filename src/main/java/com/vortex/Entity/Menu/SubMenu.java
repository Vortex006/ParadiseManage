package com.vortex.Entity.Menu;

import java.util.ArrayList;

public class SubMenu extends Menu {
    private ArrayList<Menu> Children;

    public SubMenu(int menuId, String name, String icon, String index, String route, ArrayList<Menu> children) {
        super(menuId, name, icon, index, route);
        Children = children;
    }

    public SubMenu(ArrayList<Menu> children) {
        Children = children;
    }

    public ArrayList<Menu> getChildren() {
        return Children;
    }

    public void setChildren(ArrayList<Menu> children) {
        Children = children;
    }

    @Override
    public String toString() {
        return "SubMenu{" +
                "Children=" + Children +
                "} " + super.toString();
    }
}
