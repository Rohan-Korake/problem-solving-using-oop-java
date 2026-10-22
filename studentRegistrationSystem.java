// Student Registration System (static + this)
// Write a Java program to create a class Student with instance variables rollNo, name and branch, and a static variable collegeName shared by all students.
// • Use a parameterized constructor with the same parameter names as the instance variables, and use this to initialize them.
// • Use a static variable count to automatically assign roll numbers as objects are created.
// • Write a static method changeCollege(String newName) and show that changing it affects all objects.
// • Create at least three objects and display their details.

class Student {
    int rollNo;
    String name, branch;
    static String collegeName = "MITAOE";
    static int counter = 0;

    public Student(String name, String branch) {
        this.name = name;
        this.branch = branch;
        rollNo = ++counter;
    }

    public static void changeCollegeName(String newCollegeName) {
        collegeName = newCollegeName;
    }

    public void displayDetails() {
        System.out.println("---------- Student Details ----------");
        System.out.println("Roll no : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Branch  : " + branch);
        System.out.println("College : " + collegeName);
        System.out.println("-------------------------------------");
    }
}

public class studentRegistrationSystem {
    public static void main(String args[]) throws Exception {
        Student s1 = new Student("Rohan", "Computer");
        Student s2 = new Student("Alex", "Software");
        Student s3 = new Student("Jerry", "Civil");

        System.out.println("-------------------------------------");
        System.out.println("Intial Data With Default College Name");
        System.out.println("-------------------------------------");
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();

        Student.changeCollegeName("MITAOE Alandi");

        System.out.println("\n-------------------------------------");
        System.out.println("Intial Data With New College Name");
        System.out.println("-------------------------------------");
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();
        return;
    }
}
