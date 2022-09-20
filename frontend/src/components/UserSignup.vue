<template>
  <div>
    <Card>
      <template #title>
        <h2> 회원가입 </h2>
      </template>
      <template #content>
        <div>
          <h3>아이디</h3>
          <InputText type="text" v-model="value" />
        </div>
        <div>
          <h3>비밀번호</h3>
          <InputText type="password" v-model="value" />
        </div>
        <div>
          <h3>비밀번호 확인</h3>
          <InputText type="password" v-model="value" />
        </div>
        <div>
          <h3>닉네임</h3>
          <InputText type="text" v-model="value" />
          <Button label="Secondary" style="margin-left: 1rem" class="Button-secondary Button-text ">버튼</Button>
        </div>
      </template>
      <template #footer>
        <div class="grid">
            <div class="col-5 flex align-items-center justify-content-center">
                <div class="p-fluid">
                    <div class="field">
                        <label for="username">Username</label>
                        <InputText id="username" type="text" />
                    </div>
                    <div class="field">
                        <label for="password">Password</label>
                        <InputText id="password" type="password" />
                    </div>
                    <Button label="Login"></Button>
                  </div>
            </div>
            <div class="col-2">
                <Divider layout="vertical">
                    <b>OR</b>
                </Divider>
            </div>
            <div class="col-5 flex align-items-center justify-content-center">
                <Button label="Sign Up" icon="pi pi-user-plus" class="Button-success"></Button>
            </div>
        </div>
        <Button icon="pi pi-check" label="저장" />
        <Button icon="pi pi-times" label="취소" class="Button-secondary" style="margin-left: .5em" />
      </template>
    </Card>
  </div>
</template>

<script>

export default {
}
</script>

<style>

</style>