package ie.atu.studentmanagerpackage;

public class Main {
    public static void main(String[] args) {
        // Create a StudentManager object
        StudentManager studentManager = new StudentManager();

        // Create a Student object
        Student student1 = new Student("G00123456", "John", 20);
        Student student2 = new Student("G00123457", "Mary", 21);
        Student student3 = new Student("G00123458", "Tom", 22);

        // Add the student to the StudentManager object
        studentManager.addStudent(student1);
        // Find the total number of students in the StudentManager object
        System.out.println(studentManager.findTotalStudents());

        // Print first element of the studentManager object
        System.out.println(studentManager.studentArrayList.get(0).getName());

        // Fing a student by studentId
        studentManager.printStudent(studentManager.findStudentById("G00123456"));

        // Remove the student from the StudentManager object
        studentManager.removeStudent(student1);

        studentManager.printStudent(studentManager.findStudentById("G00123456"));

        // Find the total number of students in the StudentManager object
        System.out.println(studentManager.findTotalStudents());

        // Add the student to the StudentManager object arrayList
        studentManager.addStudent(student1);
        studentManager.addStudent(student2);
        studentManager.addStudent(student3);

        // Print all students in the StudentManager object arrayList
        studentManager.printAllStudents();
    }
}
