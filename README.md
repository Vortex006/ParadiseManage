# README

本文档是天庭管理系统的说明文档，天庭管理系统（ParadiseManage）是一个SSM结构的项目，采用了Java、Vue3、Spring、SpringMVC等技术栈。

| 作者 | Vortex         |
| ---- | -------------- |
| 邮箱 | BCM666@126.com |

#### 目前暂时只上传Java部分、前端部分之后上传

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