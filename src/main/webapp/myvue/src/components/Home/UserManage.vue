<template>
  <el-card>
    <template #header>
      <el-button plain type="primary" @click="AddGodDialog = true">
        <el-icon>
          <CirclePlusFilled />
        </el-icon>
        <span>添加</span>
      </el-button>
      <el-button plain type="danger">
        <el-icon>
          <DeleteFilled />
        </el-icon>
        <span>批量删除</span>
      </el-button>

    </template>

    <el-table :data="UserList" empty-text="暂无用户信息" height=400px highlight-current-row stripe style="width: 100%">

      <el-table-column type="selection"></el-table-column>

      <el-table-column label="ID" min-width="50px" prop="userid"></el-table-column>

      <el-table-column label="用户名" min-width="80px" prop="username"></el-table-column>

      <el-table-column label="密码" min-width="180px" prop="password"></el-table-column>

      <el-table-column label="邮箱" min-width="150px" prop="email"></el-table-column>

      <el-table-column label="手机号" min-width="100px" prop="phone"></el-table-column>

      <el-table-column v-slot="scope" label="操作" min-width="150px">

        <el-button type="success" @click='ChangeGod(scope.row)'>
          <el-icon>
            <MostlyCloudy />
          </el-icon>
          <span>升仙</span>
        </el-button>

        <el-button type="danger" @click='ShowDeleteDialog(scope.row.godId)'>
          <el-icon>
            <Delete />
          </el-icon>
          <span>删除</span>
        </el-button>

      </el-table-column>

    </el-table>

    <!-- 数据分页条 -->
    <el-pagination v-model:current-page="currentPage" v-model:page-size="pagesize" :page-sizes="[1, 3, 5, 7]"
      :total="usercount" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange"
      @current-change="handleCurrentChange" />

  </el-card>

</template>

<script>
export default {
  name: "UserManage",
  data() {
    return {
      UserList: [],
      pagesize: 7,//每页显示的条数
      usercount: undefined,//总数
      currentPage: 1,//第几页
    }
  },
  created() {
    this.getUserList();
    this.getUserCount();
  },
  methods: {
    async getUserList() {
      const { data: res } = await this.$http.get("/api/SelectUser.go?pagesize=" + this.pagesize + "&&currentPage=" + this.currentPage);
      this.UserList = res.data;
    },
    async getUserCount() {
      const { data: res } = await this.$http.get("/api/UserCount.go");
      this.usercount = res.data;
    },
    handleSizeChange() {
      this.getUserList();
    },
    handleCurrentChange() {
      this.getUserList();
    }
  }
}
</script>

<style scoped>
.el-pagination {
  margin-top: 30px;
}
</style>