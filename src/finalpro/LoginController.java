/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jayesh
 */
public class LoginController implements Initializable {
    @FXML
    private TextField uid;
    @FXML
    private PasswordField pass;
    @FXML
    private Button loginb;
    @FXML
    private Button resetb;
    @FXML
    private Label uidn;
    @FXML
    private Label passn;
    DateFormat df;
    Date date;
    static String curuser;
    PreparedStatement ps;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        uidn.setVisible(false);
        passn.setVisible(false);
        //addb.setDisable(false);
        
    }    
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
    @FXML
    private void handleButtonAction(ActionEvent event) {
           String str="select * from staff where namer='"+uid.getText()+"' AND passr='"+pass.getText()+"'";
        
           try{ 
               con();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/pro",username,password);
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date = new Date();
        Statement stat=con.createStatement();
        ResultSet rs=stat.executeQuery(str);
        if(rs.next())
        {
        try{
            
            String query="insert into log values (?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,rs.getString(1));
            ps.setString(2,"Logged in at "+df.format(date));
            ps.executeUpdate();
            curuser=rs.getString("namer");
            if(uid.getText().equals("admin")&&pass.getText().equals("pass"))
            {
                Parent par = FXMLLoader.load(getClass().getResource("/finalpro/mediator.fxml"));
            Scene scene = new Scene(par);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
            }else
            {
            Parent par = FXMLLoader.load(getClass().getResource("/docsysgui/GUI.fxml"));
            Scene scene = new Scene(par);
            Stage stage = new Stage();
            stage.setScene(scene);
             
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setFullScreen(true);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
            }
        }catch(Exception e){e.printStackTrace();}
        }else
        {
            String query="insert into log values(?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1,uid.getText());
            ps.setString(2,"Tried logging in at "+df.format(date));
            ps.executeUpdate();
        }
        
        rs.close();
        stat.close();
        }
        catch(Exception e){System.out.println(e.getMessage());}
    }

    @FXML
    private void resetButton(ActionEvent event) {
        uid.setText("");
        pass.setText("");
    }
    
    public static String getCurUser()
    {
        return curuser;
    }
}
