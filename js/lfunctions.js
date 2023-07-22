const lemail=document.getElementById('lemail');
const lpassword=document.getElementById('lpassword');

let lvalidEmail=false;
let lvalidPassword=false;


// $('#success').hide();
// $('#failure').hide();

lemail.addEventListener('blur',()=>{
        let regx=/^([_\-a-zA-Z0-9]+)@([_\-a-zA-Z0-9]+)\.([\.a-zA-Z]){3,7}$/;
        //let regx=/^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\. [a-zA-Z0-9-]+)*$/;
        let str=lemail.value;
        if(regx.test(str)){
            lemail.classList.remove('is-invalid');
            lvalidEmail=true;
            document.getElementById('lsubmit-btn').disabled=false;
        }
        else{
            lemail.classList.add('is-invalid');
            lvalidEmail=false;
            document.getElementById('lsubmit-btn').disabled=true;
        }
})

lpassword.addEventListener('blur',()=>{
    let regx=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
    let str=lpassword.value;
    if(regx.test(str)){
        lpassword.classList.remove('is-invalid');
        lvalidPassword=true;
        document.getElementById('lsubmit-btn').disabled=false;
    }
    else{
        lpassword.classList.add('is-invalid');
        lvalidPassword=false;
        document.getElementById('lsubmit-btn').disabled=true;
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