package com.vortex.Controller;

import com.vortex.Entity.UserDo;
import com.vortex.Service.UserService;
import com.vortex.Util.Code;
import com.vortex.Util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //获取所有用户
    @RequestMapping("/listUsers")
    @ResponseBody
    public Result listUsers() {
        List<UserDo> userList = userService.listUsers();
        return new Result(Code.USER_ALL_SELECT_OK, "查询用户成功", userList);
    }

    //分页获取用户
    @RequestMapping("/limitUsers")
    @ResponseBody
    public Result limitUsers(int pageSize, int currentPage) {
        //pageSize:每页显示的条数      currentPage:当前页数
        int offset = (currentPage - 1) * pageSize;//索引
        List<UserDo> userLimitList = userService.limitUsers(offset, pageSize);
        if (userLimitList != null) {
            return new Result(Code.USER_ALL_SELECT_OK, "查询用户成功", userLimitList);
        } else {
            return new Result(Code.USER_ALL_SELECT_ERROR, "查询用户失败");
        }
    }

    //根据用户ID获取用户
    @RequestMapping("/getUserById")
    @ResponseBody
    public Result getUserById(int userId) {
        UserDo user = userService.getUserById(userId);
        if (user != null) {
            return new Result(Code.GOD_SELECT_BYGODID_OK, "查询用户成功", user);
        } else {
            return new Result(Code.GOD_SELECT_BYGODID_ERROR, "查询用户失败");
        }
    }

    //验证用户名是否重复
    @RequestMapping("/checkUsername")
    @ResponseBody
    public Result checkUsername(String username) {
        UserDo user = userService.getUserByName(username);
        if (user == null) {
            return new Result(Code.REGISTER_USERNAME_OK, "用户名未重复");
        } else {
            return new Result(Code.REGISTER_USERNAME_ERROR, "用户名重复 请更换用户名");
        }
    }

    //验证用户名是否重复
    @RequestMapping("/getUserByName")
    @ResponseBody
    public Result getUserByName(String username) {
        UserDo user = userService.getUserByName(username);
        if (user == null) {
            return new Result(Code.OK, "获取用户成功");
        } else {
            return new Result(Code.ERROR, "获取用户失败");
        }
    }

    //添加用户
    @RequestMapping("/saveUser")
    @ResponseBody
    public Result saveUser(@RequestBody UserDo userDo) {
        boolean isAdd = userService.saveUser(userDo);
        if (isAdd) {
            return new Result(Code.USER_ADD_OK, "新增用户成功");
        } else {
            return new Result(Code.USER_ADD_ERROR, "新增用户异常");
        }
    }

    //根据用户ID删除用户
    @RequestMapping("/deleteUserById")
    @ResponseBody
    public Result deleteUserById(int userId) {
        boolean isDelete = userService.deleteUserById(userId);
        if (isDelete) {
            return new Result(Code.USER_DELETE_OK, "删除用户成功");
        } else {
            return new Result(Code.USER_DELETE_ERROR, "删除用户异常");
        }
    }

    //更新用户
    @RequestMapping("/updateUser")
    @ResponseBody
    public Result updateUser(@RequestBody UserDo userDo) {
        boolean isUpdate = userService.updateUser(userDo);
        if (isUpdate) {
            return new Result(Code.USER_UPDATE_OK, "更新用户成功");
        } else {
            return new Result(Code.USER_UPDATE_ERROR, "更新用户失败");
        }
    }

    //获取用户总数
    @RequestMapping("/countUser")
    @ResponseBody
    public Result countUser() {
        int userCount = userService.countUser();
        if (userCount >= 0) {
            return new Result(Code.USER_COUNT_OK, "查询用户总数成功", userCount);
        } else {
            return new Result(Code.USER_COUNT_ERROR, "查询用户总数失败");
        }
    }
}
