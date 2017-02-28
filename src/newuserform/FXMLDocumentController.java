/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newuserform;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JFrame;

/**
 *
 * @author ankushbchoubey
 */
public class FXMLDocumentController extends JFrame implements Initializable {
    
    
    @FXML
    private Button cancel;

    @FXML
    private PasswordField p1;

    @FXML
    private PasswordField p2;

    @FXML
    private TextField adminuser;

    @FXML
    private Button clear;


    @FXML
    private Label lpass2;

    @FXML
    private ListView<?> rights;

    @FXML
    private Label adminuserlabel;

    @FXML
    private Button create;

    @FXML
    private PasswordField adminpass;

    @FXML
    private Label lpass;

    @FXML
    private TextField username;

    @FXML
    private Label luser;
    @FXML
    Stage stage;
    @FXML
    private Label adminpasslabel;
    Connection c;
    Statement stat;
    ResultSet rs;
    PreparedStatement ps;
    BufferedReader br;
    FileReader fr;
    String username1,password1;
    private void con()throws Exception
    {
            fr=new FileReader("vinpass.txt");    
             br=new BufferedReader(fr);
            String str=br.readLine();
            String str1[]=str.split(" ");
            username1=str1[0];
            password1=str1[1];
            br.close();
            fr.close();
    }
    public void connect()
    { try{
        con();
        Class.forName("com.mysql.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro",username1,password1);
        //stat=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        stat=c.createStatement();
    }   catch(Exception e){System.out.println(e.getMessage());}
    }
    
    @FXML
    public void clearClicked(){
        username.setText("");
        adminpass.setText("");
        adminuser.setText("");  
        p1.setText("");
        p2.setText("");        
         luser.setVisible(false);
        lpass.setVisible(false);
        lpass2.setVisible(false);
        adminuserlabel.setVisible(false);
        adminpasslabel.setVisible(false);        
        //
    }
    @FXML
    public void createClicked(){
        //Add New User
        connect();
        if(p1.getText().equals(p2.getText())){ //checks if both userpassword matches
            lpass2.setVisible(false);
        }else{
           lpass2.setVisible(true);
        }
        
        if(p1.getText().isEmpty()){ //checks user password is entered
            lpass.setVisible(true);
        }else{
            lpass.setVisible(false);
        }
        
        if(username.getText().isEmpty()){ //checks if username is entered
            luser.setVisible(true);
        }else{
            luser.setVisible(false);
        }

        if(adminuser.getText().isEmpty()){
            adminuserlabel.setVisible(true);
        }else{
            adminuserlabel.setVisible(false);
        }
       
        if(adminpass.getText().isEmpty()){
            adminpasslabel.setVisible(true);
        }else{
          adminpasslabel.setVisible(false);
        }
 
        //
        String que="Select * from staff where namer ='admin'";
        try{
        rs=stat.executeQuery(que);
        if(rs.next())
        {
            System.out.print("admin correct");
            que="insert into staff values(?,?)";//+username.getText()+"','"+p1.getText()+"'";
            ps=c.prepareStatement(que);
            ps.setString(1, username.getText());
            ps.setString(2, p1.getText());
            int i=ps.executeUpdate();
            
            if(i==1){
            
                //JOptionPane.showMessageDialog(this,"Record inserted","New User",1);
                   try{
            Parent root=FXMLLoader.load(getClass().getResource("/finalpro/login1.fxml"));
             Scene sc=new Scene(root);
            stage=new Stage();
            stage.setScene(sc);
            stage.show();
            Scene cur=clear.getScene();
            cur.getWindow().hide();
                     }
                   catch(Exception e){e.printStackTrace();}
            }
            else
            {
                   Stage stage = new Stage();
                try
                {
                    Parent par = FXMLLoader.load(getClass().getResource("/DialogsInt/staff_not_added.fxml"));
                    Scene scene = new Scene(par);
                    stage.setScene(scene);
                }catch(Exception ex){}
                stage.setResizable(false);
                stage.setTitle("Error!");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
             
            }
        }
        rs.close();
        c.close();
        ps.close();
        stat.close();
        }catch(Exception e){}
    //AdminPassword
        //*******************Add admin username and password Checking
}
     @FXML
    public void cancelClicked(){
               try{
        Parent root=FXMLLoader.load(getClass().getResource("/login_form/login1.fxml"));
        Scene sc=new Scene(root);
        stage=new Stage();
        stage.setScene(sc);
        stage.show();
        Scene cur=clear.getScene();
        cur.getWindow().hide();
        
        }catch(Exception e){e.printStackTrace();}
 }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       clearClicked();
    }    
    
}
