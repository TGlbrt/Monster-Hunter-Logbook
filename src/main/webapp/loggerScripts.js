const MHLogPath = "api/log/";
//let reqMonsterLog;
//const userInputMonsterName = (input) => reqMonsterLogs = input.value;

if(window.location.pathname.endsWith("log.html")){
    console.log("session info",sessionStorage.getItem("username"),sessionStorage.getItem("currentMonster"));
    getAllUserMonsterLogs();
}

function getAllUserLogs(){
    //check that the user login is in session storage else redirect to login page
    let response = sendRequest(JavaEEServerPath + MHLogPath + `all?user=${sessionStorage.getItem("username")}`,"GET");
    console.log(response);
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
            
            for(let key in values){
                let currentValue = values[key];
                console.log(currentValue);
                let {time,numberOfPlayers} = currentValue;
                console.log("logs data : ",time,numberOfPlayers); 
                let logsTable = document.getElementById("logs-table");
                let logsTableBody = document.getElementById("logs-table-body");
                let logsTableRow = document.createElement("tr");
                    console.log("log values : ",time,numberOfPlayers);
                    let logsTableIdEntry = document.createElement("td");

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
                logsTableRow.id = "logs-table-row";
                logsTableRow.className = "logs-table-row";
                logsTableBody.appendChild(logsTableRow);
            }
            
            
            return values;
        }
    }).catch((error) =>{
        console.log("ERROR");
        console.log(error.toString());
    });
    console.log("request returned : ",getMonstersRequest);
    console.log(response);
}

function createNewLog(){
    let newLog = new Log(sessionStorage.getItem("username"),sessionStorage.getItem("currentMonster"));
    let response = sendRequest(JavaEEServer + MHLogPath + `?user=${sessionStorage.getItem("username")}`,"POST",newLog);
}

function updateLog(){

}

function deleteLog(){
    
}