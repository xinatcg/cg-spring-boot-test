package co.creativegaming.java.recruiting.cgspringboottest.task2.domain;

import lombok.Data;

import java.util.Set;

@Data
public class Trip {
    private Driver driver;
    private Set<Passenger> passengers;
    private Integer duration;
    private Double distance;
    private Double discount;

    public Double cost() {
        if (discount == null) {
            discount = 0.0D;
        }
        return (1 - discount) * (this.duration + this.distance);
    }
}
