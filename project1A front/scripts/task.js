let apiUrl="http://localhost:8080/project1A";

if(!principal){
    window.location.href="./index.html";
}



//function approveF(){
   // console.log('approve');
//}

let infobtn= document.getElementById('info');
infobtn.addEventListener('click', getTask);

async function getTask(){

    let response = await fetch (`${apiUrl}/ReimbursementServlet`,{

    });
    if (response.status==200){
        let data = await response.json();
        console.log(data);
        populateTable1(data);
    } 
    else{
        console.log("cann't get");
    }
}

function populateTable1(data){
    let tableBody = document.getElementById('reimbs-tbody');

    data.forEach(task =>{
        let tr = document.createElement('tr');
        let tdemployee= document.createElement('td');
        let tdId = document.createElement('td');
        let tdAmount= document.createElement('td');
        let tdDes= document.createElement('td');
        
        let tdSubDate = document.createElement('td');
       // let tdResDate= document.createElement('td');
        let tdStatus = document.createElement('td');
        
        tdemployee.innerHTML= task.author.firstName;
        tdId.innerHTML= task.id;
        tdAmount.innerHTML= task.amount;
        tdDes.innerHTML= task.description;
        
        tdSubDate.innerHTML= new Date(task.submitted).toLocaleDateString();
        //tdResDate.innerHTML= new Date(task.resolved).toLocaleDateString();
        tdStatus.innerHTML= task.reimbStatus.status;
       

        tr.append(tdemployee);
        tr.append(tdId);
        tr.append(tdAmount);
        tr.append(tdDes);
        tr.append(tdSubDate);
        //tr.append(tdResDate);
        tr.append(tdStatus);
        

        tableBody.append(tr);
    
    
    
})
}