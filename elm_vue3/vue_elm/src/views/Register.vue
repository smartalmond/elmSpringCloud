<template>
<div class="wrapper">
  <!-- header部分 -->
  <header>
    <p>用户注册</p>
  </header>

  <!-- 表单部分 -->
  <div class="form-box">
    <div class="form-item">
      <div class="title">
        手机号码：
      </div>
      <div class="content">
        <input type="tel" @blur="checkUserId" v-model="user.userId" placeholder="手机号码">
      </div>
    </div>

    <div class="form-item">
      <div class="title">
        密码：
      </div>
      <div class="content">
        <input type="password" v-model="user.password" placeholder="密码">
      </div>
    </div>

    <div class="form-item">
      <div class="title">
        确认密码：
      </div>
      <div class="content">
        <input type="password" v-model="confirmPassword" placeholder="确认密码">
      </div>
    </div>

    <div class="form-item">
      <div class="title">
        用户姓名：
      </div>
      <div class="content">
        <input type="text" v-model="user.userName" placeholder="用户姓名">
      </div>
    </div>

    <div class="form-item">
      <div class="title">
        性别：
      </div>
      <div class="content">
        <input type="radio" v-model="user.userSex" name="sex" checked style="width:6vw;height: 3.2vw;">男
        <input type="radio" v-model="user.userSex" name="sex" style="width:6vw;height: 3.2vw;">女
      </div>
    </div>

    <div class="button-register">
      <button @click="register">注册</button>
    </div>
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
import router from "@/router";

const user=ref({
  userId:'',
  password:'',
  userName:'',
  userSex:1
})
const confirmPassword=ref('')

function checkUserId(){
  axios.post('UserController/getUserById', qs.stringify({
    userId: user.value.userId,
  })).then(response => {
    if(response.data===1){
      user.value.userId = '';
      alert('此手机号码已存在！')
    }
  }).catch(error => {
    console.error(error);
  });
}
function register(){
  if (user.value.userId === '') {
    alert('手机号码不能为空！');
    return;
  }
  if (user.value.password === '') {
    alert('密码不能为空！');
    return;
  }
  if (user.value.password !== confirmPassword.value) {
    alert('两次输入的密码不一致！');
    return;
  }
  if (user.value.userName === '') {
    alert('用户名不能为空！');
    return;
  }
  axios.post('UserController/saveUser',qs.stringify(
      user.value
  )).then(response => {
    if(response.data>0){
      alert('注册成功！');
      router.go(-1);
    }else{
      alert('注册失败！');
    }
  }).catch(error => {
    console.error(error);
  });
}

</script>

<style scoped>
/****************** 总容器 ******************/
.wrapper{
  width: 100%;
  height: 100%;
}
/****************** header部分 ******************/
.wrapper header{
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
  font-weight: 500;
  margin-top: 2vw;
}
.wrapper .button-register{
  width: 100%;
  padding: 2vw;
}
.wrapper .button-register button{
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
