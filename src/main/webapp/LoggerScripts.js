const MHLogPath = "log/";
//let reqMonsterLog;
//const userInputMonsterName = (input) => reqMonsterLogs = input.value;

function getAllUserLogs(){
    //check that the user login is in session storage else redirect to login page
    let response = sendRequest(JavaEEServer + MHLogPath + `all?user=${sessionStorage.getItem("username")}`,"GET");
    console.log(response);
}

function getAllUserMonsterLogs(){
    let response = sendRequest(`${JavaEEServer} + ${MHLogPath} + /all/monster?user=${sessionStorage.getItem("userName")}&monster=${sessionStorage.getItem("monsterName")}`,"GET").then((request) => {
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
                let {name,elementalWeaknesses,rank} = currentValue;
                console.log("monster data : ",name,elementalWeaknesses,rank); 
                let monsterTable = document.getElementById("monsters-table");
                let monsterTableBody = document.getElementById("monsters-table-body");
                let monsterTableRow = document.createElement("tr");
                    //let {name} = currentValue;
                    //let {elementalWeaknesses} = currentValue;
                    //let {rank} = currentValue;
                    console.log("monster values : ",name,elementalWeaknesses,rank);
                    let monsterTableNameEntry = document.createElement("td");
                    let monsterNameButton = document.createElement("input");
                    monsterNameButton.type = "button";
                    monsterNameButton.value = name;
                    monsterNameButton.addEventListener('click',(function(){getAMonstersLogs(this.value)}));
                    //monsterNameButton.onclick = (getAMonstersLogs(this.value));
                    monsterNameButton.id = "monster-name-button";
                    monsterNameButton.className = "monster-name-button";
                    monsterTableNameEntry.appendChild(monsterNameButton);
                    //monsterTableNameEntry.appendChild(document.createTextNode(name));
                    //monsterTableNameEntry.id = "monsters-table-entry";
                    //monsterTableNameEntry.className = "monsters-table-entry";
                    //monsterTableNameEntry.onclick = getAMonstersLogs(monsterTableNameEntry.value);
                    monsterTableRow.appendChild(monsterTableNameEntry);
                    let monsterTableRankEntry = document.createElement("td");
                    monsterTableRankEntry.appendChild(document.createTextNode(rank));
                    monsterTableRankEntry.id = "monsters-table-entry";
                    monsterTableRankEntry.className = "monsters-table-entry";
                    monsterTableRow.appendChild(monsterTableRankEntry);
                    let monsterTableEleWeakEntry = document.createElement("td");
                    monsterTableEleWeakEntry.appendChild(document.createTextNode(elementalWeaknesses));
                    monsterTableEleWeakEntry.id = "monsters-table-entry";
                    monsterTableEleWeakEntry.className = "monsters-table-entry";
                    monsterTableRow.appendChild(monsterTableEleWeakEntry);
                    
                monsterTableRow.id = "monsters-table-row";
                monsterTableRow.className = "monsters-table-row";
                monsterTableBody.appendChild(monsterTableRow);
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
    
    let response = sendRequest(JavaEEServer + MHLogPath + `all?user=${sessionStorage.getItem("username")}`,"POST");
}

function updateLog(){

}

function deleteLog(){
    
}