package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EjercicioGIT extends Application {

	@Override
	public void start(Stage stage) {

		stage.setTitle("Formulario");
		//AnchorPane donde ira todo el escenario
		AnchorPane ancla = new AnchorPane();

		//Creacion de campos donde iran los datos
		//NOMBRE
		Label lblNombre = new Label("Nombre: ");
		TextField txtNombre = new TextField();

		Label lblEdad = new Label("Edad: ");
		ComboBox<Integer> cbxEdad = new ComboBox<Integer>();
		for(int i=1;i<=20;i++){
			cbxEdad.getItems().add(i);
		}
		//RAZA
		Label lblRaza = new Label("Raza: ");
		ComboBox<String> cbxRaza = new ComboBox<String>();
		cbxRaza.getItems().addAll("Pastor alemán","Bulldog","Chihuahua", "Pitbull");
		//PEDIGRI
		Label lblPedigri = new Label("Pedigrí: ");
		CheckBox chbxPedigri = new CheckBox();
		//PRECIO
		Label lblPrecio = new Label("Precio: ");
		Slider sldrPrecio = new Slider();
		sldrPrecio.setMin(1);
		sldrPrecio.setMax(2000);
		sldrPrecio.setMinorTickCount(50);
		sldrPrecio.setMajorTickUnit(100);
		sldrPrecio.setShowTickLabels(true);
		sldrPrecio.setShowTickMarks(true);
		sldrPrecio.setOnMouseDragged(value -> {
			lblPrecio.setText("Precio " + (int)sldrPrecio.getValue()+":");
		});
		//BOTON_ENVIAR
		//En este boton se envian los datos a una nueva ventana para verlos detenidamente
		Button btnEnviar = new Button("Enviar");
		btnEnviar.setOnAction(value -> {
			Stage stageEnviar = new Stage();
			stageEnviar.setTitle("Datos del Formulario");
			AnchorPane anclaEnviar = new AnchorPane();
			//TITULO
			Label lblFormulario = new Label("Datos del Formulario");
			//NOMBRE
			Label lblNombreDatos = new Label("Nombre: ");
			Text txtNombreDatos = new Text("");
			txtNombreDatos.setText(txtNombre.getText());
			//EDAD
			Label lblEdadDatos = new Label("Edad: ");
			Text txtEdadDatos = new Text("");
			txtEdadDatos.setText(String.valueOf(cbxEdad.getSelectionModel().getSelectedItem()));
			//RAZA
			Label lblRazaDatos = new Label("Raza: ");
			Text txtRazaDatos = new Text("");
			txtRazaDatos.setText(String.valueOf(cbxRaza.getSelectionModel().getSelectedItem()));
			//PEDIGRI
			Label lblPedigriDatos = new Label("Pedigrí: ");
			Text txtPedigriDatos = new Text("");
			if(chbxPedigri.isSelected()){
				txtPedigriDatos.setText("Ha marcado pedigrí");
			} else {
				txtPedigriDatos.setText("No ha marcado pedigrí");
			}
			//PRECIO
			Label lblPrecioDatos = new Label("Precio: ");
			Text txtPrecioDatos = new Text("");
			txtPrecioDatos.setText(String.valueOf((int)sldrPrecio.getValue()));
			//Se añaden los campos al escenario
			//TITULO
			AnchorPane.setTopAnchor(lblFormulario, 20.0);
			AnchorPane.setLeftAnchor(lblFormulario, 90.0);
			anclaEnviar.getChildren().add(lblFormulario);
			//NOMBRE
			AnchorPane.setTopAnchor(lblNombreDatos, 60.0);
			AnchorPane.setLeftAnchor(lblNombreDatos, 20.0);
			AnchorPane.setTopAnchor(txtNombreDatos, 60.0);
			AnchorPane.setLeftAnchor(txtNombreDatos, 90.0);
			anclaEnviar.getChildren().addAll(lblNombreDatos, txtNombreDatos);
			//EDAD
			AnchorPane.setTopAnchor(lblEdadDatos, 100.0);
			AnchorPane.setLeftAnchor(lblEdadDatos, 20.0);
			AnchorPane.setTopAnchor(txtEdadDatos, 100.0);
			AnchorPane.setLeftAnchor(txtEdadDatos, 90.0);
			anclaEnviar.getChildren().addAll(lblEdadDatos, txtEdadDatos);
			//RAZA
			AnchorPane.setTopAnchor(lblRazaDatos, 140.0);
			AnchorPane.setLeftAnchor(lblRazaDatos, 20.0);
			AnchorPane.setTopAnchor(txtRazaDatos, 140.0);
			AnchorPane.setLeftAnchor(txtRazaDatos, 90.0);
			anclaEnviar.getChildren().addAll(lblRazaDatos, txtRazaDatos);

			//Escena y mostrar el escenario
			Scene escenaEnviar = new Scene(anclaEnviar, 280, 250);
			stageEnviar.setScene(escenaEnviar);
			stageEnviar.show();
		});

		sumar(4,5);

		//Creacion de escena y se enseña por pantalla
		Scene escena = new Scene(ancla, 270, 340);
		stage.setScene(escena);
		stage.show();

	}

	public int sumar(int num1, int num2){
		int suma;

		suma = num1+ num2;

		return suma;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
