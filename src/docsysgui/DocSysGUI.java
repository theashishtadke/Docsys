/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docsysgui;

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
public class DocSysGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Documentation System");
        try {
            Parent parent=FXMLLoader.load(getClass().getResource("/docsysgui/GUI.fxml"));
            Scene scene=new Scene(parent);
            
            primaryStage.setScene(scene);
            
        } catch (IOException ex) {
            Logger.getLogger(DocSysGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
