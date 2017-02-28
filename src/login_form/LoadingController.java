/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_form;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nitu
 */
public class LoadingController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //connect();
    }
    @FXML
            Stage stage;
    Connection c;
    Statement stat;
    ResultSet rs;
    @FXML
    private Button check;
    BufferedReader br;
    FileReader fr;
    String username,password;
    private void con()throws Exception
    {
            fr=new FileReader("vinpass.txt");    
             br=new BufferedReader(fr);
            String str=br.readLine();
            String str1[]=str.split(" ");
            username=str1[0];
            password=str1[1];
            br.close();
            fr.close();
    }
     public void connect()
    { 
        try{
        con();
        Class.forName("com.mysql.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro",username,password);
        stat=c.createStatement();
        rs=stat.executeQuery("Select * from uni");
            Parent root=FXMLLoader.load(getClass().getResource("/finalpro/login.fxml"));
            Scene sc=new Scene(root);
            stage=new Stage();
            stage.setScene(sc);
            stage.show();
            Scene cur=check.getScene();
            cur.getWindow().hide();
            rs.close();
            stat.close();
        }
        catch(Exception e)
        {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/DialogsInt/No_Init.fxml"));
            Scene sc=new Scene(root);
            stage=new Stage();
            stage.setScene(sc);
            stage.show();
            Scene cur=check.getScene();
            cur.getWindow().hide();
            } catch (IOException ex) {
                  ex.printStackTrace();
                }
        
        }
    }
}
