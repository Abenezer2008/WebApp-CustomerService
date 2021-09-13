package webshop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webshop.domain.Customer;
import webshop.dto.CustomerAdapter;
import webshop.dto.CustomerDTO;
import webshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class.getName());

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO add(CustomerDTO customerDTO) {
        logger.info("Calling add");
        Customer customer = CustomerAdapter.fromDTO(customerDTO);
        customerRepository.save(customer);
        logger.info("Adding Customer");
        return CustomerAdapter.toDTO(customer);
    }

    @Override
    public void remove(String id) {
        logger.info("Calling remove");
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDTO update(String id, CustomerDTO customerDTO) {
        logger.info("Calling update");
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()){
            Customer customer = CustomerAdapter.fromDTO(customerDTO);
            customerRepository.save(customer);
            logger.info("Updating customer");
            return CustomerAdapter.toDTO(customer);
        }
        logger.error("Update customer with invalid id");
        return null;
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        logger.info("Calling get customer");
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()){
            logger.info("Getting customer");
            return CustomerAdapter.toDTO(customerOptional.get());
        }
        logger.error("Get customer with invalid id");
        return null;
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        return null;
    }
}
