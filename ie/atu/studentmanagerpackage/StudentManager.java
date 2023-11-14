package ie.atu.studentmanagerpackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.io.Serializable;

public class StudentManager implements Serializable {

	// Create a serialVersionUID for serialization
	private static final long serialVersionUID = 2L;

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
	public Student findStudentByIdWithIterator(String studentId) {
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

	// Search for a student by studentId
	public Optional<Student> findStudentById(String studentId) {
		// Iterate through the student arrayList
		for (Student student : studentArrayList) {
			// If the studentId matches the studentId passed
			// then return the student
			if (student.getStudentId().equals(studentId)) {
				return Optional.of(student);
			}
		}
		// If no student is found with studentId passed in, return Optional.empty
		return Optional.empty();
	}

	// Print all students in the arrayList
	public void printAllStudents() {
		System.out.println("Here are all the students:");
		// Use Java 8 Streams to print all students in the arrayList
		studentArrayList.stream()
				.forEach(student -> System.out.println(student.toString()));
	}

	// Method to write student data to a CSV file
	public void writeStudentDataToCSVFile(String pathToStudentCSVFile) {
		// Create a buffered writer to write to the CSV file
		try (BufferedWriter bufferedStudentCSVFileWriter = new BufferedWriter(
				new FileWriter(pathToStudentCSVFile))) {
			// Write column headers to file
			bufferedStudentCSVFileWriter.write("studentId,firstName,age");
			bufferedStudentCSVFileWriter.newLine();
			// Iterate through the student arrayList
			for (Student student : studentArrayList) {
				// Write student data to file
				bufferedStudentCSVFileWriter.write(student.getStudentId() + "," + student.getFirstName() + ","
						+ student.getAge());
				bufferedStudentCSVFileWriter.newLine();
			}
			System.out.println("Student data written to CSV file located at " + pathToStudentCSVFile);
		} catch (IOException e) {
			System.err.println(
					"ERROR: An error occurred while writing the student data to the file: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Method to read student data from a CSV file
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

	// Method to serialize the Student Manager Object
	public void writeToFile(String pathToFile) {
		// Use try-with-resources to void the need to close the streams in a finally
		try (FileOutputStream fos = new FileOutputStream(pathToFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			// Write the StudentManager object to file
			oos.writeObject(this);
			System.out.println("StudentManager object written to file located at " + pathToFile);
		} catch (Exception e) {
			System.out.println("ERROR: An error occurred while writing the StudentManager object to file!");
			e.printStackTrace();
		}
	}

	// Method to de-serialize the Student Manager Object
	public StudentManager readFromFile(String pathToFile) {
		StudentManager studentManagerObject = null;
		// Use try-with-resources to void the need to close the streams in a finally
		try (FileInputStream fis = new FileInputStream(pathToFile);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			// Read in object from file
			studentManagerObject = (StudentManager) ois.readObject();
		} catch (Exception e) {
			System.out.println("ERROR: An error occurred while reading the StudentManager object from file!");
			e.printStackTrace();
		}
		// Returns null if no object is read in or an exception occurs.
		return studentManagerObject;
	}

} // End of class
