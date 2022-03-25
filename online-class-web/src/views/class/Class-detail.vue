<template>
  <div>
    <el-card>
      <div style="display: flex">
        <div>
          <el-page-header @back="goBack" content="详情页面">
          </el-page-header>
        </div>
        <div>
          <el-button type="text" style="margin-left: 950px">删除分班</el-button>
          <el-button type="text">分班重命名</el-button>
        </div>
      </div>
      <div style="display: flex;margin-top: 30px">
        <div>
          <span>共5个学生</span>
        </div>
        <div style="margin-left: 905px">
          <el-input style="width: 200px" placeholder="请输入姓名、学号进行搜索" suffix-icon="el-icon-search" v-model="username"></el-input>
          <el-button style="margin-left: 5px" type="primary" @click="load">搜索</el-button>
        </div>
      </div>

    </el-card>
    <div style="margin: 10px 0">
      <span>已选0个</span>
      <el-dropdown @command="handleCommand" style="float: right">
                  <span class="el-dropdown-link" style="font-size: 15px">
                    移动到<i class="el-icon-arrow-down el-icon--right"></i>
                  </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="a">计算机一班</el-dropdown-item>
          <el-dropdown-item command="b">计算机二班</el-dropdown-item>
          <el-dropdown-item command="b">计算机三班</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>

    <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
      <el-table-column prop="id" label="ID" type="selection" width="80" align="center"></el-table-column>
      <el-table-column prop="name" label="姓名" width="200" align="center"></el-table-column>
      <el-table-column prop="num" label="学号" width="250" align="center"></el-table-column>
      <el-table-column prop="phone" label="手机号" align="center"></el-table-column>
      <el-table-column prop="email" label="邮箱" align="center"></el-table-column>
    </el-table>
    <div style="padding: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[2, 5, 15, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>
  </div>

</template>

<script>
import router from "@/router";
import request from "@/utils/request";

export default {
  name: "Class-detail",
  data(){
    return{
      tableData: [
        {id:'1',name: '张三',num: '1855010216',phone:'123456789',email:'123456'},
        {id:'1',name: '张三',num: '1855010216',phone:'123456789',email:'123456'},
        {id:'1',name: '张三',num: '1855010216',phone:'123456789',email:'123456'},
        {id:'1',name: '张三',num: '1855010216',phone:'123456789',email:'123456'},
        {id:'1',name: '张三',num: '1855010216',phone:'123456789',email:'123456'}
      ],
      total: 0,
      pageNum: 1,
      pageSize: 2,
      classname: "",
      headerBg: 'headerBg'
    }
  },
  methods: {
    goBack() {
      router.push("/course")
    },
    load(){
      request.get("http://localhost:8443/user/page",{
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          classname: this.classname
        }
      })
          .then(res=>{
            this.tableData=res.records
            this.total=res.total
          })
    },
    handleSizeChange(pageSize){
      this.pageSize=pageSize
      this.load()
    },
    handleCurrentChange(pageNum){
      this.pageNum=pageNum
      this.load()
    },
    handleCommand(command) {
      if(command=="a"){
        this.dialogFormVisible = true
      }
    },
  }
}
</script>

<style scoped>

</style>
