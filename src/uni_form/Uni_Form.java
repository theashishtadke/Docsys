/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_form;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Nitu
 */
public class Uni_Form extends Application {
    static boolean flag=false;
    Parent root;
    @Override
    public void start(Stage stage) throws Exception {
        
        
        checkFile(stage);
    }
     public void checkFile(Stage stage)throws Exception
    {
        File f1=new File("demo.txt");
        if(f1.length()!=0)
        {
                stage = new Stage();
                try
                {
                    Parent par = FXMLLoader.load(getClass().getResource("/dialogs/staff_added.fxml"));
                    Scene scene = new Scene(par);
                    stage.setScene(scene);
                }catch(Exception ex){}
                stage.setResizable(false);
                stage.setTitle("Information!");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                flag=true;
                onCall(stage);
        }else
        {
            flag=false;
            onCall(stage);
            
        }
        
    }
    public void onCall(Stage stage)throws Exception
    {
        
        root = FXMLLoader.load(getClass().getResource("uni.fxml"));
        stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static boolean retFlag()
    {
        return(flag);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
