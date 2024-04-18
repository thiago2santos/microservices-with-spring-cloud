package guru.springframework.microserviceswithspringcloud.entrypoint;

import guru.springframework.microserviceswithspringcloud.model.CustomerDTO;
import guru.springframework.microserviceswithspringcloud.usecase.CustomerCrudOperations;
import guru.springframework.microserviceswithspringcloud.usecase.impl.CustomerUsecaseImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1")
@RestController
public class CustomerController {

    private final CustomerCrudOperations customerService;


    public CustomerController(CustomerUsecaseImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/{uuid}")
    public ResponseEntity<CustomerDTO> getById(@PathVariable("uuid") UUID uuid) {
        CustomerDTO customer = customerService.getById(uuid);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/customers")
    public ResponseEntity create(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.create(customerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", String.format("/api/v1/customers/%s", createdCustomer.getUuid()));
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/customers/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody CustomerDTO customerDTO, @PathVariable("uuid") UUID uuid) {
        customerDTO.setUuid(uuid);
        customerService.update(customerDTO);
    }

    @DeleteMapping("/customers/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("uuid") UUID uuid) {
        customerService.delete(uuid);
    }

}
