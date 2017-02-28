/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DialogsInt;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jayesh
 */
public class DialogsDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        try {
            Parent par = FXMLLoader.load(getClass().getResource("main.fxml"));
            Scene s = new Scene(par);
            stage.setScene(s);
        } catch (IOException ex) {
            Logger.getLogger(DialogsDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
