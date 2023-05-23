package com.vortex.Mapper;

import com.vortex.Entity.Action;
import com.vortex.Entity.Menu.Menu;
import com.vortex.Entity.Menu.MenuMiddle;

import java.util.ArrayList;
import java.util.List;

public interface ActionMapper {

    //插入一条Action
    int addAction(Action action);

    //插入一条公告
    int addNotice(Action action);

    //查询所有Action
    List<Action> getActions();

    //查询所有公告
    List<Action> getNotices();

    ArrayList<MenuMiddle> getMenus();

    Menu getSubMenu(int SubMenuId);

}
