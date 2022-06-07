<!-- AboutComponent.vue -->
<template>
  <div>
    <h1>Server Message</h1>
    <span>message </span>
    <h3>{{ msg }}</h3>
    <hr />
    <button @click="getServerGreeting">Get Message from Server</button>
    <h2></h2>
  </div>
</template>
<script>
import { getTest } from "@/apis/apiTest";

export default {
  name: "AboutComponent",
  data() {
    return {
      msg: "",
    };
  },
  methods: {
    async getServerGreeting() {
      try {
        const res = await getTest();
        this.msg = res;
      } catch (e) {
        console.error(e);
      }
    },
  },
};
</script>