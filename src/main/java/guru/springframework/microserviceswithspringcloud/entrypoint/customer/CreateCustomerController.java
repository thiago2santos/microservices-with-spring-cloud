package guru.springframework.microserviceswithspringcloud.entrypoint.customer;

import guru.springframework.microserviceswithspringcloud.usecase.CustomerCrudOperations;
import guru.springframework.microserviceswithspringcloud.usecase.impl.CustomerUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@Tag(name = "Customer")
@RequestMapping("/api/v1")
public class CreateCustomerController {

    private final CustomerCrudOperations customerService;

    public CreateCustomerController(CustomerUsecaseImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerDTO> create(@RequestBody @Valid CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.create(customerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", String.format("/api/v1/customers/%s", createdCustomer.getUuid()));
        return new ResponseEntity<>(createdCustomer, headers, HttpStatus.CREATED);
    }

}
