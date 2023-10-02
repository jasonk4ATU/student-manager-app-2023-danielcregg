package ie.atu.studentmanagerpackage;

public class Main {
    public static void main(String[] args) {
        // Create a new Student object
        Student studentObject1 = new Student("G00123456", "John", 20);
        
        // Print out the student's details
        System.out.println("Student ID: " + studentObject1.getStudentId());
        System.out.println("Name: " + studentObject1.getName());
        System.out.println("Age: " + studentObject1.getAge());
        
    }
}
