<template>
  <el-card id="card" shadow="hover">

    <template #header>
      <div class="cardheader">
        <span class="cardtitle">公告</span>
      </div>
    </template>
    <span class="cardbody" v-html="cardbody"></span>
  </el-card>
  <br>
  <el-button type="primary" @click="this.show = true">修改</el-button>


  <el-dialog v-model="show" title="输入新的公告内容">

    <el-input v-model="textarea" :rows="10" placeholder="请输入公告内容" type="textarea" />
    <template #footer>
      <el-button @click="show=false">取消</el-button>&nbsp;
      <el-button type="primary" @click="setNotice">提交</el-button>
    </template>

  </el-dialog>
  <!-- 因天庭服务器遭到莫名的DDOS攻击,导致部分功能模块负载超负荷,已经崩溃。目前天庭御用程序员小周正在进行修理。
  受到影响的功能有:
  1.无法使用功德购买法宝,丹药等。
  2.暂停用户的登录功能。 -->
</template>

<script>
import { ElMessage } from 'element-plus';

export default {
  name: "HomePage",
  data() {
    return {
      cardbody: undefined,
      show: false,
      textarea: undefined,
    }
  },
  created() {
    this.getNotice();
  },
  methods: {
    async setNotice() {
      this.show = false;
      this.cardbody = this.preText(this.textarea);
      const { data: res } = await this.$http.post("/api/setNotice.ho", this.cardbody);
      if (res.code == 260) {
        ElMessage({
          message: res.message,
          type: 'success',
        });
      } else {
        ElMessage.error("公告修改失败");
      }
      this.textarea = undefined;
    },
    async getNotice() {
      const { data: res } = await this.$http.get("/api/getNotice.ho");
      this.cardbody = res.data;
    },
    preText(pretext) {
      return pretext.replace(/\r\n/g, '<br/><br/>').replace(/\n/g, '<br/><br/>').replace(/\s/g, '&nbsp;')
    },
  }
}
</script>

<style scoped>

.cardheader {
  text-align: center;
}

.cardtitle {
  font-size: 40px;
  color: red;
  font-weight: 700;
}

.cardbody {
  font-size: 24px;
  font-family: "仿宋";
  font-weight: 500;
}

.el-card{
  padding: 20px;
}
</style>