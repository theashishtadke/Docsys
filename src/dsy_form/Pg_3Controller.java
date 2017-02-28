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
public class Pg_3Controller implements Initializable {
    @FXML
    private Label qualify_year;
    @FXML
    private Label qualify_per;
    @FXML
    private Label qualify_exam_total;
    @FXML
    private Label qualify_exam_sum;
    @FXML
    private Label vocational_sub;
    @FXML
    private Button print_btn;
    @FXML
    private Button back_btn;
    
    private static boolean jobRunning = true;
    
    /**
     * Initializes the controller class.
     */String username,password;
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
                vocational_sub.setText(rs.getString("vacation_sub"));
                qualify_exam_sum.setText(rs.getString("qmarks"));//verify if it is proper field
               qualify_exam_total.setText(rs.getString("qoexam"));
                qualify_per.setText(rs.getString("qper"));
                qualify_year.setText(rs.getString("qyear"));
            }else
            {
                System.out.println("No student selected");//Add error dialog box selected
            }
        }catch(Exception ex){ex.printStackTrace();}
    }    

    @FXML
    private void doPrinting(ActionEvent event) {
        print_btn.setVisible(false);
        back_btn.setVisible(false);
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
        printJob.addPrintJobListener(new Pg_3Controller.JobCompleteMonitor());
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
            ps.setString(2,"Printed Direct Second Year Form Page3 at "+df.format(date));
            ps.executeUpdate();
            
        }catch(Exception ex){ex.printStackTrace();}
        print_btn.setVisible(true);
        back_btn.setVisible(true);
    }

    @FXML
    private void onClickBack(ActionEvent event) {
        Stage stage = new Stage();
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("/dsy_form/pg_2.fxml"));
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
