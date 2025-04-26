package br.edu.unipe.customer_management_spring.domain.customer.dto;

import br.edu.unipe.customer_management_spring.domain.address.Address;
import br.edu.unipe.customer_management_spring.domain.address.dto.AddressOutputDTO;
import br.edu.unipe.customer_management_spring.domain.auditloginfo.dto.AuditLogInfoOutputDTO;
import br.edu.unipe.customer_management_spring.domain.customer.Customer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerOutputDTO {

    private String id;
    private String name;
    private String cellPhone;
    private String email;
    private String cpf;
    private LocalDate birthDate;
    private AddressOutputDTO address;
    private AuditLogInfoOutputDTO auditInfo;

    public CustomerOutputDTO(Customer customer) {
        this.id = customer.getPublicId();
        this.name = customer.getName();
        this.cellPhone = customer.getCellPhone();
        this.email = customer.getEmail();
        this.cpf = customer.getCpf();
        this.birthDate = customer.getBirthDate();
        this.address = new AddressOutputDTO(customer.getAddress());
        this.auditInfo = new AuditLogInfoOutputDTO(customer.getAuditLogInfo());
    }

}
