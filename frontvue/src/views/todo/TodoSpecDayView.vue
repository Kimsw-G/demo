<template>
    <div id="main">
        {{ date }}
        <div class="feed-box" v-for="feed in data.feeds" :key="feed">
            <div v-if="feed.ftype==1" class="todo-feed feed">
                <!-- 할 일 피드 -->
                
                <h4 class="title-box box">
                    <div class="profile-box"> <img  class="profile" :src="curlogo"/></div>
                    <div class="title">{{feed.ftitle}}</div>
                </h4>
                <div class="date-box box">
                    {{feed.start_day}} ~ {{feed.end_day}}
                    <img  class="check-box" v-if="feed.done==1" :src="donelogo" @click="switchTodo(0)"/>
                    <img  class="check-box" v-else :src="notlogo" @click="switchTodo(1)"/>
                </div>
                <div><progress class="progress-box box" :value="feed.percent" min="0" max="100"/> {{feed.percent}}%</div>
                <div class="text-box box">{{ feed.ftext }}</div>

            </div>
            <div v-else-if="feed.ftype==2" class="event-feed feed">
                <!-- 이벤트 피드 -->
                <h4 class="title-box box">
                    <div class="profile-box"> <img  class="profile" :src="curlogo"/></div>
                    <div class="title">{{feed.ftitle}}</div>
                </h4>
                <div class="date-box box">{{feed.start_day}}</div>
                <div class="text-box box">{{ feed.ftext }}</div>

            </div>
            <div v-else-if="feed.ftype==3" class="diary-feed feed">
                <!-- 일기 피드 -->
                <h4 class="title-box box">
                    <div class="profile-box"> <img  class="profile" :src="curlogo"/></div>
                    <div class="title">{{feed.ftitle}}</div>
                </h4>
                <div class="date-box box">{{feed.start_day}}</div>
                <div class="text-box box">{{ feed.ftext }}</div>

            </div>
            <div v-else-if="feed.ftype==4" class="budget-feed feed">
                <!-- 지출 피드 -->
                <h4 class="title-box box">
                    <div class="profile-box"> <img  class="profile" :src="curlogo"/></div>
                    <div class="title">{{feed.ftext}}원</div>
                </h4>
                <div class="date-box box">{{feed.start_day}}</div>
                <div class="text-box box">{{ feed.ftitle }}</div>

            </div>
        </div>
        <InfiniteLoading @infinite="load"></InfiniteLoading>
    </div>
    <div id="cal">
        <MyCal></MyCal>
    </div>
</template>
<script setup>
import { reactive } from 'vue';
import InfiniteLoading from "v3-infinite-loading";
import { useRoute } from 'vue-router';
import MyCal from '@/components/MyCalendar.vue'
import axios from 'axios';
// import "v3-infinite-loading/lib/style.css";
const curlogo =  require("@/../public/logo.png")
const donelogo = require("@/../public/ok.png")
const notlogo = require("@/../public/no.png")

let query = useRoute().query
let data = reactive({
    feeds: []
})
let page = 1

const date = `${query.year}-${query.month}-${query.day}`
const suser = 1

const load = async $state => {
    try {
        // 전체 목록들을 불러오는 axios
        const json = await axios.get(`/feed/getSpecDay?suser=${suser}&day=${date}&page=${page}`
        ).then(res => {
            console.log(res.data);
            return res.data
        }).catch(err => {
            console.log(err);
        })
        // json 데이터중 ftype이 1일때, todoPercentage를 확인하여 json 데이터를 가져와야함
        for (let i = 0; i < json.length; i++) {
            console.log(json[i].ftype)
            if(json[i].ftype==1){
                // await axios.get(`feed/getSpecDayDone?pk=${data.pk}&day=${date}`
                // ).then(res=>{
                //     json[i].done=res.data
                // }).catch(err=>{
                //     console.log(err);
                // })
                json[i].done=1
            }
        }
        

        if (json.length < 10) {
            console.log("complete all");
            data.feeds.push(...json)
            $state.loaded()
            $state.complete()
        }
        else {
            console.log("load");
            data.feeds.push(...json)
            $state.loaded()
        }
        console.log('hi' + page);
        page++
    } catch (error) {
        $state.error()
        console.log(error);
    }
}

const switchTodo = flag=>{
    console.log('switch todo!');
    
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
#main {
    display: inline-block;
    width: 70vw;
    overflow: scroll;
}

#cal {
    vertical-align: top;
    display: inline-block;
    width: 30vw;
    height: 30vh;
}

.day {
    font-size: 10px;
}

.td-link {
    width: 1em;
    height: 1em;
    border: none !important
}

.td-link:hover {
    background-color: #7de0b4;
}

.imsi {
    height: 110vh;
    background-color: yellow;
}
.feed-box{
    display: grid;
    place-items: center;
    margin-top: 20px;
}
.feed{
    text-align: left;
    /*border: 0.1px gray solid;*/
    box-shadow: rgba(0, 0, 0, 0.25) 0px 0.0625em 0.0625em, rgba(0, 0, 0, 0.25) 0px 0.125em 0.5em, rgba(255, 255, 255, 0.1) 0px 0px 0px 1px inset;
    grid-template-rows: auto;
    border-radius: 10px;
    height: auto;
    width: 40em;
    display: grid;
    padding: 16px 16px 8px 16px;
}

.feed > *{
    padding: 0 5px;
    margin: 5px 0   ;

}
.profile-box{
    margin-right: 10px;
}
.profile{
    height: 40px;
    width: 40px;
}
.title-box{
    display: flex;
}
.title{
    overflow:hidden;
    word-wrap:break-word;
}
.progress-box{
    padding-left: 40px;
}
.date-box,.text-box{
    padding-left: 50px;
}
.date-box{
    color: gray;
    font-size: 0.7em;
}
.progress-box{
    width: 90%;
    appearance: none;
}
.progress-box::-webkit-progress-bar{
    border-radius: 10px;
    box-shadow: inset 3px 3px 10px #ebebeb;
}
.progress-box::-webkit-progress-value{
    border-radius: 10px;
    background: #93F9B9;
    background: -webkit-linear-gradient(to rigth, #93F9B9, #41b98f);
    background: linear-gradient(to right, #93F9B9, #41b98f)
}
.text-box{
    overflow:hidden;
    word-wrap:break-word;
    line-height: 1.5em;
}
.check-box{
    widows: 20px;
    height: 20px;
}
</style>