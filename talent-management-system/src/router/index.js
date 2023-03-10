import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from "@/views/Login";
import SystemAdmin from "@/views/SystemAdmin.vue";
import CompanyAdminRecord from "@/views/CompanyAdminRecord.vue";
import CompanyAdminManagement from "@/views/CompanyAdminManagement.vue";
import Signup from "@/views/Signup.vue";
import HRinfo from "@/views/HRinfo.vue";
import HRhome from "@/views/HRhome.vue";
import employeeAdd from "@/views/EmployeeAdd.vue";
import employeeManager from "@/views/EmployeeManager.vue";
import employeeUpdate from "@/views/EmployeeUpdate.vue";
import checkAdd from "@/views/CheckAdd.vue";
import checkManager from "@/views/CheckManager.vue";
import achievementAdd from "@/views/AchievementAdd.vue";
import achievementManager from "@/views/AchievementManager.vue";
import companyinfo from "@/views/Companyinfo.vue"
import companyUpdate from "@/views/CompanyUpdate.vue"
import departmentManagement from "@/views/DepartmentManager.vue";
import departmentAdd from "@/views/DepartmentAdd.vue";
import departmentUpdate from "@/views/DepartmentUpdate.vue";
import companyAdmin from "@/views/CompanyAdmin";
import HRAdd from "@/views/HRAdd.vue";
import HRUpdate from "@/views/HRUpdate.vue";
import HRManagement from "@/views/HRManager.vue";
import companyAdminUpdate from "@/views/CompanyAdminUpdate.vue";

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
    path: '/HRhome',
    name: 'HR平台',
    component: HRhome,
    redirect: '/HRinfo',
    children:[
      {
        path: '/HRinfo',
        name: 'HR平台',
        component: HRinfo,
      },
      {
        path: '/employeeadd',
        name: '添加员工信息',
        component: employeeAdd
      },
      {
        path: '/employeeManager',
        name: '管理员工信息',
        component: employeeManager
      },{
        path: '/employeeUpdate',
        name: '更新员工信息',
        component: employeeUpdate
      },
      {
        path: '/checkadd',
        name: '添加考勤记录',
        component: checkAdd
      },
      {
        path: '/checkManager',
        name: '管理考勤记录',
        component: checkManager
      },
      {
        path: '/achievementAdd',
        name: '添加绩效信息',
        component: achievementAdd
      },
      {
        path: '/achievementManager',
        name: '管理绩效信息',
        component: achievementManager
      }
    ]
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
    },
    {
      path: '/companyAdminRecord',
      name: '审批记录',
      component: CompanyAdminRecord
    },
      {
        path: '/companyUpdate',
        name: '公司信息修改',
        component: companyUpdate
      }
      ,
      {
        path: '/companyinfo',
        name: '公司管理',
        component: companyinfo
      }
    ]
  },
  {
    path: '/companyAdmin',
    name: '公司管理员',
    component: companyAdmin ,
    redirect: '/departmentAdd',
    children:[
      {
        path: '/companyAdminUpdate',
        name: '修改密码',
        component: companyAdminUpdate
      },
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
      {
        path: '/hrManagement',
        name: 'HR管理',
        component: HRManagement
      },
      {
        path: '/hrAdd',
        name: '添加HR',
        component: HRAdd
      },
      {
        path: '/hrUpdate',
        name: '修改HR',
        component: HRUpdate
      }
    ]
  },
  {
    path: '/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
