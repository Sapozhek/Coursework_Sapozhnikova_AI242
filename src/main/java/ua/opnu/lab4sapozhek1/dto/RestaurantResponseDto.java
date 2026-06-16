package ua.opnu.lab4sapozhek1.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO відповіді з даними ресторану")
public class RestaurantResponseDto {

    @Schema(description = "ID ресторану", example = "1")
    private Long id;

    @Schema(description = "Назва ресторану", example = "Pizza House")
    private String name;

    @Schema(description = "Місто", example = "Одеса")
    private String city;

    @Schema(description = "Адреса", example = "вул. Дерибасівська, 10")
    private String address;

    @Schema(description = "Рейтинг", example = "4.7")
    private Double rating;

    public RestaurantResponseDto() {
    }

    public RestaurantResponseDto(Long id, String name, String city, String address, Double rating) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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