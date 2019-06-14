const MHLogPath = "log/";
let reqMonsterLog;
const userInputMonsterName = (input) => reqMonsterLogs = input.value;

function getAllUserLogs(){
    //check that the user login is in session storage else redirect to login page
    let response = sendRequest(JavaEEServer + MHLogPath + `all?user=`,"GET");
    console.log(response);
}

function getAllUserMonsterLogs(){
    let response = sendRequest(`${JavaEEServer} + ${MHLogPath} + /all/monster?user=&monster=${reqMonsterLog}`,"GET");
    console.log(response);
}

function createNewLog(){

}

function updateLog(){

}

function deleteLog(){
    
}