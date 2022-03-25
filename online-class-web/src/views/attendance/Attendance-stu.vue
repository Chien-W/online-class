<template>
<div>
  <el-tabs type="border-card" style="width: 100%">
    <el-tab-pane>
      <span slot="label">全部签到</span>
      <div v-if="attendanceData.length">
        <div v-for="item in attendanceData">
          <el-card shadow="hover" style="cursor: pointer;margin: 10px 0;position: relative">
            <div style="margin: 10px 0">
              <span>{{ item.cname }}</span>
              <el-tag type="success" style="border-radius: 10px;margin-left: 5px">进行中</el-tag>
            </div>
            <div class="signInStatus___1GIMF color1890FF___1B592">
              {{state[0]}}
            </div>
            <div style="display: flex;margin: 10px 0">
              <span>签到人数</span>
              <el-progress :percentage="60" style="width: 25%;margin: auto 5px" :show-text="false"></el-progress>
              <span style="font-size: small;margin-left: 5px">已签到{{item.num1}}/</span>
              <span style="font-size: small">应签到{{item.num2}}</span>
            </div>
            <div style="margin: 10px 0">
              <span style="font-size: small">签到发起人:{{item.tname}}</span>
              <span style="font-size: small;margin-left: 30%">开始结束时间:{{item.time}}</span>
              <div style="float: right">
                <el-button type="primary">签到</el-button>
              </div>
            </div>

          </el-card>
        </div>
      </div>
      <div v-else>
        <el-empty :image-size="300"></el-empty>
      </div>


    </el-tab-pane>

    <el-tab-pane>
      <span slot="label">正在签到</span>
      <el-empty :image-size="300"></el-empty>
    </el-tab-pane>

    <el-tab-pane>
      <span slot="label">历史签到</span>
      <el-empty :image-size="300"></el-empty>
    </el-tab-pane>

  </el-tabs>
</div>
</template>

<script>
export default {
  name: "MyAttendance",
  data(){
    return{
      attendanceData:[
        {cname: '数据结构A',num1: '10',num2: '50',tname: '谢沅峰',time:'2022-03-17 15:25-19:00'},
        {cname: '数据库技术',num1: '15',num2: '50',tname: '谢沅峰',time:'2022-03-17 15:25-19:00'},
        {cname: '操作系统',num1: '20',num2: '50',tname: '谢沅峰',time:'2022-03-17 15:25-19:00'},
        {cname: '操作系统',num1: '20',num2: '50',tname: '谢沅峰',time:'2022-03-17 15:25-19:00'}
      ],
      state:['正常','旷课'],
    }
  }
}
</script>

<style scoped>
.color1890FF___1B592 {
  background-color: rgba(24,144,255,.2);
  color: #1890ff;
  /*background-color: rgba(224,32,32,.2);*/
  /*color: #e02020;*/
}
.signInStatus___1GIMF {
  position: absolute;
  float: right;
  right: -35px;
  top: -35px;
  width: 70px;
  height: 70px;
  display: flex;
  align-items: flex-end;
  justify-content: center;
  transform: rotate(45deg);
}
</style>
