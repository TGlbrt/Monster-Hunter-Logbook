const JavaEEServer = "http://localhost:8080/MHLog/";
const accountPath = "api/accounts"
let username;
let password;
const usernameInput = (name) => username = name.value;
const passwordInput = (pass) => password = pass.value;

function sendRequest(url,headerType,payload){
    console.log("sendRequest inputs : ",url,headerType,payload);
    return new Promise((resolve,reject) => {
        console.log("PROMISE");
        const request = new XMLHttpRequest();
        console.log("1");
        request.onreadystatechange = () =>{
            console.log("2");

            if(request.status === 200){
                console.log("https.status=200");
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
                reject("rejected");
            }
            
        }
        
        request.open(headerType,url);
        if(headerType === "POST" ||headerType ==="PUT"){
           request.setRequestHeader("Content-Type","application/json"); 
        }
        request.send(payload);
        console.log("3");   
    }).then((request) => {
        console.log("THEN")
        console.log(request.readyState);
        if(request.readyState === 4){
            console.log("success");
            let values = JSON.parse(request.responseText);
            console.log("values : ",values);
            return values;
        }
    }).catch((error) =>{
        console.log("ERROR");
        console.log(error.toString());
    });
}

function createAccount(){
    console.log(username,password);//totally secure

}

function login(){
    console.log("Login : ",username,password);//totally secure

}