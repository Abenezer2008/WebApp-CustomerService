package webshop.controller;

import webshop.dto.CustomerDTO;
import webshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customerDTO1 = customerService.add(customerDTO);
        return new ResponseEntity<>(customerDTO1, HttpStatus.OK);
    }

    @PutMapping("/customers/{customerId}")
    public ResponseEntity<?> updateCustomer(@PathVariable String customerId,@RequestBody CustomerDTO customerDTO){
        CustomerDTO customerDTO1 = customerService.update(customerId,customerDTO);
        return new ResponseEntity<>(customerDTO1,HttpStatus.OK);
    }

    @DeleteMapping("customers/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String customerId){
        customerService.remove(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT,HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<?> getCustomer(@PathVariable String customerId){
        CustomerDTO customerDTO = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customerDTO,HttpStatus.OK);
    }
}
