package br.edu.unipe.customer_management_spring.domain.address.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddressInputDTO {

    @NotBlank(message = "Street is required")
    private String street;

    private String complement;

    @NotBlank(message = "City is required")
    private String city;

    @NotNull(message = "State is required")
    private String state;

    @NotBlank(message = "Postal code is required")
    private String postalCode;
}
