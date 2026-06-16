package ua.opnu.lab4sapozhek1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "DTO для створення або оновлення ресторану")
public class RestaurantRequestDto {

    @Schema(description = "Назва ресторану", example = "Pizza House")
    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 150, message = "Name must be between 2 and 150 characters")
    private String name;

    @Schema(description = "Місто", example = "Одеса")
    @NotBlank(message = "City must not be blank")
    @Size(min = 2, max = 100, message = "City must be between 2 and 100 characters")
    private String city;

    @Schema(description = "Адреса", example = "вул. Дерибасівська, 10")
    @NotBlank(message = "Address must not be blank")
    @Size(min = 5, max = 255, message = "Address must be between 5 and 255 characters")
    private String address;

    @Schema(description = "Рейтинг", example = "4.7")
    @NotNull(message = "Rating must not be null")
    @DecimalMin(value = "0.0", message = "Rating must be at least 0")
    @DecimalMax(value = "5.0", message = "Rating must be at most 5")
    private Double rating;

    public RestaurantRequestDto() {
    }

    public RestaurantRequestDto(String name, String city, String address, Double rating) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
