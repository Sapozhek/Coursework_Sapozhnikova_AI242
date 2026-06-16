package ua.opnu.lab4sapozhek1.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime reservationTime;
    private Integer guestsCount;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private RestaurantTable table;

    public Reservation() {
    }

    public Reservation(Long id, LocalDateTime reservationTime, Integer guestsCount, ReservationStatus status) {
        this.id = id;
        this.reservationTime = reservationTime;
        this.guestsCount = guestsCount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public Integer getGuestsCount() {
        return guestsCount;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public RestaurantTable getTable() {
        return table;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public void setGuestsCount(Integer guestsCount) {
        this.guestsCount = guestsCount;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setTable(RestaurantTable table) {
        this.table = table;
    }
}