package ie.atu.studentmanagerpackage;

import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    // Create a StudentManager object to manage the student list
    StudentManager sm = new StudentManager();

    @Override
    public void start(Stage primaryStage) {
        // Get command line arguments
        Parameters params = getParameters();
        List<String> args = params.getRaw();

        // Create a GridPane to hold the GUI nodes
        GridPane gridPane1 = new GridPane(); // Create gridpane node to use as root node of scene

        // Create child nodes

        // Create Text node for label at top of scene 1
        Text txtHeader = new Text("Please select an option below:");

        // Add Student Button and 3 text fields for entering student details
        Button btnAddStudent = new Button("Add Student");
        TextField tfStudentID = new TextField();
        tfStudentID.setPromptText("Student ID");
        TextField tfStudentFirstName = new TextField();
        tfStudentFirstName.setPromptText("First Name");
        TextField tfStudentAge = new TextField();
        tfStudentAge.setPromptText("Age");

        // Create a button and text field to take a Student ID for deleting a student
        // from the list
        Button btnRemoveStudent = new Button("Remove Student");
        TextField tfDelStudent = new TextField();
        tfDelStudent.setPromptText("Student ID");

        // Show total number of students
        Button btnShowTotal = new Button("Show Total Students");

        // Create a Quit button
        Button btnQuit = new Button("Exit");

        // Create TextArea node for bottom of scene 1 to display output
        TextArea taMyOutput = new TextArea();

        // Adding and arranging all the nodes in the grid - add(node, column, row)
        gridPane1.add(txtHeader, 0, 0); // column 0, row 0
        gridPane1.add(btnAddStudent, 0, 1); // column 0, row 1
        gridPane1.add(tfStudentID, 1, 1); // column 1, row 1
        gridPane1.add(tfStudentFirstName, 2, 1);
        gridPane1.add(tfStudentAge, 4, 1);
        gridPane1.add(btnRemoveStudent, 0, 2);
        gridPane1.add(tfDelStudent, 1, 2);
        gridPane1.add(btnShowTotal, 0, 3);
        gridPane1.add(btnQuit, 0, 4);
        gridPane1.add(taMyOutput, 0, 5, 5, 1); //

        // Add Student button action
        btnAddStudent.setOnAction(e -> {
        // If any of the Student fields are empty print prompt message
        try {
        if (Student.isValid(tfStudentID.getText(), tfStudentFirstName.getText(),
        Integer.parseInt(tfStudentAge.getText())) == false) {
        taMyOutput.setText("Please enter valid Student details\n");
        } else {
        // Create new Student with information in text fields
        // Add student to student list
        if (sm.addStudentToList(tfStudentID.getText(), tfStudentFirstName.getText(),
        Integer.parseInt(tfStudentAge.getText()))) {
        taMyOutput.setText("Student added to list successfully\n");
        } else {
        taMyOutput.setText("Student not added to list\n");
        }
        // Clear input fields for next student
        tfStudentID.clear();
        tfStudentFirstName.clear();
        tfStudentAge.clear();
        }
        } catch (NumberFormatException ex) {
        ex.printStackTrace();
        taMyOutput.setText("Please enter a number for Age");
        }
        });

        // Remove Student button action
        btnRemoveStudent.setOnAction(e -> {

        if (tfDelStudent.getText().trim().equals("")) { // If text field is empty
        taMyOutput.setText("Please enter the Student Number you want to remove");
        } else {
        boolean status;
        status = sm.removeStudentFromList(tfDelStudent.getText());
        if (status == true) {
        taMyOutput.setText(tfDelStudent.getText() + " has been removed from the student list!");
        tfDelStudent.clear();
        } else {
        taMyOutput.setText("Student " + tfDelStudent.getText() + " not found\n");
        taMyOutput.appendText("No student removed!");
        tfDelStudent.clear();
        }
        }

        });

        // Show total number of students
        btnShowTotal.setOnAction(e -> {
            taMyOutput.setText("Current Total Students: " + sm.getStudentArrayList().size());
        });

        // Exit button action
        btnQuit.setOnAction(e -> Platform.exit());

        // ==== All nodes now added to the scene and actions configured ====

        // Create scene and add the root node i.e. the gridpane
        Scene scene1 = new Scene(gridPane1, 600, 450);
        // Setting the scene on which this stage will show
        primaryStage.setScene(scene1);

        // Set a default title
        primaryStage.setTitle("Student Manager Application");

        // Check command line args to see if -t or -f flag is present
        for (int i = 0; i < args.size(); i++) { // Loop through all args	
            switch (args.get(i)) { // Check which flag is present
                case "-t": // If -t flag is present
                    if (i + 1 < args.size()) { // Check if there is another arg after -t
                        String title = args.get(i + 1); // Get the title
                        primaryStage.setTitle(title); // Set the title
                    }
                    break; // Break out of the switch statement
                case "-f": // If -f flag is present
                    if (i + 1 < args.size()) { // Check if there is another arg after -f
                        String csvFilePath = args.get(i + 1); // Get the CSV file path
                        // Read students from the CSV file and add them to the studentArrayList
                        sm.readStudentDataFromCSVFile(csvFilePath);
                    }
                    break; // Break out of the switch statement
            }
        }

        // Displaying the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}