<template>
    
    <table>
        <tr>
            <td id="today" colspan="7">
                <span @click="preMonth([year,month])" @mouseover="leftover" @mouseleave="leftleave" class="arrow left-arrow">{{left_arrow}}</span> 
                <select @change="changeYear($event,month)" v-model="year" class="gobox year-gobox">
                    <option v-for="year_idx in years" :key="year_idx" :value="year_idx">{{year_idx}}</option>
                </select>
                <select @change="changeMonth(year,$event)" v-model="month" class="gobox month-gobox">
                    <option v-for="month_idx in months" :key="month_idx" :value="month_idx">{{month_idx}}</option>
                </select>
                <span @click="nextMonth([year,month])" @mouseover="rightover" @mouseleave="rightleave" class="arrow right-arrow">{{right_arrow}}</span>
            </td></tr>
        <tr>
            <th :key="dow" v-for="dow in dows">
                {{ dow }}
            </th>
        </tr>
        <tr v-for="(date, index) in dates" :key="index">
            <router-link :to="day==''? '':{
    path: '/todo/specday',
    query: {
        year: year,
        month: month,
        day: day
    }
}" class="td-link" v-for="(day, index) in date" :key="index" >
                <div class="day">{{ day }}</div>
                <div class="context"></div>
            </router-link>
        </tr>

    </table>
</template>

<script setup>
import { ref, onMounted } from "vue";

let custom_years = []
for (let i = 2000; i < 2100; i++) {
    custom_years.push(i)
}

const dows = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
const years = custom_years
const months = [1,2,3,4,5,6,7,8,9,10,11,12]
const year = ref(0)
const month = ref(0)
const firstDay = ref(0)
const lastDay = ref(0)
const preLastDay = ref(0)
const dates = ref([])
const left_arrow = ref("◁")
const right_arrow = ref("▷")
const createCal = param => {
    if (param) {
        year.value = param[0]
        month.value = param[1]
        setFirstDayLastDate(year.value, month.value)
        setDayDate()
    } else {
        const date = new Date()
        year.value = date.getFullYear()
        month.value = date.getMonth() + 1
        setFirstDayLastDate(year.value, month.value)
        setDayDate()
    }
}
const setFirstDayLastDate = (year, month) => { //1일의 요일 및 마지막 날짜
    const _firstDay = new Date(year, month - 1, 1).getDay() // 1일의 요일
    const _lastDate = new Date(year, month, 0).getDate() // 마지막 날짜(30,31...)
    let lastMonth = month - 1
    if (month === 1) {
        lastMonth = 12
        year -= 1
    }
    const _preLastDay = new Date(year, lastMonth, 0).getDate() // 저번달 마지막 날짜
    firstDay.value = _firstDay
    lastDay.value = _lastDate
    preLastDay.value = _preLastDay

}
const setDayDate = () => {
    let dayCnt = 1
    // let nextDayCnt = 1
    for (let i = 0; i < 6; i++) {
        let tmp = []
        for (let j = 0; j < 7; j++) {
            if (i == 0 && j < firstDay.value) { // 첫줄에서 저번 달 표시
                // tmp[j] = preLastDay.value - firstDay.value + 1 + j
                tmp[j] = ""
            } else if (dayCnt > lastDay.value) { // 마지막 줄에서
                tmp[j] = ""
            } else {
                tmp[j] = dayCnt++
            }
        }
        dates.value.push(tmp)
    }
}
const preMonth = param =>{
    // 달력 초기화
    dates.value = []

    // 이전 달 받기
    param[1] = param[1]-1
    if(param[1] == 0){
        param[1] = 12
        param[0] = param[0]-1
    }
    createCal(param)
}
const nextMonth = param =>{
    // 달력 초기화
    dates.value = []

    // 다음 달 받기
    param[1] = param[1]+1
    if(param[1] == 13){
        param[1] = 1
        param[0] = param[0]+1
    }
    createCal(param)
}
const changeMonth = (year,event) =>{
    // 달력 초기화
    dates.value = []
    createCal([year,event.target.value])
}
const changeYear = (event,month) =>{
    // 달력 초기화
    dates.value = []
    createCal([event.target.value,month])
}
const leftleave = ()=>{
    left_arrow.value = "◁"
}
const leftover = ()=>{
    left_arrow.value = "◀"
}
const rightleave = ()=>{
    right_arrow.value = "▷"
}
const rightover = ()=>{
    right_arrow.value = "▶"
}
onMounted(()=>{
    createCal()
})
</script>

<style scoped>
#today{
    font-size: 2em;
    height: 1em;
    border: none;
}
table{
    table-layout: fixed;
    width: 100%;
}
th{
    height: 1em;
}
.td-link{
    display: table-cell;
    position: relative;
    border: 1px solid ;
    text-decoration: none;
    color: black;
}
td{
    position: relative;
    border: 1px solid ;
}
.day{
    display: inline;
    position: absolute;
    top: 0px;
    left: 0px;
}
.context{
    height: auto;
}
.gobox{
    border: none;
    font-size: 32px;
    width: 3em;
}
.year-gobox{
    width: auto;
}
.month-gobox{
    width: auto;
}
.left-arrow{
    color: black;
}
</style>