document.getElementById('addCustomerForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;

    // Extract other form fields and build the request body

    const apiUrl = 'https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=create';

    try {
        const response = await fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Authorization': 'Bearer YOUR_BEARER_TOKEN',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                "first_name": firstName,
                "last_name": lastName,
                // Add other customer details to the request body
            })
        });

        if (response.ok) {
            // Successfully created
            // Redirect to customer list or perform other actions
        } else {
            console.error('Failed to create customer');
            // Display an error message to the user
        }
    } catch (error) {
        console.error('An error occurred:', error);
    }
});
