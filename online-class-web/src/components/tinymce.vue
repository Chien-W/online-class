<template>
    <section id="tinymce-editor"></section>
</template>

<script>
import '../../public/tinymce/tinymce.min.js';
import '../../public/tinymce/themes/silver/theme.min.js';
import '../../public/tinymce/langs/zh_CN.js'
import '../../public/tinymce/plugins/preview/plugin.min.js'
import '../../public/tinymce/plugins/searchreplace/plugin.min'
export default {
  name: "tinymce",
  mounted() {
    tinymce.init({
      language: 'zh_CN',
      selector: '#tinymce-editor',
      // menubar: 'bar1 bar2',  //菜单栏
      // menu: {
      //   bar1: {title: '菜单栏1',items: 'copy paste'},
      //   bar2: {title: '菜单栏2',items: 'cut preview'},
      //  },
      // toolbar: 'undo redo bold bullist numlist',  //工具栏
      height: 400, //编辑器高度
      min_height: 300,//按照自己的需求设置
      fontsize_formats: '12px 14px 16px 18px 24px 36px 48px 56px 72px',
      font_formats: '微软雅黑=Microsoft YaHei,Helvetica Neue,PingFang SC,sans-serif;苹果苹方=PingFang SC,Microsoft YaHei,sans-serif;宋体=simsun,serif;仿宋体=FangSong,serif;黑体=SimHei,sans-serif;Arial=arial,helvetica,sans-serif;Arial Black=arial black,avant garde;Book Antiqua=book antiqua,palatino;',
      plugins: 'preview searchreplace'
    })
  },
  beforeDestroy () {
    window.tinymce.remove('#tinymce-editor') //一定要销毁 否则每次都需要刷新页面才能初始化
  },
  methods: {
  }
}
</script>

<style scoped>
@import url('../../public/tinymce/skins/ui/oxide/skin.min.css');
</style>
