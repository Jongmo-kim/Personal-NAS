<!-- AboutComponent.vue -->
<template>
  <div>
    <h1>File Browser</h1>
    <Toast></Toast>
    <Button></Button>
    <InputText></InputText>
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