<template>
  <div class="mainModule">
    <div class="header-container">
      <Header />
    </div>
    <div class="middle-container">
      <div class="sidebar-container">
        <Sidebar />
      </div>
      <div class="router-view-container">
        <router-view />
      </div>
    </div>
    <div class="footer-container">
      <Footer />
    </div>
  </div>
</template>

<script setup>
// import * as $ from "jquery";
import { onMounted, ref } from "vue";
import Sidebar from "@/components/views/SidbarLayout.vue";
import Footer from "@/components/views/FooterLayout.vue";
import Header from "@/components/views/HeaderLayout.vue";

import router from "../../router";
// import $ from "jquery";
</script>

<style>
.mainModule {
  width: 100%;
  height: 100vh;
}

.header-container {
  /* height: 15%;
  background-color: skyblue; */
}

.middle-container {
  height: 75%;
  display: flex;
}

.sidebar-container {
  width: 20%;
  height: 100%;
  background-color: white;
}

.router-view-container {
  width: 80%;
  height: 100%;
  background-color: orange;
}

.footer-container {
  /* height: 10%; */
  background-color: #ddd;
}
</style>
