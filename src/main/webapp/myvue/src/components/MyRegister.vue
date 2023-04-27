<template>
  <div id="Main" v-loading="loading">
    <el-form ref="RegisterForm" :model="RegisterForm" :rules="RegisterFormRules">

      <el-form-item>
        <h1>Register</h1>
      </el-form-item>

      <el-form-item prop="Username">
        <span class="label">用&nbsp;户&nbsp;名:</span>
        <el-input v-model="RegisterForm.Username" maxlength=16/ minlength=4 placeholder="4-16位 字母数字" />
      </el-form-item>

      <el-form-item prop="Password">
        <span class="label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</span>
        <el-input v-model="RegisterForm.Password" maxlength=16/ minlength=8 placeholder="8-16位 至少包含大小写和数字"
          show-password />
      </el-form-item>

      <el-form-item prop="CheckPassword">
        <span class="label">确认密码:</span>
        <el-input v-model="RegisterForm.CheckPassword" maxlength=16/ minlength=4 placeholder="请确认密码" show-password />
      </el-form-item>

      <el-form-item prop="Email">
        <span class="label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</span>
        <el-input v-model="RegisterForm.Email" placeholder="请输入正确的邮箱地址" />
      </el-form-item>

      <el-form-item prop="Phone">
        <span class="label">手&nbsp;机&nbsp;号:</span>
        <el-input v-model="RegisterForm.Phone" maxlength=16/ minlength=4 placeholder="请输入正确的手机号码" />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="Register">注册</el-button>
        <el-button type="success" @click="ToLogin">登录</el-button>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>
import { ElMessage } from 'element-plus'

export default {
  name: 'MyRegister',
  data() {

    /*验证两次输入的密码是否一致的函数*/
    const equalToPassword = (rule, value, callback) => {
      if (this.RegisterForm.Password !== value) {
        callback(new Error("两次输入的密码不一致"));
      } else {
        callback();
      }
    };

    /*验证用户名是否重复的函数*/
    const CheckUsername = async (rule, value, callback) => {
      const { data: res } = await this.$http.get("/api/CheckUsername.go?username=" + value);
      if (res.code == 203) {
        callback();
      } else if (res.code == 201) {
        callback(new Error("用户名重复 请更换用户名"));
      }
    }

    /*数据源*/
    return {
      RegisterForm: {
        Username: "",
        Password: "",
        Email: "",
        Phone: "",
      },
      CheckPassword: "",
      /*加载遮罩*/
      loading: false,
      /*表单验证规则*/
      RegisterFormRules: {
        Username: [
          { required: true, message: "此项为必填项", trigger: "blur" },
          {   /*4-16位字母数字*/
            pattern: /^[a-zA-Z0-9]{4,16}$/,
            message: "请输入正确的用户名", trigger: "blur",
          },
          /*表单是否验证：是 表单验证规则 表单验证时机：失去焦点后*/
          { required: true, validator: CheckUsername, trigger: "blur" }
        ],
        Password: [
          { required: true, message: "此项为必填项", trigger: "blur" },
          {   /*8-16位 至少一个大写字母，一个小写字母和一个数字*/
            pattern: /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,16}$/,
            message: "请输入正确的密码", trigger: "blur",
          }
        ],
        CheckPassword: [
          { required: true, message: "此项为必填项", trigger: "blur" },
          { required: true, validator: equalToPassword, trigger: "blur" }
        ],
        Email: [
          { required: true, message: "此项为必填项", trigger: "blur" },
          { message: "请输入正确的邮箱格式", trigger: "blur", type: "email" },
        ],
        Phone: [
          { required: true, message: "此项为必填项", trigger: "blur" },
          {
            pattern: /^1(3\d|4[5-9]|5[0-35-9]|6[567]|7[0-8]|8\d|9[0-35-9])\d{8}$/,
            message: "请输入正确的手机号", trigger: "blur"
          },
        ],
      },
    }

  },

  /*方法*/
  methods: {

    Register() {
      const RegisterForm = this.$refs['RegisterForm'];
      RegisterForm.validate(async (valid) => {
        if (valid) {
          const { data: res } = await this.$http.post("/api/Register.go", this.RegisterForm);
          if (res.code == 200) {

            ElMessage({
              message: res.message,
              type: 'success',
            });
            //打开遮罩
            this.loading = true;
            /*设置一个定时器 在2500毫秒后执行该方法*/
            setTimeout(this.RegistrationSucceeded, 2500);
            /*清空表单*/
            RegisterForm.resetFields();
          } else {
            ElMessage.error("(Code:" + res.code + ") " + res.message);
            RegisterForm.resetFields();
          }
        } else {
          ElMessage.error('注册失败');
          RegisterForm.resetFields();
        }
      });
    },

    //当点击登录按钮时，切换页面 ，跳转到登录页面
    ToLogin() {
      //清空表单
      this.$refs['RegisterForm'].resetFields();
      //跳转至登录页面
      this.$router.push("/Login");
    },

    //注册成功的方法，进行跳转
    RegistrationSucceeded() {
      //清空表单
      this.$refs['RegisterForm'].resetFields();
      //跳转至登录页面
      this.$router.push("/Login");
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
  margin: 100px auto;
  width: 450px;
  height: 550px;
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
  margin-top: 30px;
}

h1 {
  font-size: 48px;
  margin: 0 auto;
  font-family: Georgia, 'Times New Roman', Times, serif;
}
</style>