package br.edu.unipe.customer_management_spring.repository;

import br.edu.unipe.customer_management_spring.domain.customer.Customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByPublicId(String publicId);
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByCpf(String cpf);
    Optional<Customer> findByCellPhone(String cellPhone);
    Optional<Customer> findByName(String name);
    
}