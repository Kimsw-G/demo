<template>
<div>
    <router-link to="/" class="logo">
        <img id='header-logo' :src="getImageUrl(curlogo)" @mouseover="curlogo = logo_over" @mouseleave="curlogo = logo" />
    </router-link>
    <div class="login-box top-box">
        <button class="all-box oauth-login facebook-login">페이스북 로그인</button>
        <button class="all-box oauth-login kakao-login">카카오톡 로그인</button>
        <button class="all-box oauth-login google-login">구글 로그인</button>
    </div>
    <div class="login-box bottom-box">
        <input type="text" name="id" placeholder="아이디" class="all-box ">
        <input type="password" name="password" placeholder="영어와 특수문자를 포함한 비밀번호" class="all-box ">
        <button class="login-button all-box">로그인</button>
    </div>
</div>
</template>

<script setup>
import { ref } from "vue";
const getImageUrl = name => (name)
const logo = require("../assets/logo.png")
const logo_over = require("../assets/logo_over.png")
const curlogo = ref(logo);
</script>

<style scoped>
.login-box{
    display: grid;
    width: 25vw;
    min-width: 300px;
    gap: 0.4em;
    margin: 0 auto;
}
.top-box{
    padding: 0;
    border: 0;
}
.bottom-box{
    margin-top: 20px;
    border-top: 1px #d9d9d9 solid;
    padding-top: 20px;
}
.top-box .all-box{
}
.bottom-box .all-box{
    border:1px #d9d9d9 solid;
}
.bottom-box .all-box:hover{
    background-color: #f1f1f1;
}
.all-box{
    height: 4em;
    border-radius: 10px;
}
.oauth-login{
    width: 100%;
    height: 4em;
    border: none;
}
.facebook-login{
    background-color: #6788cd;
}
.facebook-login:hover{
    background-color: #5571a9;
}
.kakao-login{
    background-color: #f8ec3f;
}
.kakao-login:hover{
    background-color: #ddd336;
}
.google-login{
    background-color: white;
    border: 1px solid #d9d9d9;
}
.google-login:hover{
    background-color: #d9d9d9;
}
input{
    padding: 10px;
}
.login-button:hover{
    background-color: #d9d9d9;
}
</style>