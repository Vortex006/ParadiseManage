package com.vortex.Service.impl;

import com.vortex.Entity.Menu.MainMenu;
import com.vortex.Entity.Menu.SubMenuDo;
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
    public SubMenuDo getSubMenuById(String subMenuId) {
        SubMenuDo subMenuDo = menuMapper.getSubMenuById(subMenuId);
        return subMenuDo;
    }

    @Override
    public List<MainMenu> listMainMenus() {
        List<MainMenu> mainMenuList = menuMapper.listMainMenus();
        return mainMenuList;
    }
}

