package ua.opnu.lab4sapozhek1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurant_tables")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reservation> reservations = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "restaurant_table_types",
            joinColumns = @JoinColumn(name = "table_id"),
            inverseJoinColumns = @JoinColumn(name = "table_type_id")
    )
    private Set<TableType> tableTypes = new HashSet<>();

    public RestaurantTable() {
    }

    public RestaurantTable(Long id, String number, Integer capacity) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Set<TableType> getTableTypes() {
        return tableTypes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
