package com.vortex.Service;

import com.vortex.Entity.Action;
import com.vortex.Entity.Menu.Menu;
import com.vortex.Entity.Menu.MenuMiddle;

import java.util.ArrayList;
import java.util.List;

public interface ActionService {

    //插入一条Action
    boolean AddAction(Action action);

    //插入一条公告
    boolean AddNotice(Action action);

    //查询所有Action
    List<Action> SelectAction();

    //查询所有公告
    List<Action> SelectNotice();

    ArrayList<MenuMiddle> SelectMenu();

    Menu SelectSubMenu(int SubMenuId);


}
