<template>
  <el-card v-loading="loading">
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
      <el-select v-model="searchField" placeholder="请选择" class="select">
        <el-option v-for="item in options" :key="item" :label="item" :value="item" />
      </el-select>
      <el-input v-model="Godsearch" placeholder="请输入搜索内容" class="searchInput" clearable maxlength="50"
        prefix-icon="Search" @change="searchChange" />
    </template>

    <el-table :data="GodList" empty-text="暂无神仙信息" height=400px highlight-current-row stripe style="width: 100%">

      <el-table-column type="selection"></el-table-column>

      <el-table-column label="ID" prop="godId" width="80"></el-table-column>

      <el-table-column label="姓名" prop="godName"></el-table-column>

      <el-table-column label="类型" prop="godType"></el-table-column>

      <el-table-column label="职位" prop="godPosition"></el-table-column>

      <el-table-column label="居所" prop="godPlace"></el-table-column>

      <el-table-column label="功德" prop="godMerit"></el-table-column>

      <el-table-column v-slot="scope" label="操作" min-width="150">

        <el-button type="info" @click='ShowGod(scope.row)'>
          <el-icon>
            <InfoFilled />
          </el-icon>
          <span>详情</span>
        </el-button>

        <el-button type="success" @click='ChangeGod(scope.row)'>
          <el-icon>
            <Edit />
          </el-icon>
          <span>修改</span>
        </el-button>

        <el-button type="danger" @click='ShowDeleteDialog(scope.row.godId)'>
          <el-icon>
            <Delete />
          </el-icon>
          <span>下凡</span>
        </el-button>

      </el-table-column>

    </el-table>

    <el-pagination v-model:current-page="currentPage" v-model:page-size="pagesize" :page-sizes="[1, 3, 5, 7]"
      :total="godcount" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange"
      @current-change="handleCurrentChange" />

  </el-card>

  <!-- 消息提示框 -->

  <!-- 神仙详情 -->
  <el-dialog v-model="ShowGodDialog" title="神仙详情">
    <el-descriptions :column="2" :size="large" border direction="vertical">

      <el-descriptions-item label="神仙ID">{{ showGod.godId }}</el-descriptions-item>
      <el-descriptions-item label="神仙姓名">{{ showGod.godName }}</el-descriptions-item>
      <el-descriptions-item label="神仙类型">{{ showGod.godType }}</el-descriptions-item>
      <el-descriptions-item label="神仙性别">{{ showGod.godSex }}</el-descriptions-item>
      <el-descriptions-item label="神仙职位">{{ showGod.godPosition }}</el-descriptions-item>
      <el-descriptions-item label="神仙居所">{{ showGod.godPlace }}</el-descriptions-item>
      <el-descriptions-item label="神仙功德">{{ showGod.godMerit }}</el-descriptions-item>
      <el-descriptions-item label="神仙尊号">{{ showGod.godMaster }}</el-descriptions-item>

    </el-descriptions>
  </el-dialog>

  <!-- 修改神仙信息 -->
  <el-dialog v-model="UpdateGodDialog" title="修改神仙信息">
    <el-form :model="updateGod">

      <el-form-item label="神仙ID" label-width=100>
        <el-input v-model="updateGod.godId" disabled />
      </el-form-item>

      <el-form-item label="神仙姓名" label-width=100 maxlength=20>
        <el-input v-model="updateGod.godName" />
      </el-form-item>

      <el-form-item label="神仙性别" label-width=100>
        <el-radio-group v-model="updateGod.godSex">
          <el-radio label="男">男</el-radio>
          <el-radio label="女">女</el-radio>
          <el-radio label="无相">无相</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="神仙类型" label-width=100>
        <el-select v-model="updateGod.godType">
          <el-option label="天仙" value="天仙" />
          <el-option label="地仙" value="地仙" />
          <el-option label="人仙" value="人仙" />
          <el-option label="神仙" value="神仙" />
          <el-option label="鬼仙" value="鬼仙" />
          <el-option label="菩萨" value="菩萨" />
          <el-option label="佛祖" value="佛祖" />
        </el-select>
      </el-form-item>

      <el-form-item label="神仙职位" label-width=100>
        <el-input v-model="updateGod.godPosition" />
      </el-form-item>

      <el-form-item label="神仙居所" label-width=100>
        <el-input v-model="updateGod.godPlace" />
      </el-form-item>

      <el-form-item label="神仙功德" label-width=100>
        <el-input-number v-model="updateGod.godMerit" max=2147483647 min=0 size="large" step=100 />
      </el-form-item>

      <el-form-item label="神仙尊号" label-width=100>
        <el-input v-model="updateGod.godMaster" rows="3" type="textarea" />
      </el-form-item>

      <el-form-item label-width=100>
        <el-button type="primary" @click="UpdateSubmit">提交</el-button>
        <el-button @click="UpdateGodDialog = false">取消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>

  <!-- 添加神仙信息的对话框 -->
  <el-dialog v-model="AddGodDialog" title="添加神仙信息">
    <el-form ref="AddForm" :model="addGod">

      <el-form-item label="神仙姓名" label-width=100>
        <el-input v-model="addGod.godName" autofocus maxlength=20 minlength=1 placeholder="请输入神仙姓名" />
      </el-form-item>

      <el-form-item label="神仙性别" label-width=100>
        <el-radio-group v-model="addGod.godSex">
          <el-radio label="男" size="large">男</el-radio>
          <el-radio label="女" size="large">女</el-radio>
          <el-radio label="无相" size="large">无相</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="神仙类型" label-width=100>
        <el-select v-model="addGod.godType" placeholder="请选择神仙类型">
          <el-option label="天仙" value="天仙" />
          <el-option label="地仙" value="地仙" />
          <el-option label="人仙" value="人仙" />
          <el-option label="神仙" value="神仙" />
          <el-option label="鬼仙" value="鬼仙" />
          <el-option label="菩萨" value="菩萨" />
          <el-option label="佛祖" value="佛祖" />
        </el-select>
      </el-form-item>

      <el-form-item label="神仙神职" label-width=100>
        <el-input v-model="addGod.godPosition" maxlength=20 minlength=1/ placeholder="请输入神仙神职" />
      </el-form-item>

      <el-form-item label="神仙居所" label-width=100>
        <el-input v-model="addGod.godPlace" maxlength=100 minlength=1/ placeholder="请输入神仙居所" show-word-limit />
      </el-form-item>

      <el-form-item label="神仙功德" label-width=100>
        <el-input-number v-model="addGod.godMerit" max=2147483647 min=0 placeholder=0/ size="large" step=100 />
      </el-form-item>

      <el-form-item label="神仙尊号" label-width=100>
        <el-input v-model="addGod.godMaster" maxlength=150 placeholder="请输入神仙尊号,最多150个字符" rows="3" show-word-limit
          type="textarea" />
      </el-form-item>

      <el-form-item label-width=100>
        <el-button type="primary" @click="AddSubmit">提交</el-button>
        <el-button @click="AddCancel">取消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>

  <!-- 确认删除提示框 -->
  <el-dialog v-model="isDeleteDialog" title="警告信息" width="30%" center>
    <span>是否将该神仙贬下凡间</span>
    <template #footer>
      <el-button @click="isDeleteDialog = false">取消</el-button>
      <el-button type="primary" @click="YesDeleteGod">
        <span>确定</span>
      </el-button>
    </template>

  </el-dialog>
</template>

<script>
import { ElMessage } from 'element-plus';

export default {
  //神仙列表
  name: "GodManage",
  data() {
    return {
      //展示神仙列表
      GodList: [],
      //表单数据
      addGod: {},//增
      updateGod: {},//删
      showGod: {},//查
      //对话框
      AddGodDialog: false,//增
      isDeleteDialog: false,//删
      UpdateGodDialog: false,//改
      ShowGodDialog: false,//查
      //删除神仙 根据id
      Deleteid: undefined,
      //遮罩
      loading: false,
      //规则

      //批量删除
      size: [],
      //分页相关
      pagesize: 7,//每页显示的条数
      godcount: undefined,//总数
      currentPage: 1,//第几页
      //查询相关
      Godsearch: undefined, //搜索框的内容
      options: ["姓名", "职位", "尊号"], //搜索类型预设
      searchField: undefined, //搜索类型选择框结果
    }
  },
  created() {
    this.getGodList();//获取table数据
    this.getGodCount();
    setTimeout(this.showLoading, 1500);//定时器 1.5秒后遮罩消失

  },
  methods: {
    //获取全部信息
    async getGodList() {
      const { data: res } = await this.$http.get("/api/SelectGod.do?pagesize=" + this.pagesize + "&&currentPage=" + this.currentPage);
      this.GodList = res.data;
    },
    //获取总数
    async getGodCount() {
      const { data: res } = await this.$http.get("/api/GodCount.do");
      this.godcount = res.data;
    },
    //展示 详情 表单
    ShowGod(scope) {//这里的scope参数是这一行的数据
      this.showGod = scope;
      this.ShowGodDialog = true;
    },
    //展示 是否删除 提示框
    ShowDeleteDialog(id) {
      this.isDeleteDialog = true;
      this.Deleteid = id;
    },
    //展示 修改 表单
    ChangeGod(scope) {//这里的scope参数是这一行的数据
      this.UpdateGodDialog = true;
      this.updateGod = scope;
    },
    //点击 修改页面 提交按钮 
    async UpdateSubmit() {
      const { data: res } = await this.$http.post("/api/UpdateGod.do", this.updateGod);
      this.UpdateGodDialog = false;
      if (res.code == 400) {
        ElMessage({
          message: "修改成功",
          type: 'success',
        });
        this.getGodList();
      } else {
        ElMessage.error('修改失败')
      }
    },
    //点击 添加页面 提交按钮
    async AddSubmit() {
      const AddForm = this.$refs['AddForm'];
      const { data: res } = await this.$http.post("/api/AddGod.do", this.addGod);
      this.AddGodDialog = false;
      if (res > 0) {
        ElMessage({
          message: "升仙成功!",
          type: 'success',
        });
        this.getGodList();
        AddForm.resetFields();
      } else {
        ElMessage.error('升仙失败!');
        AddForm.resetFields();
      }
    },
    //点击 添加页面 取消按钮
    AddCancel() {
      this.$refs['AddForm'].resetFields();
      this.AddGodDialog = false;
    },
    //点击 是否删除的提示框 提交按钮
    YesDeleteGod() {
      this.DeleteGod();
      this.isDeleteDialog = false;
    },
    //删除方法
    async DeleteGod() {
      const { data: res } = await this.$http.get("/api/DeleteGod.do?godId=" + this.Deleteid);
      if (res > 0) {
        ElMessage({
          message: "已成功贬下凡间。",
          type: 'success',
        });
        this.getGodList();
      } else {
        ElMessage.error('操作失败,请稍后重试!')
      }
    },
    //展示遮罩
    showLoading() {
      this.loading = false;
    },
    handleSizeChange() {
      this.getGodList();
    },
    handleCurrentChange() {
      this.getGodList();
    },
    async searchChange(value) {
      if (this.searchField != undefined) {
        const { data: res } = await this.$http.post("/api/SelectGodForType.do", {
          type: this.searchField,
          value: value,
          searchPageSize: this.pagesize,//条数
          //godcount: undefined,//总数
          searchCurrentPage: this.currentPage//第几页
        });
        this.GodList = res.data;
        console.log(res.data);
        console.log(this.searchField);
        console.log(value);
      } else {
        this.Godsearch = undefined;
        alert("请选择搜索类型");
      }

    },

  }
}
</script>

<style scoped>
.searchInput {
  width: 250px;
}

.select {
  margin-left: 20px;
  width: 90px;
  text-align: center;
}
</style>