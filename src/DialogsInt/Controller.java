/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DialogsInt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author jayesh
 */
public class Controller implements Initializable{

    @FXML
    private Button path;

    @FXML
    private Button datanotfilled;

    @FXML
    private Button emailsent;

    @FXML
    private Button loginsuccess;

    @FXML
    private Button emailnotsent;

    @FXML
    private Button datanotstored;

    @FXML
    private Button datastored;
    
    @FXML
    private Button okbtn;
    
    @FXML
    private Button browse_btn;
    
    @FXML
    private TextField path_tf;
    
    @FXML
    private ImageView image;
    
    @FXML
    private Label path_lbl;
    
    @FXML
    private Button pathokbtn;
    
    @FXML
    private Button setimagebtn;
    
    public static String filepath;
    public static String imgpath;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    public void onDataStored()
    {
        Stage s = new Stage();
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("formid_not_selected.fxml"));
            Scene scene = new Scene(par);
            s.setScene(scene);
        }catch(Exception ex){}
        s.setResizable(false);
        s.setTitle("Success!");
        s.initModality(Modality.APPLICATION_MODAL);
        s.show();
    }
    
    @FXML
    public void onDatanotStored()
    {
        Stage s = new Stage();
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("data_not_stored.fxml"));
            Scene scene = new Scene(par);
            s.setScene(scene);
        }catch(Exception ex){}
        s.setResizable(false);
        s.setTitle("Incomplete Data");
        s.initModality(Modality.APPLICATION_MODAL);
        s.show();
    }
    
    @FXML
    public void loginsuccess()
    {
        Stage s = new Stage();
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("login_success.fxml"));
            Scene scene = new Scene(par);
            s.setScene(scene);
        }catch(Exception ex){}
        s.setResizable(false);
        s.setTitle("Success!");
        s.initModality(Modality.APPLICATION_MODAL);
        s.show();
    }
    
    @FXML
    public void emailsent()
    {
        Stage s = new Stage();
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("email_sent.fxml"));
            Scene scene = new Scene(par);
            s.setScene(scene);
        }catch(Exception ex){}
        s.setResizable(false);
        s.setTitle("Success!");
        s.initModality(Modality.APPLICATION_MODAL);
        s.show();
    }
    
    @FXML
    public void enterpath()
    {
        Stage s = new Stage();
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("enter_path.fxml"));
            Scene scene = new Scene(par);
            s.setScene(scene);
        }catch(Exception ex){}
        s.setResizable(false);
        s.setTitle("Path");
        s.initModality(Modality.APPLICATION_MODAL);
        s.show();
    }
    
    @FXML
    public void onclickbrowse(ActionEvent e) throws IOException
    {
       Stage s = new Stage();
        FileChooser fileChooser = new FileChooser();
 fileChooser.setTitle("Open Resource File");
 fileChooser.getExtensionFilters().addAll(
         new ExtensionFilter("Image Files", "*.png", "*.jpg"));
 File selectedFile = fileChooser.showOpenDialog(s);
 if (selectedFile != null) {
            path_tf.setText(selectedFile.getAbsolutePath());
            filepath=path_tf.getText();
            imgpath=selectedFile.getCanonicalPath();
    } 
    }
    
    @FXML
    public void onClickpathok(ActionEvent e)
    {
        ((Node)(e.getSource())).getScene().getWindow().hide();
        
    }
    
    @FXML
    public void onsetimage()
    {
        try {
            path_lbl.setText(filepath);
            BufferedImage bf=ImageIO.read(new File(filepath));
            Image img = SwingFXUtils.toFXImage(bf,null);
            image.setImage(img);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void emailnotsent()
    {
        Stage s = new Stage();
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("email_not_sent.fxml"));
            Scene scene = new Scene(par);
            s.setScene(scene);
        }catch(Exception ex){}
        s.setResizable(false);
        s.setTitle("Error");
        s.initModality(Modality.APPLICATION_MODAL);
        s.show();
    }
    
    @FXML
    public void datanotfilled()
    {
        Stage s = new Stage();
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("data_not_filled.fxml"));
            Scene scene = new Scene(par);
            s.setScene(scene);
        }catch(Exception ex){}
        s.setResizable(false);
        s.setTitle("Incomplete Data");
        s.initModality(Modality.APPLICATION_MODAL);
        s.show();
    }
    
    @FXML
    public void onclickok(ActionEvent e)
    {
        ((Node)(e.getSource())).getScene().getWindow().hide();
    }
    @FXML
    public void onClickLoadingError()
    {
        Stage s = new Stage();
        try
        {
            Parent par = FXMLLoader.load(getClass().getResource("/login_form/login1.fxml"));
            Scene scene = new Scene(par);
            s.setScene(scene);
        }catch(Exception ex){}
        //s.setResizable(false);
        s.setTitle("MYSQL LOGIN");
        s.show();
        Scene cur=okbtn.getScene();
            cur.getWindow().hide();
            
        
    }
}
