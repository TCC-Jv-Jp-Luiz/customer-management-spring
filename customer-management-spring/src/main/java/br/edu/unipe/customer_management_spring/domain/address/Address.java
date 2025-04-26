package br.edu.unipe.customer_management_spring.domain.address;

import br.edu.unipe.customer_management_spring.domain.auditloginfo.AuditLogInfo;
import br.edu.unipe.customer_management_spring.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "public_id", unique = true, nullable = false)
    private String publicId;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "complement")
    private String complement;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "postalCode", nullable = false)
    private String postalCode;

    @OneToOne
    @JoinColumn(name = "audit_log_info_id")
    private AuditLogInfo auditLogInfo;
}
