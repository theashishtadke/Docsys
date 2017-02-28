/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcform;

import static edit_uni.EditController.getFormid;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
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
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Nitu
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label rNo;
    @FXML
    private Label sNo;
    @FXML
    private Label name;
    @FXML
    private Label religion;
    @FXML
    private Label cast;
    @FXML
    private Label nationality;
    @FXML
    private Label place_DOB;
    @FXML
    private Label word_DOB;
    @FXML
    private Label last_Cast_attend;
    @FXML
    private Label Date_Admission;
    @FXML
    private Label progress;
    @FXML
    private Label conduct;
    @FXML
    private Label date_of_leaving;
    @FXML
    private Label classStudy;
    @FXML
    private Label Since;
    @FXML
    private Label reason;
    @FXML
    private Label enroll;
    @FXML
    private Label remarks;
    
    int formid;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        con1();
        try {
            con2();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
    
    @FXML
    private void nextButton(ActionEvent event) throws IOException {
        Parent par;
      
            par = FXMLLoader.load(getClass().getResource("l2.fxml"));
        
            Scene scene = new Scene(par);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
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
     Connection c;
    Statement stat;
    ResultSet rs;
     public void connect()
    { try{
        con();
        Class.forName("com.mysql.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro",username,password);
        stat=c.createStatement();
        
        rs=stat.executeQuery("select * from uni where formid="+formid);
        
         }   catch(Exception e){System.out.println(e.getMessage());}
    }
    public void con1()
    {
        connect();
        try {
            rs.next();
            rNo.setText(" ");
            sNo.setText(rs.getString(1));
            String n=rs.getString(1);
            n+=" "+rs.getString(2);
            n+=" "+rs.getString(3);
            name.setText(n);
            religion.setText(rs.getString("religion"));
            cast.setText(rs.getString("cast"));
            nationality.setText("Indian");
            n=rs.getString(6);
            n+=" "+rs.getString(7);
            n+=" "+rs.getString(5);
            n+=" "+rs.getString(8);
            place_DOB.setText(n);
            word_DOB.setText(rs.getString("DOBDate"));
            date_of_leaving.setText(""+new Date());
            last_Cast_attend.setText("");
            String s[]=rs.getString("qyear").split("-");
            Since.setText(""+(Integer.parseInt(s[0])+1));
            Date_Admission.setText(""+(Integer.parseInt(s[0])));
            progress.setText("");
            conduct.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public void con2() throws IOException
    {
        connect();
        try {
            rs.next();
            //date_of_leaving.setText(rs.getString(1));
            String sq=rs.getString(22);
            if(sq.contains("C"))sq="Computer Engineering";
            if(sq.contains("I"))sq="Information Tech";
            if(sq.contains("E"))sq="Electronics";
            classStudy.setText(sq);
            //Since.setText(rs.getString(1));
            reason.setText("");
            enroll.setText(rs.getString(23));
            remarks.setText(" ");
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   
    }
        
}
