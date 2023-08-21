// src/router.ts
import { createRouter, createWebHistory } from "vue-router";
// import "../../corejs/app-assets/css/app.css";
import "./corejs/app-assets/css/app.css";
// import * as $ from "jquery";

const routes = [
  { path: "/", component: () => import("@/components/HelloWorld.vue") },
  {
    path: "/testTest",
    component: () => import("@/components/testTest.vue"),
  },
  // { path: "/main", component: () => import("@/views/MainLayout.vue") },
  {
    path: "/main",
    component: () => import("@/views/MainLayout.vue"),
    children: [
      {
        path: "testTest",
        component: () => import("@/components/testTest.vue"),
      },
      // { path: "child2", component: () => import("@/components/Child2.vue") },
      // 추가 자식 라우트
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
