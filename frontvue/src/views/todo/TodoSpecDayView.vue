<template>
    <div id="main">
        <div class="result" v-for="comment in comments" :key="comment">
            <div>대충 내용</div>
        </div>
        <InfiniteLoading @infinite="load"></InfiniteLoading>
    </div>
    <div id="cal">
        <MyCal></MyCal>
    </div>
</template>
<script setup>
import { ref } from 'vue';
import InfiniteLoading from "v3-infinite-loading";
import { useRoute } from 'vue-router';
import MyCal from '@/components/MyCalendar.vue'
import axios from 'axios';
// import "v3-infinite-loading/lib/style.css";

let query = useRoute().query
let comments = ref([])
let page = 1

const date = `"${query.year}-${query.month}-${query.day}"`
const suser = 1

const load = async $state => {
    console.log('im here');
    try {
        const json = loadData()
        
        if (json.length < 10) {
            console.log("complete all");
            $state.complete()
        }
        else {
            console.log("load");
            comments.value.push(...json)
            $state.loaded()
        }
        page++
        console.log('hi' + page);
    } catch (error) {
        $state.error()
        console.log(error);
    }
}


const loadData = ()=>{
    axios.get(`/feed/getSpecDay?suser=${suser}&day=${date}&page=${page}`
    ).then(res=>{
        let data = res.data
        console.log("data:" + data);
        return data
    }).catch(err=>{
        console.log(err);
    })
}
</script>

<script>
export default {
    components: {
        MyCal,
        InfiniteLoading
    },
    data() {
        return {
            sampleData: ''
        }
    },
    methods: {}
}
</script>
<style>
#main{
    display: inline-block;
    width: 70vw;
    overflow: scroll;
}
#cal{
    vertical-align: top ;
    display: inline-block;
    width: 30vw;
    height: 30vh;
}
.day{
    font-size: 10px;
}
.td-link{
    width: 1em;
    height: 1em;
    border: none !important
}
.td-link:hover{
    background-color: #7de0b4;
}
.imsi{
    height: 110vh;
    background-color: yellow;
}
</style>