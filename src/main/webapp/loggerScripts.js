const MHLogPath = "api/log/";
let time;
let numberOfPlayers = 1;
const timeInput = (input) => time = input.value;
const numberOfPlayersInput = (noOfPlayers) => numberOfPlayers = noOfPlayers.value;

if(window.location.pathname.endsWith("log.html")){
    console.log("session info",sessionStorage.getItem("username"),sessionStorage.getItem("currentMonster"));
    //if(sessionStorage.getItem("username") === null && sessionStorage.getItem("currentMonster") === null){
    //    window.location.href = "index.html";
    //}
    let createLogButton = document.getElementById("create-log-button");
    let updateLogButton = document.getElementById("update-log-button");
    updateLogButton.hidden = true;
    if(sessionStorage.getItem("currentMonster") === null){
        getAllUserLogs();
    }else{
        getAllUserMonsterLogs();
    }
}

function getAllUserLogs(){
    let getAllUserLogsRequest = sendRequest(JavaEEServerPath + MHLogPath + `all?user=${sessionStorage.getItem("username")}`,"GET").then((request) => {
        console.log("THEN")
        console.log(request.readyState);
        if(request.readyState === 4){
            console.log("success");
            let values = (request.responseText);
            console.log("values : ",values);
            values = JSON.parse(request.responseText);
            console.log("values object : ",values);
            let counter = 0;
            for(let key in values){
                counter++;
                let currentValue = values[key];
                console.log(currentValue);
                populateTableRow(currentValue,counter);
            }
            return values;
        }
    }).catch((error) =>{
        console.log("ERROR");
        console.log(error.toString());
    });
    console.log("request returned : ",getAllUserLogsRequest);
}

function getAllUserMonsterLogs(){
    let getMonstersRequest = sendRequest(`${JavaEEServerPath}${MHLogPath}all/monster?user=${sessionStorage.getItem("username")}&monster=${sessionStorage.getItem("currentMonster")}`,"GET").then((request) => {
        console.log("THEN")
        console.log(request.readyState);
        if(request.readyState === 4){
            console.log("success");
            let values = (request.responseText);
            console.log("values : ",values);
            values = JSON.parse(request.responseText);
            console.log("values object : ",values);
            let counter = 0;
            for(let key in values){
                counter++;
                let currentValue = values[key];
                console.log(currentValue);
                populateTableRow(currentValue,counter);
            }
            return values;
        }
    }).catch((error) =>{
        console.log("ERROR");
        console.log(error.toString());
    });
    console.log("request returned : ",getMonstersRequest);
    console.log(getMonstersRequest);
}

function createNewLog(){
    console.log("createNewLog called");
    console.log(time,numberOfPlayers);
    let newLog = new Log(sessionStorage.getItem("username"),sessionStorage.getItem("currentMonster"),time,numberOfPlayers);
    let createLogRequest = sendRequest(JavaEEServerPath + MHLogPath + `?user=${sessionStorage.getItem("username")}`,"POST",JSON.stringify(newLog)).then((request) => {
        console.log("THEN")
        console.log(request.readyState);
        if(request.readyState === 4){
            console.log("success");
            let values = (request.responseText);
            console.log("values object : ",values);
            forceRefresh();
            return values;
        }
    }).catch((error) =>{
        console.log("ERROR");
        console.log(error.toString());
    });
    console.log("request returned : ",createLogRequest);
}

function getUpdatedValues(id,time,numberOfPlayers){
    sessionStorage.setItem("logId",id);
    console.log("getUpdatedValues called");
    let createLogButton = document.getElementById("create-log-button");
    createLogButton.hidden = true;
    let updateLogButton = document.getElementById("update-log-button");
    updateLogButton.hidden = false;
    let timeInput = document.getElementById("input-time");
    timeInput.value = time;
    let noOfPlayersInput = document.getElementById("input-number_of_players");
    noOfPlayersInput.value = numberOfPlayers;
}

function updateLog(){
    console.log("updateLog called");
    let updatedLog = new Log(sessionStorage.getItem("username"),sessionStorage.getItem("currentMonster"),time,numberOfPlayers);
    let updateLogRequest = sendRequest(JavaEEServerPath + MHLogPath + `${sessionStorage.getItem("logId")}`,"PUT",JSON.stringify(updatedLog)).then((request) => {
        console.log("THEN");
        console.log(request.readyState);
        if(request.readyState === 4){
            console.log("success");
            let createLogButton = document.getElementById("create-log-button");
            createLogButton.hidden = false;
            let updateLogButton = document.getElementById("update-log-button");
            updateLogButton.hidden = true;
            let values = (request.responseText);
            console.log("values : ",values);
            values = JSON.parse(request.responseText);
            console.log("values object : ",values);
            sessionStorage.removeItem("logId");
            forceRefresh();
            return values;
        }
    }).catch((error) =>{
        console.log("ERROR");
        console.log(error.toString());
    });
    console.log("request returned : ",updateLogRequest);
}

function deleteLog(id){
    console.log("deleteLog called");
    let deleteLogRequest = sendRequest(JavaEEServerPath + MHLogPath + `${id}`,"DELETE").then((request) => {
        console.log("THEN")
        console.log(request.readyState);
        if(request.readyState === 4){
            console.log("success");
            forceRefresh();
        }
    }).catch((error) =>{
        console.log("ERROR");
        console.log(error.toString());
    });
    console.log("request returned : ",deleteLogRequest);
}

function populateTableRow(input,counter){
    console.log(input);
    let {id,time,numberOfPlayers} = input;
    console.log("logs data : ",id,time,numberOfPlayers); 
    let logsTable = document.getElementById("logs-table");
    let logsTableBody = document.getElementById("logs-table-body");
    let logsTableRow = document.createElement("tr");
        console.log("log values : ",time,numberOfPlayers);
        let logsTableIdEntry = document.createElement("td");
        logsTableIdEntry.appendChild(document.createTextNode(counter));
        logsTableRow.appendChild(logsTableIdEntry);
        let logsTableTimeEntry = document.createElement("td");
        logsTableTimeEntry.appendChild(document.createTextNode(time));
        logsTableTimeEntry.id = "logs-table-entry";
        logsTableTimeEntry.className = "logs-table-entry";
        logsTableRow.appendChild(logsTableTimeEntry);
        let logsTableNoOfPlayersEntry = document.createElement("td");
        logsTableNoOfPlayersEntry.appendChild(document.createTextNode(numberOfPlayers));
        logsTableNoOfPlayersEntry.id = "logs-table-entry";
        logsTableNoOfPlayersEntry.className = "logs-table-entry";
        logsTableRow.appendChild(logsTableNoOfPlayersEntry);

        let logsTableUpdateEntry = document.createElement("td");
        let logUpdateButton = document.createElement("input");
        logUpdateButton.type = "button";
        logUpdateButton.value = "Update";
        logUpdateButton.addEventListener('click',(function(){getUpdatedValues(id,time,numberOfPlayers)}));
        logUpdateButton.id = "log-update-button";
        logUpdateButton.className = "log-update-button";
        logsTableUpdateEntry.appendChild(logUpdateButton);
        logsTableRow.appendChild(logsTableUpdateEntry);
        let logsTableDeleteEntry = document.createElement("td");
        let logDeleteButton = document.createElement("input");
        logDeleteButton.type = "button";
        logDeleteButton.value = "DELETE";
        logDeleteButton.addEventListener('click',(function(){deleteLog(id)}));
        logDeleteButton.id = "log-delete-button";
        logDeleteButton.className = "log-delete-button";
        logsTableDeleteEntry.appendChild(logDeleteButton);
        logsTableRow.appendChild(logsTableDeleteEntry);
    logsTableRow.id = "logs-table-row";
    logsTableRow.className = "logs-table-row";
    logsTableBody.appendChild(logsTableRow);
}

function forceRefresh(){
    window.location.href = "log.html";
}