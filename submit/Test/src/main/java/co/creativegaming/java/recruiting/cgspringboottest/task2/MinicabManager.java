package co.creativegaming.java.recruiting.cgspringboottest.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import co.creativegaming.java.recruiting.cgspringboottest.task2.domain.Driver;
import co.creativegaming.java.recruiting.cgspringboottest.task2.domain.Passenger;
import co.creativegaming.java.recruiting.cgspringboottest.task2.domain.Trip;
public class MinicabManager {
    public static Set<Driver> allDrivers;
    public static Set<Passenger> allPassengers;
    public static List<Trip> trips;

    public static Set<Driver> findFakeDrivers() {
        // TODO
    	Set<Driver> result = new HashSet<Driver>();
    	Iterator<Driver> it = allDrivers.iterator();
    	while(it.hasNext()) {
    		Driver temp = it.next();
    		boolean check=false;
    		for(int i=0;i<trips.size();i++) {
    			if(trips.get(i).getDriver().getDriver().equals(temp.getDriver())) {
    				check=true;
    			}
    		}
    		if(check==false) {
    			result.add(temp);
    		}
    	}
    	
    	
        return result;
    }

    public static Set<Passenger> findFaithfulPassengers(int minTrips) {
        // TODO
    	//iterates the "allpassengers" set, under the iterations, iterate each element of "trip" list
    	//find out the passenger had this "trip" element;
    	// if so count++, and after finish the iteration of the trip list, 
    	// if the count is greater than or equal to the given argument, add this passenger to the created set
    	// the created set will return as result.
    	Set <Passenger> result = new HashSet<Passenger>();
    	Iterator <Passenger> it = allPassengers.iterator();
    	
    	while(it.hasNext()) {
    		int count=0;
    		Passenger temp = it.next();
    		//iterates the trip list;
    		for(int i=0;i<trips.size();i++) {
    			Iterator<Passenger> its2 = trips.get(i).getPassengers().iterator();
    			while(its2.hasNext()) {
    				Passenger temp2 = its2.next();
    				if(temp2.getName().equals(temp.getName())) {
    					count++;
    				}
    			}
    		}
    		//System.out.println(count);
    		//after iteration of trip list
    		if(count>=minTrips) {
    			//System.out.println(temp.getName());
    			result.add(temp);
    		}
    		
    	}
        return result;
    }

    public static Set<Passenger> findFrequentPassengers(Driver driver) {
        // TODO
    	
    	//Iterate the trip list and find out which trip that use the given driver
    	// add such trips to a new created list
    	// iterates the set of passengers; under that iteration, iterate the created list;
    	// find out the frequent passenger and add to a new created set;
    	List <Trip> temp1 = new ArrayList<>();
    	for(int i=0;i<trips.size();i++) {
    		if(trips.get(i).getDriver().getDriver().equals(driver.getDriver())) {
    			temp1.add(trips.get(i));
    		}
    	}
    	
    	Set <Passenger> result = new HashSet<Passenger>();
    	Iterator <Passenger> it = allPassengers.iterator();
    	
    	while(it.hasNext()) {
    		int count=0;
    		Passenger temp = it.next();
        	for(int i=0;i<temp1.size();i++) {
        		Iterator<Passenger> its2 = temp1.get(i).getPassengers().iterator();
    			while(its2.hasNext()) {
    				Passenger temp2 = its2.next();
    				if(temp2.getName().equals(temp.getName())) {
    					count++;
    				}
    			}
        	}
    		if(count>1) {
    			//System.out.println(temp1.size());
    			result.add(temp);
    		}
    	}
    	
    	
        return result;
    }

    public static Set<Passenger> findSmartPassengers() {
        // TODO
    	
    	//add all the trips that has discount in a created list
    	List<Trip> discounttrip = new ArrayList<>();
    	for(int i=0;i<trips.size();i++) {
    		if(trips.get(i).getDiscount()!=null&&trips.get(i).getDiscount()>0) {
    			discounttrip.add(trips.get(i));
    		}
    	}
    	//System.out.println(discounttrip.size());
    	//add all the trips that do not have discount in a created list
    	List<Trip> nodiscounttrip = new ArrayList<>();
    	for(int i=0;i<trips.size();i++) {
    		if(trips.get(i).getDiscount()==null) {
    			nodiscounttrip.add(trips.get(i));
    		}
    	}
    	//System.out.println(nodiscounttrip.size());
    	Set <Passenger> result = new HashSet<Passenger>();
    	//iterate the allpassengers set
    	Iterator <Passenger> it = allPassengers.iterator();
    	
    	while(it.hasNext()) {
    		int countfordiscount=0;
        	int countfornodiscount=0;
    		Passenger temp = it.next();
    		//calcualte how many discount trips that passenger(temp) has.
        	for(int i=0;i<discounttrip.size();i++) {
        		Iterator<Passenger> its2 = discounttrip.get(i).getPassengers().iterator();
    			while(its2.hasNext()) {
    				Passenger temp2 = its2.next();
    				if(temp2.getName().equals(temp.getName())) {
    					//System.out.println(temp2.getName());
    					countfordiscount++;
    				}
    			}
        		
        	}
    		//calcualte how many nodiscount trips that passenger(temp) has.
        	for(int i=0;i<nodiscounttrip.size();i++) {
        		Iterator<Passenger> its2 = nodiscounttrip.get(i).getPassengers().iterator();
    			while(its2.hasNext()) {
    				Passenger temp2 = its2.next();
    				if(temp2.getName().equals(temp.getName())) {
    					countfornodiscount++;
    				}
    			}
        	}
    		if(countfordiscount>countfornodiscount) {
    			//System.out.println(temp.getName());
    			result.add(temp);
    		}
    	}
        return result;
    }


    public static Pair<Integer, Integer> findTheMostFrequentTripDurationPeriod() {
        // TODO
    	
    	//find maximum duration
    	Integer max = 0;
    	for(int i=0;i<trips.size();i++) {
    		if(trips.get(i).getDuration()>max) {
    			max=trips.get(i).getDuration();
    		}
    	}
    	if(max%10!=0) {
    		//this will check if the maximum time is 10 20 30 40....etc if not round up to the number that is divisible by 10
			max = max +((10-max%10));
		}
    	
    	//create a map that store time period as string and frequency as integer
    	Map<String,Integer> d = new HashMap<String,Integer>();
    	int count=1;
    	int record=0;
    	for(int i=0;i<max;i++) {
    		if(count==10) {
    			//add time period and its frequency to the map and initialize the frequency as zero
    			d.put(record+"-"+i, 0);
    			//System.out.println(record+"-"+i);
    			record=i+1;
    			count=0;
    		}
    		count++;
    	}
    	
    	//iterates the trip list
    	
    	for(int i=0;i< trips.size();i++) {
    		//iterates the keyset of the map
    		Iterator<String> t = d.keySet().iterator();
    		while(t.hasNext()) {
    			String temp = t.next();
    			int tmax=0;
    			int tmin=0;
    			StringBuffer appends=new StringBuffer();
    			//split max and min number from the string (key);
    			for(int j=0;j<temp.length();j++) {
    				if(temp.charAt(j)=='-') {
    					tmin = Integer.valueOf(appends.toString());
    					appends.delete(0, appends.length());
    				}else {
    					appends.append(temp.charAt(j));
    				}
    				if(j==temp.length()-1) {
    					tmax=Integer.valueOf(appends.toString());
    				}
    			}
    			//calculate the frequency
    			if(trips.get(i).getDuration()>=tmin&&trips.get(i).getDuration()<=tmax) {
    				d.put(temp, d.get(temp)+1);
    			}	
    		}
    	}
    	
    	//find out most frequency time period(key) from map
    	String frequencyperiod = "";
    	int count2=0;
    	Iterator<String> t = d.keySet().iterator();
    	boolean check=false;
    	while(t.hasNext()) {
    		String temp=t.next();
    		
    		if(d.get(temp)>count2) {
    			
    			frequencyperiod=temp;
    			count2=d.get(temp);
    			check=false;
    		}else
    		if(d.get(temp)==count2){
    			check=true;
    		}
    	}
    	if(check==true) {
    		frequencyperiod="";
    	}
    	
    	if(frequencyperiod=="") {
    		return null;
    	}else {
	    	//work out max and min from the string (key)
	    	Integer tmax=0;
			Integer tmin=0;
			StringBuffer appends=new StringBuffer();
			//split max and min number from the string (key);
			for(int j=0;j<frequencyperiod.length();j++) {
				if(frequencyperiod.charAt(j)=='-') {
					tmin = Integer.valueOf(appends.toString());
					appends.delete(0, appends.length());
				}else {
					appends.append(frequencyperiod.charAt(j));
				}
				if(j==frequencyperiod.length()-1) {
					tmax=Integer.valueOf(appends.toString());
				}
			}
	    	
	        return Pair.of(tmin, tmax);
    	}
    }

    public static Boolean checkParetoPrinciple() {
        // TODO
    	//this map store driver and his income
    	Map<Driver,Double> driverincome = new HashMap<Driver,Double>();
    	//calcualte driver income
    	Iterator<Driver> it = allDrivers.iterator();
    	while(it.hasNext()) {
    		Driver temp = it.next();
    		Double total = 0.0;
    		//iterate all the trips find out which trips are use the above driver
    		for(int i=0;i<trips.size();i++) {
    			if(trips.get(i).getDriver().getDriver().equals(temp.getDriver())) {
    				total = total+trips.get(i).cost();
    			}
    		}
    		//System.out.println(temp.getDriver()+"   " +total);
    		driverincome.put(temp, total);
    	}
    	int twenty = (int) (allDrivers.size()*0.2);
    	//store top drivers income
    	Map<Driver,Double> topdriver = new HashMap<Driver,Double>();
    	//find out the top drivers and their income
    	for(int i=0;i<twenty;i++) {
    		Iterator<Driver> its = driverincome.keySet().iterator();
    		Driver mostdriver = null;
    		double largestamount=0.0;
    		while(its.hasNext()) {
    			Driver temp = its.next();
    			if(driverincome.get(temp)>largestamount) {
    				largestamount=driverincome.get(temp);
    				mostdriver=temp;
    			}
    		}
    		topdriver.put(mostdriver,largestamount);
    		driverincome.remove(mostdriver);
    	}
    	
    	//calculate total money earn from all trips
    	double totalearn=0.0;
    	for(int i=0;i<trips.size();i++) {
    		totalearn = totalearn+trips.get(i).cost();
    	}
    	//System.out.println(totalearn);
    	//calculate total money earn from top drivers
    	double totaldriverearn=0.0;
    	Iterator<Driver> its2 = topdriver.keySet().iterator();
    	while(its2.hasNext()) {
    		Driver temp = its2.next();
    		//System.out.println(temp.getDriver());
    		totaldriverearn = totaldriverearn+topdriver.get(temp);
    	}
    	
    	
    	if(totaldriverearn>=totalearn*0.8) {
    		return true;
    	}else {
    		return false;
    	}
    	
    }
}
