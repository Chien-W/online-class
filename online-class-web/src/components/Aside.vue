<template>
  <el-menu style="min-height: 100%;overflow-x: hidden"
           background-color="rgb(48, 65, 86)"
           text-color="#fff"
           active-text-color="#ffd04b"
           :collapse-transition="false"
           :collapse="isCollapse"
           router
  >
    <div style="height: 60px;line-height: 60px;text-align: center">
      <img src="../assets/logo.png" alt="" style="width: 20px;position: relative;top: 5px;margin-right: 5px">
      <b style="color: white" v-show="logoTextShow">实训教学平台</b>
    </div>
    <div v-for="item in itemData">
        <el-menu-item :index="item.path">
          <i :class="item.icon"></i>
          <span slot="title">{{ item.name }}</span>
        </el-menu-item>
    </div>
<!--    <el-menu-item :index="/class">-->
<!--      <i class="el-icon-message"></i>-->
<!--      <span slot="title">班级管理</span>-->
<!--    </el-menu-item>-->
<!--    <el-menu-item :index="/homework">-->
<!--      <i class="el-icon-message"></i>-->
<!--      <span slot="title">作业管理</span>-->
<!--    </el-menu-item>-->
<!--    <el-menu-item :index="/attendance">-->
<!--      <i class="el-icon-message"></i>-->
<!--      <span slot="title">签到</span>-->
<!--    </el-menu-item>-->
<!--    <el-menu-item :index="/file">-->
<!--      <i class="el-icon-message"></i>-->
<!--      <span slot="title">文件管理</span>-->
<!--    </el-menu-item>-->
<!--    <el-submenu index="4">-->
<!--      <template slot="title">-->
<!--        <i class="el-icon-message"></i>-->
<!--        <span slot="title">导航一</span>-->
<!--      </template>-->
<!--      <el-menu-item-group>-->
<!--        <el-menu-item index="1-1">选项1</el-menu-item>-->
<!--        <el-menu-item index="1-2">选项2</el-menu-item>-->
<!--      </el-menu-item-group>-->
<!--    </el-submenu>-->
  </el-menu>
</template>

<script>
export default {
  name: "Aside",
  data(){
    return{
      itemData: [
        {path:'/',icon:'el-icon-message',name:'班级管理'},
        {path:'/homework',icon:'el-icon-message',name:'作业管理'},
        {path:'/attendance',icon:'el-icon-message',name:'签到'},
        {path:'/file',icon:'el-icon-message',name:'文件管理'}
      ]
    }
  },
  props: {
    isCollapse: Boolean,
    logoTextShow: Boolean
  },
}
</script>

<style scoped>
.el-menu-item.is-active {
  background-color: rgb(38, 52, 69) !important;
}
.el-menu-item:hover {
  background-color: rgb(38, 52, 69) !important;
}

.el-submenu__title:hover {
  background-color: rgb(38, 52, 69) !important;
}
/*解决收缩菜单文字不消失问题*/
.el-menu--collapse span {
  visibility: hidden;
}
</style>
