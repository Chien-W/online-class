<template>
  <div>
    <div style="padding: 10px 0">
      <el-input style="width: 200px" placeholder="请输入姓名" suffix-icon="el-icon-search" v-model="username"></el-input>
      <!--            <el-input style="width: 200px;margin-left: 5px" placeholder="请输入邮箱" suffix-icon="el-icon-search"></el-input>-->
      <!--            <el-input style="width: 200px;margin-left: 5px" placeholder="请输入地址" suffix-icon="el-icon-search"></el-input>-->
      <el-button style="margin-left: 5px" type="primary" @click="load">搜索</el-button>
    </div>
    <div style="margin: 10px 0">
      <el-button type="primary">新增
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
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="username" label="用户名" width="140"></el-table-column>
      <el-table-column prop="nickname" label="昵称" width="120"></el-table-column>
      <el-table-column prop="email" label="邮箱"></el-table-column>
      <el-table-column prop="phone" label="电话"></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
      <el-table-column label="操作" width="200" align="center">
        <template>
          <el-button type="success">编辑<i class="el-icon-edit"></i></el-button>
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

export default {
  name: "Class",
  data(){
    return{
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 2,
      username: "",
      headerBg: 'headerBg'
    }
  },
  created() {
    this.load()
  },
  methods:{
    load(){
      request.get("http://localhost:8443/user/page",{
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          username: this.username
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
    }
  }
}
</script>

<style scoped>
.headerBg{
  background: #eee!important;
}
</style>
