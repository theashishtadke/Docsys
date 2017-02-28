/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package markSheet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 *
 * @author Administrator
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TableView<StudInfo> tableID;
    @FXML
    private TableColumn<StudInfo,String> name;
    @FXML
    private TableColumn<StudInfo,String> m1;
    @FXML
    private TableColumn<StudInfo,String> m2;
    @FXML
    private TableColumn<StudInfo,String> m3;
    @FXML
    private TableColumn<StudInfo,String> m4;
    @FXML
    private TableColumn<StudInfo,String> m5;
    @FXML
    private TableColumn<StudInfo,String> m6;
    @FXML
    private TableColumn<StudInfo,String> tot;
    @FXML
    private TableColumn<StudInfo,String> sign;
    
    ObservableList<StudInfo> ls=FXCollections.observableArrayList(dataFill());
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("in initialize");
        name.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("name"));
        m1.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("m1"));
        m2.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("m2"));
        m3.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("m3"));
        m4.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("m4"));
        m5.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("m5"));
        m6.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("m6"));
        tot.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("tot"));
        sign.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("sign"));
        tableID.setItems(ls);
        naming();
        System.out.println("table1 initialized");        
        
    }
    @FXML
    private Button back;
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
            
            Scene cur=back.getScene();
            cur.getWindow().hide();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void naming()
    {
        try {
            connect();
            rs=stat.executeQuery("Select sub from syllabus where syl='TYCM' AND sem=6");
            name.setText("name");
            
            ObservableList<String> ls2=FXCollections.observableArrayList();
            int i=0;
            
            while(rs.next())
            {
                System.out.println(i);
                ls2.add(rs.getString("sub"));
                i=ls2.size();
                System.out.println(i);
            }
            while(i<6)
            {
                System.out.println(i);
                ls2.add("");
                i++;
            }
            m1.setText(ls2.get(0));
            m2.setText(ls2.get(1));
            m3.setText(ls2.get(2));
            m4.setText(ls2.get(3));
            m5.setText(ls2.get(4));
            m6.setText(ls2.get(5));
            tot.setText("total");
            sign.setText("Signature");
            
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
    Connection con;
    Statement stat;
    ResultSet rs;
    public void connect()
  {
      
      
      try
        {
            con();
            String user="app" , host="jdbc:mysql://localhost:3306/pro";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(host,username,password);
             stat=con.createStatement();
        }

        catch(Exception err)
        {
            System.out.println(err.getMessage());
        }
  }
        public ObservableList<StudInfo> dataFill()//String s)
    {
        ObservableList<StudInfo> ls1=FXCollections.observableArrayList();
        String s1,s2,s9;
        System.out.print("Datafill");
        System.out.print("Select * from TYCM ");
        try
        {
            System.out.print("connecting ");
        connect();
        System.out.print("Connected ");
        rs=stat.executeQuery("select * from TYCM");
        int cnt=0;
        while(rs.next()){cnt++;}
        System.out.print("query executed ");
        PreparedStatement st2=con.prepareStatement("select * from TYCM where roll_no=?");
        ResultSet rs2;
        System.out.print("prepare statement ");
        int i=1,j=0;
        rs=stat.executeQuery("select * from TYCM");
        String [] marks=new String[7];
        while(rs.next())
        {
            System.out.println("before break");
            if(i>=(cnt+1))break;
           System.out.println("in while "+i);
           s1="vinay";
           st2.setInt(1,i);
           rs2=st2.executeQuery();
                while(rs2.next()||j<6)
                {
                    System.out.println("in while2"+j);
                    s2=rs2.getString("marks");
                    marks[j]=s2;
                    if(rs2.getString(2).equals("total"))
                    {
                        while(j<5){marks[j]=" ";j++;}
                        marks[5]=s2;
                    }
                    if(rs2.getString(2).equals("per"))
                        marks[6]=s2;
                    j++;
                    rs.next();
                }
           j=0;
           s9="";
           System.out.println("adding");
           ls1.add(new StudInfo(s1,marks[0],marks[1],marks[2],marks[3],marks[4],marks[5],marks[6],s9));
           System.out.println("added record"+i);
           i++;
           
        }
        if(ls1.isEmpty()){System.out.print("list empty");}
        con.close();
        }catch(Exception e){e.printStackTrace();}
        System.out.println("record fetch complete");        
        
        return ls1;
    }

}
