package br.edu.unipe.customer_management_spring.repository.customer;

import br.edu.unipe.customer_management_spring.domain.customer.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByPublicId(String publicId);

    @Query(value = "SELECT * FROM customer LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Customer> findAllWithLimitAndOffset(@Param("offset") int offset, @Param("limit") int limit);

    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    boolean existsByCellPhone(String cellPhone);
}
