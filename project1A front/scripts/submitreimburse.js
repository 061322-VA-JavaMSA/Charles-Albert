let submitForm = document.createElement("submitForm")

let submitbtn = document.getElementById("submitbtn")
submitbtn.addEventListener('click', sumitReimburse);
let errorMsg1 = document.getElementById("noDescripError");
let errorMsg2 = document.getElementById("noAmountError");

async function submitReimburse(){

    let author = principal.firstName + " " + principal.lastName;
    let type = document.getElementById("type_id").value;
    let description =document.getElementById("amount").value;

    let current = new Date();
    let submitted = current.toLocaleDateString();

    let status = "pending";

    if (description == " "){
        errorMsg1.innerHTML = "You must enter a description.<br><br>";
    }

    if (amount == " ") {
        errorMsg2.innerHTML = "You must enter an amount.<br><br>";
    }
    else{

        const object = {description: `${description}`},
            author: `${author}`,
            amount: `${amount}`,
            type: `${type}`,
            submitted: `${submitted}`,
            status: `${status}`};


        let response = await fetch(`${apiUrl}/ReimbursementServlet`,{
            method: "Post",
            body: JSON.stringify(object)

        });

        if (response.status == 201){
            window.location.herf = "../veiws/submitsuccess.html";
        }
        else {
            console.log("Unable to submit reimbursement request.");
        }

    }



