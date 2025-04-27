package br.edu.unipe.customer_management_spring.domain.customer;

import java.time.LocalDate;
import br.edu.unipe.customer_management_spring.domain.address.Address;
import br.edu.unipe.customer_management_spring.domain.auditloginfo.AuditLogInfo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "public_id", unique = true, nullable = false)
    private String publicId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", unique = true, nullable = false)
    private String cellPhone;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "audit_log_info_id")
    private AuditLogInfo auditLogInfo;

    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "address_id")
    private Address address;

}
