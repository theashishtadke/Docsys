
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syllabus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Nitu
 */
public class controller implements Initializable {
    
    //=================================================================
    //----------------- code for ChSyllabus
    @FXML
    private ChoiceBox csCh;
    @FXML
    private TextField csName;
    @FXML
    private ListView<String> csLs;
    @FXML
    private ChoiceBox csSem;
    
    ObservableList<String> observableList1 = FXCollections.observableArrayList();
    ObservableList<String> observableList2 = FXCollections.observableArrayList();
    public void csAdd()
    {
        int cnt=observableList1.size(),i=2;
        for(i=0;i<cnt;i++)
        {
            String s=observableList1.get(i);
            if(csName.getText().equals(s))
            {
                System.out.println("if"+s+"\t"+csName.getText());
                break;
            }
            System.out.println("else");
           
        }
        System.out.println((csName.getText()).trim());
        String str=(csName.getText()).trim();
        if(str.isEmpty())
        {
           System.out.println("empty");
        }
        else
        {
            System.out.println("i="+i+"cnt="+cnt);
             if((i!=cnt)&&(cnt>0))
            {
                System.out.println("Duplcate entry");
            }
            else
            {
                observableList1.add(csName.getText());
                csLs.setItems(observableList1);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        csCh.setItems(FXCollections.observableArrayList(
                "FYCM", "FYEJ", "FYIF", "SYCM", "SYIF", "SYEJ","TYCM","TYIF","TYEJ"));
        csLs.setItems(observableList1);
        csSem.setItems(observableList2);
        
        csLs.setOnMouseClicked(new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            System.out.println("clicked on " + csLs.getSelectionModel().getSelectedItem());
        }
        
    });
        

            }
    public void changeSem()
    {
        String str=csCh.getSelectionModel().getSelectedItem().toString();
        if(str.charAt(0)=='T')
        csSem.setItems(FXCollections.observableArrayList(
                "5","6"));
        
        else if(str.charAt(0)=='F')
        csSem.setItems(FXCollections.observableArrayList(
                "1","2"));
        else if(str.charAt(0)=='S')
        csSem.setItems(FXCollections.observableArrayList(
                "3","4"));

    }
    Connection con;
    PreparedStatement ps;
    @FXML
    private Button confirm;
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
    public void sylAdd() 
    {
        try {
            con();
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro",username,password);
            ps=con.prepareStatement("insert into syllabus values(?,?,?)");
            int cnt=observableList1.size();
            System.out.println("conprepared cnt="+cnt);
            for(int i=0;i<cnt;i++)
            {
                System.out.println("for i="+i);
            ps.setString(1,csCh.getSelectionModel().getSelectedItem().toString());
            ps.setString(2, observableList1.get(i));
            ps.setString(3,csSem.getSelectionModel().getSelectedItem().toString());
            ps.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        onConfirm();
            
    }
    @FXML
    Stage stage;
    @FXML
    public void onConfirm()
    {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/docsysgui/GUI.fxml"));
            Scene sc=new Scene(root);
            stage=new Stage();
            stage.setScene(sc);
            stage.setFullScreen(true);
            stage.show();
            Scene cur=confirm.getScene();
            cur.getWindow().hide();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
