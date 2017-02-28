/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docsysgui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author jayesh
 */
public class MainController1 implements Initializable{
    
    String form_to_open;
    int flag=1;
    
     @FXML
    private Label status_label;
     
     @FXML
     private Button show_logs;
     
    @FXML
    private MenuBar menubar;

    @FXML
    private Pane centerpane;
    
    @FXML
    private Pane rightpane;

    @FXML
    private BorderPane borderpane;
    
    @FXML
    private AnchorPane form_pane;
    
    @FXML
    private Button adm_form_btn;
    
    @FXML
    private AnchorPane extras_form_pane;
    
     @FXML
    private Button print_btn;
     
      @FXML
    private Button uniform_btn;
      
       @FXML
    private TextField cand_f;
    
    @FXML
    private TextField cand_fa;


    @FXML
    private TextField cand_s;


    @FXML
    private TextField cand_m;

//birthdate
    @FXML
    private TextField dob_district;
   
    @FXML
    private TextField dob_place;
    
    @FXML
    private TextField dob_village;
    
    @FXML
    private TextField dob_taluka;
    
    @FXML
    private TextField dob_state;
    
    
// gropu4
    @FXML
    private TextField name_father;
@FXML
    private TextField occupation;
@FXML
    private TextField relation;
@FXML
    private TextField land_num;
@FXML
    private TextField father_num;
//grotp 5
@FXML
    private TextField income;
//group 6
@FXML
    private TextArea address;
//group 7
@FXML
    private TextField mob_num;
@FXML
    private TextField email_id;
//group 8
@FXML
    private TextField tot_marks;
@FXML
    private TextField per_marks;
@FXML
    private TextField qual_exam;
@FXML
    private TextField vocation_sub;
//buttons
    @FXML
    private Button submit;

//error handling
    @FXML
            Label e1;
     
       FileWriter fw;
    BufferedWriter bf;
    BufferedReader br;
    FileReader fr;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
    //direct second year
    @FXML
    private Label gender;
    @FXML
    private Label cast;
    @FXML
    private Label mother_name;
    @FXML
    private Label last_name;
    @FXML
    private Label form_num;
    @FXML
    private Label religion;
    @FXML
    private Label father_name;
    @FXML
    private Label dobl;
    @FXML
    private Label category;
    @FXML
    private Label first_name;
    
    @FXML
    void onClickAdm_Cat()
    {
        
        try {
            centerpane.getChildren().clear();
            centerpane.getChildren().add(FXMLLoader.load(getClass().getResource("adm_cat_page.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    @FXML
    void onClickAdm_Form()
    {
         
              
             try {
                 Stage stage = new Stage();
                    Parent par = FXMLLoader.load(getClass().getResource("/admission_form/pg_1.fxml"));
                    Scene scene = new Scene(par);
                    stage.setScene(scene);
                    stage.setResizable(true);
                    stage.centerOnScreen();
                    stage.show();
               } catch (IOException ex) {
           Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @FXML
    void onClickDSY_Form()
    {
   
             try {
                 Stage stage = new Stage();
                    Parent par = FXMLLoader.load(getClass().getResource("/dsy_form/pg_1.fxml"));
                    Scene scene = new Scene(par);
                    stage.setScene(scene);
                    stage.setResizable(true);
                    
                    stage.centerOnScreen();
                    stage.show();
               } catch (IOException ex) {
           Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
            }
   
    }
    
    @FXML
    void onClickGRE()
    {
        try {
           centerpane.getChildren().clear();
           centerpane.getChildren().add(FXMLLoader.load(getClass().getResource("gre_cat_page.fxml")));
       } catch (IOException ex) {
           Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
    /*void open_form()
    {
        System.out.println("Inside open_form");
        try
        {
            System.out.println("Inside try");
            switch(form_to_open)
            {
                case "admission_form":
                    System.out.println("inside case");
                     centerpane.getChildren().clear();
                     centerpane.getChildren().add(FXMLLoader.load(getClass().getResource("adm_form.fxml")));
            }
        }catch(IOException ex){
            Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }*/
    
    //retrive username and pass
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
        @FXML
        public void onShowLogs(ActionEvent event)
        {
            try
            {
                con();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pro",username,password);
                String query="select * from log";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(query);
  
                if(!rs.next())
                {
                    System.out.println("Inside if");
                    Stage stage = new Stage();
                    System.out.println("Stage initialized");
                    Parent root = FXMLLoader.load(getClass().getResource("/logs_pkg/empty_logs_dialog.fxml"));
                    System.out.println("Parent selected");
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    System.out.println("scene set");
                    //stage.setTitle("Empty Logs");
                    stage.setResizable(false);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.show();
                }
                else
                {
                    Stage stage = new Stage();
                    Parent par = FXMLLoader.load(getClass().getResource("/logs_pkg/show_logs.fxml"));
                    Scene scene = new Scene(par);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.show();
                }
            }catch(Exception ex){}
        }
    
        @FXML
        void onClickExtras_Page()
        {
            try {
           centerpane.getChildren().clear();
           centerpane.getChildren().add(FXMLLoader.load(getClass().getResource("extras_cat_page.fxml")));
             } catch (IOException ex) {
           Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
             }
        }   
        //-----------------------------------------------------------------------------
        //BONAFIDE_FORM
        
        @FXML
        void onClickBonafide_form()
        {
             try {
            Stage stage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource("/forms_all/bonafide.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
            
        
        @FXML
        void onClickPrint() throws IOException
        {
            
            Parent parent = FXMLLoader.load(getClass().getResource("GUI.fxml"));
            Scene scene = new Scene(parent);
            WritableImage image = scene.snapshot(null);
            File file = new File("test.png");
            RenderedImage renderedImage = SwingFXUtils.fromFXImage(image, null);
            ImageIO.write(
            renderedImage, 
            "png",
            file);
        }
        
        @FXML
        public void doPrinting()
        {
            print_btn.setVisible(false);
            Scene scene = print_btn.getScene();
            WritableImage snapshot = scene.snapshot(null);
            BufferedImage image = SwingFXUtils.fromFXImage(snapshot, null);
            
            PrinterJob printJob = PrinterJob.getPrinterJob();
            printJob.setPrintable(new Printable()
            {

                @Override
                public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                    if(pageIndex!=0)
                        return NO_SUCH_PAGE;
                    graphics.drawImage(image,0,0,image.getWidth(),image.getHeight(),null);
                    return PAGE_EXISTS;
                }
                
            });
            
            try
            {
                printJob.print();
            }catch(PrinterException e){}
            print_btn.setVisible(true);
            //new Thread(new PrintActionListener(image)).start();
        }

    /**
     *
     */
    @FXML
        public void showUniForm()
        {
            try {
           centerpane.getChildren().clear();
           centerpane.getChildren().add(FXMLLoader.load(getClass().getResource("/uni_form/uni.fxml")));
               } catch (IOException ex) {
           Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    @FXML
    private Button leavingBut;
    @FXML
        public void showLeavingForm()
        {
            System.out.println("LC called");
         
           centerpane.getChildren().clear();
           //centerpane.getChildren().add(FXMLLoader.load(getClass().getResource("/lcform/LeavingCertificate.fxml")));
            Stage stage = new Stage();
            try
            {
                Parent par = FXMLLoader.load(getClass().getResource("/lcform/LeavingCertificate.fxml"));
                Scene scene = new Scene(par);
                stage.setScene(scene);
            }catch(Exception ex){ex.printStackTrace();}
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }
    @FXML
    private Button railbtn;
    @FXML
        public void showRailwayForm()
        {
            try {
           centerpane.getChildren().clear();
           centerpane.getChildren().add(FXMLLoader.load(getClass().getResource("/railway/RailwayInput.fxml")));
               } catch (IOException ex) {
           Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    @FXML
    private Button delbtn;
    @FXML
        public void showDelUniForm()
        {
                              Stage s = new Stage();
                try
                {
                    Parent par = FXMLLoader.load(getClass().getResource("/delete/FXMLDocument.fxml"));
                    Scene scene = new Scene(par);
                    s.setScene(scene);
                }catch(Exception ex){}
                s.setResizable(false);
                s.setTitle("Success!");
                s.initModality(Modality.APPLICATION_MODAL);
                s.show();
        }
        
    @FXML
    private Button unittestbtn;
    @FXML
        public void showUnitTestForm()
        {
            try {
           centerpane.getChildren().clear();
           centerpane.getChildren().add(FXMLLoader.load(getClass().getResource("/unittest/unit1.fxml")));
               } catch (IOException ex) {
           Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    @FXML
    private Button mlbtn;
    @FXML
        public void meritListForm()
        {
            try {
           centerpane.getChildren().clear();
           centerpane.getChildren().add(FXMLLoader.load(getClass().getResource("/tableviewer/FXMLDocument.fxml")));
               } catch (IOException ex) {
           Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    @FXML
    private Button bonabtn;
    @FXML
        public void bonafideForm()
        {
             try {
            Stage stage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource("/forms_all/bonafide.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    @FXML
    private Button editbtn;
    @FXML
        public void editUniForm()
        {
            //will be send by jayesh        
            try {
           centerpane.getChildren().clear();
           centerpane.getChildren().add(FXMLLoader.load(getClass().getResource("/edit_uni/uni.fxml")));
               } catch (IOException ex) {
           Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    @FXML
    private Button about;
    @FXML
        public void aboutForm()
        {
            //will be send by jayesh        
            try {
           centerpane.getChildren().clear();
           
           centerpane.getChildren().add(FXMLLoader.load(getClass().getResource("/about_us/About DocSys.fxml")));
               } catch (IOException ex) {
           Logger.getLogger(MainController1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //genrate btn
        private Button genbten;
        @FXML
        public void ongenbtn()
        {
              
                  Stage s = new Stage();
                try
                {
                    Parent par = FXMLLoader.load(getClass().getResource("/edit_uni/edit.fxml"));
                    Scene scene = new Scene(par);
                    s.setScene(scene);
                }catch(Exception ex){}
                s.setResizable(false);
                s.setTitle("Success!");
                s.initModality(Modality.APPLICATION_MODAL);
                s.show();
        }       
        
                
        
        void con(int n)
    {
        
        try
        {   if(n==1)
            {
             fw=new FileWriter("demo.txt");    
             bf=new BufferedWriter(fw);
            }
            if(n==0)
            { 
            fr=new FileReader("demo.txt");    
             br=new BufferedReader(fr);
            }
        }
        catch(FileNotFoundException e){
        }
        catch(IOException e)
        {}   
    }
    
    @FXML
    public void retrive()
    { con(0);
    try{
        //name
         cand_f.setText(br.readLine());
         cand_fa.setText(br.readLine());
         cand_m.setText(br.readLine());
         cand_s.setText(br.readLine());
         //date
         dob_place.setText(br.readLine());
         dob_village.setText(br.readLine());
         dob_taluka.setText(br.readLine());
         dob_district.setText(br.readLine());
         dob_state.setText(br.readLine());
         //
         name_father.setText(br.readLine());
         occupation.setText(br.readLine());
         relation.setText(br.readLine());
         land_num.setText(br.readLine());
         father_num.setText(br.readLine());
//---------------------------------------------       
         income.setText(br.readLine());
         address.setText(br.readLine());
         mob_num.setText(br.readLine());
         email_id.setText(br.readLine());
         tot_marks.setText(br.readLine());
        per_marks.setText(br.readLine());
        qual_exam.setText(br.readLine());
         
    }catch(Exception e){}
    dclose(0);
    }
    @FXML
    public void save()
    {
        con(1);
        try{
        bf.write(cand_f.getText());
        bf.newLine();
        bf.write(cand_fa.getText());
        bf.newLine();
        bf.write(cand_m.getText());
        bf.newLine();
        bf.write(cand_s.getText());
        bf.newLine();
//---------------------------------------------
        bf.write(dob_place.getText());
        bf.newLine();
        bf.write(dob_village.getText());
        bf.newLine();
        bf.write(dob_taluka.getText());
        bf.newLine();        
        bf.write(dob_district.getText());
        bf.newLine();
        bf.write(dob_state.getText());
        bf.newLine();
//---------------------------------------------
        bf.write(name_father.getText());
        bf.newLine();
        bf.write(occupation.getText());
        bf.newLine();
        bf.write(relation.getText());
        bf.newLine();
        bf.write(land_num.getText());
        bf.newLine();
        bf.write(father_num.getText());
        bf.newLine();
        bf.write(income.getText());
        bf.newLine();
        bf.write(address.getText());
        bf.newLine();
        bf.write(mob_num.getText());
        bf.newLine();
        bf.write(email_id.getText());
        bf.newLine();
        bf.write(tot_marks.getText());
        bf.newLine();
        bf.write(per_marks.getText());
        bf.newLine();
        bf.write(qual_exam.getText());
        bf.newLine();
        bf.write(vocation_sub.getText());
        bf.newLine();
        
        }
        catch(Exception e){}
        dclose(1);
    }
    
    
    void dclose(int n)
    {
        try
        {
            if(n==1)
            bf.close();
            if(n==0)
            br.close();
        }
        catch(IOException e)
        {}   
    }
    
    public void submit()
    {
        con(1);
        try
        {
        bf.write("");
        dclose(1);
        }
        catch(IOException e){}
        System.out.println("Saved");
    }
    public void conti()
    {
       retrive();
    }
//-----------------------------------------------------------------
    void validation(String s,Label ll)
    {
        char ch[]= new char[15];
        //for checking whether String entered is not contains number
        int i,flag=1;
        System.out.println("invoke");
        s.getChars(0, s.length(), ch, 0);
        System.out.println("dir");
        //checking words
        if(s.split(" ").length>1) ll.setVisible(true);
        else
        {
        for(i=0;i<ch.length;i++)
        {
            System.out.println(""+ch[i]);
            if(Character.isDigit(ch[i])){flag=0;break;}
        }
        if(flag==0) e1.setVisible(true);
        else e1.setVisible(false);
        }
    }
    public void valid()
    {String s=cand_f.getText();
    //length checking
        if(s.length()>15 || s.length()<4) e1.setVisible(true);
        else
        validation(s,e1);
    }
}
class PrintActionListener implements Runnable
{
     private BufferedImage       image;

    public PrintActionListener(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void run() {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(new ImagePrintable(printJob, image));

        if (printJob.printDialog()) {
            try {
                printJob.print();
            } catch (PrinterException prt) {
                prt.printStackTrace();
            }
        }
    }
}
class ImagePrintable implements Printable {

        private double          x, y, width;

        private int             orientation;

        private BufferedImage   image;

        public ImagePrintable(PrinterJob printJob, BufferedImage image) {
            PageFormat pageFormat = printJob.defaultPage();
            this.x = pageFormat.getImageableX();
            this.y = pageFormat.getImageableY();
            this.width = pageFormat.getImageableWidth();
            this.orientation = pageFormat.getOrientation();
            this.image = image;
        }

        @Override
        public int print(Graphics g, PageFormat pageFormat, int pageIndex)
                throws PrinterException {
            if (pageIndex == 0) {
                int pWidth = 0;
                int pHeight = 0;
                if (orientation == PageFormat.PORTRAIT) {
                    pWidth = (int) Math.min(width, (double) image.getWidth());
                    pHeight = pWidth * image.getHeight() / image.getWidth();
                } else {
                    pHeight = (int) Math.min(width, (double) image.getHeight());
                    pWidth = pHeight * image.getWidth() / image.getHeight();
                }
                g.drawImage(image, (int) x, (int) y, pWidth, pHeight, null);
                return PAGE_EXISTS;
            } else {
                return NO_SUCH_PAGE;
            }
        }
}
