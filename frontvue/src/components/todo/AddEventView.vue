<template>
    <div class="black-bg" @click="closeModal">
        <div class="white-bg">
            <label class="etitle-label" for="etitle">제목</label>
            <input type="text" id="etitle" v-model="etitle" placeholder="제목"> <br>
            <label class="date-label" for="dday">D-Day</label>
            <input type="date" id="dday" v-model="dday"> <br>
            <textarea rows="" cols="" id="etext" v-model="etext" placeholder="내용" />
            <button @click="registEvent">이벤트 추가</button>
            <pre id="errMsg">{{ errMsg }}</pre>
        </div>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    props: {
        issAddEvent: Boolean
    },
    components: {},
    data() {
        return {
            etitle: '',
            dday: '',
            etext: '',
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
                etitle: this.etitle,
                etext: this.etext,
                suser: 1,
                dday: this.dday,
                // suser : this.suser
                // 추후 유저도 추가
            }

            // this.axios.defaults.headers.common = {
            //     'Content-Type': 'application/json'
            // }
            axios.post("/todo/addEvent", data
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

#etitle {
    width: 90%;
    height: 2em;
    margin: 3px;
}

.etitle-label {
    display: inline-block;
    width: 90%;
    margin-top: 10px;
}

.date-label {
    display: inline-block;
    width: 90%;
}

#dday {
    width: 90%;
    height: 2em;
}

#etext {
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