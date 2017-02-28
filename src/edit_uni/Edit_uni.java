/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edit_uni;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jayesh
 */
public class Edit_uni extends Application {
    
    @Override
    public void start(Stage stage) {
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("uni.fxml"));
            Scene scene = new Scene(par);
            stage.setScene(scene);
        }catch(Exception ex){}
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
