//import MHLUser from './mhluser';
const JavaEEServerPath = "http://localhost:8080/TGlbrt.mhlogbook-0.1/";
const userPath = "api/user/";
let username;
let password;
const usernameInput = (name) => username = name.value;
const passwordInput = (pass) => password = pass.value;
//tests
salt("wonderfall");
username = "test";
password = "test"
//let newUser = new MHLUser(username,password);
createNewUser();
getUserByName();

function sendRequest(url,headerType,payload){
    console.log("sendRequest inputs : ",url,headerType,payload);
    return new Promise((resolve,reject) => {
        console.log("PROMISE");
        const request = new XMLHttpRequest();
        console.log("1");
        request.onreadystatechange = () =>{
            console.log("2");
            if(request.status >= 200){
                if(request.readyState === 4){
                   resolve(request); 
                }
                
            }else if(request.status === 0){
                console.log("xmlhttprequest ERROR : http.status=0");
            }
            else{
                console.log("FUCKED UP");
                console.log(request.status);
                console.log(request.statusText);
                console.log(request.readyState);
                reject("rejected");
            }
            
        }
        request.open(headerType,url);
        if(headerType === "POST" ||headerType ==="PUT"){
            request.setRequestHeader("Content-Type","application/json"); 
        }
        request.send(payload);
        console.log("3"); 
    })
}

function createNewUser(){
    console.log(username,password);//totally secure
    if(username[username.length] === "-"){
        alert("username cannot have - at the end");
    }
    const newUser = new MHLUser(username,password);
    let responsePost = sendRequest(JavaEEServerPath + userPath,"POST",JSON.stringify(newUser));
    responsePost.then((request) => {
        console.log("THEN")
        console.log(request.readyState);
        if(request.readyState === 4){
            console.log("success");
            let values = (request.responseText);
            console.log("values : ",values);
            return values;
        }
    }).catch((error) =>{
        console.log("ERROR");
        console.log(error.toString());
    });
    console.log(responsePost);
}

function getAllUsers(){
    let responsePost = sendRequest(JavaEEServerPath + userPath,"GET");
    responsePost.then((request) => {
        console.log("THEN")
        console.log(request.readyState);
        if(request.readyState === 4){
            console.log("success");
            let values = (request.responseText);
            console.log("values : ",values);
            return values;
        }
    }).catch((error) =>{
        console.log("ERROR");
        console.log(error.toString());
    });
    console.log(responsePost);
}

function getUserByName(){
    let responsePost = sendRequest(JavaEEServerPath + userPath.substring(0,userPath.length -1) + `?name=${username}`,"GET");
    responsePost.then((request) => {
        console.log("THEN")
        console.log(request.readyState);
        if(request.readyState === 4){
            console.log("success");
            let values = (request.responseText);
            console.log("values : ",values);
            return values;
        }
    }).catch((error) =>{
        console.log("ERROR");
        console.log(error.toString());
    });
    console.log(responsePost);
}

function login(){
    console.log("Login : ",username,password);//totally secure
    let saltedPassword = salt(password);
    console.log("last character : ",username[username.length-1]);
    if(username[username.length-1] === "-"){
        alert("username cannot have - at the end");
        let usernameTextBox = document.getElementById("usernameInput");
        usernameTextBox.value = "";
    }
    //sendRequest(`${JavaEEServerPath}${userPath}${username}-${saltedPassword}` ,"GET");
}

function salt(input){
    let stageOne = input.toString().split("");
    console.log(stageOne);
    let stageTwo = stageOne.reduce((acc,value) => acc + (parseInt(value.toString(),36) * acc ),22);
    console.log(stageTwo);
    //stageOne.forEach((value) => console.log(parseInt(value.toString(),36)))
}
