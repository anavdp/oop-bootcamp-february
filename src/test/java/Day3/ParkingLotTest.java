package Day3;

import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ParkingLotTest {

    private ParkingLot parkingLot;

    @Mock
    private UsageService usageService;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        parkingLot = new ParkingLot(5, usageService);
    }

    @Test
    public void itShouldCheckIfHasSpace() {
        assertTrue(parkingLot.hasSpace());
    }

    @Test
    public void itShouldIfNotHasSpace() {
        var parkingLot = new ParkingLot(1, usageService);
        var car = new Car();
        parkingLot.park(car);
        assertFalse(parkingLot.hasSpace());
    }

    @Test
    public void itShouldParkACar() {
        var car = new Car();
        parkingLot.park(car);
        assertEquals(parkingLot.getCarsParked().size(), 1);

    }


}