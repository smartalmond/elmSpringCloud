import { createApp } from 'vue'
import { createPinia } from 'pinia'

import 'font-awesome/css/font-awesome.min.css'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import qs from "qs"
import {
    getCurDate,
    setSessionStorage,
    getSessionStorage,
    removeSessionStorage,
    setLocalStorage,
    getLocalStorage,
    removeLocalStorage
} from './common.js'

const app = createApp(App)
app.use(createPinia())
app.use(router)

app.mount('#app')

app.provide('$getCurDate', getCurDate())
app.provide('$setSessionStorage', setSessionStorage);
app.provide('$getSessionStorage', getSessionStorage);
app.provide('$removeSessionStorage', removeSessionStorage);
app.provide('$setLocalStorage', setLocalStorage);
app.provide('$getLocalStorage', getLocalStorage);
app.provide('$removeLocalStorage', removeLocalStorage);
app.provide('$axios',axios)
app.provide('$qs',qs)

//设置axios的基础url部分
axios.defaults.baseURL = 'http://localhost:8080/';

router.beforeEach(function(to,from,next){
    let user = sessionStorage.getItem('user');
    //除了登录、注册、首页、商家列表、商家信息之外，都需要判断是否登录
    if(!
        (to.path==='/'||to.path==='/index'||to.path==='/businessList'||to.path==='/businessInfo'
            ||to.path==='/login'||to.path==='/register')){
        if(user==null){
            router.push('/login').then(r =>location.reload() );
        }
    }
    next();
});
