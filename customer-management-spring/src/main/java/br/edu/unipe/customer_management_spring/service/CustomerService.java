package br.edu.unipe.customer_management_spring.service;

import br.edu.unipe.customer_management_spring.domain.customer.Customer;
import br.edu.unipe.customer_management_spring.domain.customer.dto.CustomerInputDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer save(CustomerInputDTO customerInputDTO) {

        return new Customer();
    }
}
