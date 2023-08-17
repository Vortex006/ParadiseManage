# README

本文档是天庭管理系统的说明文档，天庭管理系统（ParadiseManage）是一个SSM结构的项目，采用了Java、Vue3、Spring、SpringMVC等技术栈。

| 作者 | Vortex         |
| ---- | -------------- |
| 邮箱 | BCM666@126.com |

#### 目前暂时只上传Java部分、前端部分之后上传

目录

1. 字段说明
2. 开发规范手册

# 字段说明

### User表

| 字段名            | 类型        | 说明                                                     |
| ----------------- | ----------- | -------------------------------------------------------- |
| UserId            | int         | 用户ID 主键 自增                                         |
| UserName          | String      | 用户名 4-16位大小写字母数字                              |
| UserPassword      | String/Text | 用户密码 8-16位大小写字母数字                            |
| UserSalt          | String      | 密码盐 UUID（36位字符串）                                |
| UserCreateDate    | String      | 用户创建时间 格式化的日期（yyyy-MM-DD HH:mm:ss）         |
| UserLastLoginDate | String      | 用户最后一次登录时间 格式化的日期（yyyy-MM-DD HH:mm:ss） |
| UserState         | short       | 用户状态 0代表禁用 1代表启用                             |
| UserPermission    | int         | 用户权限 0代表超级管理员 1代表管理员 2代表普通用户       |
| UserEmail         | String      | 用户邮箱 5-18位大小写字母数字+@+邮箱后缀                 |
| UserPhone         | String      | 用户手机号 手机号前缀+9位数字                            |

### 邮箱服务器

| 邮箱后缀    | 所属服务器 |
| ----------- | ---------- |
| @tt666.com  | 天庭服务器 |
| @df123.com  | 地府服务器 |
| @ls321.com  | 灵山服务器 |
| @rj2468.com | 人间服务器 |

### 手机服务器

| 手机号前缀 | 所属服务器 |
| ---------- | ---------- |
| +10        | 天庭服务器 |
| +20        | 地府服务器 |
| +30        | 灵山服务器 |
| +40        | 人间服务器 |

# 天庭管理系统开发规范手册

### 1. 变量命名

变量不能以下划线“_”或美元符号“￥”为开头或结尾。

变量命名需遵循小驼峰命名法（即第一个单词的首字母小写，之后单词的首字母大写）。

变量名中不可出现中文，更不能出现中英文混合。

变量命名一般以英文单词为主，尽量避免拼音命名，一些特殊拼音除外（如：taobao，alibaba，HeNan，BeiJing等）。

##### 1.1 普通变量

boolean变量命名时，视情况而定，一般添加“is”作为前缀，如下所示：

```class
boolean isSave = true;
boolean isDelete = false;
```

String变量命名时，视情况而定，一般添加“Str”作为后缀，如下所示：

```class
String sqlStr = "select * from abc;";
String errorMessageStr = "请求失败";
```

##### 1.2 数组变量

数组变量命名时，象征数组变量的中括号“[]”一般放在变量类型后，同时变量名一般呈现复数形态。如下所示：

```class
String[] sqls = {"select * from abc;","select * from def;"};
int[] numbers = new int[10];
```

##### 1.3 集合变量

集合变量命名时，一般在变量名后添加集合类型，如List集合或ArrayList集合需在变量名后添加”List“后缀；Map集合或HashMap集合需在变量名后添加”Map“后缀等，如下所示：

```class
List<String> userNameList = new List<String>();
List<String> userNameList = new ArrayList<String>();

Map<String,String> nameMap = new HashMap<String, String>();
```

### 2.常量命名

常量命名时，所有字母均大写，同时每个单词之间使用下划线进行分割，如下所示：

```class
final int MAX_COUNT = 100;
```

### 3.方法命名

方法命名时，同样采用小驼峰命名法，根据方法的作用，方法名的前缀也各有不同，如下表所示：

| 方法名前缀 | 说明               |
| ---------- | ------------------ |
| save       | 插入对象           |
| delete     | 删除对象           |
| update     | 更新对象           |
| get        | 获取单个对象       |
| limit      | 分页获取对象       |
| list       | 获取所有对象       |
| count      | 统计获取对象的数量 |

以下展示一些方法的常用写法：

```class
//插入用户
public boolean saveUser(User userDo);

//根据用户ID删除用户
public boolean deleteUserById(int userId);

//根据用户ID更新用户
public boolean updateUserById(int userId);

//根据用户ID获取用户
public User getUserById(int userId);

//分页获取用户 pageSize:每页显示的条数      currentPage:当前页数
public List<User> limitUsers(int currentPage,int pageSize);

//获取所有用户
public List<User> listUsers();

//获取用户总数
public int getUserCount();
```

### 4.类命名

类命名时，采用大驼峰命名法。

对于控制层的类，命名时需要添加“Controller”作为后缀，如下所示：

```java
class UserController {
    
}

class GodController {
    
}
```

对于服务层的类，基于SOA理念，采用接口与实现分离的方法，对于接口需要添加“Service”作为后缀，对于实现类需要添加“ServiceImpl”作为后缀，如下所示：

```java
class UserService {
    
}

class UserServiceImpl implements UserService {
    
}
```

对于数据层的类，本项目使用MyBatis框架管理数据库，所以对于数据层中的类，需要添加“Mapper”作为后缀，如下所示：

```java
class UserMapper {

}
```

对于实体类，需要添加“Do”作为后缀，如下所示：

```java
class UserDo {

}
```

对于工具类，需要添加“Util”作为后缀，如下所示：

```java
class DateUtil {

}

class TokenUtil {

}
```

对于配置类，需要添加“Config”作为后缀，如下所示：

```java
class SpringConfig {
    
}

class SpringMvcConfig {
    
}
```

### 5.包命名

包命名时，采用全小写的命名方法。

包名采用“com”+项目负责人+描述的方式，如下所示：

```class
String packageName = "com.vortex.Config";
String packageName2 = "com.vortex.Service";
```
