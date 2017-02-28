/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms_all;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ankushbchoubey
 */
public class BonafideForm extends Application {
    Stage s;
    @Override
    public void start(Stage stage) throws Exception {
        s=stage;
        Parent root = FXMLLoader.load(getClass().getResource("bonafide.fxml"));
        
        Scene scene = new Scene(root);
        
        s.setScene(scene);
        s.show();
    }

    public void close(){
        s.hide();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
