package ua.opnu.lab4sapozhek1.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class RestaurantTableRequestDto {

    @NotBlank(message = "Table number must not be blank")
    private String number;

    @NotNull(message = "Capacity must not be null")
    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    @NotNull(message = "Restaurant id must not be null")
    private Long restaurantId;

    @NotEmpty(message = "Table type ids must not be empty")
    private Set<Long> tableTypeIds;

    public RestaurantTableRequestDto() {
    }

    public RestaurantTableRequestDto(String number, Integer capacity, Long restaurantId, Set<Long> tableTypeIds) {
        this.number = number;
        this.capacity = capacity;
        this.restaurantId = restaurantId;
        this.tableTypeIds = tableTypeIds;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Set<Long> getTableTypeIds() {
        return tableTypeIds;
    }

    public void setTableTypeIds(Set<Long> tableTypeIds) {
        this.tableTypeIds = tableTypeIds;
    }
}