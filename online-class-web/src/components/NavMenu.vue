<template>
  <div style="line-height: 60px; display: flex">
    <div style="flex: 1;">
      <el-breadcrumb separator="/" style="display: inline-block; margin-left: 10px">
        <el-breadcrumb-item :to="'/'">首页</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <span style="position: absolute;right: 40%;font-size: 20px;font-weight: bold">欢迎来到湖南科技大学教学课堂</span>

    <el-dropdown style="width: 150px; cursor: pointer; text-align: right">
      <div style="display: inline-block">
        <span>王小虎</span>
        <i class="el-icon-arrow-down" style="margin-left: 5px"></i>
      </div>
      <el-dropdown-menu slot="dropdown" style="width: 100px; text-align: center">
        <el-dropdown-item style="font-size: 14px; padding: 5px 0">
          <span style="text-decoration: none" @click="info">个人信息</span>
        </el-dropdown-item>
        <el-dropdown-item style="font-size: 14px; padding: 5px 0">
          <span style="text-decoration: none" @click="logout">退出</span>
        </el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>

  </div>
</template>

<script>
export default {
  name: "NavMenu",
  methods: {
    logout() {
      this.$message.success("退出成功")
    },
    info(){
      this.$router.push("/info")
    }
  }
}
</script>

<style scoped>

</style>
