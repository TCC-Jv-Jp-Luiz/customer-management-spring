package br.edu.unipe.customer_management_spring.errors;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final BusinessError error;

    public BusinessException(String errorMessage) {
        super(errorMessage);
        this.error = new BusinessError("invalid_action", errorMessage);
    }

}
