// const { table } = require("console");

let apiUrl="http://localhost:8080/project1A";
if(!principal){
    window.location.href="./index.html";
}


let infobtn = document.getElementById('infoo');
infobtn.addEventListener('click', getTasks1);

async function getTasks1(){
    let tableBody = document.getElementById('task-tbody');
    let response = await fetch (`${apiUrl}/ReimbursementServlet`,{

    });
    if (response.status=200){

        let data = await response.json();
     
        console.log(data);
   
    

       

   populateTable(data);
    }
    else{
        console.log("Cann't get");
    }
}

function populateTable (data){
    // let tableBody = document.getElementById('task-tbody');

    data.forEach(task =>{

        let tr = document.createElement('tr');
        let tdemployee = document.createElement('td');
        let tdId = document.createElement('td');
        
        let tdDes= document.createElement('td');
        let tdAmount= document.createElement('td');
        let tdSubDate = document.createElement('td');
        
        let tdStatus = document.createElement('td');
        
        tdemployee.innerHTML= task.author.firstName;
        tdId.innerHTML= task.id;
       tdAmount.innerHTML= task.amount;
       tdDes.innerHTML= task.description;
        
       tdSubDate.innerHTML= new Date(task.submitted).toLocaleDateString();
        
        tdStatus.innerHTML= task.reimbStatus.status;
       

       tr.append(tdemployee);
       tr.append(tdId);
       tr.append(tdAmount);
       tr.append(tdDes);
       tr.append(tdSubDate);
        
        tr.append(tdStatus);
        
        tableBody.append(tr);




    })
    // document.getElementById('infoo').disabled=true; 

}