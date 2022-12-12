<template>
    <div id="main">
        <div class="result" v-for="comment in comments" :key="comment">
            <div>대충 내용</div>
        </div>
        <InfiniteLoading @to="load"></InfiniteLoading>
    </div>
    <div id="cal">
        <MyCal></MyCal>
    </div>
</template>
<script setup>
import { ref } from 'vue';
import InfiniteLoading from "v3-infinite-loading";
// import "v3-infinite-loading/lib/style.css";

let comments = ref([])
let page = 1
const load = async $state => {
    try {
        // TODO : 대충 연월일을 쿼리로 날려 값을 들고올것
        const response = await fetch(`http://127.0.0.1:10000/list?page=${page}`)
        const json = await response.json()
        if (json.length < 10) $state.complete()
        else {
            comments.value.push(...json)
            $state.loaded()
        }
        page++
        console.log('hi' + page);
    } catch (error) {
        $state.error()
    }
}
</script>

<script>
import MyCal from '@/components/MyCalendar.vue'
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
    created() {},
    mounted() {},
    unmounted() {},
    methods: {}
}
</script>
<style>
#main{
    display: inline-block;
    width: 70vw;

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
</style>