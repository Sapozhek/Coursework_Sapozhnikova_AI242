package ua.opnu.lab4sapozhek1.dto;

import ua.opnu.lab4sapozhek1.model.ReservationStatus;

import java.time.LocalDateTime;

public class ReservationResponseDto {

    private Long id;
    private LocalDateTime reservationTime;
    private Integer guestsCount;
    private ReservationStatus status;
    private Long customerId;
    private Long restaurantId;
    private Long tableId;

    public ReservationResponseDto() {
    }

    public ReservationResponseDto(Long id, LocalDateTime reservationTime, Integer guestsCount,
                                  ReservationStatus status, Long customerId, Long restaurantId, Long tableId) {
        this.id = id;
        this.reservationTime = reservationTime;
        this.guestsCount = guestsCount;
        this.status = status;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.tableId = tableId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Integer getGuestsCount() {
        return guestsCount;
    }

    public void setGuestsCount(Integer guestsCount) {
        this.guestsCount = guestsCount;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }
}