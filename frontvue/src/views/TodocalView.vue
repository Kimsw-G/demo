<template>
    <div>{{ year }} {{ month }}</div>
    <div id="allbody">
        <left-bar></left-bar>
        <div id="callbody">
            <div class="blank"></div>
            <my-cal></my-cal>
            <div class="blank"></div>
            <div id="rigth-bar">
                <router-link to="/todocal/addevent"><button>이벤트<br/>추가</button></router-link>
                <router-link to="/todocal/addtodo"><button>계획<br/>추가</button></router-link>
                <router-link to="/todocal/seetodo"><button>계획<br/>보기</button></router-link>
            </div>
        </div>
    </div>
</template>
<script>
import MyCal from '@/components/MyCalendar.vue'
import LeftBar from '@/components/LeftBar.vue'
export default {
    components: {
        MyCal,
        LeftBar
    },
    data() {
        return {

        }
    },
    created() {
        
    },
    mounted() { },
    unmounted() { },
    methods: {
        
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