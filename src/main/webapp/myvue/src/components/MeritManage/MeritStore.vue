<template>

<el-row>
    <el-col :span="6"><div class="card">1</div></el-col>
    <el-col :span="6"><div class="card">2</div></el-col>
    <el-col :span="6"><div class="card">3</div></el-col>
    <el-col :span="6"><div class="card">4</div></el-col>
</el-row>

<el-row>
    <el-col :span="6"><div class="card">5</div></el-col>
    <el-col :span="6"><div class="card">6</div></el-col>
    <el-col :span="6"><div class="card">7</div></el-col>
    <el-col :span="6"><div class="card">8</div></el-col>
</el-row>






  

</template>

<script>
export default {
  name: "MeritStore",
  data() {
    return {}
  },
  created() {

  },
  methods: {},
}
</script>

<style>

.card{
  border: 2px red solid;
  width: 100px;
  height: 100px;
  margin-top: 30px;
  margin-bottom: 10px;
  text-align: center;
  line-height: 100px;
  margin-left: 50px;
  background-color: red;
  color: white;
  backface-visibility:hidden;
  user-select: none;

}

.card:active{
  transform:rotateY(180deg);
}




</style>