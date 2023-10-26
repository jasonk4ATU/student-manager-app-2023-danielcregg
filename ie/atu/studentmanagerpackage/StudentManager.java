package ie.atu.studentmanagerpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    // Read student details from file csv file and add to studentList
	public void readStudentDataFromCSVFile(String pathToStudentCSVFile) {
		// Create a file object to represent the file
        File studentCSVFile = null;
		FileReader studentCSVFileReader = null;
		BufferedReader bufferedStudentCSVFileReader = null;
		String bufferLineData = null; // Used to store lines of data we read from the buffer

		// Create a file reader
		try {
            // Add a file object to represent the file
			studentCSVFile = new File(pathToStudentCSVFile);
            // Add a file reader to the file
			studentCSVFileReader = new FileReader(studentCSVFile);
			// Add a buffer to the file reader
			bufferedStudentCSVFileReader = new BufferedReader(studentCSVFileReader);
			// Read first line of file and discard it. It contains column headers.
			bufferedStudentCSVFileReader.readLine();

            // Keep reading lines of data from the buffer until we reach the end of the file
			while ((bufferLineData = bufferedStudentCSVFileReader.readLine()) != null) {
				// System.out.println(bufferLineData);
				String[] studentFieldValues = bufferLineData.split(",");
				// System.out.println(Arrays.toString(studentFieldValues));
				String studentId = studentFieldValues[0];
				String firstName = studentFieldValues[1];
				int age = Integer.parseInt(studentFieldValues[2]); // Convert age from String to int and store in age variable
				addStudent(new Student(studentId, firstName, age)); // Add student to studentList
			}
			System.out.println("Student data read from CSV file located at " + pathToStudentCSVFile);
		} catch (Exception ex) {
			System.err.println("ERROR: Students NOT saved to file!");
			ex.printStackTrace();
		} finally {
			try {
				// Flushes buffer, which transfers buffer data to the file, then closes buffer.
				bufferedStudentCSVFileReader.close();
				// Close the file reader stream
				studentCSVFileReader.close();
			} catch (Exception ex) {
				System.err.println("ERROR: Could not close the buffer file reader!");
				ex.printStackTrace();
			} // End catch
		} // End finally
	} // End read method

} // End of class
