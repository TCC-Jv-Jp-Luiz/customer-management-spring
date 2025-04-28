package br.edu.unipe.customer_management_spring.controller.customer;

import br.edu.unipe.customer_management_spring.domain.customer.Customer;
import br.edu.unipe.customer_management_spring.domain.customer.dto.CustomerInputDTO;

import br.edu.unipe.customer_management_spring.domain.customer.dto.CustomerOutputDTO;
import br.edu.unipe.customer_management_spring.domain.customer.dto.CustomerPaginationOutputDTO;
import br.edu.unipe.customer_management_spring.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerOutputDTO> createCustomer(@RequestBody @Valid CustomerInputDTO customerInputDTO) {
        Customer customer = customerService.save(customerInputDTO);

        return new ResponseEntity<CustomerOutputDTO>(new CustomerOutputDTO(customer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CustomerPaginationOutputDTO> listCustomers(@RequestParam(defaultValue = "0") Integer offset,
                                                                     @RequestParam(defaultValue = "10") Integer limit) {
        List<Customer> customerList = customerService.findAll(offset, limit);

        CustomerPaginationOutputDTO customerPaginationOutputDTO = new CustomerPaginationOutputDTO(
                limit,
                offset,
                customerService.count(),
                customerList
        );

        return new ResponseEntity<CustomerPaginationOutputDTO>(customerPaginationOutputDTO, HttpStatus.OK);
    }

    @PutMapping("/{publicId}")
    public ResponseEntity<CustomerOutputDTO> updateCustomer(@PathVariable String publicId, @RequestBody @Valid CustomerInputDTO customerInputDTO) {
        Customer customer = customerService.update(publicId, customerInputDTO);

        return new ResponseEntity<CustomerOutputDTO>(new CustomerOutputDTO(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{publicId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String publicId) {
        customerService.delete(publicId);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/{publicId}")
    public ResponseEntity<CustomerOutputDTO> getCustomerByPublicId(@PathVariable String publicId) {
        Customer customer = customerService.findByPublicId(publicId);

        return new ResponseEntity<CustomerOutputDTO>(new CustomerOutputDTO(customer), HttpStatus.OK);
    }

}
