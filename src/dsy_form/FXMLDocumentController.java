/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsy_form;

import static edit_uni.EditController.getFormid;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Nitu
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private ImageView imageView;
   
    @FXML
    Button nextB;
    @FXML
    Label last_name;
    @FXML
    Label first_name;
    @FXML
    Label father_name;
    @FXML
    Label mother_name;
    @FXML
    Label gender;
    @FXML
    Label category;
    @FXML
    Label cast;
    @FXML
    Label religion;
    @FXML
    Label nationality;
    @FXML
    Label DOB;
    @FXML
    Label dob_word;
    int i=0;
    int formid;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       formid=Integer.parseInt(getFormid());
        connect();
        connect2();
     //   if(i==0)
       // {System.out.println("executing init "+i);connect();}
    }    
    Connection con;
    Statement stat;
    ResultSet rs;
    String username,password;
       FileWriter fw;
    BufferedWriter bf;
    BufferedReader br;
    FileReader fr;

    private void con1()throws Exception
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
        private void makecon()
        {System.out.println("Connecting");
               try{
                   con1();
        Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro",username,password);
         stat=con.createStatement();
         
               }catch(Exception e){e.printStackTrace();}
               System.out.println("Connected");
        }
    public void connect()
    {
        try{
        makecon();
        rs=stat.executeQuery("select * from uni where formid="+formid);
        while(rs.next())
        {
            File file = new File("src//images/Desert.jpg");
        
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
            last_name.setText(rs.getString("cand_s"));
            first_name.setText(rs.getString("cand_f"));
            father_name.setText(rs.getString("cand_fa"));
            mother_name.setText(rs.getString("cand_m"));
           gender.setText(rs.getString("gender"));
            category.setText(rs.getString("cast"));
            //cast.setText(rs.getString("cast"));
            religion.setText(rs.getString("religion"));
            nationality.setText("India");
            DOB.setText(rs.getString("DOBDate"));
            //dob_word.setText(rs.getString(1));
            //JOptionPane.showMessageDialog(this,"Record not inserted","Error",0);
            
            //disconnect();
        }   
        //disconnect();
        }catch(Exception e){e.printStackTrace();}
    }
        
    private void disconnect()throws Exception{
    con.close();
    stat.close();
    rs.close();
    }
    @FXML
    Stage stage ;
    @FXML
    public void nextButton()
    {
        try{
        i=100;
        Parent root=FXMLLoader.load(getClass().getResource("/admission_form/form2.fxml"));
        Scene sc=new Scene(root);
        stage=new Stage();
        stage.setScene(sc);
        stage.show();
        
        Scene cur=nextB.getScene();
        cur.getWindow().hide();
        connect2();
        connect2();
        }catch(Exception e){e.printStackTrace();}
    }
    
    
        @FXML
    Label father_name2;
    @FXML
    Label bplace_village;
    @FXML
    Label bplace_district;
    @FXML
    Label blc_taluka;
    @FXML
    Label bplace_state;
    @FXML
    Label father_relation;
    @FXML
    Label father_landline;
    @FXML
    Label father_mobile;
    @FXML
    Label father_occ;
    @FXML
    Label total_income;
    @FXML
    Label stud_address;
    @FXML
    Label stud_mobile;
    @FXML
    Label stud_email;
    @FXML
    Label nplace_village;
    @FXML
    Label nplc_taluka;
    @FXML
    Label nplace_district;
    @FXML
    Label nplace_state;
    @FXML
    Label stud_ssc;
    @FXML
    Label ssc_total;
    @FXML
    Label ssc_totalmarks;
    @FXML
    Label ssc_per;
    @FXML
    Label ssc_passyr;
    @FXML
    Label qualifying_exam;
    @FXML
    Label vocational_sub;
    @FXML
    Label QES;
    @FXML
    Label qualify_exam_total;
    @FXML
    Label qualify_per;
    @FXML
    Label qualify_year;
    
    private void connect2()
    {
        try
        {
            makecon();
            rs=stat.executeQuery("select * from uni where formid="+formid);
            System.out.println("filling");
            while(rs.next())
            {         System.out.println(1);
            bplace_village.setText(rs.getString(6));
            bplace_district.setText(rs.getString(5));
            blc_taluka.setText(rs.getString(7));
            bplace_state.setText(rs.getString(8));
            System.out.println(1);
            
            father_name2.setText(rs.getString(9));
            System.out.println(1);
            father_occ.setText(rs.getString(10));
            System.out.println(1);
            father_relation.setText(rs.getString(11));
            System.out.println(1);
            father_landline.setText(rs.getString(12));
            System.out.println(1);
            father_mobile.setText(rs.getString(13));
            total_income.setText(rs.getString(14));
            
            stud_address.setText(rs.getString(15));
            stud_mobile.setText(rs.getString(16));
            stud_email.setText(rs.getString(17));
            nplace_village.setText(rs.getString(6));
            nplc_taluka.setText(rs.getString(7));
            nplace_district.setText(rs.getString(5));
            nplace_state.setText(rs.getString(8));
            //stud_ssc.setText(rs.getString("ssctot"));
            ssc_total.setText(rs.getString("ssctot"));
            ssc_totalmarks.setText(rs.getString("sscoutof_marks"));
            ssc_per.setText(rs.getString("sscper"));
            String s[]=rs.getString("qyear").split("-");
            ssc_passyr.setText(""+(Integer.parseInt(s[0])));
            qualifying_exam.setText(rs.getString("qual_exam"));
     vocational_sub.setText(rs.getString("vocationexam"));
     QES.setText(rs.getString("qoexam"));
     qualify_exam_total.setText(rs.getString("qmarks"));
     qualify_per.setText(rs.getString("qper"));
     qualify_year.setText(rs.getString("qyear"));
                       System.out.println(1);
        }
        disconnect();
        //JOptionPane.showMessageDialog(this,"Record inserted sucessfully","sucessful",1);
        System.out.println("Record inserted sucessful");
        }catch(Exception e){
            e.printStackTrace();
}}

    
}
