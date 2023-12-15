import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CabServiceTest {
    @Test
    public void InvoiceGeneratorMinimumTest(){
        CabService cab = new CabService();

        //normal
        int km = 0;
        int time = 0;
        boolean category = false;
        int expectedFare = 5;
        int calculatedFare = cab.generateInvoice(km, time, category);
        assertEquals(expectedFare, calculatedFare);

        //premium
        km = 0;
        time = 0;
        category = true;
        expectedFare = 20;
        calculatedFare = cab.generateInvoice(km, time, category);
        assertEquals(expectedFare, calculatedFare);
    }
    @Test
    public void InvoiceGeneratorTest(){
        CabService cab = new CabService();

        //normal
        int km = 1;
        int time = 1;
        boolean category = false;
        int expectedFare = 11;
        int calculatedFare = cab.generateInvoice(km, time, category);
        assertEquals(expectedFare, calculatedFare);
        km = 5;
        time = 5;
        expectedFare = 55;
        calculatedFare = cab.generateInvoice(km, time, category);
        assertEquals(expectedFare, calculatedFare);

        //premium
        km = 1;
        time = 1;
        category = true;
        expectedFare = 20;
        calculatedFare = cab.generateInvoice(km, time, category);
        assertEquals(expectedFare, calculatedFare);
        km = 5;
        time = 5;
        category = true;
        expectedFare = 85;
        calculatedFare = cab.generateInvoice(km, time, category);
        assertEquals(expectedFare, calculatedFare);
    }

    @Test
    public void InvoiceGeneratorMultipleRidesTest(){

        //normal
        Ride ride1 = new Ride("Person1", 0, 0);
        Ride ride2 = new Ride("Person1", 1, 1);
        Ride ride3 = new Ride("Person1", 5, 5);
        ArrayList<Ride> rides = new ArrayList<>();
        rides.add(ride1);
        rides.add(ride2);
        rides.add(ride3);
        int expectedFare = 71;
        boolean category = false;
        CabService cab = new CabService();
        int calculatedFare = cab.generateTotalInvoice(rides, category);
        assertEquals(expectedFare, calculatedFare);

        //premium
        expectedFare = 125;
        category = true;
        calculatedFare = cab.generateTotalInvoice(rides, category);
        assertEquals(expectedFare, calculatedFare);
    }

    @Test
    public void EnhancedInvoiceTest(){
        Ride ride1 = new Ride("Person1", 0, 0);
        Ride ride2 = new Ride("Person1", 1, 1);
        Ride ride3 = new Ride("Person1", 5, 5);
        Ride ride4 = new Ride("Person1", 1, 9);
        ArrayList<Ride> rides = new ArrayList<>();
        rides.add(ride1);
        rides.add(ride2);
        rides.add(ride3);
        rides.add(ride4);

        //normal
        boolean category = false;
        Double[] expectedOutput = {4.0, 90.0, 22.5};
        CabService cab = new CabService();
        Double[] calculatedOutput = cab.generateEnhancedInvoice(rides, category);
        assertArrayEquals(expectedOutput, calculatedOutput);

        //premium
        category = true;
        Double[]expectedOutput2 = {4.0, 158.0, 39.5};
        Double[] calculatedOutput2 = cab.generateEnhancedInvoice(rides, category);
        assertArrayEquals(expectedOutput2, calculatedOutput2);

    }

    @Test
    public void EnhancedInvoiceForUserTest(){
        RideRepository rides = new RideRepository();

        //normal
        boolean category = false;
        Double[] expectedOutput = {4.0, 90.0, 22.5};
        CabService cab = new CabService();
        Double[] calculatedOutput = cab.generateEnhancedInvoiceForUser("Person1", rides.rides, category);
        assertArrayEquals(expectedOutput, calculatedOutput);

        //normal
        category = true;
        Double[] expectedOutput2 = {4.0, 158.0, 39.5};
        Double[] calculatedOutput2 = cab.generateEnhancedInvoiceForUser("Person1", rides.rides, category);
        assertArrayEquals(expectedOutput2, calculatedOutput2);
    }

}
