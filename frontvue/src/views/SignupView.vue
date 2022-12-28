<template>
    <div>
        <div class="sign-box">
            <input type="text" placeholder="6자리 이상의 아이디" class="all-box " v-model="state.id" ref="id">
            <input type="password" placeholder="영어와 숫자를 포함한 10자리 이상 비밀번호" class="all-box " v-model="state.password" ref="password">
            <input type="password" placeholder="비밀번호 확인" class="all-box" v-model="state.password_chk" ref="password_chk">
            <input type="text" placeholder="이름" class="all-box" v-model="state.name" ref="name">
            <div>
                <input type="text" placeholder="'-' 없이 번호를 입력해주세요" class="all-box call-box" v-model="state.phone" ref="phone" @keyup="isPhoneCheck"/>
                <button class="all-box phone-button" ref="phoenButton"  :disabled="state.isPhone" @click="identify">인증하기</button>
            </div>
            <button class="login-button all-box" @click="checkAll" :disabled="state.isIdentify">회원가입(임시)</button>
        </div>
    </div>
</template>
<script>
import { reactive,ref } from 'vue'
export default {
    components: {},
    data() {
        return {
            sampleData: ''
        }
    },
    created() { },
    setup(){
        
        const state = reactive({
            id: '',
            password: '',
            password_chk: '',
            name: '',
            phone: '',
            isPhone: true,
            isIdentify: true
        })
        const id = ref(null)
        const password = ref(null)
        // const password_chk = ref(null)
        const name = ref(null)
        const phone = ref(null)
        const phoenButton = ref(null)
        const checkID = ()=>{
            const ID_LENGTH_MIN = 6
            if(state.id.length<ID_LENGTH_MIN){
                alert('아이디는 6글자 이상입니다')
                id.value.focus()
                return true;
            }
            return false
        }
        const goToPassword = ()=>{
            state.password=''
            state.password_chk=''
            password.value.focus()
        }
        const checkPassword = ()=>{
            if(state.password!=state.password_chk){
                alert('패스워드가 일치하지 않습니다')
                goToPassword()
                return true;
            }
            return false
        }
        const checkPasswordLaw = ()=>{
            let regPass = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,20}$/
            if (!regPass.test(state.password)) {
                alert("영문, 숫자 조합으로 10-20자리 입력해주세요.")
                goToPassword()
                return true
            }
            return false
        }
        const checkName = ()=>{
            console.log(name.value);
            if(state.name.length==0){
                alert("이름을 입력해 주세요")
                name.value.focus()
                return true
            }
            return false
        }
        const signUp = ()=>{
            // 회원가입 axios
            console.log('회원가입 완료');
        }

        const checkAll = ()=>{
            if(checkID()) return
            if(checkPassword()) return
            if(checkPasswordLaw()) return
            if(checkName()) return
            signUp()
        }

        const isPhoneCheck = ()=>{
            console.log("hi!"+state.phone.length);
            if(state.phone.length==11) {
                state.isPhone=false
            }else{
                state.isPhone=true
            }
        }

        const identify = ()=>{
            state.isIdentify = false
        }

        

        return{
            checkAll, state, id, password, name, phone, phoenButton, isPhoneCheck, identify
        }
    }
}
</script>
<style scoped>
.sign-box{
    display: grid;
    width: 25vw;
    min-width: 300px;
    gap: 0.4em;
    margin: 0 auto;
    margin-top:5em;
}
.all-box{
    height: 4em;
    border-radius: 10px;
}
input{
    padding: 10px;
}
button:hover{
    background-color: #d9d9d9;
}
.call-box{
    margin-right: 10px;
}
.phone-button{
    height: 3.9em;
}
</style>