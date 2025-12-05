package br.edu.unipe.customer_management_spring.domain.address.dto;

import br.edu.unipe.customer_management_spring.domain.address.Address;
import br.edu.unipe.customer_management_spring.enums.State;
import lombok.Data;

@Data
public class AddressOutputDTO {

    private String street;
    private String complement;
    private String city;
    private State state;
    private String postalCode;

    public AddressOutputDTO(Address address) {
        this.street = address.getStreet();
        this.complement = address.getComplement();
        this.city = address.getCity();
        this.state = address.getState();
        this.postalCode = address.getPostalCode();
    }
}
