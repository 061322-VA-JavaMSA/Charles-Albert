async function updateReimb(id) {

    let status = document.getElementById(`select${id}`).value;
    let resolver = principal.firstName + " " + principal.lastName;

    let current = new Date();
    let dateResolved = current.toLocaleDateString();

    const object = { id: `${id}`,
    status: `${status}`,
    resolver: `${resolver}`,
    resolved: `${resolved}`};

    let response = await fetch(`${apiUrl}/ReimbursementServlet`, {
        method: 'PUT',
        body: JSON.stringify(object)
    });

    if (response.status==200) {
        location.reload();
    }
}

