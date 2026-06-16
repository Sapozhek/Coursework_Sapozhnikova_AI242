package ua.opnu.lab4sapozhek1.repository;

import ua.opnu.lab4sapozhek1.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}