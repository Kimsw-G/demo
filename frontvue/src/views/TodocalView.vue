<template>
    <div>{{year}} {{month}}</div>
    <div id="all-body">
        <left-bar></left-bar>
        <div id="cal-body">
            <div class="blank"></div>
            <my-cal></my-cal>
            <div class="blank"></div>
            <div id="right-bar">
                <a><button @click="openAddEvent">이벤트<br/>추가</button></a>
                <a><button @click="openAddTodo">계획<br/>추가</button></a>
                <router-link to="/todo/seetodo"><button>게획<br/>보기</button></router-link>
            </div>
        </div>
    </div>
    <Teleport to="#all-body">
        <add-event v-if="isAddEvent" v-bind:isAddEvent="isAddEvent" @closeEvent="closeEvent"></add-event>
        <add-todo v-if="isAddTodo" v-bind:isAddTodo="isAddTodo" @closeTodo="closeTodo"></add-todo>
    </Teleport>
</template>

<script setup>
import { ref } from 'vue';
import MyCal from '@/components/MyCalendarComp.vue'
import LeftBar from '@/components/LeftBarComp.vue'
import AddEvent from '@/components/AddEventComp.vue'
import AddTodo from '@/components/AddTodoComp.vue'

const isAddEvent=ref(false)
const isAddTodo=ref(false)
const openAddEvent = ()=>{
    isAddEvent.value = true
}
const openAddTodo = ()=>{
    console.log(isAddTodo.value);
    isAddTodo.value = true
}
const closeEvent = ()=>{
    isAddEvent.value = false
}
const closeTodo = ()=>{
    isAddTodo.value = false
}

</script>

<style scoped>
#all-body {
    display: grid;
    grid-template-columns: 7vw 93vw;
    height: 70vh;
}
#cal-body{
    display: grid;
    grid-template-columns: 0.1fr 1fr 0.1fr 0.1fr;
}
#cal-body>*{
    padding: 0 10px;
}
#right-bar{
    padding: 5px;
    display: grid;
    grid-template-rows: 1fr 1fr 1fr;
    gap: 10px
}
button{
    width: 100%;
    height: 100%;
    border: none;
}
a.router-link-exact-active button{
    background-color: #7de0b4;
}
a button:hover{
    background-color: #7de0b4;
    color:black;
}
</style>
<style>
.black-bg{
    background-color: rgba(0, 0, 0, 0.5);
    width: 100vw; height: 100vh; position: fixed;
    align-items: center;
    display: flex;
    justify-content: center;
    align-items : center;
}
.white-bg{
    width: 40%; height: 40%;
    background-color: rgba(255,255,255,1);
    z-index: 10;
    border-radius: 8px;
    padding: 0px;
}
</style>