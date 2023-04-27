<template>
  <el-container>
    <el-aside width="225px" style="overflow: visible;">

      <div class="title">
        <span>天庭管理系统</span>
      </div>

      <el-menu router unique-opened :default-active="activeIndex" background-color="#304156" text-color="white">

        <template v-for="Menu in MenuList" :key="Menu.menuId">

          <el-menu-item v-if="!Menu.children || Menu.children.length <= 0" :index="Menu.index" :route="Menu.route">
            <el-icon>
              <component :is="Menu.icon"></component>
            </el-icon>&nbsp;&nbsp;
            <span>{{ Menu.name }}</span>
          </el-menu-item>

          <el-sub-menu v-else :index="Menu.menuId">

            <template #title>
              <el-icon>
                <component :is="Menu.icon" />
              </el-icon>&nbsp;&nbsp;
              <span>{{ Menu.name }}</span>
            </template>

            <template v-for="subMenu in Menu.children" :key="subMenu.menuId">

              <el-menu-item :index="subMenu.index" :route="subMenu.route">
                <el-icon>
                  <component :is="subMenu.icon" />
                </el-icon>&nbsp;&nbsp;
                <span>{{ subMenu.name }}</span>
              </el-menu-item>

            </template>
          </el-sub-menu>
        </template>
      </el-menu>
    </el-aside>

    <el-main>
      <el-header>
        <div class="avatar">
          <el-avatar :size="45" :src="circleUrl" @click="upload" />
          <el-dropdown>
            <span class="username">{{ username }}</span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>Action 1</el-dropdown-item>
                <el-dropdown-item>Action 2</el-dropdown-item>
                <el-dropdown-item>Action 3</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </el-header>
      <RouterView></RouterView>
    </el-main>

  </el-container>

</template>


<script>
export default {
  name: "MyHome",
  data() {
    return {
      activeIndex: this.$route.path,
      tabvalue: "/HomePage",
      tabs: [
        {
          title: "首页",
          name: "/HomePage",
          content: <router-view></router-view>
        },
      ],
      MenuList: [],
      circleUrl: '',
      username: undefined
    }
  },
  created() {
    this.getMenu();
  },
  methods: {
    async getMenu() {
      const { data: res } = await this.$http.get("/api/getMenu.ho");
      this.MenuList = res;
    },
    upload() {
      this.showdialog = true;
    },
    submit(UploadFile) {
      console.log(UploadFile);
      this.imageUrl = UploadFile.name;
    },
    handleAvatarSuccess(UploadFile) {
      console.log(UploadFile);
    },

    addTab(item) {
      console.log(item);
    },

    AddTab() {
      let tabname = "demo";
      this.tabs.push({
        title: "Demo",
        name: tabname,
        content: <router-view></router-view>
      });
      this.tabvalue = tabname;
    },

    removeTab(targetName) {
      if (this.tabs.length <= 1) {
        return false;
      }
      let tabs = this.tabs;

      let activename = this.tabvalue;

      if (activename === targetName) {
        tabs.forEach((tab, index) => {
          if (tab.name == targetName) {
            let nextTab = tabs[index + 1] || tabs[index - 1];
            if (nextTab) {
              activename = nextTab.name;
            }
          }
        });
      }
      this.tabvalue = activename;
      this.tabs = tabs.filters(tab => { tab.name != targetName });
    },
  },
}
</script>

<style scoped>
.el-header {
  background-color: #304156;
  height: 50px;
}

.avatar {
  padding-top: 2px;
  position: absolute;
  right: 3%;
  color: white;
  text-align: center;
  height: 47px;
}

.avatar .username {
  padding-left: 20px;
  float: right;
  font-size: 26px;
  font-family: "华文宋体";
  padding-top: 9px;
  color: white;
}

.title {
  background-color: #304156;
  color: white;
  font-size: 24px;
  height: 50px;
  text-align: center;
  line-height: 50px;
  font-family: "微软雅黑";
}

.el-main {
  padding: 0px;
  padding-left: 5px;
}
</style>
