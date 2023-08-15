package com.vortex.Controller;

import com.vortex.Entity.User;
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

    @RequestMapping("/getUsers")
    @ResponseBody
    public Result getUsers() {
        List<User> users = userService.getUsers();
        return new Result(Code.USER_ALL_SELECT_OK, "查询用户成功", users);
    }

    @RequestMapping("/getUsersLimit")
    @ResponseBody
    public Result getUsersLimit(int pageSize, int currentPage) {
        //pageSize:每页显示的条数      currentPage:当前页数
        int offset = (currentPage - 1) * pageSize;//索引
        List<User> AllUser = userService.getUsersLimit(offset, pageSize);
        if (AllUser != null) {
            return new Result(Code.USER_ALL_SELECT_OK, "查询用户成功", AllUser);
        } else {
            return new Result(Code.USER_ALL_SELECT_ERROR, "查询用户失败");
        }
    }

    @RequestMapping("/getUserForUserId")
    @ResponseBody
    public Result getUserForUserId(int userId) {
        User user = userService.getUserForUserId(userId);
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
        User user = userService.getUserForUserName(username);
        if (user == null) {
            return new Result(Code.REGISTER_USERNAME_OK, "用户名未重复");
        } else {
            return new Result(Code.REGISTER_USERNAME_ERROR, "用户名重复 请更换用户名");
        }
    }

    //添加用户
    @RequestMapping("/addUser")
    @ResponseBody
    public Result addUser(@RequestBody User user) {
        boolean isAdd = userService.addUser(user);
        if (isAdd) {
            return new Result(Code.USER_ADD_OK, "新增用户成功");
        } else {
            return new Result(Code.USER_ADD_ERROR, "新增用户异常");
        }
    }

    //根据用户ID删除用户
    @RequestMapping("/deleteUserById")
    @ResponseBody
    public Result deleteUserByUserId(int userId) {
        boolean isDelete = userService.deleteUserForUserId(userId);
        if (isDelete) {
            return new Result(Code.USER_DELETE_OK, "删除用户成功");
        } else {
            return new Result(Code.USER_DELETE_ERROR, "删除用户异常");
        }
    }

//    //根据用户ID的集合删除用户
//    @RequestMapping("/deleteUserForUserIdList")
//    @ResponseBody
//    public Result deleteUserForUserIdList(List<Integer> userIdList) {
//        for(int userId:userIdList){
//            boolean isDelete = userService.deleteUserForUserId(userId);
//            if(isDelete){
//                return new Result(Code.USER_DELETE_OK, "删除用户成功");
//            }else {
//                return new Result(Code.USER_DELETE_ERROR, "删除用户异常");
//            }
//        }
//    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Result updateUser(@RequestBody User user) {
        boolean isUpdate = userService.updateUser(user);
        if (isUpdate) {
            return new Result(Code.USER_UPDATE_OK, "更新用户成功");
        } else {
            return new Result(Code.USER_UPDATE_ERROR, "更新用户失败");
        }
    }

    @RequestMapping("/getUserCount")
    @ResponseBody
    public Result getUserCount() {
        int userCount = userService.getUserCount();
        if (userCount >= 0) {
            return new Result(Code.USER_COUNT_OK, "查询用户总数成功", userCount);
        } else {
            return new Result(Code.USER_COUNT_ERROR, "查询用户总数失败");
        }
    }
}
