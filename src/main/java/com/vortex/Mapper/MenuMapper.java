package com.vortex.Mapper;

import com.vortex.Entity.Menu.Menu;
import com.vortex.Entity.Menu.MenuMiddle;

import java.util.ArrayList;

public interface MenuMapper {

    ArrayList<MenuMiddle> SelectMenu();

    Menu SelectSubMenu(int SubMenuId);
}
