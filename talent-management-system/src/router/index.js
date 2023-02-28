import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from "@/views/Login";
import SystemAdmin from "@/views/SystemAdmin.vue";
import CompanyAdminRecord from "@/views/CompanyAdminRecord.vue";
import CompanyAdminManagement from "@/views/CompanyAdminManagement.vue";
import Signup from "@/views/Signup.vue";
import CompanyAdmin from "@/views/CompanyAdmin.vue";
import departmentManagement from "@/views/DepartmentManagement.vue";
import departmentAdd from "@/views/DepartmentAdd.vue";
import departmentUpdate from "@/views/DepartmentUpdate.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/signup',
    name: '注册',
    component: Signup
  },
  {
    path: '/login',
    name: '登录',
    component: Login
  },
  {
    path: '/systemAdmin',
    name: '系统管理员',
    component: SystemAdmin,
    redirect: '/companyAdminManagement',
    children:[
    {
      path: '/companyAdminManagement',
      name: '注册审批',
      component: CompanyAdminManagement
    }
    ,
    {
      path: '/companyAdminRecord',
      name: '审批记录',
      component: CompanyAdminRecord
    }
    ]
  },
  {
    path: '/companyAdmin',
    name: '系统管理员',
    component: CompanyAdmin,
    redirect: '/departmentManagement',
    children:[
      {
        path: '/departmentManagement',
        name: '部门信息管理',
        component: departmentManagement
      },
      {
        path: '/departmentAdd',
        name: '部门添加',
        component: departmentAdd
      },
      {
        path: '/departmentUpdate',
        name: '部门信息修改',
        component: departmentUpdate
      },
    ]
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
