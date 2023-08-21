<template>
  <nav
    class="header-navbar navbar-expand-md navbar navbar-with-menu navbar-without-dd-arrow fixed-top navbar-semi-light"
  >
    <div class="navbar-wrapper">
      <div class="navbar-container content">
        <Logo />
        <Search />
        <Session />
      </div>
    </div>
  </nav>
</template>

<script>
// 각각의 컴포넌트를 임포트
import Logo from "../moduleViews/logoModule.vue";
import Search from "../moduleViews/searchModule.vue";
import Session from "../moduleViews/sessionModule.vue";

export default {
  components: {
    // 컴포넌트를 로컬로 등록
    Logo,
    Search,
    Session,
  },
};
</script>

<style>
.navbar-container.content {
  display: flex; /* Flexbox를 사용해 자식 요소들을 레이아웃 */
  align-items: center; /* 수직 중앙 정렬 */
  justify-content: center; /* 수평 중앙 정렬 */
}

/* 개별 요소들에 대한 스타일 (필요에 따라 추가적인 스타일을 적용할 수 있음) */
.logo,
.search,
.session {
  text-align: center; /* 텍스트를 수평 중앙 정렬 */
  width: 30%;
}

.blinking {
  -webkit-animation: blink 0.75s ease-in-out infinite alternate;
  -moz-animation: blink 0.75s ease-in-out infinite alternate;
  animation: blink 0.75s ease-in-out infinite alternate;
}
@-webkit-keyframes blink {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}
@-moz-keyframes blink {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}
@keyframes blink {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}
.nav-item.mobile-menu.d-md-none.mr-auto {
  height: 55px !important;
}
</style>
