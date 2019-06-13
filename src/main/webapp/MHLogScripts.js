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
//createNewUser();
//getUserByName();
//updateUser();
//deleteUser();

function sendRequest(url,headerType,payload){
    console.log("sendRequest inputs : ",url,headerType,payload);
    return new Promise((resolve,reject) => {
        console.log("PROMISE");
        const request = new XMLHttpRequest();
        request.onreadystatechange = () =>{
            console.log("status : ",request.status);
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
        console.log("send : ", payload); 
    }).then((request) => {
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
}

function createNewUser(){
    console.log("create new user");
    console.log(username,password);//totally secure
    if(username[username.length] === "-"){
        alert("username cannot have - at the end");
    }
    const newUser = new MHLUser(username,password);
    let responsePost = sendRequest(JavaEEServerPath + userPath,"POST",JSON.stringify(newUser));
    console.log("request returned : ",responsePost);
}

function getAllUsers(){
    console.log("get all users");
    let responseGet = sendRequest(JavaEEServerPath + userPath + "all","GET");
    console.log("request returned : ",responseGet);
}

function getUserByName(){
    console.log("get by name");
    let responseGet = sendRequest(JavaEEServerPath + userPath.substring(0,userPath.length -1) + `?name=${username}`,"GET");
    console.log("request returned : ",responseGet);
}
function updateUser(){
    console.log("update");
    const newUser = new MHLUser("updated",password);
    let responsePut = sendRequest(JavaEEServerPath + userPath.substring(0,userPath.length - 1) + `?name=${username}` ,"PUT",JSON.stringify(newUser));
    console.log("request returned : ",responsePut);
}

function deleteUser(){
    console.log("delete user");
    let responseDelete = sendRequest(JavaEEServerPath + userPath.substring(0,userPath.length - 1) + `?name=${username}` ,"DELETE");
    console.log("request returned : ",responseDelete);
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
    let loginRequest = getUserByName();
    //sendRequest(`${JavaEEServerPath}${userPath.substring(0,userPath.length - 1)}?name=${username}` ,"GET");
    console.log("login returned : ",loginRequest)
}

function salt(input){
    let stageOne = input.toString().split("");
    console.log(stageOne);
    let stageTwo = stageOne.reduce((acc,value) => acc + (parseInt(value.toString(),36) * acc ),22);
    console.log(stageTwo);
    //stageOne.forEach((value) => console.log(parseInt(value.toString(),36)))
}
