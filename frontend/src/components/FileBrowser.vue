<!-- AboutComponent.vue -->
<template>
  <div>
    <h1>File Browser</h1>
    <p-toast></p-toast>
    <p-button></p-button>
    <p-input></p-input>
  </div>
</template>
<script>
import { getTest } from "@/apis/apiTest";

export default {
  name: "FileBrowser",
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