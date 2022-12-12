<template>
    <div>
        <div class="sign-box">
            <input type="text" name="id" placeholder="아이디" class="all-box ">
            <input type="password" name="password" placeholder="영어와 특수문자를 포함한 비밀번호" class="all-box ">
            <button class="login-button all-box">회원가입(임시)</button>
        </div>
    </div>
</template>
<script>
export default {
    components: {},
    data() {
        return {
            sampleData: ''
        }
    },
    created() { },
    mounted() { },
    unmounted() { },
    methods: {}
}
</script>
<style scoped>
.sign-box{
    display: grid;
    width: 25vw;
    min-width: 300px;
    gap: 0.4em;
    margin: 0 auto;
}
.all-box{
    height: 4em;
    border-radius: 10px;
}
input{
    padding: 10px;
}
.login-button:hover{
    background-color: #d9d9d9;
}
</style>