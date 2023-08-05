document.getElementById('loginForm').addEventListener('submit', async function(event) {
  event.preventDefault();

  const loginId = document.getElementById('loginId').value;
  const password = document.getElementById('password').value;

  const apiUrl = 'https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp';

  const response = await fetch(apiUrl, {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify({
          login_id: loginId,
          password: password
      })
  });

  if (response.ok) {
      const data = await response.json();
      const token = data.token; // Assuming the API returns a JSON object with a 'token' field
      // Store the token securely (e.g., in a cookie or session storage) for future API calls
      // Redirect to the customer list page or perform other actions
  } else {
      console.error('Authentication failed');
      // Display an error message to the user
  }
});
