<template>
<div class="wrapper">
  <!-- header部分 -->
  <header>
    <p>用户登陆</p>
  </header>

  <!-- 表单部分 -->
  <div class=form-box>
    <div class="form-item">
      <div class="title">
        手机号码：
      </div>
      <div class="content">
        <input type="text" v-model="userId" placeholder="请输入手机号码">
      </div>
    </div>
    <div class="form-item">
      <div class="title">
        密码：
      </div>
      <div class="content">
        <input type="password" v-model="password" placeholder="请输入密码">
      </div>
    </div>
  </div>
  <div class="button-set">
    <button @click="login">登录</button>
  </div>
  <div class="button-set">
    <button @click="register">去注册</button>
  </div>

  <!-- 底部菜单部分 -->
  <Footer></Footer>
</div>
</template>

<script setup>
import Footer from "@/components/Footer.vue";
import {ref} from "vue";
import axios from "axios";
import qs from "qs";
import {setSessionStorage} from "@/common";
import router from "@/router";

const userId = ref('');
const password = ref('');

function login(){
  if(userId === ''){
    alert('手机号码不能为空！');
    return;
  }
  if(password === ''){
    alert('密码不能为空！');
    return;
  }

  // 登录请求
  axios.post('/UserController/getUserByIdByPass', qs.stringify({
    userId: userId.value,
    password: password.value
  })).then(response => {
    let user = response.data;
    if (user==null || user === '') {
      alert('用户名或密码不正确！');
    } else {
      // sessionStorage 有容量限制，为了防止数据溢出，所以不将 userImg 数据放入 session
      user.userImg = '';
      setSessionStorage('user', user);
      router.go(-1);
    }
  }).catch(error => {
    console.error(error);
    alert('登录请求失败，请稍后重试！');
  });
}

function register(){
  router.push({
    path:'/register'
  })
}
</script>

<style scoped>
/****************** 总容器 ******************/
.wrapper {
  width: 100%;
  height: 100%;
}
/****************** header部分 ******************/
.wrapper header {
  width: 100%;
  height: 12vw;
  background-color: #0097FF;
  color: #fff;
  font-size: 4.8vw;

  position: fixed;
  left: 0;
  top: 0;
  z-index: 1000;

  display: flex;
  justify-content: center;
  align-items: center;
}
/****************** Form部分 ******************/
.wrapper .form-box{
  width: 100%;
  margin-top: 15vw;
}
.wrapper .form-item{
  display: flex;
  margin-bottom: 3vw;
  padding-left: 2vw;
  align-items: center;
}
.wrapper .form-box .form-item .title{
  display: flex;
  font-size: 4.5vw;
  font-weight: 600;
  color: #505050;
}
.wrapper .form-box .form-item .content{
  color: #666;
}
.wrapper .form-box .form-item .content input{
  border: 0;
  align-items: center;
  font-size: 4.2vw;
  font-weight: 600;
  margin-top: 2vw;
}
.wrapper .button-set{
  width: 100%;
  padding: 1vw 2vw;
}
.wrapper .button-set button{
  width: 100%;
  height: 10vw;
  font-size: 4.5vw;
  font-weight: 700;
  color: #fff;
  background-color: #38CA73;
  border-radius: 2vw;

  border: none;
  outline: none;
}
</style>
