package dad.javafx.copyreplace;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CopyReplace extends Application {

	private Label buscarLabel, reemplazarLabel;
	private TextField buscarText, reemplazarText;
	private Button BuscarButtton, reemplazarButton, reemplazarAllButton, cerrarButton, helpButton;
	private CheckBox MayusCheck, searchBackCheck, regExpCheck, stickOutCheck;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		buscarLabel = new Label("Buscar:");
		reemplazarLabel = new Label("Reemplazar con:");
		
		buscarText = new TextField();
		reemplazarText = new TextField();
		
		BuscarButtton = new Button("Buscar");
		BuscarButtton.setMaxWidth(Double.MAX_VALUE);
		BuscarButtton.setDefaultButton(true);
		
		reemplazarButton = new Button("Reemplazar");
		reemplazarButton.setMaxWidth(Double.MAX_VALUE);
		reemplazarAllButton = new Button("Reemplazar todo");
		reemplazarAllButton.setMaxWidth(Double.MAX_VALUE);
		cerrarButton = new Button("Cerrar");
		cerrarButton.setMaxWidth(Double.MAX_VALUE);
		helpButton = new Button("Ayudar");
		helpButton.setMaxWidth(Double.MAX_VALUE);
		
		MayusCheck = new CheckBox("Mayúsculas  y minúsculas");
		searchBackCheck = new  CheckBox("Buscar hacia atrás");
		regExpCheck = new CheckBox("Expresión regular");
		stickOutCheck = new CheckBox("Resaltar resultados");
		
		// 3 columnas y 4 filas
		GridPane searchGrid = new GridPane();
		searchGrid.addRow(0, buscarLabel, buscarText);
		searchGrid.addRow(1, reemplazarLabel, reemplazarText);
		
		GridPane checkGrid = new GridPane();
		checkGrid.addRow(0, MayusCheck, searchBackCheck);
		checkGrid.addRow(1, regExpCheck, stickOutCheck);
		checkGrid.setHgap(5);
		checkGrid.setVgap(5);
		
		searchGrid.setHgap(5);
		searchGrid.setVgap(5);
		
		searchGrid.add(checkGrid, 1, 2);
		
		ColumnConstraints[] cols = {
			
				new ColumnConstraints(),
				new ColumnConstraints()
		};
		
		cols[1].setFillWidth(true);
		cols[1].setHgrow(Priority.ALWAYS);
		searchGrid.getColumnConstraints().addAll(cols);
		
		VBox btBox = new VBox(5, BuscarButtton, reemplazarButton, reemplazarAllButton, cerrarButton, helpButton);
		
		BorderPane root = new BorderPane();
		root.setCenter(searchGrid);
		root.setRight(btBox);
		root.setPadding(new Insets(5, 5, 5, 5));
		BorderPane.setMargin(searchGrid, new Insets(0,15,0,0));
		BorderPane.setAlignment(btBox, Pos.CENTER);
		
		Scene scene = new Scene(root, 600, 200);
		
		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
