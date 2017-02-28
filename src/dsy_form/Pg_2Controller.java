/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsy_form;

import admission_form.FXMLController1;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import static edit_uni.EditController.getEnroll;
import static edit_uni.EditController.getFormid;
import static edit_uni.EditController.getName;
import static finalpro.LoginController.getCurUser;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

/**
 * FXML Controller class
 *
 * @author ankushbchoubey
 */
public class Pg_2Controller implements Initializable {
    @FXML
    private Label bplace_village;
    @FXML
    private Label bplace_district;
    @FXML
    private Label blc_taluka;
    @FXML
    private Label bplace_state;
    @FXML
    private Label father_name2;
    @FXML
    private Label father_occ;
    @FXML
    private Label father_relation;
    @FXML
    private Label father_landline;
    @FXML
    private Label father_mobile;
    @FXML
    private Label total_income;
    @FXML
    private Label stud_address;
    @FXML
    private Label stud_mobile;
    @FXML
    private Label stud_email;
    @FXML
    private Label nplace_village;
    @FXML
    private Label nplc_taluka;
    @FXML
    private Label nplace_district;
    @FXML
    private Label nplace_state;
    @FXML
    private Label stud_ssc;
    @FXML
    private Label ssc_total;
    @FXML
    private Label ssc_totalmarks;
    @FXML
    private Label ssc_per;
    @FXML
    private Label ssc_passyr;
    @FXML
    private Button print_btn;
    @FXML
    private Button nextB;
    @FXML
    private Button back_btn;

    private static boolean jobRunning = true;
    
    /**
     * Initializes the controller class.
     */
    
    
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
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try
        {
            con1();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/pro",username,password);
            String query="select * from uni where formid=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,getFormid());
            //ps.setString(1,""+130);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                bplace_village.setText(rs.getString("dob_village"));
                blc_taluka.setText(rs.getString("dob_taluka"));
                bplace_district.setText(rs.getString("dob_district"));
                bplace_state.setText(rs.getString("dob_state"));
                father_name2.setText(rs.getString("cand_fa"));
                father_occ.setText(rs.getString("occupation"));
                father_relation.setText(rs.getString("relation"));
                father_landline.setText(rs.getString("land_num"));
                father_mobile.setText(rs.getString("father_num"));
                total_income.setText(rs.getString("income"));
                stud_address.setText(rs.getString("address"));
                stud_mobile.setText(rs.getString("mob_num"));
                stud_email.setText(rs.getString("email_id"));
                nplace_village.setText(rs.getString("dob_village"));
                nplace_district.setText(rs.getString("dob_district"));
                nplace_state.setText(rs.getString("dob_state"));
                nplc_taluka.setText(rs.getString("dob_taluka"));
                
                ssc_totalmarks.setText(rs.getString("ssctot"));
                ssc_per.setText(rs.getString("sscper"));
                ssc_passyr.setText(rs.getString("qyear"));
            }else
            {
                System.out.println("No student selected");//Add error dialog box selected
            }
        }catch(Exception ex){ex.printStackTrace();}
    }    

    @FXML
    private void nextButton(ActionEvent event) {
        Parent par = null;
        try {
            par = FXMLLoader.load(getClass().getResource("/dsy_form/pg_3.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Pg_2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
            Scene scene = new Scene(par);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void doPrinting(ActionEvent event) {
        print_btn.setVisible(false);
        back_btn.setVisible(false);
        nextB.setVisible(false);
        Scene scene = print_btn.getScene();
            WritableImage snapshot = scene.snapshot(null);
            BufferedImage image = SwingFXUtils.fromFXImage(snapshot, null);
            File f = new File("test2.png");
        try {
            ImageIO.write(image,"png",f);
        } catch (IOException ex) {
            
        }
        Document document = new Document(PageSize.A4,0,0,0,0);
        try {
        PdfWriter.getInstance(document,new FileOutputStream("Image.pdf"));
        document.open();
          // BufferedImage img = ImageIO.read(new File("test1.png"));
        //File f = new File("test1.png");
        Image image1 = Image.getInstance("test2.png");
        document.add(image1);


        document.close();
    } catch(Exception e){
      e.printStackTrace();
    }
        try{
        InputStream is = new BufferedInputStream(new FileInputStream("Image.pdf"));
        DocFlavor flavor = DocFlavor.INPUT_STREAM.PDF;
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob printJob = service.createPrintJob();
        printJob.addPrintJobListener(new Pg_2Controller.JobCompleteMonitor());
        Doc doc = new SimpleDoc(is,flavor,null);
        PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
        //attributes.add(new Destination(new java.net.URI("file:/home/jayesh/NetBeansProjects/myFile.ps")));
        printJob.print(doc,attributes);
        //while(jobRunning)
        //{
        //    Thread.sleep(1000);
        //}
        is.close();
        }catch(Exception ex){}
        finally{
        System.out.println("exiting");
        
        }
        System.out.println("Done");
        try
        {
            con1();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/pro",username,password);
            String query="insert into log values(?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, getCurUser());
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
            ps.setString(2,"Printed Direct Second Year Form Page2 at "+df.format(date));
            ps.executeUpdate();
            
        }catch(Exception ex){ex.printStackTrace();}
        print_btn.setVisible(true);
        back_btn.setVisible(true);
        nextB.setVisible(true);
    }

    @FXML
    private void onClickBack(ActionEvent event) {
        Stage stage = new Stage();
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("/dsy_form/pg_1.fxml"));
            Scene scene = new Scene(par);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
        }catch(Exception ex){ex.printStackTrace();}
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.show();       
    }
     private static class JobCompleteMonitor extends PrintJobAdapter
    {
        @Override
        public void printJobCompleted(PrintJobEvent event)
        {
            System.out.println("Job completed");
            jobRunning = false;
        }
    }
}
