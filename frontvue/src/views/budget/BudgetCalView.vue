<template>
    <div>{{ year }} {{ month }}</div>
    <div id="allbody">
        <left-bar></left-bar>
        <div id="callbody">
            <table id="start-budget">
                <th>예산</th>
                <tr :key="data" v-for="data in imsiData">
                    <td>{{data}}</td>
                </tr>
            </table>
            <my-cal></my-cal>
            <table id="result-budget">
                <th>잔액</th>
                <tr :key="data" v-for="data in imsiData">
                    <td>{{data}}</td>
                </tr>
            </table>
            <div id="rigth-bar">
                
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
            sampleData: '',
            imsiData: [1,2,3,4,5,6]
        }
    },
    created() {},
    mounted() {},
    unmounted() {},
    methods: {}
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
button{
    width: 100%;
    height: 100%;
}
.budget-box{
    height: 95%;
    display: grid;
    grid-template-rows: 1fr 1fr 1fr 1fr 1fr 1fr;
}
table{
    table-layout: fixed;
}
th{
    height: 1em;
}
td{
    position: relative;
    border: 1px solid ;
}
</style>