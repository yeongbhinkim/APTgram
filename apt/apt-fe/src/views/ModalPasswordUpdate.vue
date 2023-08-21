<!-- <template>
  <b-modal
    v-model="modalShow"
    hide-footer
    hide-header
    title-tag="h3"
    title="회원가입"
  >
    <div>
      <div class="modal-header">
        <h3 ref="title" class="modal-title" id="myModalLabel35">
          비밀번호 변경
        </h3>
        <button
          type="button"
          class="close"
          data-dismiss="modal"
          aria-label="Close"
          @click="cancle"
        >
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <b-form id="formMbrPw_Edit" @submit="submit">
        <div class="modal-body">
          <div class="form-group">
            <label for="memPassword0">기존 비밀번호 확인</label>
            <b-form-input
              v-model="form.oldPw"
              type="password"
              :state="nameState0"
              aria-describedby="inputLiveFeedback0"
              id="memPassword0"
              class="form-control"
              placeholder=""
              name=""
              @change.native="keyupOldPw"
              required
            ></b-form-input>
            <b-form-invalid-feedback id="inputLiveFeedback0">
              기존 비밀번호가 맞지 않습니다.
            </b-form-invalid-feedback>
          </div>
          <div class="form-group">
            <label for="memPasswordAdd">패스워드</label>
            <b-form-input
              v-model="form.memPasswordAdd"
              type="password"
              :state="nameState"
              aria-describedby="inputLiveFeedback0"
              id="memPasswordAdd"
              class="form-control"
              placeholder=""
              name=""
              v-on:keyup="keyup"
              required
            ></b-form-input>
            <b-form-invalid-feedback id="inputLiveFeedback0">
              비밀번호는 영문대소문자,숫자,특수문자를 포함하여 8~32글자 사이로
              입력해주세요.
            </b-form-invalid-feedback>
          </div>
          <div class="form-group">
            <label for="memPassword1">패스워드 확인</label
            ><!--onkeyup="this.commonFn.txtChk(this);" v-model="always"-->
            <b-form-input
              v-model="form.pw2"
              type="password"
              :state="nameState2"
              aria-describedby="inputLiveFeedback"
              id="memPassword1"
              class="form-control"
              placeholder=""
              name=""
              v-on:keyup="keyup"
              required
            ></b-form-input>
            <b-form-invalid-feedback id="inputLiveFeedback">
              비밀번호는 영문대소문자,숫자,특수문자를 포함하여 8~32글자 사이로
              입력해주세요.
            </b-form-invalid-feedback>
            {{ msg }}
          </div>
        </div>
        <div class="modal-footer">
          <Button v-bind:propsdata="buttons" />
        </div>
      </b-form>
    </div>
  </b-modal>
</template>

<script>
//
import commonFn from "@/utils/commonFunction.js";
import Button from "@/components/common/Button.vue";

export default {
  name: "modalMbrInfo",
  data() {
    return {
      modalShow: true,
      form: [],
      options: [],
      config: require("@/plugins/config.js"),
      always: "",
      memPasswdAdd: "",
      msg: "",
      oldPwCk: true,
      dupCheckYn: false,
      nameStateSucess: false,
      buttons: ["btnLater", "subChange"],
      // buttons:['btnLater','subChange','threeLater']
    };
  },
  props: ["memIdProps", "memPasswordProps"],
  components: { Button },
  computed: {
    nameState0: function () {
      return this.oldPwCk == true;
    },
    nameState: function () {
      console.log("nameState");
      if (this.$commonFn.nullChk(this.form.memPasswordAdd) == "") {
        return true;
      }

      //영문대소문자, 숫자, 특수문자 혼용해서 8~32자 이내
      if (this.$commonFn.passWordCheck(this.form.memPasswordAdd)) {
        //if(this.form.memPasswordAdd == this.form.pw2)
        return true;
      }

      return false;
    },
    nameState2: function () {
      if (this.$commonFn.nullChk(this.form.pw2) == "") {
        return true;
      }

      //영문대소문자, 숫자, 특수문자 혼용해서 8~32자 이내
      if (this.$commonFn.passWordCheck(this.form.pw2)) {
        if (this.form.memPasswordAdd == this.form.pw2) return true;
      }
      return false;
    },
  },
  created() {
    console.log("modal mbrInfo create");

    this.$EventBus.$on("laterBtn", this.laterBtn);
    //    this.$EventBus.$on('threeLaterBtn', this.threeLaterBtn);
  },
  watch: {
    always: function () {
      console.log("입력중......");
    },
  },
  methods: {
    laterBtn: function () {
      console.log("laterBtn");
      this.$emit("goLogin", "Y"); //pass 여부
    },
    // threeLaterBtn : function() {
    // 	console.log("threeLaterBtn");
    // 	this.$emit('threeLater', 'Y');

    // },
    submit: function (evt) {
      evt.preventDefault();

      if (this.nameState == true && this.nameState2 == true) {
        if (this.form.memPasswordAdd == this.form.pw2) this.chkOldInfo();
        else {
          alert("신규 비밀번호가 맞지 않습니다.");
        }
      }
    },
    keyupOldPw: function () {
      console.log("keyupOldPw");
      //기존 비밀번호 체크

      $.ajax({
        type: "POST",
        url: this.$config.host + "/login/loginChk",
        data: {
          mbrId: this.memIdProps,
          mbrPw: this.form.oldPw,
        },
        success: (result) => {
          console.log(result);
          if (result == true) {
            console.log("loginChk - success");
            this.oldPwCk = true;
          } else {
            console.log("loginChk - fail");
            this.oldPwCk = false;
          }
        },
        error: function () {
          console.log("loginChk - error");
          alert("error");
        },
      });
    },
    keyup: function (event) {
      commonFn.txtChk(event.target);

      //전화번호 숫자만 입력 가능하도록
      if (event.target.id == "tel" && event.target.value != "") {
        var keyID = event.which ? event.which : event.keyCode;

        if (!commonFn.checkNumberType(keyID)) {
          event.target.value = event.target.value.replace(/[^0-9]/g, "");
        }
      } else if (event.target.id == "memIdAdd") {
        this.dupCheckYn = false;
      }
    },
    cancle: function () {
      this.$emit("close");
    },
    savePw: function () {
      console.log(this.form.mbrPw);
      $.ajax({
        type: "POST",
        url: this.$config.host + "/site/setMbrPw",
        data: {
          mbrId: this.memIdProps,
          mbrPw: $("#memPassword1").val(),
        },
        success: (result) => {
          if (result == "1") {
            console.log("setMbrPw - success");
            alert("변경되었습니다.");
            this.cancle();
          } else {
            console.log("setMbrPw - fail");
          }
        },
        error: function () {
          console.log("setMbrPw - error");
          alert("error");
        },
      });
    },
    chkOldInfo: function () {
      console.log(this.form.mbrPw);
      $.ajax({
        type: "POST",
        url: this.$config.host + "/login/oldInfoChk",
        data: {
          mbrId: this.memIdProps,
          mbrPw: $("#memPassword1").val(),
        },
        success: (result) => {
          if (result == true) {
            console.log("chkOldInfo - success");
            this.savePw();
          } else {
            console.log("chkOldInfo - fail");
            alert(
              "기존에 사용하던 비밀번호입니다. 새로운 비밀번호를 입력해주세요."
            );
            $("#memPasswordAdd").focus();
          }
        },
        error: function () {
          console.log("chkOldInfo - error");
          alert("error");
        },
      });
    },
  },
  mounted() {},
  beforeUnmount() {
    this.$EventBus.$off("btnLater");
  },
};
</script> -->
