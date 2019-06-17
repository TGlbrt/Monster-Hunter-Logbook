let monstersPath = "api/monster/";

let newMonsterName;
let userAddMonsterName = (monsterName) => {newMonsterName = monsterName;}
let newMonsterRank;
let userAddMonsterRank = (rank) => {newMonsterRank = rank;}
let newMonsterWeaknesses;
let userAddMonsterWeaknesses = (weaknesses) => {newMonsterWeaknesses = weaknesses;}
let updateMonsterName;
let userUpdateMonstersName = (monsterName) => {updateMonsterName = monsterName;}
let updateMonsterRank;
let userUpdateMonstersRank = (monsterRank) => {updateMonsterRank = monsterRank;}

if(window.location.pathname.endsWith("monsters.html")){
    getAllMonsters();
    if(sessionStorage.getItem("username") != null){
        let userActionsArea = document.getElementById("monsters-user");
        let monsterName = document.createElement("input");
        monsterName.id = "monsterName-input";
        monsterName.className = "monsterName-input";
        monsterName.type = "text";
        monsterName.value = "Monster Name";
        monsterName.addEventListener("keyup",function(){userAddMonsterName(this.value)});
        userActionsArea.appendChild(monsterName);
        let monsterRank = document.createElement("input");
        monsterRank.id = "monsterRank-input";
        monsterRank.className = "monsterRank-input";
        monsterRank.type = "text";
        monsterRank.value = "0";
        monsterRank.addEventListener("keyup",function(){userAddMonsterRank(this.value)});
        userActionsArea.appendChild(monsterRank);
        let monsterWeaknesses = document.createElement("input");
        monsterWeaknesses.id = "monsterWeaknesses-input";
        monsterWeaknesses.className = "monsterWeaknesses-input";
        monsterWeaknesses.type = "text";
        monsterWeaknesses.value = "Monster Weaknesses";
        monsterWeaknesses.addEventListener("keyup",function(){userAddMonsterWeaknesses(this.value)});
        userActionsArea.appendChild(monsterWeaknesses);
        let monsterAddButton = document.createElement("input");
        monsterAddButton.id = "monster-add-button";
        monsterAddButton.className = "monster-add-button";
        monsterAddButton.type = "button";
        monsterAddButton.value = "Add Monster"
        monsterAddButton.addEventListener("click",function(){checkMonsterDuplication()});
        userActionsArea.appendChild(monsterAddButton);
        
        userActionsArea.appendChild(document.createElement("p"));
        let monsterUpdateNameInput = document.createElement("input");
        monsterUpdateNameInput.id = "monster-update-name-input";
        monsterUpdateNameInput.className = "monster-update-name-input";
        monsterUpdateNameInput.type = "text";
        monsterUpdateNameInput.value = "Monster Name to Update";
        monsterUpdateNameInput.addEventListener("input",function(){userUpdateMonstersName(this.value)});
        userActionsArea.appendChild(monsterUpdateNameInput);
        let monsterUpdateRankInput = document.createElement("input");
        monsterUpdateRankInput.id = "monster-update-rank-input";
        monsterUpdateRankInput.className = "monster-update-rank-input";
        monsterUpdateRankInput.type = "text";
        monsterUpdateRankInput.value = "Monster Rank to Update";
        monsterUpdateRankInput.addEventListener("input",function(){userUpdateMonstersRank(this.value)});
        userActionsArea.appendChild(monsterUpdateRankInput);
        let monsterUpdateButton = document.createElement("input");
        monsterUpdateButton.id = "monster-update-button";
        monsterUpdateButton.className = "monster-update-button";
        monsterUpdateButton.type = "button";
        monsterUpdateButton.value = "update";
        monsterUpdateButton.addEventListener("click",function(){updateMonster()});
        userActionsArea.appendChild(monsterUpdateButton);
    }
}

function getAllMonsters(){
    let getMonstersRequest = sendRequest(JavaEEServerPath + monstersPath + "all","GET").then((request) => {
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
                let {id,name,elementalWeaknesses,rank} = currentValue;
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
                    monsterNameButton.id = "monster-name-button-" + counter;
                    monsterNameButton.className = "monster-name-button";
                    monsterTableNameEntry.appendChild(monsterNameButton);
                    monsterTableRow.appendChild(monsterTableNameEntry);
                    let monsterTableRankEntry = document.createElement("td");
                    monsterTableRankEntry.appendChild(document.createTextNode(rank));
                    monsterTableRankEntry.id = "monsters-table-entry-"+ counter;
                    monsterTableRankEntry.className = "monsters-table-entry";
                    monsterTableRow.appendChild(monsterTableRankEntry);
                    let monsterTableEleWeakEntry = document.createElement("td");
                    monsterTableEleWeakEntry.appendChild(document.createTextNode(elementalWeaknesses));
                    monsterTableEleWeakEntry.id = "monsters-table-entry-"+ counter;
                    monsterTableEleWeakEntry.className = "monsters-table-entry";
                    monsterTableRow.appendChild(monsterTableEleWeakEntry);
                    if(sessionStorage.getItem("username") != null){
                        let monsterTableDeleteButtonEntry = document.createElement("td");
                        let monsterDeleteButton = document.createElement("button");
                        monsterDeleteButton.type = "button";
                        monsterDeleteButton.innerText = "Delete";
                        monsterDeleteButton.value = "Delete";
                        monsterDeleteButton.addEventListener('click',(function(){deleteMonster(id)}));
                        monsterDeleteButton.id = "monster-delete-button-"+ counter;
                        monsterDeleteButton.className = "monster-delete-button";
                        monsterTableDeleteButtonEntry.appendChild(monsterDeleteButton);
                        monsterTableRow.appendChild(monsterTableDeleteButtonEntry);
                    }
                
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
}

let selectedMonster;
let userSelectMonster = (monsterName) => {selectedMonster = monsterName;}

function getAMonstersLogs(monsterName){
    sessionStorage.setItem("currentMonster",monsterName);
    console.log("monsterName",monsterName);
    console.log(sessionStorage.getItem("currentMonster"));
    window.location.href = "log.html";
}

function addAMonster(){
    console.log("addAMonsterCalled");
    let newMonster = new Monster(newMonsterName,newMonsterRank,newMonsterWeaknesses);
    let postMonstersRequest = sendRequest(JavaEEServerPath + monstersPath,"POST",JSON.stringify(newMonster)).then((request) => {
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
    console.log("request returned : ",postMonstersRequest);
}

function checkMonsterDuplication(){
    console.log("checkMonsterDuplication called");
    console.log(newMonsterName,newMonsterRank,newMonsterWeaknesses);
    let getAllMonstersRequest = sendRequest(JavaEEServerPath + monstersPath + "all","GET").then((request) => {
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
                let {name,rank} = currentValue;
                console.log("current name : ", name,rank," compare : ", newMonsterName,newMonsterRank);
                if(name === newMonsterName){
                    if(rank.toString() === newMonsterRank){
                        console.log("name and rank is the same");
                        return false;
                    }
                }
            }
            return addAMonster();
        }
    }).catch((error) =>{
        console.log("ERROR");
        console.log(error.toString());
    });
    console.log("request returned : ",getAllMonstersRequest);
}

function updateMonster(){
    console.log("updateMonster called");
    console.log(newMonsterName,newMonsterRank,newMonsterWeaknesses," update : ",updateMonsterName,updateMonsterRank);
    let updatedMonster = new Monster(newMonsterName,newMonsterRank,newMonsterWeaknesses);
    let getAllMonstersRequest = sendRequest(JavaEEServerPath + monstersPath.substring(0,monstersPath.length - 1) + `?name=${updateMonsterName}&rank=${updateMonsterRank}`,"PUT",JSON.stringify(updatedMonster)).then((request) => {
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
    console.log("request returned : ",getAllMonstersRequest);
}

function deleteMonster(monsterId){
    console.log("deleteMonster called");
    let deleteMonsterRequest = sendRequest(JavaEEServerPath + monstersPath.substring(0,monstersPath.length - 1) + `?id=${monsterId}`,"DELETE").then((request) => {
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
    console.log("request returned : ",deleteMonsterRequest);
}