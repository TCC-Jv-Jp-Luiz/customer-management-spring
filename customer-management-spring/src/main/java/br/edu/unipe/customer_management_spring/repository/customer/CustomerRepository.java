package br.edu.unipe.customer_management_spring.repository.customer;

import br.edu.unipe.customer_management_spring.domain.customer.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
