/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railway;

import static edit_uni.EditController.getFormid;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    Connection con;
    Statement stat;
    ResultSet rs;
    @FXML
    private int formid=125;
     @FXML
    private Label cand_month;

    @FXML
    private Label period;

    @FXML
    private Label curr_date;

    @FXML
    private Label cand_year;

    @FXML
    private Label src_stn;

    @FXML
    private Label dest_stn;

    @FXML
    private Label last_ticket_upto;

    @FXML
    private Label amt;

    @FXML
    private Label prev_cer;

    @FXML
    private Label class_no;

    @FXML
    private Label duration;

    @FXML
    private Label hr_perday;

    @FXML
    private Label cand_course;

    @FXML
    private Label prev_dated;

    @FXML
    private Label cand_name;

    @FXML
    private Label cand_dob;

    @FXML
    private Label doi;
    @FXML
    private Button b1;
    @FXML
    private TextField hr_per_day;

    @FXML
    private TextField end_date;

    @FXML
    private TextField cls_no;

    @FXML
    private TextField period_input;

    @FXML
    private TextField amount;

    @FXML
    private TextField strt_date;

    @FXML
    private TextField src;

    @FXML
    private Label today_date;

    @FXML
    private TextField name_of_course;

    @FXML
    private TextField dest;

    @FXML
    private Label years;

    @FXML
    private Button output;

    @FXML
    private TextField ending;

    @FXML
    private Label month;

    @FXML
    private TextField avaliable;

    @FXML
    private TextField ticket_no;

    @FXML
    private Label name;

    @FXML
    private TextField dateoi;

    @FXML
    private TextField holds;

    @FXML
    private TextField duration_course;
    @FXML
    private Label holdsl;
     @FXML
    private Label ticketno;
      @FXML
    private Label start_date;
       @FXML
    private Label enddate;
        @FXML
    private Label endng;
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
    private void connect()
    {
        try {
            con();
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro",username,password);
            stat=con.createStatement();
            rs=stat.executeQuery("select * from uni where formid="+formid);
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    static int abc=0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        //formid=125;
        if(abc==0)
        {
            System.out.println("Inside if");
            fillIn();
        }
        else
        {
            System.out.println("Inside else");
            fillOut();
        }
        
         
    }
    //declare all strings
    String cname,a,b,c,d,e,f,g,h,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    
    private void fillIn()
    {
        connect();
        try{
         System.out.println("Inside fillin");
         if(rs.next())
          { 
              //fill input forms fields only not output
            cname=rs.getString("cand_f")+rs.getString("cand_s");
            name.setText(cname);
            rs.close();
            stat.close();
            con.close();
           }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    private void fill1()
    {
              a=name_of_course.getText();
            b=duration_course.getText();
            c=hr_per_day.getText();
            d=period_input.getText();
            e=src.getText();
            g=dest.getText();
            h=dateoi.getText();
            j=cls_no.getText();
            k=amount.getText();
            l=avaliable.getText();
            m=holds.getText();
            n=ticket_no.getText();
            o=strt_date.getText();
            p=end_date.getText();
            q=ending.getText();
      
    }
    private void fillOut()
    {
        
        
         
         System.out.println("Inside fillout");
         
              //only fill output form fields
         System.out.println(a+"\n"+b+"\n"+c+"\n"+v+"\n"+p+"\n"+q+"\n"+k);
            //cand_name.setText(""+name);
            cand_course.setText(""+a);
            duration.setText(""+b);
            hr_perday.setText(""+c);
            period.setText(""+d);
            src_stn.setText(""+e);
            dest_stn.setText(""+g);
            doi.setText(""+h);
            class_no.setText(""+j);
            amt.setText(""+k);
            last_ticket_upto.setText(""+l);
            holdsl.setText(""+m);
            ticketno.setText(""+n);
            start_date.setText(""+o);
            enddate.setText(""+p);
            endng.setText(""+q);
          
        
    }
    @FXML
            Stage stage;
        @FXML
         public void retive()
         {
             stage=new Stage();
            System.out.println("inside the retrive methd");
            fill1();
            System.out.println(a+"\n"+b+"\n"+c+"\n"+v+"\n"+p+"\n"+q+"\n"+k);
            try{
                       abc=100;
                 Parent par = FXMLLoader.load(getClass().getResource("RailwayOutput.fxml"));
                    Scene scene = new Scene(par);
                    stage.setScene(scene);
                    stage.show();
             //       fillOut();
            }
            catch(Exception ex){
            ex.printStackTrace();
            }
         }
    }    

    
      
    


