package br.edu.unipe.customer_management_spring.repository.customer;

import br.edu.unipe.customer_management_spring.domain.customer.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByPublicId(String publicId);
}
