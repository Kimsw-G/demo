<template>
    
    <table>
        <tr><td id="today" colspan="7">{{ year }} {{ month }}</td></tr>
        <tr>
            <th :key="dow" v-for="dow in dows">
                {{ dow }}
            </th>
        </tr>
        <tr v-for="(date, index) in dates" :key="index">
            <router-link :to="{
    path: '/todo/specday',
    query: {
        year: year,
        month: month,
        day: day
    }
}" class="td-link" v-for="(day, index) in date" :key="index">
                <div class="day">{{ day }}</div>
                <div class="context"></div>
            </router-link>
        </tr>

    </table>
</template>

<script setup>
import { ref, onMounted } from "vue";

const dows = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
const year = ref(0)
const month = ref(0)
const firstDay = ref(0)
const lastDay = ref(0)
const preLastDay = ref(0)
const dates = ref([])
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
    const _lastDate = new Date(year.month, 0).getDate() // 마지막 날짜(30,31...)
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
    let nextDayCnt = 1
    for (let i = 0; i < 6; i++) {
        let tmp = []
        for (let j = 0; j < 7; j++) {
            if (i == 0 && j < firstDay.value) { // 첫줄에서 저번 달 표시
                tmp[j] = preLastDay.value - firstDay.value + 1 + j
            } else if (dayCnt > lastDay.value) { // 마지막 줄에서
                tmp[j] = nextDayCnt++
            } else {
                tmp[j] = dayCnt++
            }
        }
        dates.value.push(tmp)
    }
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
</style>