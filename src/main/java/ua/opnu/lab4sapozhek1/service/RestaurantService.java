package ua.opnu.lab4sapozhek1.service;

import org.springframework.stereotype.Service;
import ua.opnu.lab4sapozhek1.dto.RestaurantRequestDto;
import ua.opnu.lab4sapozhek1.dto.RestaurantResponseDto;
import ua.opnu.lab4sapozhek1.exception.ResourceNotFoundException;
import ua.opnu.lab4sapozhek1.model.Restaurant;
import ua.opnu.lab4sapozhek1.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<RestaurantResponseDto> findAll() {
        return restaurantRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public RestaurantResponseDto findById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + id + " not found"));

        return toResponseDto(restaurant);
    }

    public RestaurantResponseDto create(RestaurantRequestDto dto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(dto.getName());
        restaurant.setCity(dto.getCity());
        restaurant.setAddress(dto.getAddress());
        restaurant.setRating(dto.getRating());

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return toResponseDto(savedRestaurant);
    }

    public RestaurantResponseDto update(Long id, RestaurantRequestDto dto) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + id + " not found"));

        restaurant.setName(dto.getName());
        restaurant.setCity(dto.getCity());
        restaurant.setAddress(dto.getAddress());
        restaurant.setRating(dto.getRating());

        Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
        return toResponseDto(updatedRestaurant);
    }

    public void deleteById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + id + " not found"));

        restaurantRepository.delete(restaurant);
    }

    private RestaurantResponseDto toResponseDto(Restaurant restaurant) {
        return new RestaurantResponseDto(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getCity(),
                restaurant.getAddress(),
                restaurant.getRating()
        );
    }
}