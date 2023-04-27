package com.vortex.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*

        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取接口
        String uri = req.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
        //工具类
        ConfigUtils configUtils = new ConfigUtils();
        MyUtils myUtils = new MyUtils();

        switch (action) {

            //修改公告
            case "/setNotice":
                String str = req.getReader().readLine();
                configUtils.setConfig("Notice", str, configUtils.getDefaultComments());
                break;

            //获取公告
            case "/getNotice":
                String Notice = configUtils.getConfig("Notice");
                break;

            //获取菜单
            case "/getMenu":
                ArrayList<SubMenu> MenuList = myUtils.getMenuList();
                break;
        }*/
    }
}
