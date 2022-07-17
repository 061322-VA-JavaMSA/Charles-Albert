if(!principal){
    window.location.href="./manager.html";
}

let infobtn = document.getElementById('info');
infobtn.addEventListener('click', getTask);

async function getReimbursements(){

       let response = await fetch(`${apiUrl}/ReimbursementServlet`, {
        credentials: 'include'
    });

        if(response.status == 200){
            let data = await response.json();
                console.log();
                populatePendingTable(data)
        }
        else{
            console.log("Unable to retreive reimbursements.");   
        }
}


function populatePendingTable(data){
    let tableBody = document.getElementById('reimb-tbody');

    data.forEach(reimbursement => {
        let tr = document.createElement('tr');
        let tdAuthor = document.createElement('td');
        let tdType = document.createElement('td');
        let tdDescrip = document.createElement('td');
        let tdAmount = document.createElement('td');
        let tdSubmitted = document.createElement('td');
        
        
        

        tdAuthor.innerHTML = reimbursement.firstName;
        tdAmount.innerHTML = reimbursement.amount;
        tdDescrip.innerHTML = reimb.description;
        tdSubmitted.innerHTML = reimbursement.submitted;
        tdType.innerHTML = reimbursement.type_id;

        tr.append(tdAmount);
        tr.append(tdDescrip);
        tr.append(tdSubmitted);
        tr.append(tdAuthor);
        tr.append(tdType);

        tableBody.append(tr);
        console.log(reimbursement);
         });
}


