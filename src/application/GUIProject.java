package application;

import javafx.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.scene.effect.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.util.Duration;

import static java.lang.Math.random;

public class GUIProject extends Application {

	private Button startGameButton;
	private Button exitGameButton;
	private Button goBackButton1;
	private Button goBackButton2;
	private Button continueButton;

	private Button selectMageButton;
	private Button selectRogueButton;
	private Button selectWarriorButton;

	private Button enemy1Button;
	private Button enemy2Button;
	private Button enemy3Button;
	private Button enemy4Button;
	private Button enemy5Button;

	private Button mageAbilityButton;
	private Button rogueAbility1Button;
	private Button warriorAbility1Button;

	private Button specialAbility1Button;
	private Button specialAbility2Button;
	private Button specialAbility3Button;
	private Button specialAbility4Button;

	private Image warrior = new Image("file:src/warrior.png", 239.4, 453.6, false, false);
	private Image rogue = new Image("file:src/rogue.png", 239.4, 453.6, false, false);
	private Image mage = new Image("file:src/mage.png", 241.92, 456.96, false, false);
	// Image (enemyname) = new Image("file:src/(enemyname).png", ~240, ~455, false,
	// false);
	// Image (enemyname) = new Image("file:src/(enemyname).png", ~240, ~455, false,
	// false);
	// Image (enemyname) = new Image("file:src/(enemyname).png", ~240, ~455, false,
	// false);
	// Image (enemyname) = new Image("file:src/(enemyname).png", ~240, ~455, false,
	// false);
	// Image (enemyname) = new Image("file:src/(enemyname).png", ~240, ~455, false,
	// false);

	private ImageView selectedHero;
	private ImageView warriorStartImage;
	private ImageView rogueStartImage;
	private ImageView mageStartImage;
	private ImageView warriorSelectImage;
	private ImageView rogueSelectImage;
	private ImageView mageSelectImage;

	private Text finalShowdownText;
	private Text selectHeroText;
	private Text statsText;

	private Pane startPane;
	private Pane selectPane;
	private Pane statsPane;

	private Group startGroup;
	private Group selectGroup;
	private Group statsGroup;

	private Scene startScene;
	private Scene selectScene;
	private Scene statsScene;

	private Stage sceneStage;

	// Str int dex con

	private Button addStrengthButton;
	private Button addIntelligenceButton;
	private Button addDexterityButton;
	private Button addConstitutionButton;

	private Button subStrengthButton;
	private Button subIntelligenceButton;
	private Button subDexterityButton;
	private Button subConstitutionButton;

	private Label strengthInfo;
	private Label intelligenceInfo;
	private Label dexterityInfo;
	private Label constitutionInfo;

	 int strengthNum = 10;
	 int intelligenceNum = 10;
	 int dexterityNum = 10;
	 int constitutionNum = 10;
	 
	 int lowerStrNum = strengthNum;
	 int lowerIntNum = intelligenceNum;
	 int lowerDexNum = dexterityNum;
	 int lowerConNum = constitutionNum;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		sceneStage = primaryStage; // This is used functionally for scene transitions

		/************************* Scene 1: The Opening Scene *************************/

		/* ImageView Modifications */

		warriorStartImage = new ImageView();
		warriorStartImage.setImage(warrior);
		warriorStartImage.setPreserveRatio(true);
		warriorStartImage.setLayoutX(30);
		warriorStartImage.setLayoutY(290);

		rogueStartImage = new ImageView();
		rogueStartImage.setImage(rogue);
		rogueStartImage.setLayoutX(680);
		rogueStartImage.setLayoutY(290);

		mageStartImage = new ImageView();
		mageStartImage.setImage(mage);
		mageStartImage.setLayoutX(1340);
		mageStartImage.setLayoutY(290);

		/* Text Field */

		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);
		ds.setColor(Color.color(0.8f, 0.6f, 0.8f));

		finalShowdownText = new Text(490, 120, "FINAL\nSHOWDOWN");
		finalShowdownText.setEffect(ds);
		finalShowdownText.setCache(true);
		finalShowdownText.setFill(Color.RED);
		finalShowdownText.setFont(Font.font("Impact", FontWeight.BOLD, 120));
		finalShowdownText.setTextAlignment(TextAlignment.CENTER);

		/* Button Field */

		startGameButton = new Button("Start");
		startGameButton.setStyle("-fx-font: 26 impact; -fx-base: #69d036;");
		startGameButton.setMinWidth(80.0);
		startGameButton.setPrefWidth(250.0);
		startGameButton.setMaxWidth(350.0);
		startGameButton.setMinHeight(50.0);
		startGameButton.setPrefHeight(50.0);
		startGameButton.setMaxHeight(50.0);
		startGameButton.setAlignment(Pos.CENTER);
		startGameButton.setLayoutX(660); // Sets the X co-ordinate
		startGameButton.setLayoutY(750); // Sets the Y co-ordinate

		exitGameButton = new Button("Exit");
		exitGameButton.setStyle("-fx-font: 26 impact; -fx-base: #ff3e00;");
		exitGameButton.setMinWidth(80.0);
		exitGameButton.setPrefWidth(250.0);
		exitGameButton.setMaxWidth(350.0);
		exitGameButton.setMinHeight(50.0);
		exitGameButton.setPrefHeight(50.0);
		exitGameButton.setMaxHeight(50.0);
		exitGameButton.setAlignment(Pos.CENTER);
		exitGameButton.setLayoutX(660); // Sets the X co-ordinate
		exitGameButton.setLayoutY(810); // Sets the Y co-ordinate

		startGameButton.setOnAction(e -> ButtonAction(e));
		exitGameButton.setOnAction(e -> ButtonAction(e));

		/* Weaving it altogether */

		startPane = new Pane();
		startPane.getChildren().addAll(finalShowdownText, startGameButton, exitGameButton, warriorStartImage,
				mageStartImage, rogueStartImage);

		startGroup = new Group(startPane);
		startScene = new Scene(startGroup, 1600, 900, Color.BLACK);
		primaryStage.setTitle("Final Showdown");
		primaryStage.setScene(startScene);
		primaryStage.show();

		/************************* Scene 2: Select Your Class *************************/

		/* ImageView Modifications */

		warriorSelectImage = new ImageView();
		warriorSelectImage.setImage(warrior);
		warriorSelectImage.setPreserveRatio(true);
		warriorSelectImage.setLayoutX(30);
		warriorSelectImage.setLayoutY(290);

		rogueSelectImage = new ImageView();
		rogueSelectImage.setImage(rogue);
		rogueSelectImage.setLayoutX(680);
		rogueSelectImage.setLayoutY(290);

		mageSelectImage = new ImageView();
		mageSelectImage.setImage(mage);
		mageSelectImage.setLayoutX(1340);
		mageSelectImage.setLayoutY(290);

		/* Text Field */

		DropShadow ds2 = new DropShadow();
		ds2.setOffsetY(3.0f);
		ds2.setColor(Color.color(0.8f, 0.6f, 0.8f));

		selectHeroText = new Text(420, 120, "Select Your Hero:");
		selectHeroText.setEffect(ds2);
		selectHeroText.setCache(true);
		selectHeroText.setFill(Color.RED);
		selectHeroText.setFont(Font.font("Impact", FontWeight.BOLD, 120));
		selectHeroText.setTextAlignment(TextAlignment.CENTER);

		/* Button Field */

		selectWarriorButton = new Button("Warrior");
		selectWarriorButton.setStyle("-fx-font: 26 impact; -fx-base: #b20a0a;");
		selectWarriorButton.setMinWidth(80.0);
		selectWarriorButton.setPrefWidth(250.0);
		selectWarriorButton.setMaxWidth(350.0);
		selectWarriorButton.setMinHeight(50.0);
		selectWarriorButton.setPrefHeight(50.0);
		selectWarriorButton.setMaxHeight(50.0);
		selectWarriorButton.setAlignment(Pos.CENTER);
		selectWarriorButton.setLayoutX(25); // Sets the X co-ordinate
		selectWarriorButton.setLayoutY(750); // Sets the Y co-ordinate

		selectRogueButton = new Button("Rogue");
		selectRogueButton.setStyle("-fx-font: 26 impact; -fx-base: #eff700;");
		selectRogueButton.setMinWidth(80.0);
		selectRogueButton.setPrefWidth(250.0);
		selectRogueButton.setMaxWidth(350.0);
		selectRogueButton.setMinHeight(50.0);
		selectRogueButton.setPrefHeight(50.0);
		selectRogueButton.setMaxHeight(50.0);
		selectRogueButton.setAlignment(Pos.CENTER);
		selectRogueButton.setLayoutX(660); // Sets the X co-ordinate
		selectRogueButton.setLayoutY(750); // Sets the Y co-ordinate

		selectMageButton = new Button("Mage");
		selectMageButton.setStyle("-fx-font: 26 impact; -fx-base: #0b357a;");
		selectMageButton.setMinWidth(80.0);
		selectMageButton.setPrefWidth(250.0);
		selectMageButton.setMaxWidth(350.0);
		selectMageButton.setMinHeight(50.0);
		selectMageButton.setPrefHeight(50.0);
		selectMageButton.setMaxHeight(50.0);
		selectMageButton.setAlignment(Pos.CENTER);
		selectMageButton.setLayoutX(1325); // Sets the X co-ordinate
		selectMageButton.setLayoutY(750); // Sets the Y co-ordinate

		goBackButton1 = new Button("Go Back");
		goBackButton1.setStyle("-fx-font: 26 impact; -fx-base: #ff3e00;");
		goBackButton1.setMinWidth(80.0);
		goBackButton1.setPrefWidth(250.0);
		goBackButton1.setMaxWidth(350.0);
		goBackButton1.setMinHeight(50.0);
		goBackButton1.setPrefHeight(50.0);
		goBackButton1.setMaxHeight(50.0);
		goBackButton1.setAlignment(Pos.CENTER);
		goBackButton1.setLayoutX(660); // Sets the X co-ordinate
		goBackButton1.setLayoutY(810); // Sets the Y co-ordinate

		selectWarriorButton.setOnAction(e -> ButtonAction(e));
		selectRogueButton.setOnAction(e -> ButtonAction(e));
		selectMageButton.setOnAction(e -> ButtonAction(e));
		goBackButton1.setOnAction(e -> ButtonAction(e));

		/* Weaving it altogether */

		selectPane = new Pane();
		selectPane.getChildren().addAll(selectHeroText, warriorSelectImage, mageSelectImage, rogueSelectImage,
				selectWarriorButton, selectRogueButton, selectMageButton, goBackButton1);
		selectGroup = new Group(selectPane);
		selectScene = new Scene(selectGroup, 1600, 900, Color.BLACK);

		/************************* Scene 3: Stat Distribution *************************/

		/* ImageView Modifications */

		selectedHero = new ImageView();

		DropShadow ds3 = new DropShadow();
		ds3.setOffsetY(3.0f);
		ds3.setColor(Color.color(0.8f, 0.6f, 0.8f));

		statsText = new Text(425, 120, "Stat Distribution");
		statsText.setEffect(ds3);
		statsText.setCache(true);
		statsText.setFill(Color.RED);
		statsText.setFont(Font.font("Impact", FontWeight.BOLD, 120));
		statsText.setTextAlignment(TextAlignment.CENTER);

		strengthInfo = new Label("Strength:\t\t" + strengthNum);
		strengthInfo.setLayoutX(100);
		strengthInfo.setLayoutY(300);
		strengthInfo.setFont(Font.font("Impact", FontWeight.BOLD, 50));
		strengthInfo.setTextFill(Color.WHITE);

		dexterityInfo = new Label("Dexterity:\t\t" + dexterityNum);
		dexterityInfo.setLayoutX(100);
		dexterityInfo.setLayoutY(400);
		dexterityInfo.setFont(Font.font("Impact", FontWeight.BOLD, 50));
		dexterityInfo.setTextFill(Color.WHITE);

		intelligenceInfo = new Label("Intelligence:\t" + intelligenceNum);
		intelligenceInfo.setLayoutX(100);
		intelligenceInfo.setLayoutY(500);
		intelligenceInfo.setFont(Font.font("Impact", FontWeight.BOLD, 50));
		intelligenceInfo.setTextFill(Color.WHITE);

		constitutionInfo = new Label("Constitution:\t" + constitutionNum);
		constitutionInfo.setLayoutX(100);
		constitutionInfo.setLayoutY(600);
		constitutionInfo.setFont(Font.font("Impact", FontWeight.BOLD, 50));
		constitutionInfo.setTextFill(Color.WHITE);

		addStrengthButton = new Button("+");
		addStrengthButton.setStyle("-fx-font: 26 impact; -fx-base: #69d036;");
		addStrengthButton.setMinWidth(50.0);
		addStrengthButton.setPrefWidth(50.0);
		addStrengthButton.setMaxWidth(50.0);
		addStrengthButton.setMinHeight(50.0);
		addStrengthButton.setPrefHeight(50.0);
		addStrengthButton.setMaxHeight(50.0);
		addStrengthButton.setAlignment(Pos.CENTER);
		addStrengthButton.setLayoutX(500); // Sets the X co-ordinate
		addStrengthButton.setLayoutY(310); // Sets the Y co-ordinate

		subStrengthButton = new Button("-");
		subStrengthButton.setStyle("-fx-font: 26 impact; -fx-base: #69d036;");
		subStrengthButton.setMinWidth(50.0);
		subStrengthButton.setPrefWidth(50.0);
		subStrengthButton.setMaxWidth(50.0);
		subStrengthButton.setMinHeight(50.0);
		subStrengthButton.setPrefHeight(50.0);
		subStrengthButton.setMaxHeight(50.0);
		subStrengthButton.setAlignment(Pos.CENTER);
		subStrengthButton.setLayoutX(560); // Sets the X co-ordinate
		subStrengthButton.setLayoutY(310); // Sets the Y co-ordinate

		addDexterityButton = new Button("+");
		addDexterityButton.setStyle("-fx-font: 26 impact; -fx-base: #69d036;");
		addDexterityButton.setMinWidth(50.0);
		addDexterityButton.setPrefWidth(50.0);
		addDexterityButton.setMaxWidth(50.0);
		addDexterityButton.setMinHeight(50.0);
		addDexterityButton.setPrefHeight(50.0);
		addDexterityButton.setMaxHeight(50.0);
		addDexterityButton.setAlignment(Pos.CENTER);
		addDexterityButton.setLayoutX(500); // Sets the X co-ordinate
		addDexterityButton.setLayoutY(410); // Sets the Y co-ordinate

		subDexterityButton = new Button("-");
		subDexterityButton.setStyle("-fx-font: 26 impact; -fx-base: #69d036;");
		subDexterityButton.setMinWidth(50.0);
		subDexterityButton.setPrefWidth(50.0);
		subDexterityButton.setMaxWidth(50.0);
		subDexterityButton.setMinHeight(50.0);
		subDexterityButton.setPrefHeight(50.0);
		subDexterityButton.setMaxHeight(50.0);
		subDexterityButton.setAlignment(Pos.CENTER);
		subDexterityButton.setLayoutX(560); // Sets the X co-ordinate
		subDexterityButton.setLayoutY(410); // Sets the Y co-ordinate

		addIntelligenceButton = new Button("+");
		addIntelligenceButton.setStyle("-fx-font: 26 impact; -fx-base: #69d036;");
		addIntelligenceButton.setMinWidth(50.0);
		addIntelligenceButton.setPrefWidth(50.0);
		addIntelligenceButton.setMaxWidth(50.0);
		addIntelligenceButton.setMinHeight(50.0);
		addIntelligenceButton.setPrefHeight(50.0);
		addIntelligenceButton.setMaxHeight(50.0);
		addIntelligenceButton.setAlignment(Pos.CENTER);
		addIntelligenceButton.setLayoutX(500); // Sets the X co-ordinate
		addIntelligenceButton.setLayoutY(510); // Sets the Y co-ordinate

		subIntelligenceButton = new Button("-");
		subIntelligenceButton.setStyle("-fx-font: 26 impact; -fx-base: #69d036;");
		subIntelligenceButton.setMinWidth(50.0);
		subIntelligenceButton.setPrefWidth(50.0);
		subIntelligenceButton.setMaxWidth(50.0);
		subIntelligenceButton.setMinHeight(50.0);
		subIntelligenceButton.setPrefHeight(50.0);
		subIntelligenceButton.setMaxHeight(50.0);
		subIntelligenceButton.setAlignment(Pos.CENTER);
		subIntelligenceButton.setLayoutX(560); // Sets the X co-ordinate
		subIntelligenceButton.setLayoutY(510); // Sets the Y co-ordinate

		addConstitutionButton = new Button("+");
		addConstitutionButton.setStyle("-fx-font: 26 impact; -fx-base: #69d036;");
		addConstitutionButton.setMinWidth(50.0);
		addConstitutionButton.setPrefWidth(50.0);
		addConstitutionButton.setMaxWidth(50.0);
		addConstitutionButton.setMinHeight(50.0);
		addConstitutionButton.setPrefHeight(50.0);
		addConstitutionButton.setMaxHeight(50.0);
		addConstitutionButton.setAlignment(Pos.CENTER);
		addConstitutionButton.setLayoutX(500); // Sets the X co-ordinate
		addConstitutionButton.setLayoutY(610); // Sets the Y co-ordinate

		subConstitutionButton = new Button("-");
		subConstitutionButton.setStyle("-fx-font: 26 impact; -fx-base: #69d036;");
		subConstitutionButton.setMinWidth(50.0);
		subConstitutionButton.setPrefWidth(50.0);
		subConstitutionButton.setMaxWidth(50.0);
		subConstitutionButton.setMinHeight(50.0);
		subConstitutionButton.setPrefHeight(50.0);
		subConstitutionButton.setMaxHeight(50.0);
		subConstitutionButton.setAlignment(Pos.CENTER);
		subConstitutionButton.setLayoutX(560); // Sets the X co-ordinate
		subConstitutionButton.setLayoutY(610); // Sets the Y co-ordinate

		continueButton = new Button("Continue");
		continueButton.setStyle("-fx-font: 26 impact; -fx-base: #69d036;");
		continueButton.setMinWidth(80.0);
		continueButton.setPrefWidth(250.0);
		continueButton.setMaxWidth(350.0);
		continueButton.setMinHeight(50.0);
		continueButton.setPrefHeight(50.0);
		continueButton.setMaxHeight(50.0);
		continueButton.setAlignment(Pos.CENTER);
		continueButton.setLayoutX(660); // Sets the X co-ordinate
		continueButton.setLayoutY(750); // Sets the Y co-ordinate

		goBackButton2 = new Button("Go Back");
		goBackButton2.setStyle("-fx-font: 26 impact; -fx-base: #ff3e00;");
		goBackButton2.setMinWidth(80.0);
		goBackButton2.setPrefWidth(250.0);
		goBackButton2.setMaxWidth(350.0);
		goBackButton2.setMinHeight(50.0);
		goBackButton2.setPrefHeight(50.0);
		goBackButton2.setMaxHeight(50.0);
		goBackButton2.setAlignment(Pos.CENTER);
		goBackButton2.setLayoutX(660); // Sets the X co-ordinate
		goBackButton2.setLayoutY(810); // Sets the Y co-ordinate

		goBackButton2.setOnAction(e -> ButtonAction(e));
		continueButton.setOnAction(e -> ButtonAction(e));
		
		addStrengthButton.setOnAction(e -> ButtonAction(e));
		addDexterityButton.setOnAction(e -> ButtonAction(e));
		addIntelligenceButton.setOnAction(e -> ButtonAction(e));
		addConstitutionButton.setOnAction(e -> ButtonAction(e));
		
		subStrengthButton.setOnAction(e -> ButtonAction(e));	
		subDexterityButton.setOnAction(e -> ButtonAction(e));	
		subIntelligenceButton.setOnAction(e -> ButtonAction(e));	
		subConstitutionButton.setOnAction(e -> ButtonAction(e));
		
		
		statsPane = new Pane();
		statsPane.getChildren().addAll(statsText, selectedHero, goBackButton2, continueButton, strengthInfo,
				intelligenceInfo, constitutionInfo, dexterityInfo, addStrengthButton, addDexterityButton,
				addIntelligenceButton, addConstitutionButton, subStrengthButton, subDexterityButton,
				subIntelligenceButton, subConstitutionButton);

		statsGroup = new Group(statsPane);
		statsScene = new Scene(statsGroup, 1600, 900, Color.BLACK);

		
		/************************* Scene 4: Enemy Selection *************************/
	}

	public void ButtonAction(ActionEvent e) {
		Stage stage;
		Parent root;
		if (e.getSource() == startGameButton) {
			sceneStage.setScene(selectScene);
		}

		if (e.getSource() == exitGameButton) {
			System.exit(0);
		}

		if (e.getSource() == selectMageButton) {
			sceneStage.setScene(statsScene);
			selectedHero.setImage(mage);
			selectedHero.setPreserveRatio(true);
			selectedHero.setLayoutX(1340);
			selectedHero.setLayoutY(290);

		}

		if (e.getSource() == selectRogueButton) {
			sceneStage.setScene(statsScene);
			selectedHero.setImage(rogue);
			selectedHero.setPreserveRatio(true);
			selectedHero.setLayoutX(1340);
			selectedHero.setLayoutY(290);
		}

		if (e.getSource() == selectWarriorButton) {
			sceneStage.setScene(statsScene);
			selectedHero.setImage(warrior);
			selectedHero.setPreserveRatio(true);
			selectedHero.setLayoutX(1340);
			selectedHero.setLayoutY(290);
		}

		if (e.getSource() == goBackButton1) {
			sceneStage.setScene(startScene);
		}

		if (e.getSource() == goBackButton2) {
			sceneStage.setScene(selectScene);
		}

		if (e.getSource() == continueButton) {

		}
		
		if(e.getSource() == addStrengthButton)
		{
			strengthNum++;
			strengthInfo.setText("Strength:\t\t" + strengthNum);
		}
		
		if(e.getSource() == subStrengthButton)
		{
			strengthNum--;
			strengthInfo.setText("Strength:\t\t" + strengthNum);
		}
		
		if(e.getSource() == addDexterityButton)
		{
			dexterityNum++;
			dexterityInfo.setText("Dexterity:\t\t" + dexterityNum);
		}
		
		if(e.getSource() == subDexterityButton)
		{
			dexterityNum--;
			dexterityInfo.setText("Dexterity:\t\t" + dexterityNum);
		}
		
		if(e.getSource() == addIntelligenceButton)
		{
			intelligenceNum++;
			intelligenceInfo.setText("Intelligence:\t" + intelligenceNum);
		}
		
		if(e.getSource() == subIntelligenceButton)
		{
			intelligenceNum--;
			intelligenceInfo.setText("Intelligence:\t" + intelligenceNum);
		}
		
		if(e.getSource() == addConstitutionButton)
		{
			constitutionNum++;
			constitutionInfo.setText("Constitution:\t" + constitutionNum);
		}
		
		if(e.getSource() == subConstitutionButton)
		{
			constitutionNum--;
			constitutionInfo.setText("Constitution:\t" + constitutionNum);
		}
	}
}
