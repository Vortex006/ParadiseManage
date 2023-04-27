package com.vortex.Utils;

import com.vortex.Entity.Menu.Menu;
import com.vortex.Entity.Menu.MenuMiddle;
import com.vortex.Entity.Menu.SubMenu;
import com.vortex.Mapper.MenuMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.jasypt.util.text.BasicTextEncryptor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyUtils {

    //加密密码的密钥
    private final String PasswordKey = "Paradise";

    //加密密码
    public String encrypted(String str) {
        //创建实例
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //设置加密密钥
        textEncryptor.setPassword(PasswordKey);
        //加密信息
        String text = textEncryptor.encrypt(str);
        return text;
    }

    //解密密码
    public String decrypted(String str) {
        //创建实例
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //设置加密密钥
        textEncryptor.setPassword(PasswordKey);
        //解密信息
        String text = textEncryptor.decrypt(str);
        return text;
    }

    //格式化日期 格式:“yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒”
    public String formatDate(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
        String now = f.format(date);
        return now;
    }

    //获取菜单并封装
    public ArrayList<SubMenu> getMenuList() {
        //调用对象
        SqlSessionFactory sqlSessionFactory = DBUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        //转接
        ArrayList<MenuMiddle> menus = menuMapper.SelectMenu();
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
                    Menu demoMenu = menuMapper.SelectSubMenu(index[k]);
                    menuArrayList.add(demoMenu);
                }
                //将二级菜单放入菜单中
                subMenu.setChildren(menuArrayList);
                //将菜单放入菜单集合中
                MenuList.add(subMenu);
            }
        }
        return MenuList;
    }


}
