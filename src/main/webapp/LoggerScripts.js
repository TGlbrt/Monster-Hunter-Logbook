const MHLogPath = "user/m/log/";
let reqLog;
const userInputLogName = (input) => reqLog = input.value;

function getAll(){
    let response = sendRequest(JavaEEServer + MHLogPath,"GET");
    console.log(response);
}

function getALog(){
    let response = sendRequest(`${JavaEEServer} + ${MHLogPath} + / + ${reqLog}`,"GET");
    console.log(response);
}
