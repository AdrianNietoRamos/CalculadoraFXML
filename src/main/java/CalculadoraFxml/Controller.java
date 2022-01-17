package CalculadoraFxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class Controller implements Initializable{
	
	Calculadora cal = new Calculadora();
	public Controller() throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}
	@FXML
	private GridPane view;
	
	@FXML
	private TextField resultadoText;
	
	@FXML
	private Button sieteButton;
	
	@FXML
	private Button ochoButton;
	
	@FXML
	private Button nueveButton;
	
	@FXML
	private Button cuatroButton;
	
	@FXML
	private Button cincoButton;
	
	@FXML
	private Button seisButton;
	
	@FXML
	private Button unoButton;
	
	@FXML
	private Button dosButton;
	
	@FXML
	private Button tresButton;
	
	@FXML
	private Button ceroButton;
	
	@FXML
	private Button sumaButton;
	
	@FXML
	private Button comaButton;
	
	@FXML
	private Button restaButton;
	
	@FXML
	private Button dividirButton;
	
	@FXML
	private Button borrartodoButton;
	
	@FXML
	private Button borrarButton;
	
	@FXML
	private Button multiplicarButton;
	
	@FXML
	private Button igualButton;
	
	@FXML
	void onBorrarAction(ActionEvent event) {
		cal.borrar();		
	}

	@FXML
	void onBorrarTodoAction(ActionEvent event) {
		cal.borrarTodo();		
	}

	@FXML
	void onCeroAction(ActionEvent event) {
		cal.insertar('0');
		
	}

	@FXML
	void onCincoAction(ActionEvent event) {
		cal.insertar('5');
	}

	@FXML
	void onComaAction(ActionEvent event) {
		cal.insertarComa();
	}

	@FXML
	void onCuatroAction(ActionEvent event) {
		cal.insertar('4');
	}

	@FXML
	void onDividirAction(ActionEvent event) {
		cal.operar(Calculadora.DIVIDIR);
	}

	@FXML
	void onDosAction(ActionEvent event) {
		cal.insertar('2');
	}

	@FXML
	void onIgualAction(ActionEvent event) {
		cal.operar(Calculadora.IGUAL);
	}

	@FXML
	void onMultiplicarAction(ActionEvent event) {
		cal.operar(Calculadora.MULTIPLICAR);
	}

	@FXML
	void onNueveAction(ActionEvent event) {
		cal.insertar('9');
	}

	@FXML
	void onOchoAction(ActionEvent event) {
		cal.insertar('8');
	}

	@FXML
	void onRestaAction(ActionEvent event) {
		cal.operar(Calculadora.RESTAR);
	}

	@FXML
	void onSeisAction(ActionEvent event) {
		cal.insertar('6');
	}

	@FXML
	void onSieteAction(ActionEvent event) {
		cal.insertar('7');
	}

	@FXML
	void onSumaAction(ActionEvent event) {
		cal.operar(Calculadora.SUMAR);
	}

	@FXML
	void onTresAction(ActionEvent event) {
		cal.insertar('3');
	}

	@FXML
	void onUnoAction(ActionEvent event) {
		cal.insertar('1');
	}

public GridPane getView() {
	return view;
	
}
public Calculadora getModel() {
	return cal;
}

	public void initialize(URL location, ResourceBundle resources) {
		resultadoText.textProperty().bind(cal.pantallaProperty());
		MenuItem menuClasico=new MenuItem("Clasico");
		menuClasico.setOnAction(e->{
			view.getStylesheets().clear();
			view.getStylesheets().add(getClass().getResource("/css/clasico.css").toExternalForm());
		});
		MenuItem menuModerno=new MenuItem("Moderno");
		menuModerno.setOnAction(e->{
			view.getStylesheets().clear();
			view.getStylesheets().add(getClass().getResource("/css/moderno.css").toExternalForm());
			
		});
		ContextMenu menu=new ContextMenu(menuClasico,menuModerno);
		view.setOnContextMenuRequested(e->{
			menu.show(view,e.getScreenX(),e.getScreenY());
		});
	

}
}