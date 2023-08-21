<template>
  <div class="content-wrapper">
    <section class="flexbox-container">
      <div class="col-12 d-flex align-items-center justify-content-center">
        <div
          class="col-md-4 col-10 box-shadow-2 p-0 card border-grey border-lighten-3 px-1 py-1 m-0"
        >
          <div class="card-header border-0 text-center">
            <div class="mb-1"></div>
            <div class="font-large-1">Member Login</div>
          </div>
          <div class="card-content card-body">
            <form @submit.prevent="goLogin" class="form-horizontal" novalidate>
              <fieldset class="form-group position-relative has-icon-left">
                <input
                  v-model="uid"
                  type="text"
                  class="form-control round"
                  placeholder="Your Username"
                  required
                />
                <div class="form-control-position">
                  <i class="ft-user"></i>
                </div>
              </fieldset>
              <fieldset class="form-group position-relative has-icon-left">
                <input
                  v-model="password"
                  type="password"
                  class="form-control round"
                  placeholder="Enter Password"
                  required
                />
                <div class="form-control-position">
                  <i class="ft-lock"></i>
                </div>
              </fieldset>
              <div class="form-group text-center">
                <button
                  type="submit"
                  class="btn round btn-block btn-glow btn-bg-gradient-x-purple-blue col-12 mr-1 mb-1"
                >
                  Login
                </button>
              </div>
            </form>
          </div>
          <modals-container @goLogin="goFinal" />
        </div>
      </div>
    </section>
  </div>
</template>

<script setup>
import { ref } from "vue";
import ModalPasswordUpdate from "@/views/ModalPasswordUpdate.vue";
import store from "../utils/store";

// Data properties
const uid = ref("");
const password = ref("");

// Methods
const goLogin = function () {
  // Authentication logic goes here
};

// Other methods can be defined similarly

// Component lifecycle hooks
onMounted(() => {
  $("#memId").focus();
});
</script>
