package ua.opnu.lab4sapozhek1.dto;

import java.util.Set;

public class RestaurantTableResponseDto {

    private Long id;
    private String number;
    private Integer capacity;
    private Long restaurantId;
    private Set<Long> tableTypeIds;

    public RestaurantTableResponseDto() {
    }

    public RestaurantTableResponseDto(Long id, String number, Integer capacity, Long restaurantId, Set<Long> tableTypeIds) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.restaurantId = restaurantId;
        this.tableTypeIds = tableTypeIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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