package guru.springframework.microserviceswithspringcloud.entrypoint.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FindCustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Deve retornar os dados do cliente com sucesso.")
    public void findClientTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/customers/{uuid}", UUID.randomUUID().toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Deve retornar BadRequest se URI Variable ausente.")
    public void badRequestTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/customers/")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

}