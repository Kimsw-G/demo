<template>
<div class="black-bg" @click="closeModal">
    <div class="white-bg">
        <label class="ftitle-label" for="ftitle">제목</label>
        <input type="text" id="ftitle" v-model="ftitle" placeholder="제목"><br>
        <label class="date-label" for="startday">시작일</label>
        <label class="date-label" for="endday">종료일</label>
        <input type="date" id="startday" class="date" name="startday" v-model="start_day"><input type="date"
            id="endday" class="date" name="endday" v-model="end_day"> <br>
        <textarea id="ftext" placeholder="내용"></textarea>
        <button id="submit" @click="registEvent">제출테스트</button>
        <pre id="errMsg">{{ errMsg }}</pre>
    </div>
</div>
</template>

<script setup>
import axios from 'axios';
import { defineEmits,ref } from 'vue';
const emit = defineEmits('closeEvent')
const closeModal = event=>{
    if(event.target.classList.contains("black-bg")) emit("closeEvent")
}

const errMsg = ref('')
const start_day = ref('')
const end_day = ref('')
const ftitle = ref('')
const ftext = ref('')

const registEvent = ()=>{
    let data = {
        start_day:start_day.value,
        end_day:end_day.value,
        ftitle:ftitle.value,
        ftext:ftext.value,
        suser:1,
        ftype:2,
    }
    axios.post("/feed/addEvent",data
    ).then(res=>{
        console.log(res)
        emit("closeEvent")
    }).catch(()=>{
        errMsg.value = "에러가 발생하였습니다"
    })
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
    width: 45%;
}
#startday, #endday{
    width: 45%;
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