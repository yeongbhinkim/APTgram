<template>
  <div id="app">
    <router-view />
    <!-- 라우터 출력 위치 -->
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { useStore } from "vuex"; // 스토어 사용
import { useRouter } from "vue-router"; // 라우터 사용

export default defineComponent({
  name: "App",
  setup() {
    // 스토어와 라우터 인스턴스 가져오기
    const store = useStore();
    const router = useRouter();

    // 스토어나 라우터를 이용한 로직은 여기에 작성

    return {}; // 필요한 변수나 메서드 반환
  },
});
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
</style>
