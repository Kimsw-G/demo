<template>
    <nav id="left-bar">
        <router-link to="/todocal"><button>일정</button></router-link>
        <router-link to="/budgetcal"><button>가계</button></router-link>
    </nav>
</template>

<script setup>

</script>

<style scoped>
#left-bar{
    margin-left: 10px;
    display: grid;
    grid-template-rows: 1fr 1fr;
    gap: 30px;
}
button{
    width: 100%;
    height: 100%;
    border: none
}
a.router-link-exact-active button{
    background-color: #7de0b4;
}
a button:hover{
    background-color: #7de0b4;
    color:black;
}
</style>