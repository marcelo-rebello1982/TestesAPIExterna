package com.api.client;

import org.springframework.web.client.RestTemplate;


public class CustomerClient {

    RestTemplate restTemplate;

    public CustomerClient() {
        restTemplate = new RestTemplate();
    }


    public static void main(String[] args) {

        CustomerClient customerClient = new CustomerClient();


        //  System.out.println("Calling GET using ParameterizedTypeReference");
        // customerClient.getAllCustomerParameterized();

        //  System.out.println("Calling GET for entity using arrays");
        //   customerClient.getForEntityCustomerAsArray();

        //   System.out.println("Calling GET using wrapper class");
        //   customerClient.getAllCustomers();

        //  System.out.println("Calling POST using normal lists");
        //  employeeClient.createEmployeesUsingLists();

        //   System.out.println("Calling POST using wrapper class");
        //  employeeClient.createEmployeesUsingWrapperClass();
    }

//    public Customer[] getForEntityCustomerAsArray() {
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        ResponseEntity<Customer[]> response =
//                restTemplate.getForEntity(
//                        "https://run.mocky.io/v3/37946fab-4b1b-447c-8d63-7d8e9ccb57e6",
//                        Customer[].class);
//
//        Customer[] customers = response.getBody();
//        assert customers != null;
//        asList(customers).forEach(System.out::println);
//
//        return customers;
//
//    }


//    public List<CustomerDTO> getAllCustomerParameterized() {
//
//        ResponseEntity<List<CustomerDTO>> response =
//                restTemplate.exchange(
//                        "https://run.mocky.io/v3/37946fab-4b1b-447c-8d63-7d8e9ccb57e6",
//                        HttpMethod.GET,
//                        null,
//                        new ParameterizedTypeReference<List<CustomerDTO>>() {
//                        });
//        List<CustomerDTO> customers = response.getBody();
//        assert customers != null;
//        customers.forEach(System.out::println);
//        return customers;
//    }

//    public List<CustomerDTO> getAllCustomers() {
//
//        CustomerList response =
//                restTemplate.getForObject(
//                        "https://run.mocky.io/v3/37946fab-4b1b-447c-8d63-7d8e9ccb57e6",
//                        CustomerList.class);
//
//        List<CustomerDTO> customers = response.getCustomers();
//        customers.stream().forEach(customer -> System.out.println(" id : " + customer.getId() + " | name :  " + customer.getName() + " | city : " +  customer.getCity() + " | age : " + customer.getAge()));
//        return customers;
//    }

//    public void createCustomerUsingLists() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        List<Customer> newCustomer = new ArrayList<>();
//        newCustomer.add(new Customer(3, "Intern", "City",30));
//        newCustomer.add(new Customer(4, "CEO","City", 40));
//
//        restTemplate.postForObject(
//                "http://localhost:8080/spring-rest/customer/",
//                newCustomer,
//                ResponseEntity.class);
//    }

//    public void createCustomerUsingWrapperClass() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        List<Customer> newCustomers = new ArrayList<>();
//        newCustomers.add(new Customer(3, "Intern", "City", 10));
//        newCustomers.add(new Customer(4, "CEO", "City", 40));
//
//        restTemplate.postForObject(
//                "http://localhost:8080/spring-rest/customers/v2/",
//                new CustomerList(newCustomers),
//                ResponseEntity.class);
//    }
}