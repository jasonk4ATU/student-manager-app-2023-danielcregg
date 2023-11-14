package ie.atu.studentmanagerpackage;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Create a StudentManager object
        StudentManager studentManager = new StudentManager();
        // Read student data from a csv file and add to the StudentManager object arrayList
        //studentManager.readStudentDataFromCSVFile("./resources/students.csv");
        // Read student data from a serialized file and add to the StudentManager object arrayList
        studentManager = studentManager.readFromFile("./resources/students.ser");
        // Find total number of students in the StudentManager object arrayList
        System.out.println("Total number of students: " + studentManager.findTotalStudents());
        // Print all students in the StudentManager object arrayList
        studentManager.printAllStudents();
        // Find a student by age
        System.out.println("Students with age 20:");
        // Use a for loop to iterate through the list of students with age 20
        // for (Student student : studentManager.getStudentsByAge(20)) {
        //     System.out.println(student.toString());
        // }
        studentManager.getStudentsByAge(20).forEach(student -> System.out.println(student.toString()));
        // Find a student by first name
        studentManager.findStudentsByName("Pat");
        studentManager.writeToFile("./resources/students.ser");     
        
        // Search for a student by studentId and print the student details
        Optional<Student> student = studentManager.findStudentById("G00111111");
        if (student.isPresent()) {
            System.out.println("Student with id G00111111: " + student.get().toString());
        } else {
            System.out.println("Student with id G00111111 not found");
        }
        
        // Write student data to a csv file
        studentManager.writeStudentDataToCSVFile("./resources/students.csv");

    } // End of main method
} // End of Main class
