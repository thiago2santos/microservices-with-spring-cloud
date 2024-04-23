package guru.springframework.microserviceswithspringcloud.entrypoint;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
