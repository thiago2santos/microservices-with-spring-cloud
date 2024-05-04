package guru.springframework.microserviceswithspringcloud.usecase.impl;

import guru.springframework.microserviceswithspringcloud.entrypoint.customer.CustomerDTO;
import guru.springframework.microserviceswithspringcloud.model.Customer;
import guru.springframework.microserviceswithspringcloud.usecase.CustomerCrudOperations;
import guru.springframework.microserviceswithspringcloud.utils.mappers.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerUsecaseImpl implements CustomerCrudOperations {

    @Autowired
    private final CustomerMapper customerMapper;

    public CustomerUsecaseImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO getById(UUID uuid) {
        log.info("executando getById");
        Customer customer = new Customer(uuid, "Thiago dos Santos");
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
        return customerDTO;
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        log.info("Criando um novo cliente.");
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setCustomerId(UUID.randomUUID());
        return customerMapper.customerToCustomerDTO(customer);
    }

    @Override
    public void update(CustomerDTO customerDTO) {
        log.info("Atualizando um cliente existente.");
        log.info("Customer {} updated. Id: {}", customerDTO.getName(), customerDTO.getCustomerId());
    }

    @Override
    public void delete(UUID uuid) {
        log.info("Customer deleted. Id: {}", uuid);
    }
}
