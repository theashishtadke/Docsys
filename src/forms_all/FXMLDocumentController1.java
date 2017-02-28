/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms_all;

import static edit_uni.EditController.getFormid;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JFrame;

/**
 *
 * @author ankushbchoubey
 */
public class FXMLDocumentController1 extends JFrame implements Initializable {
    
    
    @FXML
            Label name;
    @FXML
            Label tdate;
    @FXML
            Label classname;
    Connection con;
    Statement stat;
    ResultSet rs;
    
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
         private void makecon()
        {
               try{
                   con();
        Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro",username,password);                                                                                                
         stat=con.createStatement();
         rs=stat.executeQuery("select * from uni where formid="+formid);
               }catch(Exception e){e.printStackTrace();}
        }
         @FXML
    private Label acayear;
    public void connect()
    {
        try{
        makecon();
        System.out.println("inside1");
        while(rs.next())
        {
            System.out.println("inside2");
            String str;
            str=rs.getString(1)+" "+rs.getString(4)+" "+rs.getString(3);
            name.setText(str);
            String str1,clas="";
            str1=rs.getString(22);
            if(str1.contains("C"))clas="COMPUTER ENGINEERING";
            if(str1.contains("I"))clas="Information Technology";
            if(str1.contains("E"))clas="Electronics ENGINEERING";
            classname.setText(clas);
            String pattern = "dd-MM-yyyy";
            String dateInString =new SimpleDateFormat(pattern).format(new Date());
            tdate.setText(dateInString);
            String s[]=dateInString.split("-");
            acayear.setText(""+(Integer.parseInt(s[2])-1)+"-"+""+(Integer.parseInt(s[2])));
            
            
            
        }   
        disconnect();
        }catch(Exception e){
                Stage stage = new Stage();
                try
                {
                    Parent par = FXMLLoader.load(getClass().getResource("/DialogsInt/data_not_filled.fxml"));
                    Scene scene = new Scene(par);
                    stage.setScene(scene);
                }catch(Exception ex){}
                stage.setResizable(false);
                stage.setTitle("Error!");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
    }
    System.out.println("outside1");
    }
        
    private void disconnect()throws Exception{
    con.close();
    stat.close();
    rs.close();
    }
    int formid;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try{
        formid=Integer.parseInt(getFormid());
        }catch(NumberFormatException e){
        
            Stage s = new Stage();
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("/DialogsInt/formid_not_selected.fxml"));
            Scene scene = new Scene(par);
            s.setScene(scene);
        }catch(Exception ex){}
        s.toFront();
        s.centerOnScreen();
        s.requestFocus();
        s.setAlwaysOnTop(true);
        
        s.setResizable(false);
        s.setTitle("Error!");
        s.initModality(Modality.APPLICATION_MODAL);
        s.show();
        }
        connect();
    }    
    
}
