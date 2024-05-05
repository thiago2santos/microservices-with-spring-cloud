package guru.springframework.microserviceswithspringcloud.usecase.impl;

import guru.springframework.microserviceswithspringcloud.entrypoint.customer.CustomerDTO;
import guru.springframework.microserviceswithspringcloud.model.Customer;
import guru.springframework.microserviceswithspringcloud.repository.CustomerRepository;
import guru.springframework.microserviceswithspringcloud.usecase.CustomerCrudOperations;
import guru.springframework.microserviceswithspringcloud.utils.mappers.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CustomerUsecaseImpl implements CustomerCrudOperations {
    private final CustomerMapper customerMapper;

    private final CustomerRepository customerRepository;

    public CustomerUsecaseImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customerMapper::customerToCustomerDTO).toList();
    }

    @Override
    public CustomerDTO getById(UUID uuid) {
        log.info("executando getById");
        Customer customer = customerRepository.getReferenceById(uuid);
        return customerMapper.customerToCustomerDTO(customer);
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        log.info("Criando um novo cliente.");
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(customer);
    }

    @Override
    public void update(CustomerDTO customerDTO) {
        log.info("Atualizando um cliente existente.");
        log.info("Customer {} updated. Id: {}", customerDTO.getName(), customerDTO.getCustomerId());
        customerRepository.updateNameByCustomerId(customerDTO.getName(), customerDTO.getCustomerId());
    }

    @Override
    public void delete(UUID uuid) {
        log.info("Customer deleted. Id: {}", uuid);
        Customer customer = customerRepository.getReferenceById(uuid);
        customerRepository.delete(customer);
    }
}
