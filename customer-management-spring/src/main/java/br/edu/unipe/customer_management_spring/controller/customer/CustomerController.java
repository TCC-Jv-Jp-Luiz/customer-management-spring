package br.edu.unipe.customer_management_spring.controller.customer;

import br.edu.unipe.customer_management_spring.domain.customer.dto.CustomerInputDTO;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerInputDTO customerInputDTO) {
        return ResponseEntity.ok("Customer created successfully");
    }
}
