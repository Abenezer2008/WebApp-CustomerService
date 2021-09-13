package webshop.service;

import webshop.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO add(CustomerDTO customerDTO);
    void remove(String id);
    CustomerDTO update(String id, CustomerDTO customerDTO);
    CustomerDTO getCustomer(String id);
    CustomerDTO getCustomerByEmail(String email);
}
