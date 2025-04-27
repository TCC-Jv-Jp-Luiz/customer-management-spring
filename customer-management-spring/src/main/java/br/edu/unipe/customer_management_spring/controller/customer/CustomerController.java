package br.edu.unipe.customer_management_spring.controller.customer;

import br.edu.unipe.customer_management_spring.domain.customer.Customer;
import br.edu.unipe.customer_management_spring.domain.customer.dto.CustomerInputDTO;

import br.edu.unipe.customer_management_spring.domain.customer.dto.CustomerOutputDTO;
import br.edu.unipe.customer_management_spring.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerOutputDTO> createCustomer(@RequestBody @Valid CustomerInputDTO customerInputDTO) {
        Customer customer = customerService.save(customerInputDTO);

        return new ResponseEntity<CustomerOutputDTO>(new CustomerOutputDTO(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{publicId}")
    public ResponseEntity<CustomerOutputDTO> updateCustomer(@PathVariable String publicId, @RequestBody @Valid CustomerInputDTO customerInputDTO) {
        Customer customer = customerService.update(publicId, customerInputDTO);

        return new ResponseEntity<CustomerOutputDTO>(new CustomerOutputDTO(customer), HttpStatus.OK);
    }
}
