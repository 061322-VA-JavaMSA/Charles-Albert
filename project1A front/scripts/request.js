let reqsubmit = document.getElementById('submitButton');
reqsubmit.addEventListener('click', request);
let apiUrl="http://localhost:8080/project1A";


async function request(){

    
    let rt=document.getElementById("rtype").value;
    let ra=document.getElementById('ramount').value;
   // let rd=document.getElementById('rsubmit').value;
    let rdes = document.getElementById('rdescription').value;
    //let userId = document.getElementById('rUserId').value;
        

        let response = await fetch(`${apiUrl}/ReimbursementServlet`,{
                method: 'POST',
            credentials: 'include',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
        
        body: JSON.stringify({
           
          // "author":{"authorId":`${userId}`},
           "description": `${rdes}`,
            "amount": `${ra}`,
          //  "submitted": `${rd}`,
            "type":`${rt}`,
        })

    });

    if (response.status == 201){
        // console.log('created');
        window.alert('created');
 
     } else {
         console.log('couldnot ');
     }
 
     
 
 
 }
