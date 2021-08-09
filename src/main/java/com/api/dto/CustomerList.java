package com.api.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data @Getter @Setter
public class CustomerList {

    public List<CustomerDTO> customers;

    public CustomerList() {
        customers = new ArrayList<>();
    }

    public CustomerList(List<CustomerDTO> customers) {
        this.customers = customers;
    }
}