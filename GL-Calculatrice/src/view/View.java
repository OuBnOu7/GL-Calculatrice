package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View extends Application {

    private TextField inputField;
    private String currentInput = "";
    private double result = 0.0;
    private String operator = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Calculator");
        inputField = new TextField();
        inputField.setEditable(false);

        GridPane buttonGrid = createButtonGrid();

        VBox vbox = new VBox(inputField, buttonGrid);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createButtonGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        String[][] buttonLabels = {
            {"7", "8", "9", "+"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "*"},
            {"C", "0", "=", "/"}
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Button button = new Button(buttonLabels[i][j]);
                button.setMinSize(50, 50);
                grid.add(button, j, i);

                final int row = i; // Declare a final variable to capture the current value of 'i' 
                final int riw = j; // Declare a final variable to capture the current value of 'i' 

                button.setOnAction(e -> handleButtonClick(buttonLabels[row][riw]));
            }
        }

        return grid;
    }

    private void handleButtonClick(String value) {
        if (value.matches("[0-9]")) {
            currentInput += value;
            inputField.setText(currentInput);
        } else if (value.equals("C")) {
            currentInput = "";
            result = 0.0;
            operator = "";
            inputField.setText("");
        } else if (value.equals("=")) {
            if (!currentInput.isEmpty() && !operator.isEmpty()) {
                double num = Double.parseDouble(currentInput);
                switch (operator) {
                    case "+":
                        result += num;
                        break;
                    case "-":
                        result -= num;
                        break;
                    case "*":
                        result *= num;
                        break;
                    case "/":
                        if (num != 0) {
                            result /= num;
                        } else {
                            inputField.setText("Error");
                            return;
                        }
                        break;
                }
                inputField.setText(String.valueOf(result));
                currentInput = "";
                operator = "";
            }
        } else {
            if (!currentInput.isEmpty()) {
                operator = value;
                result = Double.parseDouble(currentInput);
                currentInput = "";
            }
        }
    }
	
}
