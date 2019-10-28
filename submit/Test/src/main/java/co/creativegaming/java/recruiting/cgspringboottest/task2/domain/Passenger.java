package co.creativegaming.java.recruiting.cgspringboottest.task2.domain;

import lombok.Data;

@Data
public class Passenger {
    private String name;
    
    public Passenger(String name) {
    	this.name=name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
