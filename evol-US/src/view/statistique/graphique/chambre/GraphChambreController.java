package view.statistique.graphique.chambre;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class GraphChambreController implements Initializable {
	
	@FXML
	private PieChart pieChart;
	
	@FXML
	private Label pourcentage;
	
	private ObservableList<PieChart.Data> pieCharData;

	public GraphChambreController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		pieCharData = FXCollections.observableArrayList(
					new PieChart.Data("Chambres vides", 13),
					new PieChart.Data("Chambres en maintenance", 25),
					new PieChart.Data("Chambres ocupp�es", 10),
					new PieChart.Data("Chambre reserv�e non confirm�e", 22),
					new PieChart.Data("Chambres neutes", 30)
				);
		pieChart.setLabelLineLength(30);
		//pieChart.setLegendSide(Side.LEFT);
		//pieChart.setClockwise(false);
		pieChart.setData(pieCharData);
		pieChart.setTitle("Statut des chambres");
		
		pourcentage.setTextFill(Color.BLUE);
		
		pourcentage.setStyle("-fx-font: 24 arial;");

		for (final PieChart.Data data : pieChart.getData()) {
		    data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
		            @Override 
		            public void handle(MouseEvent e) {
		            	pourcentage.setTranslateX(e.getSceneX());
		            	//pourcentage.setTranslateY(e.getSceneY());
		                System.out.println("X : "+e.getSceneX()+"  Y : "+e.getSceneY()+" Value : "+data.getPieValue());
		                pourcentage.setText(String.valueOf(data.getPieValue()) + "%");
		            }
		        });
		}

	}

}
