package ua.opnu.lab4sapozhek1.repository;

import ua.opnu.lab4sapozhek1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}