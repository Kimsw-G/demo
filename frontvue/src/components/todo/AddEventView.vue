<template>
<div class="black-bg" @click="closeModal">
    <div class="white-bg">
        <label class="etitle-label" for="ttitle">제목</label>
        <input type="text" id="etitle" name="etitle" placeholder="제목"> <br>
        <label class="date-label" for="dday">D-Day</label>
        <input type="date" id="dday" name="dday" > <br>
        <textarea rows="" cols="" id="etext" name="etext" placeholder="내용"/>
    </div>
</div>
</template>
<script>
export default {
    props:{
        issAddEvent: Boolean
    },
    components: {},
    data() {
        return {
        }
    },
    created() {},
    mounted() {},
    unmounted() {},
    methods: {
        closeModal(event){
            if(event.target.classList.contains("black-bg")) this.$emit("closeEvent")
        }
    }
}
</script>
<style scoped>
input{
    padding: 5px 7px;
}
#etitle{
    width: 90%;
    height: 2em;
    margin: 3px;
}
.etitle-label{
    display: inline-block;
    width: 90%;
    margin-top: 10px;
}
.date-label{
    display: inline-block;
    width: 90%;
}
#dday{
    width: 90%;
    height: 2em;
}
#etext{
    margin-top: 1em;
    padding: 0.5em;
    width: 90%;
    height: 4em;
}
</style>