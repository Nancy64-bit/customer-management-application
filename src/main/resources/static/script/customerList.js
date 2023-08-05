document.addEventListener("DOMContentLoaded", async function () {
  const customerTable = document.getElementById("customer-table");

  // Fetch and display customer data
  const response = await fetch("/customers", {
    headers: {
      Authorization: "Bearer your_token_here",
    },
  });

  if (response.ok) {
    const data = await response.json();
    const tbody = customerTable.querySelector("tbody");

    data.forEach((customer) => {
      const row = document.createElement("tr");
      row.innerHTML = `
    <td>${customer.firstName}</td>
    <td>${customer.lastName}</td>
    <td>${customer.email}</td>
    <td>${customer.phone}</td>
`;
      tbody.appendChild(row);
    });
  } else {
    // Handle error
  }
});

function redirectToAddCustomer() {
  window.location.href = "addCustomer.html"; // Replace with your actual URL
}
