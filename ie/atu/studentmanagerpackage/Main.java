package ie.atu.studentmanagerpackage;

public class Main {
    public static void main(String[] args) {
        // Create a StudentManager object
        StudentManager studentManager = new StudentManager();
        // Read student data from a csv file and add to the StudentManager object arrayList
        studentManager.readStudentDataFromCSVFile("./resources/students.csv");
        // Find total number of students in the StudentManager object arrayList
        System.out.println("Total number of students: " + studentManager.findTotalStudents());
        // Print all students in the StudentManager object arrayList
        studentManager.printAllStudents();
    }
}
