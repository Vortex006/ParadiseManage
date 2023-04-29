package com.vortex.Controller;

import com.vortex.Entity.Action;
import com.vortex.Entity.Menu.Menu;
import com.vortex.Entity.Menu.MenuMiddle;
import com.vortex.Entity.Menu.SubMenu;
import com.vortex.Service.ActionService;
import com.vortex.Utils.Code;
import com.vortex.Utils.MyUtils;
import com.vortex.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ActionController {

    //工具类
    MyUtils myUtils = new MyUtils();
    @Autowired
    ActionService actionService;


    @RequestMapping("/setNotice")
    @ResponseBody
    public Result setNotice(@RequestBody String notice) {
        Action Notice = new Action(notice, myUtils.formatDate(new Date()));
        boolean flag = actionService.AddNotice(Notice);
        if (flag) {
            return new Result(Code.NOTICE_SET_OK, "公告修改成功");
        } else {
            return new Result(Code.NOTICE_SET_ERROR, "公告修改失败");
        }
    }


    @RequestMapping("/getNotice")
    @ResponseBody
    public Result getNotice() {
        List<Action> Notices = actionService.SelectNotice();
        if (Notices != null) {
            String Last_Notice_Data = Notices.get(Notices.size() - 1).getData();
            return new Result(Code.NOTICE_GET_OK, "公告获取成功", Last_Notice_Data);
        } else {
            return new Result(Code.NOTICE_GET_ERROR, "公告获取失败");
        }
    }


    @RequestMapping("/getMenu")
    @ResponseBody
    public Result getMenu() {
        //转接
        ArrayList<MenuMiddle> menus = actionService.SelectMenu();
        //菜单集合
        ArrayList<SubMenu> MenuList = new ArrayList<SubMenu>();

        for (int i = 0; i < menus.size(); i++) {

            //如果没有二级菜单，直接添加进List中
            if (menus.get(i).getChildren() == null) {
                //获取一级菜单
                MenuMiddle menu = menus.get(i);
                //将一级菜单添加到菜单集合中
                SubMenu subMenu = new SubMenu(menu.getMenuId(), menu.getName(), menu.getIcon(), menu.getIndex(),
                        menu.getRoute(), null);
                MenuList.add(subMenu);
            } else if (menus.get(i).getChildren() != null) {
                //如果有二级菜单，首先获取二级菜单的id
                MenuMiddle menu = menus.get(i);
                String str = menu.getChildren();
                //将获取到的字符串分割
                String temp[] = str.split(",");
                //转化成数组
                int[] index = new int[temp.length];
                for (int j = 0; j < index.length; j++) {
                    index[j] = Integer.parseInt(temp[j]);
                }
                //先添加除了二级菜单之外的其他信息
                SubMenu subMenu = new SubMenu(menu.getMenuId(), menu.getName(), menu.getIcon(), menu.getIndex(),
                        menu.getRoute(), null);
                //创建用于存放二级菜单的数组
                ArrayList<Menu> menuArrayList = new ArrayList<Menu>();
                //调用方法，将二级菜单查出，并添加进二级菜单的数组
                for (int k = 0; k < index.length; k++) {
                    Menu demoMenu = actionService.SelectSubMenu(index[k]);
                    menuArrayList.add(demoMenu);
                }
                //将二级菜单放入菜单中
                subMenu.setChildren(menuArrayList);
                //将菜单放入菜单集合中
                MenuList.add(subMenu);
            }
        }
        if (MenuList != null) {
            return new Result(Code.MENU_GET_OK, "菜单获取成功", MenuList);
        } else {
            return new Result(Code.MENU_GET_ERROR, "菜单获取失败");
        }
    }


}
