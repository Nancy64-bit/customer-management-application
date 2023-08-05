package com.sunbasedata.customermanagement.customermanagementapp.model;

import lombok.Data;

@Data
public class Customer {
    private String uuid; // Add this line for UUID
    private String firstName;
    private String lastName;
    private String street;
    private String address;
    private String city;
    private String state;
    private String email;
    private String phone;
}
