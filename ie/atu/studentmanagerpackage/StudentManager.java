package ie.atu.studentmanagerpackage;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    // Create an arrayList to hold Student objects
    List<Student> studentArrayList = new ArrayList<Student>();

    // Add a student to the arrayList
    public void addStudent(Student student) {
        studentArrayList.add(student);
    }

    // Remove a student from the arrayList
    public void removeStudent(Student student) {
        studentArrayList.remove(student);
    }

    // Find the total number of students in the arrayList
    public int findTotalStudents() {
        return studentArrayList.size();
    }

    // Search for a student by studentId
    public Student findStudentById(String studentId) {
        for (Student student : studentArrayList) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    // Print instance variables a given student object
    public void printStudent(Student student) {
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
    }
   
}
