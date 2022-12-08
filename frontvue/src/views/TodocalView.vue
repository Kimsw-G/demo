<template>
    <div>{{ year }} {{ month }}</div>
    <div id="allbody">
        <left-bar></left-bar>
        <div id="callbody">
            <div class="blank"></div>
            <my-cal></my-cal>
            <div class="blank"></div>
            <div id="rigth-bar">
                <a><button @click="openAddEvent">이벤트<br/>추가</button></a>
                <a><button @click="openAddTodo">계획<br/>추가</button></a>
                <router-link to="/todocal/seetodo"><button>계획<br/>보기</button></router-link>
            </div>
        </div>
    </div>
    <teleport to="#allbody">
        <AddEvent v-if="isAddEvent" v-bind:isAddEvent="isAddEvent" @closeEvent="closeEvent"></AddEvent>
        <AddTodo v-if="isAddTodo" v-bind:isAddTodo="isAddTodo" @closeTodo="closeTodo"></AddTodo>
    </teleport>
</template>
<script>
import MyCal from '@/components/MyCalendar.vue'
import LeftBar from '@/components/LeftBar.vue'
import AddEvent from '@/components/AddEventView.vue'
import AddTodo from '@/components/AddTodoView.vue'
export default {
    components: {
        MyCal,
        LeftBar,
        AddEvent,
        AddTodo
    },
    data() {
        return {
            isAddEvent: false,
            isAddTodo: false
        }
    },
    created() {
        
    },
    mounted() { },
    unmounted() { },
    methods: {
        openAddEvent(){
            this.isAddEvent=true
        },
        openAddTodo(){
            this.isAddTodo=true
        },
        closeTodo(){
            this.isAddTodo= false
        },
        closeEvent(){
            this.isAddEvent= false
        }
    }
}
</script>
<style scoped>
#allbody {
    display: grid;
    grid-template-columns: 7vw 93vw;
    height: 70vh;
}
#callbody{
    display: grid;
    grid-template-columns: 0.1fr 1fr 0.1fr 0.1fr;
}
#callbody>*{
    padding: 0 10px;
}

#rigth-bar{
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