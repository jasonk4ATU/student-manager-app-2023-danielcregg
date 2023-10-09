package ie.atu.studentmanagerpackage;

public class Main {
    public static void main(String[] args) {
        // Create a StudentManager object
        StudentManager studentManager = new StudentManager();

        // Create a Student object
        Student student1 = new Student("G00123456", "John", 20);

        // Add the student to the StudentManager object
        studentManager.addStudent(student1);

        // Print first element of the studentManager object
        System.out.println(studentManager.studentArrayList.get(0).getName());

        // Remove the student from the StudentManager object
        //studentManager.removeStudent(student1);

        // Print first element of the studentManager object
        //System.out.println(studentManager.studentArrayList.get(0).getName());

        // Find the total number of students in the StudentManager object
        System.out.println(studentManager.findTotalStudents());

        // Fing a student by studentId
        studentManager.printStudent(studentManager.findStudentById("G00123456"));

    }
}
