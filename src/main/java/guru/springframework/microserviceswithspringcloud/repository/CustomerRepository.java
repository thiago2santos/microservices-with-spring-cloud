package guru.springframework.microserviceswithspringcloud.repository;

import guru.springframework.microserviceswithspringcloud.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
