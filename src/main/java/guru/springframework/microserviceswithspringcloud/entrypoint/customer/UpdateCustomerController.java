package guru.springframework.microserviceswithspringcloud.entrypoint.customer;

import guru.springframework.microserviceswithspringcloud.usecase.CustomerCrudOperations;
import guru.springframework.microserviceswithspringcloud.usecase.impl.CustomerUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Validated
@RestController
@Tag(name = "Customer")
@RequestMapping("/api/v1")
public class UpdateCustomerController {

    private final CustomerCrudOperations customerService;

    public UpdateCustomerController(CustomerUsecaseImpl customerService) {
        this.customerService = customerService;
    }

    @PutMapping("/customers/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody @Valid CustomerDTO customerDTO, @PathVariable("uuid") UUID uuid) {
        customerDTO.setUuid(uuid);
        customerService.update(customerDTO);
    }

}
