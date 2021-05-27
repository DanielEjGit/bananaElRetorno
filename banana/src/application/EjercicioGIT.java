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

		//Agregamos dichos campos al panel
		//NOMBRE
		AnchorPane.setTopAnchor(lblNombre, 20.0);
		AnchorPane.setLeftAnchor(lblNombre, 20.0);
		AnchorPane.setTopAnchor(txtNombre, 20.0);
		AnchorPane.setLeftAnchor(txtNombre, 90.0);
		ancla.getChildren().addAll(lblNombre, txtNombre);
		//EDAD
		AnchorPane.setTopAnchor(lblEdad, 80.0);
		AnchorPane.setLeftAnchor(lblEdad, 20.0);
		AnchorPane.setTopAnchor(cbxEdad, 80.0);
		AnchorPane.setLeftAnchor(cbxEdad, 90.0);
		ancla.getChildren().addAll(lblEdad, cbxEdad);
		//RAZA
		AnchorPane.setTopAnchor(lblRaza, 140.0);
		AnchorPane.setLeftAnchor(lblRaza, 20.0);
		AnchorPane.setTopAnchor(cbxRaza, 140.0);
		AnchorPane.setLeftAnchor(cbxRaza, 90.0);
		ancla.getChildren().addAll(lblRaza, cbxRaza);
		//PEDIGRI
		AnchorPane.setTopAnchor(lblPedigri, 200.0);
		AnchorPane.setLeftAnchor(lblPedigri, 20.0);
		AnchorPane.setTopAnchor(chbxPedigri, 200.0);
		AnchorPane.setLeftAnchor(chbxPedigri, 90.0);
		ancla.getChildren().addAll(lblPedigri, chbxPedigri);
		//PRECIO
		AnchorPane.setTopAnchor(lblPrecio, 260.0);
		AnchorPane.setLeftAnchor(lblPrecio, 20.0);
		AnchorPane.setTopAnchor(sldrPrecio, 260.0);
		AnchorPane.setLeftAnchor(sldrPrecio, 90.0);
		ancla.getChildren().addAll(lblPrecio, sldrPrecio);
		//BOTON_ENVIAR
		AnchorPane.setTopAnchor(btnEnviar, 300.0);
		AnchorPane.setLeftAnchor(btnEnviar, 20.0);
		ancla.getChildren().add(btnEnviar);
		//Creacion de escena y se enseña por pantalla
		Scene escena = new Scene(ancla, 270, 340);
		stage.setScene(escena);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
