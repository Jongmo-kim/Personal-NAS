<template>
  <div>
    <Card>
      <template #title>
        <h2> 회원가입 </h2>
      </template>
      <template #content>
        <Divider layout="vertical">
          <form>
            <div>
              <h3>아이디</h3>
              <InputText type="text" v-model="id" />
            </div>
            <div>
              <h3>비밀번호</h3>
              <InputText type="password" v-model="password" autocomplete="on"/>
            </div>
            <div>
              <h3>이름</h3>
              <InputText type="text" v-model="name" />
            </div>
          </form>
        </Divider>
      </template>
      <template #footer>
        <Divider layout="vertical">
          <Button icon="pi pi-check" label="저장" @click="signup"/>
          <Button icon="pi pi-times" label="취소" class="Button-secondary" style="margin-left: .5em" />
        </Divider>
      </template>
    </Card>
  </div>
</template>

<script> 

import {getTest} from '@/apis/apiTest.js';
import {insert} from '@/apis/apiUser.js';
import {errHandler} from '@/utils/NetworkErrorHadnler.js';

 export default {
  name: 'UserSignup',
  components: {},
  data() {
    return {
      id: '',
      password: '',
      passwordConfirm: '',
      name: ''
  }
},
  created() {
    getTest();
  },
  mounted() {},
  methods: {
    async signup() {
      this.validateAllInput();
      try{
        const res = await insert(this.id, this.password, this.name);
        console.log(res);
      } catch(e) {
        await errHandler(e);
      }
    },
    validateAllInput() {
      console.log(this.id);
      console.log(this.password);
      console.log(this.passwordConfirm);
      console.log(this.name);
    },
  },
}
</script>

<style>

</style>