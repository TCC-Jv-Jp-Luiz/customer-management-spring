package br.edu.unipe.customer_management_spring.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusinessError {

    private String code;

    private String message;
}
