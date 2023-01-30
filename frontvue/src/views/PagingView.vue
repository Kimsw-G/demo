<template>
<div>
    
    <el-button type="primary">el 버튼</el-button> <br>
    <ul class="paginaton h-20 justify-content-center align-items-center">
        <li class="page-item">
            <a href="#" class="page-link" tabindex="-1" @click="onPageChange(page-1)">Previous</a>
        </li>
        <li :class="pa==page?'page-item active': page-item" v-for="(pg,i) in pageList" :key="(pg,i)">
            <a href="#" class="page-link" @click="onPageChange(pg)">{{pg}}</a> 
        </li>
        <li class="page-item">
            <a href="#" class="page-link" tabindex="-1" @click="onPageChange(page+1)">Next</a>
        </li>
    </ul>
    
</div>
</template>

<script>
export default{
    name:'ThePagination',
    props: ['page','prev','next','start','end','pageList','totalPage'],
    setup(){
        
        
    }
}
</script>

<script setup>

import axios from 'axios'
import { onMounted } from 'vue';
import { reactive } from 'vue'

let data = reactive({
    page: [],
})
let page = 1
let limit = 10
const getPage = () => {
    axios.get(`/page?page=${page}&limit=${limit}`
    ).then(res => {
        console.log(res.data);
        data.page = res.data
    })
}
onMounted(() => {
    getPage()
})

</script>

<style scoped>
.page-item{
    width:50px
}
.page-item:first-child{
    width: 80px;
}
.page-item:last-child{
    width: 80px;
}
</style>