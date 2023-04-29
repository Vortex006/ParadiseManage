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
    public boolean AddAction(Action action) {
        int x = actionMapper.AddAction(action);
        return x > 0;
    }

    @Override
    public boolean AddNotice(Action action) {
        int x = actionMapper.AddNotice(action);
        return x > 0;
    }

    @Override
    public List<Action> SelectAction() {
        List<Action> actions = actionMapper.SelectAction();
        return actions;
    }

    @Override
    public List<Action> SelectNotice() {
        List<Action> actions = actionMapper.SelectNotice();
        return actions;
    }

    @Override
    public ArrayList<MenuMiddle> SelectMenu() {
        ArrayList<MenuMiddle> menulist = actionMapper.SelectMenu();
        return menulist;
    }

    @Override
    public Menu SelectSubMenu(int SubMenuId) {
        Menu subMenu = actionMapper.SelectSubMenu(SubMenuId);
        return subMenu;
    }
}
