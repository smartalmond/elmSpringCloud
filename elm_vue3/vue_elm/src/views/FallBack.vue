<template>
  <div class="wrapper">
    <div class="message-container">
      <img src="@/assets/busy.jpg" alt="Service Busy" class="icon" />
      <p class="message">哎呀，服务器繁忙中...</p>
      <button class="retry-button" @click="retry">返回重试</button>
    </div>
    <!-- 底部菜单部分 -->
    <Footer></Footer>
  </div>
</template>

<script setup>
import Footer from "@/components/Footer.vue";
import router from "@/router";

const retry = () => {
  router.go(-1);
};
</script>

<style scoped>
.wrapper {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 100vw;
  height: 100vh;
}

.message-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 40vh; /* Adjusted height to give more space for the footer */
  transform: translateY(15vh); /* Moved content upwards */
}

.icon {
  width: 40vw;
  height: 40vw;
}

.message {
  font-size: 5vw;
  color: #666;
  margin-top: 2vh;
}

.retry-button {
  margin-top: 3vh;
  padding: 1vh 3vw;
  font-size: 4vw;
  color: #fff;
  background-color: #007BFF;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.retry-button:hover {
  background-color: #0056b3;
}
</style>
