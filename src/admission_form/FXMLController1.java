/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admission_form;

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
 * @author jayesh
 */
public class FXMLController1 implements Initializable {
    @FXML
    private Label choice_pref31;
    @FXML
    private Label choice_pref21;
    @FXML
    private Label choice_pref11;
    @FXML
    private Label email_stud1;
    @FXML
    private Label mobno_21;
    @FXML
    private Label mobno_11;
    @FXML
    private Button print_btn;

    private static boolean jobRunning = true;
    
    /*
     * Initializes the controller class.
     */
    String username,password;
       FileWriter fw;
    BufferedWriter bf;
    BufferedReader br;
    FileReader fr;
    @FXML
    private Button back_btn;

    private void con1()throws Exception
    {
            fr=new FileReader("vinpass.txt");    
             br=new BufferedReader(fr);
            String str=br.readLine();
            String str1[]=str.split(" ");
            username=str1[0];
            System.out.println(username);
            password=str1[1];
            br.close();
            fr.close();
    }
   
    int formid;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try{
        int formid=Integer.parseInt(getFormid());
        }catch(NumberFormatException e){
        
            Stage s = new Stage();
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("/DialogsInt/formid_not_selected.fxml"));
            Scene scene = new Scene(par);
            s.setScene(scene);
        }catch(Exception ex1){}
        s.toFront();
        s.centerOnScreen();
        s.requestFocus();
        s.setAlwaysOnTop(true);
        
        s.setResizable(false);
        s.setTitle("Error!");
        s.initModality(Modality.APPLICATION_MODAL);
        s.show();
        }

        try
        {
            con1();
            System.out.println("initialize called");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro",username,password);
            String query="select * from uni where formid=? ";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,""+getFormid());
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                
                email_stud1.setText(" "+rs.getString("email_id"));
                mobno_11.setText(" "+rs.getString("mob_num"));
                mobno_21.setText(" "+rs.getString("land_num"));
                String str=rs.getString("class");
                if(str.isEmpty()){
                choice_pref11.setText("-");
                choice_pref21.setText("-");
                choice_pref31.setText("-");
                }
                else
                {
                if(str.charAt(0)=='C') choice_pref11.setText("computer");
                else if(str.charAt(0)=='I')choice_pref11.setText("information tech");
                else if(str.charAt(0)=='E')choice_pref11.setText("Electronincs");
                if(str.length()>=2)
                {
                if(str.charAt(1)=='C') choice_pref21.setText("computer");
                else if(str.charAt(1)=='I')choice_pref21.setText("information tech");
                else if(str.charAt(1)=='E')choice_pref21.setText("Electronincs");
                }else choice_pref21.setText("-");
                if(str.length()>=3)
                {
                if(str.charAt(2)=='C') choice_pref31.setText("computer");
                else if(str.charAt(2)=='I')choice_pref31.setText("information tech");
                else if(str.charAt(2)=='E')choice_pref31.setText("Electronincs");
                }else choice_pref21.setText("-");
                }
            }
            else
            {
                //Show dialog "Student not selected"
                System.out.println("Student not selected");
            }
        }catch(Exception ex){
        }
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
        printJob.addPrintJobListener(new JobCompleteMonitor());
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
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/pro",username,password);
            String query="insert into log values(?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, getCurUser());
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
            ps.setString(2,"Printed Admission Form Page2 at "+df.format(date));
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
            Parent par = FXMLLoader.load(getClass().getResource("/admission_form/pg_1.fxml"));
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
