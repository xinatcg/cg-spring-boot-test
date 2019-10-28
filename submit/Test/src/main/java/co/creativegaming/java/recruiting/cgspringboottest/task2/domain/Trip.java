package co.creativegaming.java.recruiting.cgspringboottest.task2.domain;

import lombok.Data;

import java.util.Set;

@Data
public class Trip {
    private Driver driver;
	private Integer duration;
	private Double distance;
    private Double discount;
    private Set<Passenger> passengers;
    
    public Trip(Driver driver,Integer duration,Double distance,Double discount,Set<Passenger> passengers) {
    	this.driver=driver;
    	this.duration=duration;
    	this.distance=distance;
    	this.discount=discount;
    	this.passengers=passengers;
    			
    }

    public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double cost() {
        if (discount == null) {
            discount = 0.0D;
        }
        return (1 - discount) * (this.duration + this.distance);
    }
	
	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	
    public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	public Integer getDuration() {
			return duration;
	}

	public void setDuration(Integer duration) {
			this.duration = duration;
	}

}
