import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    children: [
      {
        path: '/',
        name: '班级管理',
        component: () => import('../views/teacher/Class')
      },
      {
        path: '/homework',
        name: '作业管理',
        component: () => import('../views/teacher/Homework')
      },
      {
        path: '/attendance',
        name: '签到',
        component: () => import('../views/teacher/Attendance')
      },
      {
        path: '/file',
        name: '文件管理',
        component: () => import('../views/teacher/File')
      }
    ]
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('../components/About.vue')
  },
  {
    path: '/info',
    name: 'Info',
    component: () => import('../components/Info')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


router.beforeEach((to, from, next) => {
  localStorage.setItem("currentPathName", to.name)  // 设置当前的路由名称

  // // 未找到路由的情况
  // if (!to.matched.length) {
  //   const storeMenus = localStorage.getItem("menus")
  //   if (storeMenus) {
  //     next("/404")
  //   } else {
  //     // 跳回登录页面
  //     next("/login")
  //   }
  // }
  // // 其他的情况都放行
  next()

})

export default router
