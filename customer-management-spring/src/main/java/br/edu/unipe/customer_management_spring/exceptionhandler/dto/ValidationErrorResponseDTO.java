package br.edu.unipe.customer_management_spring.exceptionhandler.dto;

import br.edu.unipe.customer_management_spring.errors.BusinessError;
import br.edu.unipe.customer_management_spring.errors.BusinessException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationErrorResponseDTO {

    private final List<BusinessError> errors = new ArrayList<>();

    public void addError(String code, String message) {
        this.errors.add(new BusinessError(code, message));
    }

    public void addError(BusinessException businessException) {
        this.errors.add(businessException.getError());
    }
}
