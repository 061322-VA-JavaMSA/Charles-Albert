
let loginButton = document.getElementById('submitButton');
loginButton.addEventListener('click', login);

let apiUrl = 'http://localhost:8080/project1A'; 

async function login(){

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    let response = await fetch(`${apiUrl}/AuthServlet`,{
        method: 'POST',
        //credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'username': `${username}`,
            'password': `${password}`
        })
    });
    
    
    if(response.status == 200){
        let data = await response.json();
        sessionStorage.setItem('principal', JSON.stringify(data));
        console.log(data);
        window.location.href="./users.html";
        if(data.role["role"] == "employee"){
            window.location.href = "../views/users.html";
            console.log(data);
        } 
        
        else{
            
           window.location.href = "../views/manager.html";
           console.log(data);
           
        }
    
        
    
   
    }   
     else{
             console.log("Unable to log in.");
             document.getElementById('error').innerHTML="Incorrecnt Credentials!";
         }

   
}

