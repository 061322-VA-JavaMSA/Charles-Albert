//if (!pricipal){
 //   window.location.href = "./index.html";  
//}
if(principal.role === 'employee'){
    document.getElementById('newReimburseButton').style.visibility = 'visible';
    document.getElementById('newReimburseButton').style.display = 'inline';
} else {
    document.getElementById('newReimburseButton').style.visibility = 'hidden';
    document.getElementById('newReimburseButton').style.display = 'none';
}

window.onload= getReimburse;
let reimburse;
let ascend = true;
let lastClick;

let amount = document.getElementById('amount');
amount.addEventListener('click', sortReimburse);
let author = document.getElementById('author');
author.addEventListener('click', sortReimburse);
let type = document.getElementById('type');
type.addEventListener('click', sortReimburse);
let submitted = document.getElementById('submitted');
submitted.addEventListener('click', sortReimburse);
let statusCo = document.getElementById('status');
statusCo.addEventListener('click', sortReimburse);
let submitRequest = document.getElementById('submitRequest');
submitRequest.addEventListener('click', addReimburse);
let cancelRequest = document.getElementById('cancelRequest');
cancelRequest.addEventListener('click', clearRequestForm);

let reimburseToView;

async function addReimburse(){
    let reqAmount = document.getElementById('newAmount').value;
    let reqType = document.getElementById('newType').value;
    let reqDescipt = document.getElementById('new reqDescript');
    
    let submitRequest = await fetch (`${apiUrl}/reimbursements`,{
        method: 'Post',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'type':  `${reqType}`,
            'amount': `${reqAmount}`,
            'description': `${reqDescript}`
        })
});

    if (submitResponse.status >= 200 && submitResponse < 300) {
            clearRequestForm();
            getReimburse();
    }else{
        console.log('Unable to complete your request.');
    }
}

function clearRequestForm() {
    document.getElementById('newRequestForm').resest();
}

async function getReimburse() {
    let reimburseResp = await fetch(`${apiUrl}/reimbursements`,{
        credentials: 'include'
    });

    if (reimburseResp.status >= 200 && reimburseResp.status < 300) {
        reimburse = await reimburseResp.json();
        populateReimburse();
    } else {
        console.log('Unable to fetch the data');
    }

}

function populateReimburse() {
    let tbody = document.getElementById('reimburse-tbody');
    while (tbody.firstChild){
        tbody.removeChild(tbody.firstChild);
    }

    let id = 0;

    reimburse.forEach(function (r) {
        let tr = document.createElement('tr');
        let rowAuthor = document.createElement('td');
        rowAuthor.innerHTML = r.author ? r.author.fullName : 'undefined';
        tr.appendChild(rowAuthor);
        let reqAmount = document.createElement('td');
        rowAmount.innerHTML = r.amount ? '$ ${r.amount.toFixed(2)}' : 'undefined';
        tr.appendChild(rowAmount);
        let rowType = document.createElement('td');
        rowType.innerHTML = r.type ? r.type : 'undefined';
        tr.appendChild(rowType);
        let rowSubmitted = document.createElement('td');
        rowSubmitted.innerHTML = r.submitted ? formatDate(r.submitted, '  ') : 'undefined';
        tr.appendChild(rowSubmitted);
        let rowStatus = document.createElement('td');
        rowStatus.innerHTML = r.status ? r.status : 'undefined';
        tr.appendChild(rowStatus);
        tr.addEventListener('click', populateViewer);
        tr.style.cursor = 'pointer';
        tr.setAttribute('data-bs-toggle', 'modal');
        tr.setAttribute('data-bs-target', '#reimbView');
        tbody.appendChild(tr);
        tr.id = id;
        id++;
    });   
}

async function resolveReimburse(event) {
    let resolvedId = reimburseToView.id;
    let resolvedStatus = event.target.value;
    let resolvedResponse= await fetch (`${apiUrl}/reimbursements`,{
        method: 'Put',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'id' : `${resolveId}`,
            'status' : `${resolvedStatus}`
        })

    });

    if (resolvedResponse.status >= 200 && resolvedResponse.status < 300) {
        getReimburse();
    } else {
        console.log('unabble to  complete your request.');
    }
}

function populateViewer(event) {
    reimburseToView = reimburse[event.target.parentNode.id];
    console.log(reimburseToView);
    document.getElementById('viewAuthor').innerHTML = reimburseToView.author.fullName ? reimburseToView.author.fullName : '—';
    document.getElementById('viewResolver').innerHTML = reimburseToView.resolver.fullName ? reimburseToView.resolver.fullName : '—';
    document.getElementById('viewSubmitted').innerHTML = reimburseToView.submitted ? formatDate(reimburseToView.submitted, '  ') : '—';
    document.getElementById('viewResolved').innerHTML = reimburseToView.resolved ? formatDate(reimburseToView.resolved, '  ') : '—';
    document.getElementById('viewAmount').innerHTML = reimburseToView.amount ? `$ ${reimburseToView.amount.toFixed(2)}` : '—';
    document.getElementById('viewType').innerHTML = reimburseToView.type ? reimburseToVieww.type : '—';
    document.getElementById('viewStatus').innerHTML = reimburseToView.status ? reimburseToView.status : '—';
    document.getElementById('viewDescription').innerHTML = reimburseToView.description ? reimburseToView.description : '—';
    

    let approveB = document.getElementById('approved');
    let denyB = document.getElementById('denied');
    if (principal.role === 'manager' && reimburseToView.status === 'pending') {
        approveB.style.visibility = 'visible';
        approveB.style.display = 'inline';
        approveB.addEventListener('click', resolveReimburse);
        denyB.style.visibility = 'visible';
        denyB.style.display = 'inline';
        denyB.addEventListener('click', resolveReimburse);
    } else {
        approveB.style.visibility = 'hidden';
        approveB.style.display = 'none';
        denyB.style.visibility = 'hidden';
        denyB.style.display = 'none';
    }
}

function sortReimburse(event) {
    if (lastClick) {
        lastClick.innerHTML = lastClick.innerHTML.slice(0, -2);
    }
    let thisClick = event.target;
    if (thisClick == lastClick) {
        ascend = !ascend;
    } else {
        ascend = true;
    }
    thisClick.innerHTML += ascend ? ' ▲' : ' ▼';
    lastClick = thisClick;
    switch (thisClick.id) {

        case 'amount':
            reimburse = reimburse.sort(ascend ? compareAmA : compareAmD);
            break;
        case 'author':
            reimburse = reimburse.sort(ascend ? compareAuA : compareAuD);
            break;

        case 'type':
            reimburse = reimburse.sort(ascend ? compareTA : compareTD);
            break;

        case 'submitted':
            reimburse = reimburse.sort(ascend ? compareSuA : compareSuD);
            break;

        case 'status':
            reimburse = reimburse.sort(ascend ? compareStA : compareStD);
            break;

        case 'receipt':
            reimburse = reimburse.sort(ascend ? compareRA : compareRD);
            break;

        default:
    }
    populateReimbs();
}

function compareAmA(a,b) {
    if(a.amount > b.amount){
        return -1;
    }
    if (a.amount < b.amount){
        return -1;
    }
    return 0;
}

function compareAuA(a, b) {
    return ('' + a.author.firstName + ' ' + a.author.lastName).localeCompare(b.author.firstName + ' ' + b.author.lastName);
}
function compareAuD(a, b) {
    return ('' + b.author.firstName + ' ' + b.author.lastName).localeCompare(a.author.firstName + ' ' + a.author.lastName);
}
function compareTA(a, b) {
    return ('' + a.type).localeCompare(b.type);
}
function compareTD(a, b) {
    return ('' + b.type).localeCompare(a.type);
}
function compareSuA(a, b) {
    return ('' + a.submitted).localeCompare(b.submitted);
}
function compareSuD(a, b) {
    return ('' + b.submitted).localeCompare(a.submitted);
}
function compareStA(a, b) {
    return ('' + a.status).localeCompare(b.status);
}
function compareStD(a, b) {
    return ('' + b.status).localeCompare(a.status);
}





    
