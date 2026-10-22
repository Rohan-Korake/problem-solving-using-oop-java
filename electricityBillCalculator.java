
// An electricity board needs one class that can compute a bill in several ways.Use method overloading and constructor overloading to build it.(a)​ Create class ElectricityBill with four overloaded calculate() methods: Method signature Returns

// double calculate(int units)
// units × 8.0 (default rate Rs. 8 per unit)

// double calculate(int units, double rate)
// units × rate

// double calculate(double amount, int discountPercent)
// amount after deducting discountPercent %

// String calculate(String name, int units)
// "name : Rs. bill" — must reuse

// calculate(int units)

// (b)​Create class Consumer (fields name, units) with three overloaded constructors — no argument, name only, name and units — chained using this(...). Default values are "New Consumer" and 0. Add a show() method.
// (c)​In main(), call calculate(150), calculate(150, 9.5), calculate(2000.0, 10), calculate("Asha", 150), and create one Consumer with each constructor.
// Expected output
// 1200.0
// 1425.0
// 1800.0
// Asha : Rs. 1200.0
// New Consumer used 0 units
// Rohan used 0 units
// Asha used 150 units

class consumer {
    private String name;
    private int units;

    public consumer(String name, int units) {
        this.name = name;
        this.units = units;
    }

    public consumer(String name) {
        this.name = name;
        this.units = 0;
    }

    public consumer() {
        this("New Consumer", 0);
    }

    public void show() {
        System.out.println(name + " used " + units + " units");
    }
}

class electricityBill {
    public double calculate(int units) {
        return units * 8.0;
    }

    public double calculate(int units, double rate) {
        return units * rate;
    }

    public double calculate(double amount, int discountPercent) {
        return amount - (amount * discountPercent / 100.0);
    }

    String calculate(String name, int units) {
        double bill = calculate(units);
        return name + " : Rs. " + bill;
    }
}

class electricityBillCalculator {
    public static void main(String args[]) throws Exception {
        electricityBill eBill = new electricityBill();

        // Method overloading calls
        System.out.println(eBill.calculate(150));
        System.out.println(eBill.calculate(150, 9.5));
        System.out.println(eBill.calculate(20000.0, 10));
        System.out.println(eBill.calculate("Asha", 150));

        consumer c1 = new consumer();
        consumer c2 = new consumer("Rohan", 0);
        consumer c3 = new consumer("Asha", 150);

        c1.show();
        c2.show();
        c3.show();

        return;
    }
}
