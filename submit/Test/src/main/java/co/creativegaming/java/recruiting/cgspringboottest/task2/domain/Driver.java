package co.creativegaming.java.recruiting.cgspringboottest.task2.domain;

import lombok.Data;

@Data
public class Driver {
    private String driver;

    public Driver(String driver) {
    	this.driver=driver;
    }

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
}
