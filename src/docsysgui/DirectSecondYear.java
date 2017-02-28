/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package docsysgui;

import static edit_uni.EditController.getFormid;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author jayesh
 */
public class DirectSecondYear implements Initializable{    @FXML
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
    int formid;
    @FXML
    Button print_btn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
        formid=Integer.parseInt(getFormid());
        }catch(NumberFormatException e){
        
            Stage s = new Stage();
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("/Dialogs/formid_not_selected.fxml"));
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
        fill();
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
    Connection con;
    ResultSet rs;
    Statement stat;
    String username,password;
       FileWriter fw;
    BufferedWriter bf;
    BufferedReader br;
    FileReader fr;

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
   
    public void fill()
    {
        try
            {
                con();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pro",username,password);
                String query="select * from uni where formid="+formid;
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(query);
                if(rs.next())
                {
                    gender.setText(rs.getString("gender"));
                    //cast.setText(rs.getString("cast"));
                    mother_name.setText(rs.getString("cand_m"));
                    last_name.setText(rs.getString("cand_s"));
                    form_num.setText(rs.getString("formid"));
                    religion.setText(rs.getString("religion"));
                    father_name.setText(rs.getString("cand_fa"));
                    dobl.setText(rs.getString("DOBDate"));
                    category.setText(rs.getString("cast"));
                    first_name.setText(rs.getString("cand_f"));
                    
                }
            } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(DirectSecondYear.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(DirectSecondYear.class.getName()).log(Level.SEVERE, null, ex);
    }    
    }
}
