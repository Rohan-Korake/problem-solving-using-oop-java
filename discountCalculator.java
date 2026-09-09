import java.io.*;

class Calculator {
    String name;
    int qty = 0;
    float price = 0;
    float subTotal = 0;

    public void add() {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the Name : ");
            name = buffer.readLine();

            System.out.print("Enter the Quantity : ");
            qty = Integer.parseInt(buffer.readLine());

            System.out.print("Enter the Price : ");
            price = Float.parseFloat(buffer.readLine());

            // Fixed validation: Check if they are non-positive
            if (qty <= 0) {
                System.out.println("Error: Quantity must be positive!");
            } else if (price <= 0) {
                System.out.println("Error: Price must be positive!");
            } else {
                subTotal = qty * price;
            }

        } catch (Exception e) {
            System.out.println("Invalid input format.");
        }
    }

    public void display() {
        System.out.println("\n--------------------");
        System.out.println("Item name     : " + name);
        System.out.println("Item Quantity : " + qty);
        System.out.println("Item Price    : " + price);
        System.out.println("Subtotal      : " + subTotal);
    }
}

public class discountCalculator {
    public static void main(String args[]) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int itemCount = 0;
        
        System.out.print("How many items you're billing (Max 10) : ");
        itemCount = Integer.parseInt(buffer.readLine());

        if (itemCount > 10 || itemCount <= 0) {
            System.out.println("Item count must be between 1 and 10.");
            return;
        }

        Calculator[] dc = new Calculator[itemCount];
        for (int i = 0; i < itemCount; i++) {
            System.out.println("\nEnter details for item " + (i + 1) + ":");
            dc[i] = new Calculator();
            dc[i].add();
        }

        float totalBill = 0;
        for (int i = 0; i < itemCount; i++) {
            dc[i].display();    
            totalBill += dc[i].subTotal;
        }

       // Calculate overall discount based on the aggregate total bill
        float discountAmount = 0;
        float finalTotal = totalBill;
        
        if (totalBill > 5000) {
            discountAmount = totalBill * 10 / 100; // 10% discount
            finalTotal = totalBill - discountAmount;
        } else if (totalBill > 2000) {
            discountAmount = totalBill * 5 / 100;  // 5% discount
            finalTotal = totalBill - discountAmount;
        }

        System.out.println("\n====================");
        System.out.println("Overall Grand Total : " + totalBill);
        System.out.println("Discount Applied    : " + discountAmount); // <--- Added this line
        System.out.println("Final Total         : " + finalTotal);
        System.out.println("===================="); 
    }
}