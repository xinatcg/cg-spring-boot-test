package co.creativegaming.java.recruiting.cgspringboottest.task2;

import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.creativegaming.java.recruiting.cgspringboottest.task2.domain.Driver;
import co.creativegaming.java.recruiting.cgspringboottest.task2.domain.Passenger;
import co.creativegaming.java.recruiting.cgspringboottest.task2.domain.Trip;

public class MinicabManagerTest {
    @Mock
    Set<Driver> allDrivers;
    @Mock
    Set<Passenger> allPassengers;
    @Mock
    List<Trip> trips;
    @InjectMocks
    MinicabManager minicabManager;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        MinicabManager.allDrivers=new HashSet<Driver>();
        for(int i=1;i<=10;i++) {
        	Driver d = new Driver("d"+i);
        	MinicabManager.allDrivers.add(d);
        }
        MinicabManager.allPassengers=new HashSet<Passenger>();
        for(int i=1;i<=45;i++) {
        	Passenger d = new Passenger("p"+i);
        	MinicabManager.allPassengers.add(d);
        }
        MinicabManager.trips=new ArrayList<>();
        Set<Passenger> p = new HashSet<Passenger>();
        p.add(new Passenger("p1"));
        p.add(new Passenger("p2"));
        p.add(new Passenger("p3"));
        p.add(new Passenger("p4"));
        p.add(new Passenger("p5"));
        p.add(new Passenger("p6"));
        p.add(new Passenger("p7"));
        p.add(new Passenger("p8"));
        p.add(new Passenger("p9"));
        p.add(new Passenger("p10"));
        
        Set<Passenger> p2 = new HashSet<Passenger>();
        p2.add(new Passenger("p10"));
        p2.add(new Passenger("p11"));
        p2.add(new Passenger("p12"));
        p2.add(new Passenger("p13"));
        p2.add(new Passenger("p14"));
        p2.add(new Passenger("p15"));
        p2.add(new Passenger("p16"));
        p2.add(new Passenger("p17"));
        p2.add(new Passenger("p18"));
        p2.add(new Passenger("p3"));
        p2.add(new Passenger("p2"));
        
        Set<Passenger> p3 = new HashSet<Passenger>();
        p.add(new Passenger("p1"));
        p3.add(new Passenger("p19"));
        p3.add(new Passenger("p20"));
        p3.add(new Passenger("p21"));
        p3.add(new Passenger("p22"));
        p3.add(new Passenger("p23"));
        p3.add(new Passenger("p24"));
        p3.add(new Passenger("p25"));
        p3.add(new Passenger("p26"));
        p3.add(new Passenger("p27"));
        p3.add(new Passenger("p28"));
        p3.add(new Passenger("p10"));
        p3.add(new Passenger("p9"));
        
        Set<Passenger> p4 = new HashSet<Passenger>();
        p4.add(new Passenger("p9"));
        p4.add(new Passenger("p1"));
        p4.add(new Passenger("p30"));
        p4.add(new Passenger("p31"));
        p4.add(new Passenger("p32"));
        p4.add(new Passenger("p33"));
        p4.add(new Passenger("p34"));
        p4.add(new Passenger("p35"));
        p4.add(new Passenger("p36"));
        p4.add(new Passenger("p37"));
        p4.add(new Passenger("p38"));
        p4.add(new Passenger("p2"));
        
        
        MinicabManager.trips.add(new Trip(new Driver("d1"),22,500.0,null,p));
        MinicabManager.trips.add(new Trip(new Driver("d2"),14,300.0,0.9,p2));
        MinicabManager.trips.add(new Trip(new Driver("d1"),19,550.0,null,p3));
        MinicabManager.trips.add(new Trip(new Driver("d4"),29,220.0,0.8,p4));
        allDrivers=spy(MinicabManager.allDrivers);
        allPassengers=spy(MinicabManager.allPassengers);
        trips=spy(MinicabManager.trips);
        
    }

    
    private static boolean equalset(Set<Driver> set1, Set<Driver> set2){
    	//because two sets that store driver objects has different object id even the driver objects has same driver name;
    	//therefore write a method to compare the string of driver name. don't compare object. 
        if(set1 == null || set2 ==null){
            return false;
        }
        if(set1.size()!=set2.size()){
            return false;
        }
       
        Iterator<Driver> it1 = set1.iterator(); 
        while(it1.hasNext()) {
        	boolean check=false;
        	Driver temp = it1.next();
        	Iterator<Driver> it2 = set2.iterator();
        	while(it2.hasNext()) {
        		Driver temp2=it2.next();
        		if(temp.getDriver().equals(temp2.getDriver())) {
        			check=true;
        			break;
        		}
        	}
        	if(check==false) {
        		
        		return false;
        	}
        }
        return true;
    }
    
    private static boolean equalset2(Set<Passenger> set1, Set<Passenger> set2){
        if(set1 == null || set2 ==null){
            return false;
        }
        if(set1.size()!=set2.size()){
            return false;
        }
       
        Iterator<Passenger> it1 = set1.iterator(); 
        while(it1.hasNext()) {
        	boolean check=false;
        	Passenger temp = it1.next();
        	Iterator<Passenger> it2 = set2.iterator();
        	while(it2.hasNext()) {
        		Passenger temp2=it2.next();
        		if(temp.getName().equals(temp2.getName())) {
        			check=true;
        			break;
        		}
        	}
        	if(check==false) {
        		
        		return false;
        	}
        }
        return true;
    }
    
    @Test
    public void testFindFakeDrivers() throws Exception {
    	
    	Set<Driver> expect = new HashSet<Driver>();
        for(int i=5;i<=10;i++) {
        	Driver d = new Driver("d"+i);
        	expect.add(d);
        }
        expect.add(new Driver("d3"));
    	
    	
        Set<Driver> result = MinicabManager.findFakeDrivers();
        //WRITE A METHOD TO COMPARE TWO SETS THAT HAS TYPE DRIVER
        Assert.assertEquals(equalset(expect,result), true);
    }

    @Test
    public void testFindFaithfulPassengers() throws Exception {
    	Set<Passenger> expect = new HashSet<Passenger>();
    	 expect.add(new Passenger("p1"));
        expect.add(new Passenger("p3"));
        expect.add(new Passenger("p10"));
        expect.add(new Passenger("p9"));
        expect.add(new Passenger("p2"));
    	
    	
        Set<Passenger> result = MinicabManager.findFaithfulPassengers(2);

        Assert.assertEquals(equalset2(expect,result), true);
    }

    @Test
    public void testFindFrequentPassengers() throws Exception {
    	Set<Passenger> expect = new HashSet<Passenger>();
        expect.add(new Passenger("p1"));
        expect.add(new Passenger("p9"));
        expect.add(new Passenger("p10"));
        Set<Passenger> result = MinicabManager.findFrequentPassengers(new Driver("d1"));
        Iterator<Passenger> its =result.iterator();
        while(its.hasNext()) {
        	Passenger temp = its.next();
        	//System.out.println(temp.getName());
        }
        Assert.assertEquals(equalset2(expect,result), true);
    }

    @Test
    public void testFindSmartPassengers() throws Exception {
    	Set<Passenger> expect = new HashSet<Passenger>();
    	expect.add(new Passenger("p11"));
    	expect.add(new Passenger("p12"));
    	expect.add(new Passenger("p13"));
    	expect.add(new Passenger("p14"));
    	expect.add(new Passenger("p15"));
    	expect.add(new Passenger("p16"));
    	expect.add(new Passenger("p17"));
    	expect.add(new Passenger("p18"));
    	expect.add(new Passenger("p30"));
    	expect.add(new Passenger("p31"));
    	expect.add(new Passenger("p32"));
    	expect.add(new Passenger("p33"));
    	expect.add(new Passenger("p34"));
    	expect.add(new Passenger("p35"));
    	expect.add(new Passenger("p36"));
    	expect.add(new Passenger("p37"));
    	expect.add(new Passenger("p38"));
    	expect.add(new Passenger("p2"));
    	
        Set<Passenger> result = MinicabManager.findSmartPassengers();
        Assert.assertEquals(equalset2(expect,result), true);
    }

    @Test
    public void testFindTheMostFrequentTripDurationPeriod() throws Exception {
        Pair<Integer, Integer> result = MinicabManager.findTheMostFrequentTripDurationPeriod();
        //System.out.println(result.getKey()+" " + result.getRight());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testCheckParetoPrinciple() throws Exception {
    	
    	
        Boolean result = MinicabManager.checkParetoPrinciple();
        Assert.assertEquals(Boolean.TRUE, result);
    }
}