let button1 = document.getElementById("users");
button1.addEventListener('click', getUsers);
let apiUrl = "http://localhost:8080/project1A"
async function getUsers(){

    let response = await fetch(`${apiUrl}/UserServlet`, {
        credentials: 'include'
    });

    if(response.status == 200){
        let data = await response.json();
        console.log();
        populateTable(data);
    }
    else{
        console.log("Unable to retreive employees.");   
    }
}

  
function populateTable(data) {

    let tableBody = document.getElementById("users-tbody");

    data.forEach(user => {
        let tr = document.createElement('tr');
        let tdId = document.createElement('td');
        let tdName = document.createElement('td');
        let tdUsername = document.createElement('td');
        let tdEmail = document.createElement('td');
        let tdRole = document.createElement('td');

        tdId.innerHTML = user.id;
        tdName.innerHTML = user.firstName + " " + user.lastName;
        tdUsername.innerHTML = user.username;
        tdEmail.innerHTML = user.email;
        tdRole.innerHTML = user.role.role;

        tr.append(tdId);
        tr.append(tdName);
        tr.append(tdUsername);
        tr.append(tdEmail);
        tr.append(tdRole);

        tableBody.append(tr);
        console.log(user);
    });
}

