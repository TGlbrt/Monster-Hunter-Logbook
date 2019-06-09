const MHLogPath = "user/log/";

function getAll(){
    let response = sendRequest(JavaEEServer + MHLogPath,"GET",payload);
}