let createUserbtn = document.getElementById('users');
createUserbtn.addEventListener('click', createUser);
let apiUrl = "http://localhost:8080/project1A"
async function createUser(){

    let userid= document.getElementById('userid').value;
    let username= document.getElementById('nusername').value;
    let passed=document.getElementById('npassword').value;

    let  response = await fetch('${apiUrl}/UserServlet',{
        method: "Put",
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },

        body: JSON.stringify({
            "id": `${userid}`,
            "username": `${username}`,
            "password": `${passed}`,

        })

    });
    if (response.status== 201){
        window.alert('User Updated Successfully');
        document.getElementById('userid').innerHTML.value="";
    }
    else{
        window.alert('Unalbe to update User')
    }

}
