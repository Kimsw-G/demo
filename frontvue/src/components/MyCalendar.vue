<template>
    <table>
        <tr>
            <th :key="dow" v-for="dow in dows">
                {{ dow }}
            </th>
        </tr>
        <tr v-for="(date, index) in dates" :key="index">
            <td v-for="(day, index) in date" :key="index">
                <div class="day">{{day}}</div>
                <div class="context"></div>
            </td>
        </tr>

    </table>
</template>
<script>
export default {
    components: {},
    data() {
        return {
            dows: [
                "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"
            ],
            year: 0,
            month: 0,
            firstDay: 0,
            lastDay: 0,
            preLastday: 0,
            dates: []
        }
    },
    created() {
        this.init()
    },
    mounted() {},
    unmounted() {},
    methods: {
        init(param) {
            if (param) { // 다른 날짜로 이동시 
                this.year = param[0]
                this.month = param[1]
                this.setFirstDayLastDate(this.year, this.month)
                this.setDayDate()
            } else { // 초기 화면 렌더링시
                const date = new Date()
                this.year = date.getFullYear()
                this.month = date.getMonth() + 1
                this.setFirstDayLastDate(this.year, this.month)
                this.setDayDate()
            }
        },
        setFirstDayLastDate(year, month) { // 1일의 요일 및 마지막 날짜 구하기
            const firstDay = new Date(year, month - 1, 1).getDay() // 1일의 요일
            const lastDate = new Date(year, month, 0).getDate() // 마지막 날짜

            let lastMonth = month - 1
            if (month === 1) {
                lastMonth = 12
                year -= 1
            }
            const prevLastDate = new Date(year, lastMonth, 0).getDate() // 저번달의 마지막 날짜
            this.firstDay = firstDay
            this.lastDay = lastDate
            this.preLastday = prevLastDate
        },
        setDayDate() { // 날짜를 입력
            let dayCnt = 1
            let nextDayCnt = 1
            for (let i = 0; i < 6; i++) {
                let tmp=[]
                for (let j = 0; j < 7; j++) {
                    if (i == 0 && j < this.firstDay) { // 첫줄에서 저번 달 표시
                        tmp[j] = this.preLastday - this.firstDay + 1 + j
                    } else if (dayCnt > this.lastDay) { // 마지막 줄에서
                        tmp[j] = nextDayCnt++
                    } else {
                        tmp[j] = dayCnt++
                    }
                }
                this.dates.push(tmp)
            }
        },
    }
}
</script>

<style scoped>
table{
    table-layout: fixed;
    width: 100%;
}
th{
    height: 1em;
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