<template>
  <div id="Main" v-loading="loading">
    <el-form ref="LoginForm" :model="LoginForm" :rules="LoginFormRules">

      <el-form-item>
        <h1>Login</h1>
      </el-form-item>

      <el-form-item prop="username">
        <span class="label">用户名:</span>
        <el-input v-model="LoginForm.username" maxlength=16/ minlength=4 placeholder="4-16位 字母数字" />
      </el-form-item>

      <el-form-item prop="password">
        <span class="label">密&nbsp;&nbsp;&nbsp;&nbsp;码:</span>
        <el-input v-model="LoginForm.password" maxlength=16/ minlength=8 placeholder="8-16位 至少包含大小写和数字" show-password />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="Login">登录</el-button>
        <el-button type="success" @click="ToRegister">注册</el-button>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>
import { ElMessage } from 'element-plus'

export default {
  name: 'MyLogin',
  data() {
    return {
      LoginForm: {
        username: "",
        password: "",
      },
      loading: false,
      LoginFormRules: {
        username: [
          { required: true, message: "此项为必填项", trigger: "blur" },
          {   /*4-16位字母数字*/
            pattern: /^[a-zA-Z0-9]{4,16}$/,
            message: "请输入正确的用户名", trigger: "blur",
          }
        ],
        password: [
          { required: true, message: "此项为必填项", trigger: "blur" },
          {   /*8-16位 至少一个大写字母，一个小写字母和一个数字*/
            pattern: /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,16}$/,
            message: "请输入正确的密码", trigger: "blur"
          }
        ]
      },
    }
  },
  methods: {
    Login() {
      const LoginForm = this.$refs['LoginForm'];
      LoginForm.validate(async (valid) => {
        if (valid) {
          const { data: res } = await this.$http.post("/api/Login.go", this.LoginForm);
          if (res.code == 300) {
            ElMessage({
              message: res.message,
              type: 'success',
            });
            this.loading = true;
            setTimeout(this.LoginWin, 2000);
          } else {
            ElMessage.error("(Code:" + res.code + ") " + res.message);
            LoginForm.resetFields();
          }
        } else {
          ElMessage.error('登录失败 请检查用户名与密码');
          LoginForm.resetFields();
        }
      });
    },
    ToRegister() {
      this.$refs['LoginForm'].resetFields();
      this.$router.push("/Register");
    },
    LoginWin() { //登录成功 计时器执行的函数 2000ms后
      this.$refs['LoginForm'].resetFields();
      this.$router.push("/Home");
      this.loading = false;
    },
  }
}
</script>

<style scoped>
#Main {
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  outline: none;
  /* 让输入框被选中后没有默认框框 */
  user-select: none;
  /* 用户不能选中文本，整体性更强 */
  background-size: 100% 100%;
}

.el-form {
  margin: 150px auto;
  width: 450px;
  height: 350px;
  background-color: rgba(250, 252, 255, .3);
  backdrop-filter: blur(3px);
  border-left: 2px solid rgba(255, 255, 255, .3);
  border-top: 2px solid rgba(255, 255, 255, .3);
  box-shadow: 2px 2px 10px rgba(0, 0, 0, .2);
  border-radius: 20px;
}

.el-button {
  margin: 0 auto;
}

.el-input {
  border-radius: 20px;
  text-align: center;
  height: 50px;
  width: 80%;
}

.label {
  width: 80px;
  font-size: 18px;
  text-align: center;
}

.el-form-item {
  margin-top: 40px;
}

h1 {
  font-size: 48px;
  margin: 0 auto;
  font-family: Georgia, 'Times New Roman', Times, serif;
}
</style>