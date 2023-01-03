<template>
<div class="black-bg" @click="closeModal">
    <div class="white-bg">
        <label class="ftitle-label" for="ftitle">제목</label>
        <input type="text" id="ftitle" name="ftitle" v-model="ftitle"> <br>
        <label class="date-label" for="startday">시작일</label>
        <label class="date-label" for="endday">종료일</label>
        <input type="date" id="startday" class="date" name="startday" v-model="start_day"><input type="date"
            id="endday" class="date" name="endday" v-model="end_day"> <br>
        <div class="dow-box">
            <button @click="checkDow(idx)" @mouseover="overMouse(idx)" @mouseleave="leaveMouse(idx)"
                v-for="(dow, idx) in dows" :key="dow" :id="`button${idx}`" :class="'button'" >
                {{ dow }}
            </button>
        </div>
        <textarea rows="" cols="" id="ftext" name="etext" v-model="ftext" />
        <button id="submit" @click="registTodo">제출테스트</button>
        <pre id="errMsg">{{ errMsg }}</pre>
    </div>
</div>
</template>

<script setup>
import axios from 'axios';
import { defineEmits,ref } from 'vue';
const emit = defineEmits('closeTodo')
const closeModal = event=>{
    if(event.target.classList.contains("black-bg")) emit("closeTodo")
}
const dows = ['일','월','화','수','목','금','토']
const isDows = ref([false,false,false,false,false,false,false])
const errMsg = ref('')
const start_day = ref('')
const end_day = ref('')
const ftitle = ref('')
const ftext = ref('')

const calcDow = _isDows=>{
    let result = 0
    for (let i = 0; i < _isDows.length; i++) {
        if(_isDows[i]) result+=2**(6-i)
    }
    return result
}
// const suser = ref(1)
const checkDow = idx=>{
    isDows.value[idx] = !isDows.value[idx]
    let button = document.querySelector("#button"+idx)
    if(isDows.value[idx]) button.style.backgroundColor= "#7de0b4"
    else button.style.backgroundColor= "beige"
}
const overMouse = idx=>{
    let button = document.querySelector("#button"+idx)
    button.style.backgroundColor="#7de0b4"
}
const leaveMouse = idx=>{
    let button = document.querySelector("#button"+idx)
    if(!isDows.value[idx])button.style.backgroundColor= "white"
}

const registTodo = ()=>{
    let data = {
        start_day:start_day.value,
        end_day:end_day.value,
        ftitle:ftitle.value,
        ftext:ftext.value,
        suser:1,
        ftype:1,
        freq:calcDow(isDows.value)
    }
    axios.post("/feed/addTodo",data
    ).then(res=>{
        console.log(res)
        emit("closeTodo")
    }).catch(()=>{
        errMsg.value = "에러가 발생하였습니다"
    })
}
</script>

<style scoped>
input{
    padding: 5px 7px;
}
#ftitle{
    width: 90%;
    height: 2em;
    margin: 3px;
}
.ftitle-label{
    display: inline-block;
    width: 90%;
    margin-top: 10px;
}
.date-label{
    display: inline-block;
    width: 45%;
}
#startday, #endday{
    width: 45%;
    height: 2em;
}
.dow-box{
    margin: 3px auto ;
    width: 90%;
    display: grid;
    grid-template-columns: repeat(7,1fr);
    gap: 1px;
    justify-items: center;
}
.button{
    width: 30px;
    height: 30px;
    border-radius: 15px;
    border: 0px;
    background-color: beige;
}
#ftext{
    padding: 0.5em;
    width: 90%;
    height: 4em;
}
#errMsg {
    color: red;
}
</style>