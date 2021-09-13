package webshop.dto;

import webshop.domain.Address;
import webshop.domain.Contact;
import webshop.domain.Customer;

public class CustomerAdapter {
    public static CustomerDTO toDTO(Customer customer){
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getFirstName(), customer.getLastName(),
                customer.getContact().getPhone(),customer.getContact().getEmail(),
                customer.getAddress().getStreet(),customer.getAddress().getCity(),customer.getAddress().getZip()
        );
    }
    public static Customer fromDTO(CustomerDTO customerDTO){
        return new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getFirstName(), customerDTO.getLastName(),
                new Contact(customerDTO.getPhone(), customerDTO.getEmail()),
                new Address(customerDTO.getStreet(), customerDTO.getCity(), customerDTO.getZip())
        );
    }
}
