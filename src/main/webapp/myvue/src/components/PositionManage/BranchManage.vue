<template>
  <div style="margin-bottom: 20px;">
    <el-button size="small" @click="addTab(editableTabsValue)">
      add tab
    </el-button>
  </div>
  <el-tabs v-model="editableTabsValue" type="card" closable @tab-remove="removeTab">
    <el-tab-pane v-for="item in editableTabs" :key="item.name" :label="item.title" :name="item.name">
      {{ item.content }}
    </el-tab-pane>
  </el-tabs>
</template>

<script>
export default {
  data() {
    return {
      editableTabsValue: '2',
      editableTabs: [{
        title: 'Tab 1',
        name: '1',
        content: 'Tab 1 content'
      }, {
        title: 'Tab 2',
        name: '2',
        content: 'Tab 2 content'
      }],
      tabIndex: 2
    }
  },
  methods: {
    addTab(targetName) {
      //设置tab的name
      let newTabName = ++this.tabIndex + '';
      //标签栏添加
      this.editableTabs.push({
        title: 'New Tab',//title
        name: newTabName,//name
        content: 'New Tab content'//内容
      });
      this.editableTabsValue = newTabName;//让当前选中的tab的索引=新添加的tab
      console.log(targetName);
    },

    removeTab(targetName) {
      let tabs = this.editableTabs;//将所有赋值
      let activeName = this.editableTabsValue;//当前选中

      if (activeName === targetName) { //如果当前选中=要关闭的标签页
        tabs.forEach((tab, index) => {//执行遍历

          if (tab.name === targetName) { //如果该tab=要关闭的tab
            let nextTab = tabs[index + 1] || tabs[index - 1];//判断你前后是否有标签
            if (nextTab) { //如果两者任意一个有，那么赋值 先赋值后面的标签
              activeName = nextTab.name;
            }
          }
        });
      }
      this.editableTabsValue = activeName;//让单签选中的标签=后边的标签
      //意思是说过滤掉所有被点击删除按钮的标签
      this.editableTabs = tabs.filter(tab => tab.name !== targetName);
    }
  }
}
</script>