import java.util.ArrayList;

public class CabService {
    public int generateInvoice(int km, int time, boolean category){
        final int COST_PER_KM_NORMAL = 10;
        final int COST_PER_MIN_NORMAL = 1;
        final int MINIMUM_FARE_NORMAL = 5;
        final int COST_PER_KM_PREMIUM = 15;
        final int COST_PER_MIN_PREMIUM = 2;
        final int MINIMUM_FARE_PREMIUM = 20;
        if(!category){
            int calculatedCost = km * COST_PER_KM_NORMAL + time * COST_PER_MIN_NORMAL;
            int actualCost = Math.max(calculatedCost, MINIMUM_FARE_NORMAL);
            return actualCost;
        }
        else{
            int calculatedCost = km * COST_PER_KM_PREMIUM + time * COST_PER_MIN_PREMIUM;
            int actualCost = Math.max(calculatedCost, MINIMUM_FARE_PREMIUM);
            return actualCost;
        }
    }

    public int generateTotalInvoice(ArrayList<Ride> rides, boolean category) {
        final int COST_PER_KM_NORMAL = 10;
        final int COST_PER_MIN_NORMAL = 1;
        final int MINIMUM_FARE_NORMAL = 5;
        final int COST_PER_KM_PREMIUM = 15;
        final int COST_PER_MIN_PREMIUM = 2;
        final int MINIMUM_FARE_PREMIUM = 20;
        if(category == false){
            int totalCost = 0;
            for(Ride ride : rides){
                int calculatedCost = ride.km * COST_PER_KM_NORMAL + ride.time * COST_PER_MIN_NORMAL;
                int actualCost = Math.max(calculatedCost, MINIMUM_FARE_NORMAL);
                totalCost += actualCost;
            }
            return totalCost;
        }
        else{
            int totalCost = 0;
            for(Ride ride : rides){
                int calculatedCost = ride.km * COST_PER_KM_PREMIUM + ride.time * COST_PER_MIN_PREMIUM;
                int actualCost = Math.max(calculatedCost, MINIMUM_FARE_PREMIUM);
                totalCost += actualCost;
            }
            return totalCost;
        }

    }


    public Double[] generateEnhancedInvoice(ArrayList<Ride> rides, boolean category) {
        final Double COST_PER_KM_NORMAL = 10.0;
        final Double COST_PER_MIN_NORMAL = 1.0;
        final Double MINIMUM_FARE_NORMAL = 5.0;
        final Double COST_PER_KM_PREMIUM = 15.0;
        final Double COST_PER_MIN_PREMIUM = 2.0;
        final Double MINIMUM_FARE_PREMIUM = 20.0;
        Double noOfRides = (double) rides.size();
       if(!category){
           Double totalCost = 0.0;
           for(Ride ride : rides){
               double calculatedCost = ride.km * COST_PER_KM_NORMAL + ride.time * COST_PER_MIN_NORMAL;
               double actualCost = Math.max(calculatedCost, MINIMUM_FARE_NORMAL);
               totalCost += actualCost;
           }
           double averageCost = totalCost / noOfRides;
           Double[] generatedInvoice = {noOfRides, totalCost, averageCost};
           return generatedInvoice;
       }
       else{
           Double totalCost = 0.0;
           for(Ride ride : rides){
               double calculatedCost = ride.km * COST_PER_KM_PREMIUM + ride.time * COST_PER_MIN_PREMIUM;
               double actualCost = Math.max(calculatedCost, MINIMUM_FARE_PREMIUM);
               totalCost += actualCost;
           }
           double averageCost = totalCost / noOfRides;
           Double[] generatedInvoice = {noOfRides, totalCost, averageCost};
           return generatedInvoice;
       }
    }

    public Double[] generateEnhancedInvoiceForUser(String userid, ArrayList<Ride> rides, boolean category) {
        final Double COST_PER_KM_NORMAL = 10.0;
        final Double COST_PER_MIN_NORMAL = 1.0;
        final Double MINIMUM_FARE_NORMAL = 5.0;
        final Double COST_PER_KM_PREMIUM = 15.0;
        final Double COST_PER_MIN_PREMIUM = 2.0;
        final Double MINIMUM_FARE_PREMIUM = 20.0;
        if(!category){
            Double noOfRides = 0.0;
            Double totalCost = 0.0;
            for(Ride ride : rides){
                if(ride.userid.equals(userid)){
                    double calculatedCost = ride.km * COST_PER_KM_NORMAL + ride.time * COST_PER_MIN_NORMAL;
                    double actualCost = Math.max(calculatedCost, MINIMUM_FARE_NORMAL);
                    totalCost += actualCost;
                    noOfRides += 1;
                }
            }
            double averageCost = totalCost / noOfRides;
            Double[] generatedInvoice = {noOfRides, totalCost, averageCost};
            return generatedInvoice;
        }
        else{
            Double noOfRides = 0.0;
            Double totalCost = 0.0;
            for(Ride ride : rides){
                if(ride.userid.equals(userid)){
                    double calculatedCost = ride.km * COST_PER_KM_PREMIUM + ride.time * COST_PER_MIN_PREMIUM;
                    double actualCost = Math.max(calculatedCost, MINIMUM_FARE_PREMIUM);
                    totalCost += actualCost;
                    noOfRides += 1;
                }
            }
            double averageCost = totalCost / noOfRides;
            Double[] generatedInvoice = {noOfRides, totalCost, averageCost};
            return generatedInvoice;
        }
    }
}
