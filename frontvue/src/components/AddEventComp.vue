<template>
<div class="black-bg" @click="closeModal">
    <div class="white-bg">
        <label class="ftitle-label" for="ftitle">제목</label>
        <input type="text" id="ftitle" v-model="ftitle" placeholder="제목"><br>
        <label class="date-label" for="ftitle">D-Day</label>
        <input type="date" id="start_day" v-model="start_day" placeholder="제목"><br>
        <textarea id="ftext" placeholder="내용"></textarea>
    </div>
</div>
</template>

<script setup>
import { defineEmits } from 'vue';
const emit = defineEmits('closeEvent')
const closeModal = event=>{
    if(event.target.classList.contains("black-bg")) emit("closeEvent")
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