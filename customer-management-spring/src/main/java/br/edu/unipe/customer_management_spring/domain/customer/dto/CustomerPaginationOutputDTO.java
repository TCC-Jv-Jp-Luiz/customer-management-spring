package br.edu.unipe.customer_management_spring.domain.customer.dto;

import br.edu.unipe.customer_management_spring.domain.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class CustomerPaginationOutputDTO {

    private final Integer limit;

    private final Integer offset;

    private final Long totalCount;

    private final List<CustomerOutputDTO> data;

    public CustomerPaginationOutputDTO(Integer limit, Integer offset, Long totalCount ,List<Customer> customerList) {
        this.limit = limit;
        this.offset = offset;
        this.totalCount = totalCount;
        this.data = customerList.stream().map(CustomerOutputDTO::new).toList();
    }
}
