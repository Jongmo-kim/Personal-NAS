f<template>
  <div>
    <router-link to="/">홈</router-link> 
    <router-link to="/file-browser">파일탐색</router-link> 
    <router-link to="/board">게시판</router-link>
    <router-link style="float:right;" to="/signup">회원가입</router-link>
    <router-link style="float:right;" to="/login">로그인</router-link>
  </div>
</template>

<script>
export default {
  name: "mainMenu",

}
</script>

<style>

</style>