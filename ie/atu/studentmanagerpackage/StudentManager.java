package ie.atu.studentmanagerpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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

    // Search for a student by studentId using ListIterator
    public Student findStudentById(String studentId) {
        // Create a ListIterator to iterate through the arrayList
        ListIterator<Student> studentListIterator = studentArrayList.listIterator();
        // Iterate through the student arrayList
        while (studentListIterator.hasNext()) {
            Student student = studentListIterator.next();
            // If the studentId matches the studentId passed in, return the student
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        // If no student is found with studentId passed in, return null
        return null;
    }

    // Print instance variables of a given student object
    public void printStudent(Student student) {
        if (student == null) {
            System.out.println("Student does not exist!");
        } else {
            System.out.println("Student ID: " + student.getStudentId() + ", Student Name: " + student.getName()
                    + ", Student Age: " + student.getAge());
        }
    }

    // Print all students in the arrayList
    public void printAllStudents() {
        // Create a ListIterator to iterate through the arrayList
        ListIterator<Student> studentListIterator = studentArrayList.listIterator();
        // Iterate through the student arrayList
        while (studentListIterator.hasNext()) {
            Student student = studentListIterator.next();
            printStudent(student);
        }
    }

}
