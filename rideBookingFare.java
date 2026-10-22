// A ride-booking app offers several ride types, each with its own fare rule. The billing loop must work for every ride type without checking which type it is.
// ​Create a class Ride with fields rider and km, a constructor, a method double fare(), and a method printReceipt() that prints the class name (use getClass().getSimpleName()),  rider, km and fare.
// (b) ​Create the following subclasses and override fare():
// Class
// Fare rule
// AutoRide extends Ride
// Rs. 25 + Rs. 15 per km
// CabRide extends Ride
// Rs. 50 + Rs. 20 per km
// BikeRide extends Ride
// Rs. 15 + Rs. 8 per km
// PremiumCab extends CabRide
// 20% more than a CabRide fare — must call super.fare()

// (c)​ In main(), store AutoRide ("Asha", 6), CabRide ("Rohan", 12), BikeRide ("Meera", 4) and PremiumCab ("Kunal", 12) in a single Ride[] array. Print every receipt and the total collection using one loop.
// Expected output
// AutoRide   Asha     6.0 km  Rs.   115.00
// CabRide    Rohan   12.0 km  Rs.   290.00
// BikeRide   Meera    4.0 km  Rs.    47.00
// PremiumCab Kunal   12.0 km  Rs.   348.00
// Total collection: Rs. 800.00

class Ride {
    protected String riderName;
    protected double km;

    public Ride(String name, double km) {
        this.riderName = name;
        this.km = km;
    }

    public double fare() {
        return 0.0;
    }

    public void printReceipt() {
        System.out.printf("%-10s %-6s %5.1f km  Rs. %8.2f%n",
                getClass().getSimpleName(), riderName, km, fare());
    }
}

class AutoRide extends Ride {
    public AutoRide(String name, double km) {
        super(name, km);
    }

    public double fare() {
        return 25.0 + (15.0 * km);
    }
}

class CabRide extends Ride {
    public CabRide(String name, double km) {
        super(name, km);
    }

    public double fare() {
        return 50.0 + (20.0 * km);
    }
}

class BikeRide extends Ride {
    public BikeRide(String name, double km) {
        super(name, km);
    }

    public double fare() {
        return 15.0 + (8.0 * km);
    }
}

class PremiumCab extends CabRide {
    public PremiumCab(String name, double km) {
        super(name, km);
    }

    public double fare() {
        return super.fare() * 1.20;
    }
}

public class rideBookingFare {
    public static void main(String args[]) throws Exception {

        Ride[] rides = {
                new AutoRide("Asha", 6),
                new CabRide("Rohan", 12),
                new BikeRide("Meera", 4),
                new PremiumCab("Kunal", 12)
        };

        double totalCollection = 0.0;

        for (Ride ride : rides) {
            ride.printReceipt();
            totalCollection += ride.fare();
        }
        System.out.printf("Total collection: Rs. %.2f%n", totalCollection);
    }
}
