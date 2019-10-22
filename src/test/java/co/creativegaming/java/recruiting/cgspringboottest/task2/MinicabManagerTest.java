package co.creativegaming.java.recruiting.cgspringboottest.task2;

import co.creativegaming.java.recruiting.cgspringboottest.task2.domain.Driver;
import co.creativegaming.java.recruiting.cgspringboottest.task2.domain.Passenger;
import co.creativegaming.java.recruiting.cgspringboottest.task2.domain.Trip;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

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
    }

    @Test
    public void testFindFakeDrivers() throws Exception {
        Set<Driver> result = MinicabManager.findFakeDrivers();
        Assert.assertEquals(new HashSet<Driver>(Arrays.asList(new Driver())), result);
    }

    @Test
    public void testFindFaithfulPassengers() throws Exception {
        Set<Passenger> result = MinicabManager.findFaithfulPassengers(0);
        Assert.assertEquals(new HashSet<Passenger>(Arrays.asList(new Passenger())), result);
    }

    @Test
    public void testFindFrequentPassengers() throws Exception {
        Set<Passenger> result = MinicabManager.findFrequentPassengers(new Driver());
        Assert.assertEquals(new HashSet<Passenger>(Arrays.asList(new Passenger())), result);
    }

    @Test
    public void testFindSmartPassengers() throws Exception {
        Set<Passenger> result = MinicabManager.findSmartPassengers();
        Assert.assertEquals(new HashSet<Passenger>(Arrays.asList(new Passenger())), result);
    }

    @Test
    public void testFindTheMostFrequentTripDurationPeriod() throws Exception {
        Pair<Integer, Integer> result = MinicabManager.findTheMostFrequentTripDurationPeriod();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testCheckParetoPrinciple() throws Exception {
        Boolean result = MinicabManager.checkParetoPrinciple();
        Assert.assertEquals(Boolean.TRUE, result);
    }
}