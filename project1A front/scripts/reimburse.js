if(!principal || principal.role !== 'manager')
window.location.href="./reimbursements.html";

getReimbursements();


//async function approveStatus(){
let id = document.getElementById('reimbursement.id').value;
console.log(id)

//}
async function getReimbursements(){

let response = await fetch(`${apiUrl}/ReimbursementServlet`, {
    credentials: 'include'
});

if(response.status == 200){
    let data = await response.json();

    populateTable(data);
} else{
    console.log('Unable to retrieve reimb.')
}
}

let loginButton = document.getElementById('submitButton');
loginButton.addEventListener('click', login);

async function Approval(){

let reimbstatus = document.getElementById('reimbursement.reimbstatus.status').value;
console.log("status made");


let response = await fetch(`${apiUrl}/reimb`,{
    method: 'POST',
    credentials: 'include',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
    },
    body: new URLSearchParams({
        'reimbstatus': `${reimbstatus.status.status}`
        
        
    })
});

if(response.status == 200){
    let data = await response.json();

    /*
        persisting the User object sent back to session storage for use in other pages
        Session Storage only allows persistence of Strings so the JS Object is converted to a JSON string using JSON.stringify
     */
     sessionStorage.setItem('principal', JSON.stringify(data));
    // redirect to the homepage on success
    window.location.href="./index.html";
} else{
    console.log('Unable to update.')
}}

function populateTable(data){
let tableBody = document.getElementById('reimb-tbody');

data.forEach(reimbursement => {
    let tr = document.createElement('tr');
    let tdId = document.createElement('td');
    let tdAmount = document.createElement('td');
    let tdSubmitted = document.createElement('td');
    
    let tdAuthor = document.createElement('td');
    let tdStatus = document.createElement('td');
    let tdType = document.createElement('td');


    tdId.innerHTML = reimbursement.id;
    tdAmount.innerHTML = reimbursement.amount;
    tdSubmitted.innerHTML = reimbursement.submitted;
    tdAuthor.innerHTML = reimbursement.author.firstName;
    tdStatus.innerHTML = reimbursement.reimbstatus.status;
    tdType.innerHTML = reimbursement.reimbtype.type;

    tr.append(tdId);
    tr.append(tdAmount);
    tr.append(tdSubmitted);
    tr.append(tdAuthor);
    tr.append(tdStatus);
    tr.append(tdType);

    tableBody.append(tr);
    console.log(reimbursement);
});

}