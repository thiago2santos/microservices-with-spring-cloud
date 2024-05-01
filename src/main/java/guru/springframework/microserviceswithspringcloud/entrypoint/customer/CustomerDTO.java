package guru.springframework.microserviceswithspringcloud.entrypoint.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    @JsonProperty(value = "id")
    private UUID uuid;
    @NotNull
    @Size(min = 3, max = 100)
    private String name;
}
