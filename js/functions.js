const semail=document.getElementById('semail');
const spassword=document.getElementById('spassword');
const snames=document.getElementById('sname');
const saddress=document.getElementById('saddress');

let svalidEmail=false;
let svalidPassword=false;
let svalidName=false;
let svalidAddress=false;

// $('#success').hide();
// $('#failure').hide();

snames.addEventListener('blur',()=>{
    let regx=/^[a-zA-Z]([a-zA-z0-9\s]){2,18}$/;
    let str=snames.value;
    if(regx.test(str)){
        //alert("matched");
        snames.classList.remove('is-invalid');
        svalidName=true;
        document.getElementById('ssubmit-btn').disabled=false;
    }
    else{
        //alert("not matched");
        snames.classList.add('is-invalid');
        svalidName=false;
        document.getElementById('ssubmit-btn').disabled=true;
    }
})

semail.addEventListener('blur',()=>{
        let regx=/^([_\-a-zA-Z0-9]+)@([_\-a-zA-Z0-9]+)\.([a-zA-Z]){3,7}$/;
        //let regx=/^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\. [a-zA-Z0-9-]+)*$/;
        let str=semail.value;
        if(regx.test(str)){
            semail.classList.remove('is-invalid');
            svalidEmail=true;
            document.getElementById('ssubmit-btn').disabled=false;
        }
        else{
            semail.classList.add('is-invalid');
            svalidEmail=false;
            document.getElementById('ssubmit-btn').disabled=true;
        }
})

spassword.addEventListener('blur',()=>{
    let regx=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
    let str=spassword.value;
    if(regx.test(str)){
        spassword.classList.remove('is-invalid');
        svalidPassword=true;
        document.getElementById('ssubmit-btn').disabled=false;
    }
    else{
        spassword.classList.add('is-invalid');
        svalidPassword=false;
        document.getElementById('ssubmit-btn').disabled=true;
    }
})

saddress.addEventListener('blur',()=>{
    let str=saddress.value;
    if(str!=""){
        saddress.classList.remove('is-invalid');
        svalidAddress=true;
        document.getElementById('ssubmit-btn').disabled=false;
    }
    else{
        saddress.classList.add('is-invalid');
        svalidAddress=false;
        document.getElementById('ssubmit-btn').disabled=true;
    }
})

// let submit=document.getElementById('submit');
// submit.addEventListener('click',(e)=>{
//     e.preventDefault();
//     console.log('you clicked the submit button');
//     if(validUser && validEmail && validPhone){
//         let success=document.getElementById('success');
//         success.classList.add('show');

//         let failure=document.getElementById('failure');
//         // failure.classList.remove('show');
//         // $('#failure').alert('close');
//         $('#failure').hide();
//         $('#success').show();
//     }
//     else{
//         let failure=document.getElementById('failure');
//         failure.classList.add('show');

//         let success=document.getElementById('success');
//         // success.classList.remove('show');
//         // $('#success').alert('close');
//         $('#success').hide();
//         $('#failure').show();
//     }

//})

















// //signup user,loginuser and adminlogin client side validations
// // name validation
// function validateName() {
//     let name=document.getElementById('name').value.toString();
//     if(name==""||name.length<3){
//         document.getElementById('nameErr').innerHTML="Invalid name";
//         document.getElementById('submit-btn').disabled=true;
//     }else{
//         document.getElementById('nameErr').innerHTML="";
//         document.getElementById('submit-btn').disabled=false;
//     }
// }

// // email validation
// function validateEmail() {
//     let emailRegex= /^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\. [a-zA-Z0-9-]+)*$/;
//     let email=document.getElementById('email').value;
//     if(email==""){
//         document.getElementById('emailErr').innerHTML="Invalid email";
//         document.getElementById('submit-btn').disabled=true;
//     }
//     else{
//         if(emailRegex.test(email)){
//             document.getElementById('emailErr').innerHTML="";
//             document.getElementById('submit-btn').disabled=false;
//         }
//         else{
//             document.getElementById('emailErr').innerHTML="Invalid email";
//             document.getElementById('submit-btn').disabled=true;
//         }
//     }
// }

// // password validation
// function validatePassword() {
//     let password=document.getElementById('password').value.toString();
//     if(password==""||password.length<8){
//         document.getElementById('passwordErr').innerHTML="Password must be atleast 8 characters";
//         document.getElementById('submit-btn').disabled=true;
//     }
//     else{
//         document.getElementById('passwordErr').innerHTML="";
//         document.getElementById('submit-btn').disabled=false;
//     }
// }

// // address validation
// function validateAddress() {
//     let address=document.getElementById('address').value.toString();
//     if(address==""){
//         document.getElementById('addressErr').innerHTML="field should not be empty";
//         document.getElementById('submit-btn').disabled=true;
//     }
//     else{
//         document.getElementById('addressErr').innerHTML="";
//         document.getElementById('submit-btn').disabled=false;
//     }
// }





