let monstersPath = "api/monster/";

if(window.location.pathname.endsWith("monsters.html")){
    
    getAllMonsters();

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
                    monsterTableNameEntry.appendChild(document.createTextNode(name));
                    monsterTableNameEntry.id = "monsters-table-entry";
                    monsterTableNameEntry.className = "monsters-table-entry";
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
                //monsterTable.appendChild(monsterTableRow);
                
            }
            
            
            return values;
        }
    }).catch((error) =>{
        console.log("ERROR");
        console.log(error.toString());
    });
    console.log("request returned : ",getMonstersRequest);
}