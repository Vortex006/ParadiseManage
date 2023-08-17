package com.vortex.Service;

import com.vortex.Entity.Menu.MainMenu;
import com.vortex.Entity.Menu.SubMenuDo;

import java.util.List;


public interface MenuService {

    //根据子菜单ID获取子菜单
    SubMenuDo getSubMenuById(String subMenuId);

    //获取主菜单
    List<MainMenu> listMainMenus();


}
