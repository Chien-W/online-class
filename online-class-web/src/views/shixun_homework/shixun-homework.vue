<template>
  <div>
    <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick">
      <el-tab-pane label="全部" name="0">
        <div v-if="attendanceData.length">
          <div v-for="item in attendanceData">
            <el-card shadow="hover" style="cursor: pointer;margin: 10px 0"  @click.native="openCard">
              <div style="float: left;margin: 10px 0;width: 70%">
                <div>
                  <span>{{ item.cname }}</span>
                  <el-tag type="success" style="border-radius: 10px;margin-left: 5px">进行中</el-tag>
                </div>
                <div style="margin: 15px 0">
                  <span style="font-size: small">{{item.tname}}</span>
                  <span style="font-size: small;margin-left: 4%">未提交:{{item.num}}人</span>
                  <span style="font-size: small;margin-left: 4%">发布时间:{{item.createTime}}</span>
                  <span style="font-size: small;margin-left: 2%">截止时间:{{item.limitTime}}</span>
                </div>
              </div>
              <div style="float: right">
                <el-dropdown @command="handleCommand">
                  <span class="el-dropdown-link">
                    更多<i class="el-icon-arrow-down el-icon--right"></i>
                  </span>
                  <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command="a">立即发布</el-dropdown-item>
                    <el-dropdown-item command="b">立即截止</el-dropdown-item>
                    <el-dropdown-item command="b">删除作业</el-dropdown-item>
                    <el-dropdown-item command="c" divided>高级设置</el-dropdown-item>
                  </el-dropdown-menu>
                </el-dropdown>
              </div>
            </el-card>
          </div>
        </div>
        <div v-else>
          <el-empty :image-size="300"></el-empty>
        </div>
      </el-tab-pane>
      <el-tab-pane label="进行中" name="1">
        <el-empty :image-size="300"></el-empty>
      </el-tab-pane>
      <el-tab-pane label="未发布" name="2">
        <el-empty :image-size="300"></el-empty>
      </el-tab-pane>
    </el-tabs>

    <div class="loginOut">
      <el-button type="text" icon="el-icon-plus" @click="createHw">创建作业</el-button>
    </div>

    <el-dialog title="发布作业" :visible.sync="dialogFormVisible" width="45%">
      <el-form label-width="80px" size="small">
        <el-form-item label="发布时间:">
          <el-date-picker
              v-model="value1"
              type="datetime"
              placeholder="选择日期时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="截止时间:">
          <el-date-picker
              v-model="value2"
              type="datetime"
              placeholder="选择日期时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="发布设置:">
          <el-radio v-model="radio" label="1" @change="noData=[]">统一发布</el-radio>
          <el-radio v-model="radio" label="2" @change="openDialog">分班发布</el-radio>
        </el-form-item>
        <el-transfer
            v-model="yesData"
            :props="{key: 'id',label: 'name'}"
            :titles="['未选择', '已选择']"
            @change="handleChange"
            :data="noData"
        ></el-transfer>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary">确 定</el-button>
      </div>
    </el-dialog>
  </div>


</template>

<script>
import router from "@/router";

export default {
  name: "Homework",
  components: {
  },
  data() {
    return {
      activeName: '0',
      dialogFormVisible: false,
      classFormVisible: false,
      value1: '',
      value2: '',
      radio: '1',
      yesData: [],
      noData: [],
      Data:[
        {id:1,name:'计算机一班'},
        {id:2,name:'计算机二班'},
        {id:3,name:'计算机三班'}
      ],
      attendanceData:[
        {cname: '2022年上学期潇湘学院计算机系2021级《C语言课程设计》',tname: '谢沅峰',createTime:'2022-03-21 14:10',limitTime:'2022-03-21 14:10',num: 5},
        {cname: '2022年上学期潇湘学院计算机系2021级《C语言课程设计》',tname: '谢沅峰',createTime:'2022-03-21 14:10',limitTime:'2022-03-21 14:10',num: 5},
        {cname: '2022年上学期潇湘学院计算机系2021级《C语言课程设计》',tname: '谢沅峰',createTime:'2022-03-21 14:10',limitTime:'2022-03-21 14:10',num: 5},
        {cname: '2022年上学期潇湘学院计算机系2021级《C语言课程设计》',tname: '谢沅峰',createTime:'2022-03-21 14:10',limitTime:'2022-03-21 14:10',num: 5}
      ]
    };
  },
  methods: {
    handleClick(tab, event) {
      router.push({ path: '/shixun_homework', query: { tab: tab.name } })
    },
    createHw(){
      router.push("/shixun_homework/add")
    },
    handleCommand(command) {
      if(command=="a"){
        this.dialogFormVisible = true
      }
    },
    openDialog(){
      this.noData = this.Data
    },
    handleChange(value, direction, movedKeys) {
      //console.log(value, direction, movedKeys);
      //可以通过direction回调right/left 来进行操作，right：把数字移到右边，left把数据移到左边
      if(direction === "right") {

      }
      if(direction === "left") {

      }

    },
    openCard(){
      router.push("/shixun_homework/detail")
    }
  }
}
</script>

<style scoped>
.loginOut{
  position: absolute;right:3%;top:13%;
  color: #e6a23c;
  font-weight: 600;
  font-size: 14px;
}
</style>
