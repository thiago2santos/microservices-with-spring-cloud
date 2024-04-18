package guru.springframework.microserviceswithspringcloud.usecase;

import guru.springframework.microserviceswithspringcloud.model.CustomerDTO;

import java.util.UUID;

public interface CustomerCrudOperations {
    CustomerDTO getById(UUID uuid);
    CustomerDTO create(CustomerDTO customerDTO);
    void update(CustomerDTO customerDTO);
    void delete(UUID uuid);
}
