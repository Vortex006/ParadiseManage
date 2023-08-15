package com.vortex.Service.impl;

import com.vortex.Entity.Menu.MainMenu;
import com.vortex.Entity.Menu.SubMenu;
import com.vortex.Mapper.MenuMapper;
import com.vortex.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public SubMenu getSubMenuById(String subMenuId) {
        SubMenu subMenu = menuMapper.getSubMenuById(subMenuId);
        return subMenu;
    }

    @Override
    public List<MainMenu> listMainMenus() {
        List<MainMenu> mainMenus = menuMapper.listMainMenus();
        return mainMenus;
    }
}

