package guru.springframework.microserviceswithspringcloud.usecase.impl;

import guru.springframework.microserviceswithspringcloud.model.CustomerDTO;
import guru.springframework.microserviceswithspringcloud.usecase.CustomerCrudOperations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerUsecaseImpl implements CustomerCrudOperations {
    @Override
    public CustomerDTO getById(UUID uuid) {
        CustomerDTO customer = new CustomerDTO(uuid, "Thiago dos Santos");
        return customer;
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        CustomerDTO customer = customerDTO;
        customer.setUuid(UUID.randomUUID());
        return customer;
    }

    @Override
    public void update(CustomerDTO customerDTO) {
        log.info("Customer {} updated. Id: {}", customerDTO.getName(), customerDTO.getUuid());
    }

    @Override
    public void delete(UUID uuid) {
        log.info("Customer deleted. Id: {}", uuid);
    }
}
