import java.util.ArrayList;

public class RideRepository {
    Ride ride1 = new Ride("Person5", 1, 2);
    Ride ride2 = new Ride("Person1", 1, 1);
    Ride ride3 = new Ride("Person1", 5, 5);
    Ride ride4 = new Ride("Person3", 1, 1);
    Ride ride5 = new Ride("Person2", 0, 0);
    Ride ride6 = new Ride("Person1", 1, 9);
    Ride ride7 = new Ride("Person4", 5, 5);
    Ride ride8 = new Ride("Person1", 0, 0);
    ArrayList<Ride> rides;
    RideRepository(){
        rides = new ArrayList<>();
        rides.add(ride1);
        rides.add(ride2);
        rides.add(ride3);
        rides.add(ride4);
        rides.add(ride5);
        rides.add(ride6);
        rides.add(ride7);
        rides.add(ride8);
    }
}
