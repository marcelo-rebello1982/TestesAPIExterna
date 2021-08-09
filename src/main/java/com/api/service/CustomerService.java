package com.api.service;

import com.api.dto.CustomerDTO;
import com.api.dto.CustomerList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerService {



  private RestTemplate restTemplate;

    @Value("${customersUrl}")
    private String BASE_URL;

    public CustomerService() {
       restTemplate = new RestTemplate();
    }

    public List<CustomerDTO> getAllCustomersV1() {

        CustomerList response =
                restTemplate.getForObject(BASE_URL
                        ,
                        CustomerList.class);

        List<CustomerDTO> customers = response.getCustomers();
        customers.sort(Comparator.comparing(CustomerDTO::getName));
        return customers;
        //customers.stream().forEach(customer -> System.out.println(" id : " + customer.getId() + " | name :  " + customer.getName() + " | city : " +  customer.getCity() + " | age : " + customer.getAge()));
    }

    public List<CustomerDTO> getAllCustomerParameterizedV2() {

        ResponseEntity<CustomerList> responseEntity = new RestTemplate().exchange(
                BASE_URL, HttpMethod.GET, null,CustomerList.class);

        List<CustomerDTO> customerListDTO = responseEntity
                .getBody()
                .getCustomers()
                .stream()
                .filter(customerDTO -> customerDTO.getAge() > 65).collect(Collectors.toList());
        return customerListDTO;
    }

    public List<CustomerDTO> getAllCustomerParameterizedV3() {

        ResponseEntity<List<CustomerDTO>> response =
                restTemplate.exchange(
                        BASE_URL,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<CustomerDTO>>() {
                        });
        List<CustomerDTO> customers = response.getBody();
        assert customers != null;
        customers.forEach(System.out::println);
        return customers;
    }

    public CustomerDTO[] getForCustomerAsArrayV4() {
        ResponseEntity<CustomerDTO[]> response = restTemplate.getForEntity(BASE_URL,CustomerDTO[].class);
        CustomerDTO[] customers = response.getBody();
        return customers;
    }

    public List<CustomerDTO> getAllCustomerParameterizedV5() {

        ResponseEntity<CustomerList> responseEntity = new RestTemplate().exchange(
                BASE_URL, HttpMethod.GET, null,CustomerList.class);

        List<CustomerDTO> customerListDTO = responseEntity
                .getBody()
                .getCustomers()
                .stream()
                .filter(customerDTO -> customerDTO.getAge() > 65).collect(Collectors.toList());
        return customerListDTO;
    }


    public List<CustomerDTO> getAllCustomers2() {
        List<CustomerDTO> customers = new ArrayList<>();
        customers.add(new CustomerDTO(1, "name", "city", 10));
        customers.add(new CustomerDTO(2, "name 2", "city", 20));
        return customers;
    }

    public void addCustomers(List<CustomerDTO> customers) {
        customers.forEach(e -> System.out.println("Adding new customers" + e));
    }
}