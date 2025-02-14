package com.ssnc.mapper;

import com.ssnc.dto.CustomerDto;
import com.ssnc.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer  mapCustomerDtoToCustomer(CustomerDto customerDto);

    CustomerDto mapCustomerToCustomerDto(Customer customer);
}
