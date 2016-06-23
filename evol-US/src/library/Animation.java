package library;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.util.Duration;

public class Animation {
	
	/**
	 * Cr�er des animation sur une Property d'un composante par exple l'opacit�, la translation
	 * @param property repr�sente la propri�t� de l'objet � animer
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
        //Dur�e des cycles ind�termin�
        timeline.setCycleCount(Timeline.animation.Animation.INDEFINITE);
        timeline.play();
	}
}
