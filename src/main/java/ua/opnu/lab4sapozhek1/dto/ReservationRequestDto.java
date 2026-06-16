package ua.opnu.lab4sapozhek1.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import ua.opnu.lab4sapozhek1.model.ReservationStatus;

import java.time.LocalDateTime;

public class ReservationRequestDto {

    @NotNull(message = "Reservation time must not be null")
    @Future(message = "Reservation time must be in the future")
    private LocalDateTime reservationTime;

    @NotNull(message = "Guests count must not be null")
    @Min(value = 1, message = "Guests count must be at least 1")
    private Integer guestsCount;

    @NotNull(message = "Status must not be null")
    private ReservationStatus status;

    @NotNull(message = "Customer id must not be null")
    private Long customerId;

    @NotNull(message = "Restaurant id must not be null")
    private Long restaurantId;

    @NotNull(message = "Table id must not be null")
    private Long tableId;

    public ReservationRequestDto() {
    }

    public ReservationRequestDto(LocalDateTime reservationTime, Integer guestsCount, ReservationStatus status,
                                 Long customerId, Long restaurantId, Long tableId) {
        this.reservationTime = reservationTime;
        this.guestsCount = guestsCount;
        this.status = status;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.tableId = tableId;
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