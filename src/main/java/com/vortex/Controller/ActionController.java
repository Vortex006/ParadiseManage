package com.vortex.Controller;

import com.vortex.Utils.ConfigUtils;
import com.vortex.Utils.MyUtils;
import com.vortex.Utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class ActionController {

    //工具类
    ConfigUtils configUtils = new ConfigUtils();
    MyUtils myUtils = new MyUtils();


    @RequestMapping("/setNotice")
    @ResponseBody
    public Result setNotice() {

        return new Result();
    }


    @RequestMapping("/getNotice")
    @ResponseBody
    public Result getNotice() {

        return new Result();
    }


    @RequestMapping("/getMenu")
    @ResponseBody
    public Result getMenu() {

        return new Result();
    }


}
