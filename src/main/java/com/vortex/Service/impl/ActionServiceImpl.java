package com.vortex.Service.impl;

import com.vortex.Entity.Action;
import com.vortex.Entity.Menu.Menu;
import com.vortex.Entity.Menu.MenuMiddle;
import com.vortex.Mapper.ActionMapper;
import com.vortex.Service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionMapper actionMapper;


    @Override
    public boolean addAction(Action action) {
        int x = actionMapper.addAction(action);
        return x > 0;
    }

    @Override
    public boolean addNotice(Action action) {
        int x = actionMapper.addNotice(action);
        return x > 0;
    }

    @Override
    public List<Action> getActions() {
        List<Action> actions = actionMapper.getActions();
        return actions;
    }

    @Override
    public List<Action> getNotices() {
        List<Action> actions = actionMapper.getNotices();
        return actions;
    }

    @Override
    public ArrayList<MenuMiddle> getMenus() {
        ArrayList<MenuMiddle> menulist = actionMapper.getMenus();
        return menulist;
    }

    @Override
    public Menu getSubMenu(int SubMenuId) {
        Menu subMenu = actionMapper.getSubMenu(SubMenuId);
        return subMenu;
    }
}
