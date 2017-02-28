/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delete;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
      @FXML
    private Button cancel_btn1;
    @FXML
    private TextField name_tf1;
    @FXML
    private TextField formid_tf;
    @FXML
    private TextField enroll_tf1;
    @FXML
    private Button ok_btn1;
    @FXML
    private Button dialogreset_btn;
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }   
    Connection con;
    private void connect()
    {
          try {
              Class.forName("com.mysql.jdbc.Driver");
               con=DriverManager.getConnection("jdbc:mysql://localhost/pro","root","vinay");
          } catch (ClassNotFoundException ex) {
              ex.printStackTrace();
          } catch (SQLException ex) {
              Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    @FXML
    private void onDelete(ActionEvent event) 
    {
        if(!formid_tf.getText().isEmpty())
        {
        try{
            connect();
            System.out.println("in onDel");
            String query="delete from uni where formid=?";
            PreparedStatement ps = con.prepareStatement(query);
            int a;
            a=Integer.parseInt(formid_tf.getText());
            ps.setInt(1,a);
            int stat=ps.executeUpdate();
            if(stat>0)
            {
            try
            {
                Stage stage = new Stage();
                Parent par = FXMLLoader.load(getClass().getResource("success.fxml"));
                Scene scene = new Scene(par);
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                }catch(Exception ex){}
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            
        }catch(Exception ex){ex.printStackTrace();}
        }else if(!enroll_tf1.getText().isEmpty()){
        try{
            connect();
            System.out.println("in onDel");
            String query="delete from uni where enroll=?";
            PreparedStatement ps = con.prepareStatement(query);
            int a;
            a=Integer.parseInt(enroll_tf1.getText());
            ps.setInt(1,a);
            int stat=ps.executeUpdate();
            if(stat>0)
            {
            try
            {
                Stage stage = new Stage();
                Parent par = FXMLLoader.load(getClass().getResource("success.fxml"));
                Scene scene = new Scene(par);
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                }catch(Exception ex){}
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            
        }catch(Exception ex){ex.printStackTrace();}            
        }
        
        
    }
    @FXML
    private void onClickdialogreset(ActionEvent event) {
        name_tf1.clear();
        enroll_tf1.clear();
        formid_tf.clear();
    }
    @FXML
    private void onClickCancel(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}

