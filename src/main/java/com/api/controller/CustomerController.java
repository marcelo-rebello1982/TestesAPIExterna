package com.api.controller;

import com.api.dto.CustomerDTO;
import com.api.dto.CustomerList;
import com.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, path = "/getAll/v1")
    public List<CustomerDTO> getAllCustomersV1() {
        return customerService.getAllCustomersV1();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAll/v2")
    public CustomerList getAllCustomerParameterizedV2() {
        List<CustomerDTO> customersDTO = customerService.getAllCustomerParameterizedV2();
        return new CustomerList(customersDTO);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAll/v3")
    public CustomerList getAllCustomerParameterizedV3() {
        List<CustomerDTO> customers = customerService.getAllCustomerParameterizedV3();
        return new CustomerList(customers);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAll/v4")
    public CustomerDTO[] getForCustomerAsArrayV4() {
        CustomerDTO[] customersDTO = customerService.getForCustomerAsArrayV4();
        return  customersDTO;
    }



    @RequestMapping(method = RequestMethod.POST, path = "/add/v1")
    public void addCustomers(@RequestBody List<CustomerDTO> customers) {
        customerService.addCustomers(customers);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add/v2")
    public void addCustomer(@RequestBody CustomerList customer) {
        customerService.addCustomers(customer.getCustomers());
    }
}