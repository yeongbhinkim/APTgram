<template>
  <div class="testTest">
    <h1>라우터 콘텐츠 페이지</h1>
    <div>
      <p>{{ responseMessage }}</p>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from "vue";
import axios from "axios";

export default defineComponent({
  setup() {
    const responseMessage = ref("");

    // 9080 포트로 요청 보내기
    const checkConnection = async () => {
      try {
        const response = await axios.get("http://localhost:9080/apt/test");
        console.log("성공");
        responseMessage.value = "연결 성공: " + response.data;
      } catch (error: any) {
        console.log("실패");
        responseMessage.value = "연결 실패: " + error.message;
      }
    };

    // 컴포넌트가 마운트될 때 연결 확인
    checkConnection();

    return { responseMessage };
  },
});
</script>
