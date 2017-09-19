package tech.washmore.demo.springboot.fx.controller;

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLController;
import de.felixroske.jfxsupport.FXMLView;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@FXMLController
@FXMLView("/fxml/main.fxml")
public class MainViewController extends AbstractFxmlView {
    @FXML
    private TextField inputName;
    @FXML
    private Label showName;

    @FXML
    private Canvas snakeCanvas;
    @FXML
    private Label showNameAgain;


    @FXML
    private void setName(final Event e) {
        showName.setText(inputName.getText());
    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void timer() {
        //System.out.println(cavas.getLayoutX());
        System.out.println(LocalDateTime.now().toString());
        snakeCanvas.getGraphicsContext2D().fillRect(10, 10, 50, 50);
    }

}
