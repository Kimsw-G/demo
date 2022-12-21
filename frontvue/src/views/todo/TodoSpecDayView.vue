<template>
    <div id="main">
        <div class="result" v-for="feed in data.feeds" :key="feed">
            <div>
                {{ feed.pk }},
                {{ feed.ftitle }},
                {{ feed.ftext }},
                {{ feed.start_day }},
                {{ feed.end_day }},
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

let query = useRoute().query
let data = reactive({
    feeds: []
})
let page = 1

const date = `"${query.year}-${query.month}-${query.day}"`
const suser = 1

const load = async $state => {
    try {
        const json = await axios.get(`/feed/getSpecDay?suser=${suser}&day=${date}&page=${page}`
        ).then(res => {
            console.log(res.data);
            return res.data
        }).catch(err => {
            console.log(err);
        })

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
</style>