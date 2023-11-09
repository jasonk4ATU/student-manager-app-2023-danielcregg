package ie.atu.studentmanagerpackage;

public class Student {
    // Instance variabes
    private String studentId;
    private String firstName;
    private int age;

    // Constructor
    public Student(String studentId, String name, int age) {
        this.studentId = studentId;
        this.firstName = name;
        this.age = age;
    }

    // Getters
    public String getStudentId() {
        return this.studentId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getAge() {
        return this.age;
    }

    // Setters
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    // toString -  returns a String representation of the object
    @Override
    public String toString() {
        return "Student ID: " + this.studentId + ", Name: " + this.firstName + ", Age: " + this.age;
    }
}
