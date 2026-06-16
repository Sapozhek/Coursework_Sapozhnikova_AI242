package ua.opnu.lab4sapozhek1.repository;

import ua.opnu.lab4sapozhek1.model.Restaurant;
import ua.opnu.lab4sapozhek1.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
    List<RestaurantTable> findByRestaurant(Restaurant restaurant);
}