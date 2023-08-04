package controller;

import org.springframework.web.bind.annotation.*;

import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customerList = new ArrayList<>(); // In-memory data store

    @PostMapping
    public String createCustomer(@RequestBody Customer customer) {
        customer.setUuid(UUID.randomUUID().toString()); // Generate a unique UUID for the customer
        customerList.add(customer);
        return "Customer created successfully";
    }

    @GetMapping
    public List<Customer> getCustomerList() {
        return customerList;
    }

    @PostMapping("/{uuid}")
    public String updateCustomer(@PathVariable String uuid, @RequestBody Customer updatedCustomer) {
        for (Customer customer : customerList) {
            if (customer.getUuid().equals(uuid)) {
                // Update customer data
                customer.setFirstName(updatedCustomer.getFirstName());
                customer.setLastName(updatedCustomer.getLastName());
                customer.setStreet(updatedCustomer.getStreet());
                customer.setAddress(updatedCustomer.getAddress());
                customer.setCity(updatedCustomer.getCity());
                customer.setState(updatedCustomer.getState());
                customer.setEmail(updatedCustomer.getEmail());
                customer.setPhone(updatedCustomer.getPhone());
                return "Customer updated successfully";
            }
        }
        return "Customer not found";
    }

    @DeleteMapping("/{uuid}")
    public String deleteCustomer(@PathVariable String uuid) {
        Customer customerToRemove = null;
        for (Customer customer : customerList) {
            if (customer.getUuid().equals(uuid)) {
                customerToRemove = customer;
                break;
            }
        }
        if (customerToRemove != null) {
            customerList.remove(customerToRemove);
            return "Customer deleted successfully";
        } else {
            return "Customer not found";
        }
    }
}
