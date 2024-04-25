package guru.springframework.microserviceswithspringcloud.utils.mappers;

import guru.springframework.microserviceswithspringcloud.entrypoint.CustomerDTO;
import guru.springframework.microserviceswithspringcloud.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
