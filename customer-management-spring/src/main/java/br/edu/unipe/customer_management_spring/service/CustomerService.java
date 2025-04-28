package br.edu.unipe.customer_management_spring.service;

import br.edu.unipe.customer_management_spring.domain.address.Address;
import br.edu.unipe.customer_management_spring.domain.address.dto.AddressInputDTO;
import br.edu.unipe.customer_management_spring.domain.auditloginfo.AuditLogInfo;
import br.edu.unipe.customer_management_spring.domain.customer.Customer;
import br.edu.unipe.customer_management_spring.domain.customer.dto.CustomerInputDTO;
import br.edu.unipe.customer_management_spring.enums.State;
import br.edu.unipe.customer_management_spring.errors.BusinessException;
import br.edu.unipe.customer_management_spring.errors.ResourceNotFoundException;
import br.edu.unipe.customer_management_spring.repository.customer.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer save(CustomerInputDTO customerInputDTO) {

        validateCustomer(null, customerInputDTO);
        
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

    public Customer update(String publicId, CustomerInputDTO customerInputDTO) {
        Customer customer = customerRepository.findByPublicId(publicId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

                validateCustomer(customer, customerInputDTO);

        customer.setName(customerInputDTO.getName());
        customer.setCellPhone(customerInputDTO.getCellPhone());
        customer.setEmail(customerInputDTO.getEmail());
        customer.setCpf(customerInputDTO.getCpf());
        customer.setBirthDate(customerInputDTO.getBirthDate());

        AddressInputDTO addressInputDTO = customerInputDTO.getAddress();
        Address address = customer.getAddress();
        address.setStreet(addressInputDTO.getStreet());
        address.setComplement(addressInputDTO.getComplement());
        address.setCity(addressInputDTO.getCity());
        address.setPostalCode(addressInputDTO.getPostalCode());
        address.setState(State.fromAbbreviation(addressInputDTO.getState()));

        customer.getAuditLogInfo().setUpdatedAt(LocalDateTime.now());
        address.getAuditLogInfo().setUpdatedAt(LocalDateTime.now());

        customer.setAddress(address);

        return customerRepository.save(customer);
    }

    public List<Customer> findAll(Integer offset, Integer limit) {
        if (offset < 0 || limit <= 0) {
            throw new BusinessException("Offset and limit must be greater than or equal to 0");
        }

        return customerRepository.findAllWithLimitAndOffset(offset, limit);
    }

    public Long count() {
        return customerRepository.count();
    }

    public Customer delete(String publicId) {
        Customer customer = customerRepository.findByPublicId(publicId).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        customerRepository.delete(customer);
        return customer;
    }

    public Customer findByPublicId(String publicId) {
        return customerRepository.findByPublicId(publicId).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    private void validateCustomer(Customer customer, CustomerInputDTO dto) {
        if (customerRepository.existsByEmail(dto.getEmail()) && (customer == null || !customer.getEmail().equals(dto.getEmail()))) {
            throw new BusinessException("Email already registered");
        }
        if (customerRepository.existsByCpf(dto.getCpf()) && (customer == null || !customer.getCpf().equals(dto.getCpf()))) {
            throw new BusinessException("CPF already registered");
        }
        if (customerRepository.existsByCellPhone(dto.getCellPhone()) && (customer == null || !customer.getCellPhone().equals(dto.getCellPhone()))) {
            throw new BusinessException("Cell phone already registered");
        }
    }
}
