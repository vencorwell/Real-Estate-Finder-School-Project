package house_hunting;
import java.util.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * Displays a GUI for house hunting.
 * Interacts with the user.
 * Accepts user criteria and arranges for search
 * 
 * @author V. Corwell
 * @version November 1, 2025
 */
public class HouseListTester extends Application
{
	// List of houses that meet the criteria
	private ArrayList<House> houses;

	//-------------------------------------------------------
	// Helper functions
	//-------------------------------------------------------
	/**
	 * For Minimum Input Values - Get integer value from TextField, with default values for empty fields
	 * @param tf
	 * @return int value from TextField, or 0 if empty
	 */
	public int getMinTextFieldIntValue(TextField tf)
	{
		return (tf.getText().isEmpty()) ? 0 : Integer.parseInt(tf.getText());
	}

	/**
	 * For Maximum Input Values - Get integer value from TextField, with default values for empty fields
	 * @param tf
	 * @return int value from TextField, or Integer.MAX_VALUE if empty
	 */
	public int getMaxTextFieldIntValue(TextField tf)
	{
		return (tf.getText().isEmpty()) ? Integer.MAX_VALUE : Integer.parseInt(tf.getText());
	}

	/**
	 * Selects a random House from the list of available houses and removes it from the list
	 * @return the selected House
	 */
	public House getRandomHouse()
	{
		int index = (int)(Math.random() * houses.size());
		House selectedHouse = houses.get(index);
		houses.remove(index);
		return selectedHouse;
	}

	//-------------------------------------------------------
	/**
	 * Start method - sets up GUI and event handlers
	 */
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		// Start up Screen
		Button startButton = new Button("Find My Dream Home!");
		Button anotherButton = new Button("Not my dream - find me another!");
		anotherButton.setDisable(true);

		VBox welcomeLayout = new VBox(15, startButton, anotherButton);
        welcomeLayout.setAlignment(Pos.CENTER);
        Scene welcomeScene = new Scene(welcomeLayout, 420, 300);


		//-------------------------------------------------------
		// Main Screen

		// Obtain the house list
		HouseList availableHouses = new HouseList("houses.txt");
		
		// Title
		Label title = new Label("Real Estate Listings");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: darkgreen;");

		// Input fields for criteria
		TextField minPriceInput = new TextField();
        TextField maxPriceInput = new TextField();
        TextField minAreaInput = new TextField();
        TextField maxAreaInput = new TextField();
        TextField minBedInput = new TextField();
        TextField maxBedInput = new TextField();

		// Layout for labels and input fields
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(15);
		grid.setPadding(new Insets(10, 10, 10, 10));

		grid.add(new Label("Minimum Price:"), 0, 0);
		grid.add(minPriceInput, 1, 0);
		grid.add(new Label("Maximum Price:"), 0, 1);
		grid.add(maxPriceInput, 1, 1);
		grid.add(new Label("Minimum Area:"), 0, 2);
		grid.add(minAreaInput, 1, 2);
		grid.add(new Label("Maximum Area:"), 0, 3);
		grid.add(maxAreaInput, 1, 3);
		grid.add(new Label("Minimum Bedrooms:"), 0, 4);
		grid.add(minBedInput, 1, 4);
		grid.add(new Label("Maximum Bedrooms:"), 0, 5);
		grid.add(maxBedInput, 1, 5);

		// Result display area
		Label chosenLabel = new Label("Chosen Home");
		chosenLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: darkgreen;");
		TextField chosenHomeField = new TextField();
		chosenHomeField.setEditable(false);
        chosenHomeField.setPrefWidth(250);
		
		// Buttons
		Button findButton = new Button("Find My Dream Home!");
		anotherButton.setDisable(true);
		Button resetButton = new Button("Reset");

		HBox buttonBox = new HBox(15, findButton, anotherButton);
		buttonBox.setAlignment(Pos.CENTER);

		VBox layout = new VBox(15, title, grid, chosenLabel, chosenHomeField, buttonBox, resetButton);
		layout.setAlignment(Pos.TOP_CENTER);
		layout.setPadding(new Insets(20));

		Scene mainScene = new Scene(layout, 420, 500);


		//-------------------------------------------------------
		// Button Actions
		//-------------------------------------------------------
		// Start Button Action
		startButton.setOnAction(e -> {
			primaryStage.setScene(mainScene);
		});

		// Find Dream House Button Action
		findButton.setOnAction(e -> {
			// This button needs to create a Criteria object from user input and store it in the ArrayList

			// Move focus away from input fields (highlight button instead of input field)
			findButton.getParent().requestFocus(); 
			
			// Get user input values
			int minPrice = getMinTextFieldIntValue(minPriceInput);
			int maxPrice = getMaxTextFieldIntValue(maxPriceInput);
			int minArea = getMinTextFieldIntValue(minAreaInput);
			int maxArea = getMaxTextFieldIntValue(maxAreaInput);
			int minBed = getMinTextFieldIntValue(minBedInput);
			int maxBed = getMaxTextFieldIntValue(maxBedInput);
			
			// Create Criteria object
			Criteria userCriteria = new Criteria(minPrice, maxPrice, minArea, maxArea, minBed, maxBed);
			
			// Get list of houses that meet criteria
			houses = availableHouses.metCriteriaList(userCriteria);
			
			if(houses.isEmpty())
			{
				chosenHomeField.setText("No matching houses found.");
				// Disable the 'Find Another House' button if not already disabled
				anotherButton.setDisable(true);
			}
			else
			{
				// Display the selected house address
				chosenHomeField.setText(getRandomHouse().getAddress());
				// Enable the 'Find Another House' button
				anotherButton.setDisable(false);
			}

			findButton.setDisable(true);
		});

		// Find Another House Button Action
		anotherButton.setOnAction(e -> {
			if(houses.isEmpty())
			{
				chosenHomeField.setText("No more available houses.");
				// Disable the button if no more houses are available
				anotherButton.setDisable(true);
			}
			else
			{
				// Display the selected house address
				chosenHomeField.setText(getRandomHouse().getAddress());
			}
		});

		// Reset Button Action
		resetButton.setOnAction(e -> {

			// Clear all input fields and result display
			minPriceInput.clear();
			maxPriceInput.clear();
			minAreaInput.clear();
			maxAreaInput.clear();
			minBedInput.clear();
			maxBedInput.clear();
			chosenHomeField.clear();

			// Clear the list of available houses
			houses = null;

			// Reset buttons
			findButton.setDisable(false);
			findButton.getParent().requestFocus();
			anotherButton.setDisable(true);
		});

		// Set initial scene
		primaryStage.setTitle("Real Estate Finder");
		primaryStage.setScene(welcomeScene);
		primaryStage.show();
	}
	//-------------------------------------------------------
	// Main method
	public static void main(String[] args) 
	{
		launch(args);
	}

}
