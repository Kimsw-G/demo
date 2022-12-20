<template>
    <div class="black-bg" @click="closeModal">
        <div class="white-bg">
            <label class="ftitle-label" for="ftitle">제목</label>
            <input type="text" id="ftitle" v-model="ftitle" placeholder="제목"> <br>
            <label class="date-label" for="start_day">D-Day</label>
            <input type="date" id="start_day" v-model="start_day"> <br>
            <textarea rows="" cols="" id="ftext" v-model="ftext" placeholder="내용" />
            <button @click="registEvent">이벤트 추가</button>
            <pre id="errMsg">{{ errMsg }}</pre>
        </div>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    props: {
        isAddEvent: Boolean
    },
    components: {},
    data() {
        return {
            ftitle: '',
            start_day: '',
            ftext: '',
            errMsg: ''
        }
    },
    created() { },
    mounted() { },
    unmounted() { },
    methods: {
        closeModal(event) {
            if (event.target.classList.contains("black-bg")) this.$emit("closeEvent")
        },
        registEvent() {
            let data = {
                ftitle: this.ftitle,
                ftext: this.ftext,
                suser: 1,
                start_day: this.start_day,
                // suser : this.suser
                // 추후 유저도 추가
            }
            console.log(data);

            axios.post("/feed/addEvent", data
            ).then(res => {
                console.log(res);
                this.$emit("closeEvent")
            }).catch(() => {
                this.errMsg = '에러가 발생하였습니다.\n 잠시후 재시도 부탁드립니다.'
            })
        }

    }
}
</script>
<style scoped>
input {
    padding: 5px 7px;
}

#ftitle {
    width: 90%;
    height: 2em;
    margin: 3px;
}

.ftitle-label {
    display: inline-block;
    width: 90%;
    margin-top: 10px;
}

.date-label {
    display: inline-block;
    width: 90%;
}

#start_day {
    width: 90%;
    height: 2em;
}

#ftext {
    margin-top: 1em;
    padding: 0.5em;
    width: 90%;
    height: 4em;
}

button {
    margin-top: 1em;
    width: 90%;
    height: 10%;
    border: none;
}

button:hover {
    background-color: #7de0b4;
}

#errMsg {
    color: red;
}
</style>