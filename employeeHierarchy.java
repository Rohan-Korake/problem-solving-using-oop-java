// Employee Hierarchy (super + this)
// Create a base class Employee with fields empId, name and basicSalary, and a method calculateSalary(). Derive a class Manager that adds allowance.
// • Call the parent class constructor from Manager using super(...).
// • Override calculateSalary() in Manager and call the parent's version using super.calculateSalary(), then add the allowance.
// • Use constructor chaining with this(...) in Manager to provide a default allowance when none is given.
// • Display the salary of both an Employee and a Manager object.

class Employee {
    int empId;
    String name;
    double basicSalary;

    public Employee(int id, String name, double basicSalary) {
        this.empId = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }

    public void displayDetails() {
        System.out.println("\n--- Employee Salary Invoice ---");
        System.out.println("Employee Id    : " + empId);
        System.out.println("Employee Name  : " + name);
        System.out.println("Basic Salary   : " + basicSalary);
        System.out.println("Total Salary   : " + calculateSalary());
        System.out.println("---------------------------------");
    }
}

class Manager extends Employee {
    double allowance;

    public Manager(int empId, String name, double basicSalary, double allowance) {
        super(empId, name, basicSalary);
        this.allowance = allowance;
    }

    public Manager(int empId, String name, double basicSalary) {
        this(empId, name, basicSalary, basicSalary);
    }

    public double calculateSalary() {
        return super.calculateSalary() + allowance;
    }

    public void displayDetails() {
        System.out.println("\n------- Manager Salary Invoice -------");
        System.out.println("Manager Id   : " + empId);
        System.out.println("Manager Name : " + name);
        System.out.println("Basic Salary : " + basicSalary);
        System.out.println("Allowance    : " + allowance);
        System.out.println("Total Salary : " + calculateSalary());
        System.out.println("---------------------------------");
    }
}

public class employeeHierarchy {
    public static void main(String[] args) throws Exception {
        Employee emp = new Employee(434, "Rohan", 300000);

        Manager mgr1 = new Manager(501, "Vaibhav", 400000, 15000.0);
        Manager mgr2 = new Manager(234, "Om", 500000);

        System.out.println("\n----- Regular Empolyee Details -----");
        emp.displayDetails();

        System.out.println("\n---- Manager 01 (With allowance) ----");
        mgr1.displayDetails();

        System.out.println("\n---- Manager 02 (Without allowance) ----");
        mgr2.displayDetails();
        return;
    }
}
