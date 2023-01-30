<template>
    <nav id="header-nav">
        <router-link to='/' >
            <img class="header-logo" :src="getImageUrl(curlogo)" @mouseover="curlogo=logo_over" @mouseout="curlogo=logo">
        </router-link>
        <router-link to='/todocal'><button>내 달력</button></router-link>
        <router-link to='/paging'><button>페이징테스트</button></router-link>
        <router-link to='/err'><button>미구현</button></router-link>
        <router-link to='/login'><button>로그인</button></router-link>
        <router-link to='/signup'><button>회원가입</button></router-link>
    </nav>
</template>
    
<script setup>
import { ref } from "vue";
const getImageUrl = name => (name)
const logo = require("../assets/logo.png")
const logo_over = require("../assets/logo_over.png")
const curlogo = ref(logo);
</script>
    
<style scoped>
.header-logo{
    height: 2em;
}
#header-nav {
    display: grid;
    grid-template-columns: 10% repeat(3, 20%) repeat(2, 15%);
    border: 10px;
    width: auto;
    height: 5vh;
}
#header-nav a {
    font-weight: bold;
    color: #2c3e50;
    margin: 10px;
}
#header-nav a.router-link-exact-active {
    color: #7de0b4;
}
button{
    width: 10em;
    height: 100%;
    border: none;
}
a.router-link-active button{
    background-color:#7de0b4
}
a button:hover{
    background-color: #7de0b4;
    color: black;
}
</style>
