<template>
  <div>
    <div style="padding: 10px 0">
      <el-input style="width: 200px" placeholder="请输入分班名称进行搜索" suffix-icon="el-icon-search" v-model="username"></el-input>
      <el-button style="margin-left: 5px" type="primary" @click="load">搜索</el-button>
    </div>
    <div style="margin: 10px 0">
      <el-button type="primary">新增班级
        <i class="el-icon-circle-plus-outline"></i>
      </el-button>
      <el-button type="danger">批量删除
        <i class="el-icon-remove-outline"></i>
      </el-button>
      <el-button type="primary">导入
        <i class="el-icon-bottom"></i>
      </el-button>
      <el-button type="primary">导出
        <i class="el-icon-top"></i>
      </el-button>
    </div>

    <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
      <el-table-column prop="id" label="ID" type="selection" width="80" align="center"></el-table-column>
      <el-table-column prop="classname" label="分班名称" width="200" align="center"></el-table-column>
      <el-table-column prop="stunum" label="学生成员" width="100" align="center"></el-table-column>
      <el-table-column prop="teacher" label="管理教师" align="center"></el-table-column>
      <el-table-column prop="sign" label="邀请码" align="center"></el-table-column>
      <el-table-column label="操作" width="300" align="center">
        <template>
          <el-button type="success" @click="detail">查看<i class="el-icon-edit"></i></el-button>
          <el-button type="danger">删除<i class="el-icon-remove-outline"></i></el-button>
        </template>
      </el-table-column>
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
import request from "@/utils/request";
import router from "@/router";

export default {
  name: "Class",
  data(){
    return{
      tableData: [
        {id:'1',classname: '18计算机二班',stunum: '30',teacher:'谢沅峰',sign:'AKQSCJ'},
        {id:'1',classname: '18计算机二班',stunum: '30',teacher:'谢沅峰',sign:'AKQSCJ'},
        {id:'1',classname: '18计算机二班',stunum: '30',teacher:'谢沅峰',sign:'AKQSCJ'},
        {id:'1',classname: '18计算机二班',stunum: '30',teacher:'谢沅峰',sign:'AKQSCJ'},
        {id:'1',classname: '18计算机二班',stunum: '30',teacher:'谢沅峰',sign:'AKQSCJ'}
      ],
      total: 0,
      pageNum: 1,
      pageSize: 2,
      classname: "",
      headerBg: 'headerBg'
    }
  },
  // created() {
  //   this.load()
  // },
  methods:{
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
    detail(){
      router.push("/class_detail")
    }
  }
}
</script>

<style scoped>

</style>
