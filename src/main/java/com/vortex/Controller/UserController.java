package com.vortex.Controller;

import com.vortex.Entity.User;
import com.vortex.Service.UserService;
import com.vortex.Utils.Code;
import com.vortex.Utils.MyUtils;
import com.vortex.Utils.Result;
import com.vortex.Utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    private MyUtils myUtils = new MyUtils();

    //用户登录
    @RequestMapping("/Login")
    @ResponseBody
    public Result Login(@RequestBody User user) {
        User L_user = user;
        User S_user = userService.SelectUserForUsername(L_user.getUsername());
        if (S_user == null) {
            return new Result(Code.LOGIN_USERNAME_ERROR, "用户名错误或不存在");
        }
        String S_password = myUtils.decrypted(S_user.getPassword());
        String L_password = L_user.getPassword();
        if (S_password.equals(L_password)) {
            String token = TokenUtils.getToken(S_user.getUsername(), String.valueOf(S_user.getUserid()));
            return new Result(Code.LOGIN_OK, "登录成功", token);
        } else {
            return new Result(Code.LOGIN_PASSWORD_ERROR, "用户名或密码错误");
        }
    }


    //注册用户
    @RequestMapping("/Register")
    @ResponseBody
    public Result Register(@RequestBody User user) {
        User R_user = user;
        //查询相同用户名，看看是否存在用户 用户名是否重复
        User check_username = userService.SelectUserForUsername(R_user.getUsername());
        if (check_username == null) {
            //对密码进行加密
            R_user.setPassword(myUtils.encrypted(R_user.getPassword()));
            boolean isAdd = userService.AddUser(R_user);
            if (isAdd) {
                return new Result(Code.REGISTER_OK, "注册成功");
            } else {
                return new Result(Code.REGISTER_ERROR, "注册失败 请重试");
            }
        } else {
            return new Result(Code.REGISTER_USERNAME_ERROR, "注册失败 用户名重复");
        }
    }


    //验证用户名是否重复
    @RequestMapping("/checkUsername")
    @ResponseBody
    public Result checkUsername(String username) {
        User user = userService.SelectUserForUsername(username);
        if (user == null) {
            return new Result(Code.REGISTER_USERNAME_OK, "用户名未重复");
        } else {
            return new Result(Code.REGISTER_USERNAME_ERROR, "用户名重复 请更换用户名");
        }
    }


    //查询用户总数
    @RequestMapping("/getUserCount")
    @ResponseBody
    public Result getUserCount() {
        int user_count = userService.SelectUserCount();
        return new Result(Code.USER_COUNT_OK, "用户总数查询成功", user_count);
    }


    //查询用户总数
    @RequestMapping("/getAllUser")
    @ResponseBody
    public Result getAllUser(int pageSize, int currentPage) {
        //pageSize:每页显示的条数      currentPage:当前页数
        int offset = (currentPage - 1) * pageSize;//索引
        List<User> AllUser = userService.SelectUserAll(offset, pageSize);
        if (AllUser != null) {
            return new Result(Code.USER_ALL_SELECT_OK, "所有用户查询成功", AllUser);
        } else {
            return new Result(Code.USER_ALL_SELECT_ERROR, "所有用户查询失败");
        }
    }


}
