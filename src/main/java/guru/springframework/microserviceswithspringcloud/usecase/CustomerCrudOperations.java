package guru.springframework.microserviceswithspringcloud.usecase;

import guru.springframework.microserviceswithspringcloud.entrypoint.customer.CustomerDTO;

import java.util.List;
import java.util.UUID;

public interface CustomerCrudOperations {
    List<CustomerDTO> findAll();
    CustomerDTO getById(UUID uuid);
    CustomerDTO create(CustomerDTO customerDTO);
    void update(CustomerDTO customerDTO);
    void delete(UUID uuid);
}
