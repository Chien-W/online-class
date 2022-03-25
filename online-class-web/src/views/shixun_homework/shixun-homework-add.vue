<template>
  <div>
    <el-card>
      <div style="size: 6px;margin-bottom: 10px">
        <span style="font-size: 15px;font-weight: bold">标题:</span>
      </div>
      <div style="margin-bottom: 10px">
        <el-input v-model="input" placeholder="请输入内容" maxlength="60" size="medium"></el-input>
      </div>
    </el-card>
    <el-card style="margin-top: 10px">
      <div style="size: 6px;margin-bottom: 10px">
        <span style="font-size: 15px;font-weight: bold">简介:</span>
      </div>
      <tinymce></tinymce>
      <el-upload
          class="upload-demo"
          action="https://jsonplaceholder.typicode.com/posts/"
          :on-preview="handlePreview"
          :on-remove="handleRemove"
          :before-remove="beforeRemove"
          multiple
          :limit="3"
          :on-exceed="handleExceed"
          :file-list="fileList"
          style="margin-top: 10px">
        <el-button size="small">上传附件</el-button>
      </el-upload>
      <span style="font-size: 10px">(单个文件最大150MB)</span>
    </el-card>
    <div style="margin-top: 10px">
      <el-button type="primary">提交</el-button>
      <el-button type="primary" @click="back">取消</el-button>
    </div>
  </div>
</template>

<script>
import Tinymce from "@/components/tinymce";
import router from "@/router";
export default {
  name: "shixunHw-add",
  components:{
    Tinymce
  },
  // beforeDestroy () {
  //   window.tinymce.remove('#tinymces') //一定要销毁 否则每次都需要刷新页面才能初始化
  // },
  data() {
    return {
      input: '',
      fileList: [
        {name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'},
        {name: 'hustoj文档大全.pdf', url: 'C:\\Users\\Administrator\\Desktop\\hustoj文档大全.pdf'},
      ]
    }
  },
  methods: {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${ file.name }？`);
    },
    back(){
      router.push("/shixun_homework")
    }
  }
}
</script>

<style scoped>

</style>
