// Problem 8.2 University Exam Marks Entry System
// Practical 8b: Implement a program to create own exception class.
// Scenario: Faculty members enter students' marks into the university portal. Marks must be between 0 and 100. Java has no built-in exception for "marks out of range", because that is a business rule of the university. Create a custom exception InvalidMarksException. Throw it when the entered marks are invalid, and calculate the grade only when they are valid.
// Step 1: Create the custom exception class
// 1.⁠ ⁠Create a class InvalidMarksException that extends Exception. This makes it a checked exception.
// 2.⁠ ⁠Add a private field int marks to store the wrong value.
// 3.⁠ ⁠Write a constructor (shown below). super(message) must be the first statement.
// 4.⁠ ⁠Add a getter public int getMarks().
// public InvalidMarksException(String message, int marks) {
//     super(message);      // must be the first statement
//     this.marks = marks;
// }
// Step 2: Create the class Student
// 1.⁠ ⁠Private fields: String rollNo, String name and int marks.
// 2.⁠ ⁠A constructor that takes rollNo and name.
// 3.⁠ ⁠A method getGrade() that returns a grade using this table:
// Marks	Grade
// 90 – 100	O
// 75 – 89	A
// 60 – 74	B
// 40 – 59	C
// Below 40	F (Fail)
// Step 3: Write the setMarks() method that throws the exception
// Signature:
// public void setMarks(int marks) throws InvalidMarksException
// Inside it:
// •⁠  ⁠a) If marks < 0, throw new InvalidMarksException("Marks cannot be negative", marks)
// •⁠  ⁠b) If marks > 100, throw new InvalidMarksException("Marks cannot exceed 100", marks)
// •⁠  ⁠c) Otherwise assign this.marks = marks;
// throws (in the signature) warns the caller. throw (in the body) actually raises the exception.
// Step 4: Write main() in class MarksEntryPortal
// 1.⁠ ⁠Create an array of 3 students and their entered marks:
// Student[] list = {
//     new Student("CE101", "Riya"),
//     new Student("CE102", "Aman"),
//     new Student("CE103", "Sneha")
// };
// int[] enteredMarks = {85, 112, -5};   // 2nd and 3rd are wrong
// 2.⁠ ⁠Use a for loop. For each student, inside a separate try block:
// •⁠  ⁠call list[i].setMarks(enteredMarks[i]);
// •⁠  ⁠print the roll number, name, marks and grade.
// 3.⁠ ⁠In catch (InvalidMarksException e), print:
// •⁠  ⁠"Error for " + rollNo + ": " + e.getMessage()
// •⁠  ⁠"Entered value: " + e.getMarks()
// 4.⁠ ⁠In finally, print "Record processed for " + rollNo.
// Think: Why is the try-catch placed inside the loop and not around it? What happens to Sneha's entry if you put it outside?
// Step 5: Expected output
// CE101 | Riya  | Marks: 85 | Grade: A
// Record processed for CE101
// Error for CE102: Marks cannot exceed 100
// Entered value: 112
// Record processed for CE102
// Error for CE103: Marks cannot be negative
// Entered value: -5
// Record processed for CE103
// Class Structure
// Exception (java.lang)
//      extends
// InvalidMarksException          Student
// •⁠  ⁠marks                        - rollNo, name, marks
// + getMarks()                   + setMarks(int)
//      thrown by setMarks()        throws InvalidMarksException
//                                + getGrade()

// MarksEntryPortal.main() → for loop → try / catch / finally

class InvalidMarksException extends Exception {
    private int marks;

    public InvalidMarksException(String message, int marks) {
        super(message);
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }
}

class Student {
    private String rollNo;
    private String name;
    private int marks;

    public Student(String rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public String getGrade() {
        if (marks >= 90)
            return "O";
        if (marks >= 75)
            return "A";
        if (marks >= 60)
            return "B";
        if (marks >= 40)
            return "C";
        return "F (Fail)";
    }

    public void setMarks(int marks) throws InvalidMarksException {
        if (marks < 0) {
            throw new InvalidMarksException("Marks cannot be negative", marks);
        } else if (marks > 100) {
            throw new InvalidMarksException("Marks cannot exceed 100", marks);
        }
        this.marks = marks;
    }

    public void displayResult() {
        System.out.println(
                "Roll No : " + rollNo + " | Name : " + name + " | Marks : " + marks + " | Grade : " + getGrade());
    }
}

public class marksEntryPortal {
    public static void main(String[] args) {
        System.out.println();
        Student[] list = {
                new Student("CO101", "Riya"),
                new Student("CO102", "Aman"),
                new Student("CO103", "Sneha")
        };

        int enteredMarks[] = { 85, 112, -5 };

        for (int i = 0; i < list.length; i++) {
            String currentRollNo = "CE10" + (i + 1);
            try {
                list[i].setMarks(enteredMarks[i]);
                list[i].displayResult();
            } catch (InvalidMarksException e) {
                System.out.println("Error for rollNo " + currentRollNo + " : " + e.getMessage());
            } finally {
                System.out.println("Record processed for " + currentRollNo);
                System.out.println("----------------------------------------\n");
            }
        }
        return;
    }
}
