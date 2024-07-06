import { createRouter, createWebHashHistory } from 'vue-router'
import Index from '../views/Index.vue'
import BusinessList from '../views/BusinessList.vue'
import BusinessInfo from '../views/BusinessInfo.vue'
import Login from '../views/Login.vue'
import Order from '../views/Order.vue'
import UserAddress from '../views/UserAddress.vue'
import Payment from '../views/Payment.vue'
import OrderList from '../views/OrderList.vue'
import AddUserAddress from '../views/AddUserAddress.vue'
import EditUserAddress from '../views/EditUserAddress.vue'
import Register from '../views/Register.vue'

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      name: 'home',
      component:Index
    },{
      path:'/index',
      name:'Index',
      component: () => import('../views/Index.vue')
    },{
      path:'/businessList',
      name:'BusinessList',
      component: () => import('../views/BusinessList.vue')
    },{
      path:'/businessInfo',
      name:'BusinessInfo',
      component: () => import('../views/BusinessInfo.vue')
    },{
      path:'/login',
      name:'Login',
      component: () => import('../views/Login.vue')
    },{
      path:'/order',
      name:'Order',
      component: () => import('../views/Order.vue')
    },{
      path:'/userAddress',
      name:'UserAddress',
      component: () => import('../views/UserAddress.vue')
    },{
      path:'/payment',
      name:'Payment',
      component: () => import('../views/Payment.vue')
    },{
      path:'/orderList',
      name:'OrderList',
      component: () => import('../views/OrderList.vue')
    },{
      path:'/addUserAddress',
      name:'AddUserAddress',
      component: () => import('../views/AddUserAddress.vue')
    },{
      path:'/editUserAddress',
      name:'EditUserAddress',
      component: () => import('../views/EditUserAddress.vue')
    },{
      path:'/register',
      name:'Register',
      component: () => import('../views/Register.vue')
    },{
      path:'/busy',
      name:'Busy',
      component: () => import('../views/FallBack.vue')
    }
  ]
})

export default router
