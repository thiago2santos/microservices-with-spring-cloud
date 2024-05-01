package guru.springframework.microserviceswithspringcloud.entrypoint.customer;

import guru.springframework.microserviceswithspringcloud.usecase.CustomerCrudOperations;
import guru.springframework.microserviceswithspringcloud.usecase.impl.CustomerUsecaseImpl;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Validated
@RestController
@NoArgsConstructor(force = true)
@RequestMapping("/api/v1")
public class FindCustomerController {

    private final CustomerCrudOperations customerService;

    public FindCustomerController(CustomerUsecaseImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = {"/customers/{uuid}", "/customers/"})
    public ResponseEntity<CustomerDTO> getById(@PathVariable("uuid") @NotNull UUID uuid) {
        CustomerDTO customer = customerService.getById(uuid);
        return ResponseEntity.ok(customer);
    }

}
