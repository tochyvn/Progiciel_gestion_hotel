package library;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.util.Duration;

public class Animation {
	
	/**
	 * Créer des animation sur une Property d'un composante par exple l'opacité, la translation
	 * @param property représente la propriété de l'objet à animer
	 */
	public static void doAnimationProperty(DoubleProperty property, double start, double end) {
		Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
            new KeyFrame(Duration.ZERO, new KeyValue(property, start)),
            new KeyFrame(new Duration(5000), new KeyValue(property, end))
        );
        
        timeline.play();
	}
	
	public static void doAnimationTanslateX(DoubleProperty translateX, double start, double end) {
		Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
            new KeyFrame(Duration.ZERO, new KeyValue(translateX, 45)),
            new KeyFrame(new Duration(1000), new KeyValue(translateX, -200))
        );
        //Faire l'aller et retour automatique
        timeline.setAutoReverse(true);
        //Durée des cycles indéterminé
        timeline.setCycleCount(Timeline.animation.Animation.INDEFINITE);
        timeline.play();
	}
}
