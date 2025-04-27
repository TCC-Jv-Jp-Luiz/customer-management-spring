package br.edu.unipe.customer_management_spring.service;

import br.edu.unipe.customer_management_spring.domain.address.Address;
import br.edu.unipe.customer_management_spring.domain.address.dto.AddressInputDTO;
import br.edu.unipe.customer_management_spring.domain.auditloginfo.AuditLogInfo;
import br.edu.unipe.customer_management_spring.domain.customer.Customer;
import br.edu.unipe.customer_management_spring.domain.customer.dto.CustomerInputDTO;
import br.edu.unipe.customer_management_spring.enums.State;
import br.edu.unipe.customer_management_spring.repository.CustomerRepository;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(CustomerInputDTO customerInputDTO) {
        Customer customer = new Customer();
        customer.setPublicId(UUID.randomUUID().toString());
        customer.setName(customerInputDTO.getName());
        customer.setCellPhone(customerInputDTO.getCellPhone());
        customer.setEmail(customerInputDTO.getEmail());
        customer.setCpf(customerInputDTO.getCpf());
        customer.setBirthDate(customerInputDTO.getBirthDate());

        AddressInputDTO addressInputDTO = customerInputDTO.getAddress();
        Address address = new Address();
        address.setPublicId(UUID.randomUUID().toString());
        address.setStreet(addressInputDTO.getStreet());
        address.setComplement(addressInputDTO.getComplement());
        address.setCity(addressInputDTO.getCity());
        address.setPostalCode(addressInputDTO.getPostalCode());
        address.setState(State.fromAbbreviation(addressInputDTO.getState()));

        customer.setAuditLogInfo(new AuditLogInfo());
        address.setAuditLogInfo(new AuditLogInfo());

        customer.setAddress(address);

        return customerRepository.save(customer);
    }
}
