// Problem 8.1 Implement a program to handle different exceptions.
// Scenario: A college canteen has a food ordering app. Students choose items from a menu, enter a quantity, apply a coupon code and split the bill among friends. Users often make mistakes: they type letters instead of numbers, pick an item that is not on the menu, enter a wrong coupon, or split the bill among 0 friends. The app must handle each mistake with a clear message and must never crash. User mistake	Exception raised Types "two" instead of 2 for quantity	InputMismatchException Chooses item number 9 from a 5-item menu	ArrayIndexOutOfBoundsException Enters coupon SAVE20 where a numeric code is expected	NumberFormatException Splits the bill among 0 friends ArithmeticException

// Step 1: Set up the menu data
// 1.⁠ ⁠Create a class FoodOrderApp with a main() method.
// 2.⁠ ⁠Import java.util.Scanner and java.util.InputMismatchException.
// 3.⁠ ⁠Declare two parallel arrays (shown below).
// 4.⁠ ⁠Create Scanner sc = new Scanner(System.in);
// 5.⁠ ⁠Print the menu using a for loop, numbered 1 to 5.
// String[] items = {"Vada Pav", "Samosa", "Masala Dosa",
//                   "Cold Coffee", "Veg Thali"};
// int[] prices   = {20, 15, 60, 40, 90};

// Step 2: Write the order logic inside a try block
// Task 1: Select an item (may cause ArrayIndexOutOfBoundsException)
// •⁠  ⁠Ask: "Enter item number (1-5): "
// •⁠  ⁠Read int choice = sc.nextInt();
// •⁠  ⁠Get the item with items[choice - 1] and the price with prices[choice - 1].
// •⁠  ⁠If the user enters 9, then items[8] does not exist and Java throws the exception automatically.
// Task 2: Enter quantity (may cause InputMismatchException)
// •⁠  ⁠Ask: "Enter quantity: "
// •⁠  ⁠Read int qty = sc.nextInt();
// •⁠  ⁠Calculate int total = prices[choice - 1] * qty; and print it.
// Task 3: Apply coupon code (may cause NumberFormatException)
// •⁠  ⁠Ask: "Enter numeric coupon code (e.g. 10 for ₹10 off): "
// •⁠  ⁠Read it as a String: String coupon = sc.next();
// •⁠  ⁠Convert it with int discount = Integer.parseInt(coupon);
// •⁠  ⁠Subtract the discount from total and print the new total.
// Why read the coupon as a String? In real apps, every input arrives as text from a form. parseInt() converts it and throws NumberFormatException when the text is not a number.
// Task 4: Split the bill (may cause ArithmeticException)
// •⁠  ⁠Ask: "Split among how many friends? "
// •⁠  ⁠Read int friends = sc.nextInt();
// •⁠  ⁠Calculate int share = total / friends; and print each person's share.
// Important: Keep total and friends as int. Dividing a double by zero gives Infinity and does not throw an exception.

// Step 3: Add multiple catch blocks
// Catch block	Message to print
// ArrayIndexOutOfBoundsException e	"Invalid item! Please choose between 1 and 5."
// InputMismatchException e	"Please enter digits only, not words."
// NumberFormatException e	"Invalid coupon code: " + e.getMessage()
// ArithmeticException e	"Bill cannot be split among 0 friends."
// Exception e (last)	"Something went wrong: " + e
// Rule: The general Exception catch must come last. If it comes first, the specific blocks become unreachable and the code will not compile.

// Step 4: Add a finally block
// •⁠  ⁠Close the scanner with sc.close();
// •⁠  ⁠Print "Thank you for ordering at MIT Canteen!"

// Step 5: Test with these inputs
// Run	Inputs	Expected result
// 1	3, 2, 20, 4	Order succeeds: total ₹100, share ₹25
// 2	9	Invalid item message
// 3	3, two	Digits-only message
// 4	3, 2, SAVE20	Invalid coupon message
// 5	3, 2, 20, 0	Split-bill message

// Expected output (Run 4):
// Enter item number (1-5): 3
// You selected: Masala Dosa @ ₹60
// Enter quantity: 2
// Total: ₹120
// Enter numeric coupon code (e.g. 10 for ₹10 off): SAVE20
// Invalid coupon code: For input string: "SAVE20"
// Thank you for ordering at MIT Canteen!

import java.util.InputMismatchException;
import java.util.Scanner;

public class foodOrderApp {
    public static void main(String[] args) throws Exception {
        String[] items = { "Vada Pav", "Samosa", "Masala Dosa", "Cold Coffee", "Veg Thali" };
        int[] prices = { 20, 15, 60, 40, 90 };

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------ MIT Canteen Food Ordering System ------");
        for (int i = 0; i < items.length; i++) {
            System.out.println("[ " + (i + 1) + " ] " + items[i] + " - ₹ " + prices[i]);
        }

        try {
            // Task 1
            System.out.print("\nEnter item number (1-5): ");
            int choice = scanner.nextInt();
            String selectedItemName = items[choice - 1];
            int selectedItemPrice = prices[choice - 1];
            System.out.println("You selected :" + selectedItemName + " @ ₹ " + selectedItemPrice);

            // Task 2
            System.out.print("\nEnter quantity :");
            int qty = scanner.nextInt();
            int total = selectedItemPrice * qty;
            System.out.println("You selected : " + selectedItemName + " @ ₹ " + selectedItemPrice + "  Qty : " + qty
                    + " Total : " + total);

            // Task 3
            System.out.print("\nEnter numeric coupon code (e.g. 10 for ₹10 off) :");
            String coupon = scanner.next();
            int discount = Integer.parseInt(coupon);
            total -= discount;
            System.out.println("New Total after discount: ₹" + total);

            // Task 4
            System.out.print("\nSplit among how many friends? : ");
            int friends = scanner.nextInt();
            int splitAmount = total / friends;
            System.out.println("Each person's share: ₹" + splitAmount);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid choice!! Please enter number between (1-5)..");
        } catch (InputMismatchException e) {
            System.out.println("Please enter digits only, not words.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter digits only, not words.");
        } catch (ArithmeticException e) {
            System.out.println("Bill cannot be split among 0 friends.");
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        } finally {
            scanner.close();
            System.out.println("\n----- Thank you for ordering at MIT Canteen! -----");
        }
        return;
    }

}