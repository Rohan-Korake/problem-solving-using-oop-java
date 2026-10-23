// Step 1: Create the Interface Payment
// Create an interface named Payment with:
// 1.⁠ ⁠A constant MAX_LIMIT with value 100000. 
// Hint: Any variable declared in an interface is automatically public static final. You do not need to write these keywords, but you may.
// 2.⁠ ⁠A method void pay(double amount).	
// 3.⁠ ⁠A method String getTransactionStatus().

// Step 2: Create the Abstract Class OnlinePayment
//  Create an abstract class OnlinePayment that implements Payment.
// 1.⁠ ⁠Declare two protected instance variables: String accountHolder stores the name of the person paying. String status stores the result of the last transaction.
// 2.⁠ ⁠Write a constructor that takes accountHolder as a parameter: Assign it to the instance variable. Set status to "No transaction yet".
// 3.⁠ ⁠Implement getTransactionStatus() so that it returns the value of status.
// 4.⁠ ⁠Do not implement pay(). Declare it as public abstract void pay(double amount); or simply leave it unimplemented, since the class is abstract.

// Step 3: Create the Subclass UPIPayment
// 1.⁠ ⁠UPIPayment should extend OnlinePayment.
// 2.⁠ ⁠Write a constructor that takes accountHolder and passes it to the parent using super(accountHolder);.
// 3.⁠ ⁠Override pay(double amount) and implement it in this order: 
// a) Check whether amount > MAX_LIMIT. If it is: set status to "FAILED: Amount exceeds limit of ₹100000",print a suitable rejection message, return from the method.
// b) Otherwise there are no charges, so the total equals the amount.
// c) Print the account holder, mode, amount, charges and total paid.
// d) Set status to "SUCCESS via UPI".

// Step 4: Create the Subclass CardPayment
// 1.⁠ ⁠Extend OnlinePayment and use super(accountHolder) in the constructor.
// 2.⁠ ⁠Override pay(double amount): 
// •⁠  ⁠Perform the same limit check as in Step 3.
// •⁠ Calculate the processing fee: fee = amount * 0.02 (2%).
// •⁠  ⁠Calculate total = amount + fee.
// •⁠  ⁠Print the details and set status to "SUCCESS via Card".

// Step 5: Create the Subclass NetBanking
// 1.⁠ ⁠Extend OnlinePayment and use super(accountHolder) in the constructor.
// 2.⁠ ⁠Override pay(double amount): 
// •⁠  ⁠Perform the same limit check.
// •⁠  ⁠Add a flat ₹10 charge: total = amount + 10.
// •⁠  ⁠Print the details and set status to "SUCCESS via Net Banking".

// Step 6: Write the main() Method in a Class PaymentDemo
// 	Create objects using interface references (this is runtime polymorphism):

interface Payment {
    double MAX_LIMIT = 100000; // Automatically public static final

    void pay(double amount);

    String getTransactionStatus();
}

abstract class OnlinePayment implements Payment {
    protected String accountHolder;
    protected String status;

    public OnlinePayment(String accountHolder) {
        this.accountHolder = accountHolder;
        this.status = "No transaction yet";
    }

    public String getTransactionStatus() {
        return status;
    }

    public abstract void pay(double amount);
}

class UPIPayment extends OnlinePayment {
    public UPIPayment(String accountHolder) {
        super(accountHolder);
    }

    public void pay(double amount) {
        if (amount > MAX_LIMIT) {
            status = "FAILED: Amount exceeds limit of ₹100000";
            System.out.println("Transaction rejected for AccountHolder : " + accountHolder + " Amount : " + amount);
            return;
        }

        double charges = 0.0;
        double total = amount + charges;

        System.out.println("----- Payment Receipt ------");
        System.out.println("----------------------------");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Payment Mode   : UPI");
        System.out.println("Total Amount   : ₹" + amount);
        System.out.println("Total Charges  : ₹" + charges);
        System.out.println("Final Total    : ₹" + total);
        System.out.println("----------------------------");
        status = "SUCCESS via UPI";
    }
}

class CardPayment extends OnlinePayment {
    public CardPayment(String accountHolder) {
        super(accountHolder);
    }

    public void pay(double amount) {
        if (amount > MAX_LIMIT) {
            status = "FAILED: Amount exceeds limit of ₹100000";
            System.out.println("Transaction rejected for AccountHolder : " + accountHolder + " Amount : " + amount);
            return;
        }

        double charges = amount * 0.02;
        double total = amount + charges;

        System.out.println("----- Payment Receipt ------");
        System.out.println("----------------------------");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Payment Mode   : Card ");
        System.out.println("Total Amount   : " + amount);
        System.out.println("Charges        : " + charges);
        System.out.println("Final Total    : " + total);
        System.out.println("----------------------------");
        status = "SUCCESS via CARD";
    }
}

class NetBanking extends OnlinePayment {
    public NetBanking(String accountHolder) {
        super(accountHolder);
    }

    public void pay(double amount) {
        if (amount > MAX_LIMIT) {
            status = "FAILED: Amount exceeds limit of ₹100000";
            System.out.println("Transaction rejected for AccountHolder : " + accountHolder + " Amount : " + amount);
            return;
        }

        double charges = 10.0;
        double total = amount + charges;

        System.out.println("----- Payment Receipt ------");
        System.out.println("----------------------------");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Payment Mode   : NetBanking ");
        System.out.println("Total Amount   : " + amount);
        System.out.println("Charges        : " + charges);
        System.out.println("Final Total    : " + total);
        System.out.println("----------------------------");
        status = "SUCCESS via Net Banking";

    }
}

class paymentGateway {
    public static void main(String args[]) throws Exception {
        Payment payment1 = new CardPayment("Rohan");
        Payment payment2 = new UPIPayment("Alex");
        Payment payment3 = new NetBanking("Amit");

        System.out.println("\nInitial Status : " + payment1.getTransactionStatus());
        payment1.pay(45000.0);
        System.out.println("Initial Status : " + payment1.getTransactionStatus());

        System.out.println("\nInitial Status : " + payment2.getTransactionStatus());
        payment2.pay(250000.0);
        System.out.println("Initial Status : " + payment2.getTransactionStatus());

        System.out.println("\nInitial Status : " + payment3.getTransactionStatus());
        payment3.pay(5500.0);
        System.out.println("Initial Status : " + payment3.getTransactionStatus());

        return;
    }
}
