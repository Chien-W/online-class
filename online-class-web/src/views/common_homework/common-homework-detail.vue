<template>
  <div>
    <div style="margin-bottom: 20px">
      <el-page-header @back="goBack" content="作业详情"></el-page-header>
    </div>
    <el-tabs type="border-card" @tab-click="handleClick">
      <el-tab-pane label="作业描述" name="0">
        <span>描述、</span>
        <span>新建作业时候上传的文件</span>
      </el-tab-pane>
      <el-tab-pane label="提交情况" name="1">
        <el-empty :image-size="300"></el-empty>
      </el-tab-pane>
      <el-tab-pane label="设置" name="2">
        <el-empty :image-size="300"></el-empty>
      </el-tab-pane>
    </el-tabs>


  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "common-homework-detail.vue",
  data(){
    return{
    }
  },
  methods:{
    goBack(){
      router.push("/common_homework")
    },
    handleClick(tab, event) {
      router.push({ path: '/common_homework/detail', query: { tab: tab.name } })
    },
  }
}
</script>

<style scoped>

</style>
