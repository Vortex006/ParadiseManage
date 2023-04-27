<template>

  <RouterLink to="/Login"></RouterLink>
  <RouterLink to="/Register"></RouterLink>
  <RouterLink to="/Home"></RouterLink>
  <el-config-provider :locale="locale">
    <Router-view></Router-view>
  </el-config-provider>

</template>

<script>
import {ElConfigProvider} from 'element-plus'
import zhCn from 'element-plus/lib/locale/lang/zh-cn'

export default {
  name: "MyApp",
  components: {
    ElConfigProvider
  },
  data() {
    return {
      locale: zhCn
    }
  }
}
</script>

<style>
body{
  padding: 0px;
  margin: 0px;
}
</style>