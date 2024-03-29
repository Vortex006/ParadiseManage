package com.vortex.Controller;

import com.vortex.Entity.Menu.FullMenu;
import com.vortex.Entity.Menu.MainMenu;
import com.vortex.Entity.Menu.SubMenuDo;
import com.vortex.Service.MenuService;
import com.vortex.Util.Code;
import com.vortex.Util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping("/listMenus")
    @ResponseBody
    public Result listMenus() {
        List<FullMenu> fullMenuList = new ArrayList<>();
        List<MainMenu> mainMenuList = menuService.listMainMenus();
        for (MainMenu mainMenu : mainMenuList) {
            FullMenu fullMenu = new FullMenu();
            fullMenu.setFullMenuId(mainMenu.getMainMenuId());
            fullMenu.setFullMenuName(mainMenu.getMainMenuName());
            fullMenu.setFullMenuIcon(mainMenu.getMainMenuIcon());
            fullMenu.setFullMenuIndex(mainMenu.getMainMenuIndex());
            fullMenu.setFullMenuRoute(mainMenu.getMainMenuRoute());
            ArrayList<SubMenuDo> fullSubMenuDoList = new ArrayList<>();
            if (mainMenu.getMainMenuChildren() != null) {
                String childStr = mainMenu.getMainMenuChildren();
                String[] child = childStr.split(",");
                for (String s : child) {
                    fullSubMenuDoList.add(menuService.getSubMenuById(s));
                }
                fullMenu.setFullMenuChildList(fullSubMenuDoList);
            } else {
                fullMenu.setFullMenuChildList(null);
            }
            fullMenuList.add(fullMenu);
        }
        return new Result(Code.MENU_GET_OK, "菜单获取成功", fullMenuList);
    }

    @RequestMapping("/listMainMenus")
    @ResponseBody
    public Result listMainMenus() {
        List<MainMenu> mainMenuList = menuService.listMainMenus();
        return new Result(Code.OK, "主菜单获取成功", mainMenuList);
    }

    @RequestMapping("/getSubMenuById")
    @ResponseBody
    public Result getSubMenuById(String subMenuId) {
        SubMenuDo subMenuDo = menuService.getSubMenuById(subMenuId);
        return new Result(Code.OK, "主菜单获取成功", subMenuDo);
    }

}
