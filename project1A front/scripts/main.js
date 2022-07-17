// Because main.js is the first script added to each HTML page, the logic declared here is shared/reused by all pages
//let apiUrl = 'http://localhost:8081/task-manager';


// When logged in, retrieves the JSON string representing the logged in user from Session Storage
let principalString = sessionStorage.getItem('principal');
let principal = null;



// If principalString is a truthy value(non null), therefore exists
if (principalString) {
    // converts the JSON string back to a JS object and assigns it to principal
    principal = JSON.parse(principalString);

    if (principal.role == 'manager'){
       // createNavElement('Users', nav_left, './employees.html', null);
        createNavElement('Task', nav_left, './manager.html', null);
       // createNavElement('Create Users', nav_left, './newuser.html', null);
       // createNavElement('Logout', nav_right, null, logout);
    } else {

       // createNavElement('New Request', nav_left, './request.html', null);
       // createNavElement('My Requests', nav_left, './myrequests.html', null);
       // createNavElement('Update My Info', nav_left, './updateuser.html', null);
       // createNavElement('Logout', nav_right, null, logout);
    }

}
else{
    //createNavElement('Login', nav-right, './login.html', null);
}

async function logout() {

    // Sends a DELETE request to API to invalidate session
    let response = await fetch(`${apiUrl}/AuthServlet`, {
        method: 'DELETE',
        credentials: 'include'
    });

    if (response.status == 200) {
        // clears user object JSON string in session storage
        sessionStorage.clear();
        // clears principal variable representing logged in user
        principal = null;
        window.location.href="./manager.html";
    } else {
        console.log('Unable to logout.')
    }
}


