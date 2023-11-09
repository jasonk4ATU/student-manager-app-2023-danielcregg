package ie.atu.studentmanagerpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

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

	// Filter the list of students by age
	public List<Student> getStudentsByAge(int age) {
		// Use Java 8 Streams to filter the list of students by age
		return studentArrayList.stream()
			.filter(student -> student.getAge() == age)
			.collect(Collectors.toList());
	}

	// Filter the list of students by a first name
	public void findStudentsByName(String firstName) {
		System.out.println("Here are all students with first name " + firstName + ":");
		// Use Java 8 Streams to filter the list of students by first name
		studentArrayList.stream()
			.filter(student -> student.getFirstName().equals(firstName))
			.forEach(student -> System.out.println(student.toString()));
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
            System.out.println("Student ID: " + student.getStudentId() + ", Student Name: " + student.getFirstName()
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
        } // End of while loop
    } // End of method

    public void readStudentDataFromCSVFile(String pathToStudentCSVFile) {
		// Use try-with-resources to void the need to close the streams in a finally
		try (BufferedReader bufferedStudentCSVFileReader = new BufferedReader(new FileReader(pathToStudentCSVFile))) {
			// Read first line of file and discard it. It contains column headers.
			bufferedStudentCSVFileReader.readLine();
			String bufferData; // Variable to store each line of data read from file
			// Read each line of data from file and add it to the studentList
			while ((bufferData = bufferedStudentCSVFileReader.readLine()) != null) {
				String[] studentFieldValues = bufferData.split(",");
				String studentId = studentFieldValues[0];
				String firstName = studentFieldValues[1];
				int age = Integer.parseInt(studentFieldValues[2]);
				addStudent(new Student(studentId, firstName, age)); // Add student to studentList
			}
			System.out.println("Student data read from CSV file located at " + pathToStudentCSVFile);
		} catch (IOException e) {
			System.err.println(
					"ERROR: An error occurred while reading the student data from the file: " + e.getMessage());
			e.printStackTrace();
		}
	}

} // End of class
