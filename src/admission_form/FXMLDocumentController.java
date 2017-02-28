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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
 *
 * @author jayesh
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label academic_year1;
    @FXML
    private Label iti1;
    @FXML
    private Label xii_mcvc1;
    @FXML
    private Label hscscience1;
    @FXML
    private Label englishmarks_ssc1;
    @FXML
    private Label englishmarks_stud1;
    @FXML
    private Label sciencemarks_ssc1;
    @FXML
    private Label sciencemarks_stud1;
    @FXML
    private Label mathsmarks_ssc1;
    @FXML
    private Label mathsmarks_stud1;
    @FXML
    private Label totalmarks_ssc1;
    @FXML
    private Label totalmarks_stud1;
    @FXML
    private Label defenceservice1;
    @FXML
    private Label physicalhandicap1;
    @FXML
    private Label ssc_tech1;
    @FXML
    private Label ssc_local1;
    @FXML
    private Label ssc_mah1;
    @FXML
    private Label domi_mah1;
    @FXML
    private Label dob1;
    @FXML
    private Label gender1;
    @FXML
    private Label mothername1;
    @FXML
    private Label fathername1;
    @FXML
    private Label firstname1;
    @FXML
    private Label surname1;
    @FXML
    private Label meritno1;   
    @FXML
    private Label int_grade_exam1;
    @FXML
    private Button next;
    @FXML
    private Button print_btn;

    private static boolean jobRunning = true; 
    
    @FXML
    void nextClicked(ActionEvent event) throws IOException {
      
        Parent par = FXMLLoader.load(getClass().getResource("pg_2.fxml"));
            Scene scene = new Scene(par);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
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
   int formid;
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
            System.out.println("Initialize called");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro",username,password);
            String query="select * from uni where formid=? || enroll=? || cand_f=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,""+formid);
            ps.setString(2, getName());
            ps.setString(3,getEnroll());
            
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                //academic_year1.setText(rs.getString("academicyear"));
                surname1.setText(" "+rs.getString("cand_s"));
                firstname1.setText(" "+rs.getString("cand_f"));
                fathername1.setText(" "+rs.getString("cand_fa"));
                mothername1.setText(" "+rs.getString("cand_m"));
                gender1.setText(" "+rs.getString("gender"));
                dob1.setText(" "+rs.getString("DOBDate"));
                
                ssc_mah1.setText(" "+rs.getString("sscper"));
                ssc_local1.setText(" "+rs.getString("sscper"));
                ssc_tech1.setText(" "+rs.getString("sscper"));
                physicalhandicap1.setText("no");
                defenceservice1.setText("no");
                totalmarks_stud1.setText(" "+rs.getString("ssctot"));
                mathsmarks_stud1.setText(" "+rs.getString("mathmarks"));
                sciencemarks_stud1.setText(" "+rs.getString("scimarks"));
                englishmarks_stud1.setText(" "+rs.getString("engmarks"));
                hscscience1.setText("yes");
                xii_mcvc1.setText("yes");
                iti1.setText("no");
                int_grade_exam1.setText("no");
            }
            else
            {
                //Show dialog "Student not selected"
                System.out.println("Student not selected");
            }
        }catch(Exception ex){ex.printStackTrace();}
    }

    @FXML
    private void doPrininting(ActionEvent event) {
        
        next.setVisible(false);
        print_btn.setVisible(false);
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
            con1();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/pro",username,password);
            String query="insert into log values(?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, getCurUser());
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
            ps.setString(2,"Printed Admission Form Page1 at "+df.format(date));
            ps.executeUpdate();
            
        }catch(Exception ex){ex.printStackTrace();}
        next.setVisible(true);
        print_btn.setVisible(true);
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
