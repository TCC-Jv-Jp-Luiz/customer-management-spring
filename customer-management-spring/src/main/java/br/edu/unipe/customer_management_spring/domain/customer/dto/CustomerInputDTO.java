package br.edu.unipe.customer_management_spring.domain.customer.dto;


import br.edu.unipe.customer_management_spring.domain.address.dto.AddressInputDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
@AllArgsConstructor
@Data
public class CustomerInputDTO {

    @NotBlank(message = "name is required")
    private String name;

    @Pattern(regexp = "^\\+\\d{1,3} \\d{2} \\d{4,5}-\\d{4}$")
    @NotBlank(message = "'cellPhone' invalid or not provided")
    private String cellPhone;

    @Email(message = "Invalid email format")
    @NotBlank(message = "email is required")
    private String email;

    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "Invalid CPF format")
    @NotBlank(message = "cpf is required")
    private String cpf;

    @Past(message = "birthDate must be in the past")
    @NotNull(message = "birthDate is required")
    private LocalDate birthDate;

    @Valid
    @NotNull(message = "address is required")
    private AddressInputDTO address;
}
