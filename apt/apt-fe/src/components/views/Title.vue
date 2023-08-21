<template>
  <div class="content-header row">
    <div class="content-header-left col-md-4 col-12 mb-2">
      <!-- <h3 class="content-header-title" v-model="menuName" ref="id">{{menuName}}</h3> -->
      <h3 class="content-header-title" ref="menuRef">{{ menuName }}</h3>
    </div>
    <div class="content-header-right col-md-8 col-12">
      <div class="breadcrumbs-top float-md-right">
        <!--  <div class="breadcrumb-wrapper mr-1">-->

        <div class="breadcrumb">
          <!-- 로그인 사용자 이름 / 로그아웃 -->

          <h4 class="content-header-title">
            <router-link
              :to="{ name: myPageUrl }"
              class="content-header-title"
              >{{ mbrNm }}</router-link
            >
          </h4>
          &nbsp;&nbsp;
          <h4 class="content-header-title">/</h4>
          &nbsp;&nbsp;
          <h4 class="content-header-title">
            <a
              class="content-header-title"
              href="#"
              @click="goLogout"
              data-toggle="dropdown"
              >LOGOUT</a
            >
          </h4>
        </div>

        <!-- <ol class="breadcrumb">
	                      <li class="breadcrumb-item"><a href="javascript:void(0);">Home</a>
	                  </li>
	                  <li class="breadcrumb-item"><a href="javascript:void(0);">{{menuTitle}}</a>
	                  </li>
	                  <li class="breadcrumb-item active">{{menuName}}
	                  </li>
	                </ol> -->
        <!--     </div>-->
      </div>
    </div>
  </div>
</template>

<script></script>
