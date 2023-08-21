<template>
  <body
    class="vertical-layout vertical-menu 1-column bg-gradient-directional-danger menu-expanded blank-page blank-page"
    data-open="click"
    data-menu="vertical-menu"
    data-color="bg-gradient-x-purple-blue"
    data-col="1-column"
  >
    <div class="app-content content">
      <div class="content-wrapper">
        <div class="content-wrapper-before"></div>
        <div class="content-header row"></div>
        <div class="content-body">
          <section class="flexbox-container bg-hexagons-danger">
            <div
              class="col-12 d-flex align-items-center justify-content-center"
            >
              <div class="col-md-4 col-10 p-0">
                <div class="card-header bg-transparent border-0">
                  <h2 class="error-code text-center mb-2 white">404</h2>
                  <h3 class="text-uppercase text-center white">
                    Page Not Found !
                  </h3>
                </div>
                <!-- ... 나머지 내용은 동일 ... -->
              </div>
            </div>
          </section>
        </div>
      </div>
    </div>
  </body>
</template>

<script setup>
import { onMounted } from "vue";

// 여기서 필요한 공통 함수를 가져올 수 있어
// 예: import { addBgFullScreen } from '@/common-functions';

onMounted(() => {
  // Vue 3에서는 onMounted 라이프사이클 훅을 사용해야 해
  // addBgFullScreen();
});
</script>
