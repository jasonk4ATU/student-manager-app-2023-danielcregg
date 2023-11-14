package ie.atu.studentmanagerpackage;

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
    }
}
