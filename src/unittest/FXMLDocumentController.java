/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittest;

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
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Nitu
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField rollno;
    @FXML
    private TextField om;
    @FXML
    private ChoiceBox ch;
    @FXML
    TableView<StudInfo> tb1;
    @FXML
    private TableColumn<StudInfo,String> sub;
    @FXML
    private TableColumn<StudInfo,Integer> m;
    @FXML
    private Label subL;       
    @FXML
    private Label rollno1;
    @FXML
    private TextField noStud;
    @FXML
    private Group option;
    
    @FXML
    private Group entry;
     ObservableList<StudInfo> ls=FXCollections.observableArrayList(fill());
     ObservableList<StudInfo> lsT=FXCollections.observableArrayList();
     int i=0;
    @FXML
    private Button add;
    private ObservableList<StudInfo> fill()
    {
        ObservableList<StudInfo> ls1=FXCollections.observableArrayList();
        //String select=ch.getSelectionModel().getSelectedItem().toString();
        try
        {
        connect();
        Statement st=c.createStatement();
        String s2;
        ResultSet rs=st.executeQuery("Select * from syllabus where syl= 'TYCM' AND sem= 6");
        while(rs.next())
        {
           s2=rs.getString(2);
           System.out.println("record fetching");        
           ls1.add(new StudInfo(s2,0));
        }
        if(ls1.isEmpty()){System.out.print("list empty");}
        }catch(Exception e){e.printStackTrace();}
        System.out.println("record fetch complete");        
        return ls1;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                sub.setCellValueFactory(new PropertyValueFactory<>("name"));
            m.setCellValueFactory(new PropertyValueFactory<>("marks"));
           tb1.setItems(lsT);
        StudInfo s;
        s=ls.get(i);
        subL.setText(s.getName());   
        ch.setItems(FXCollections.observableArrayList(
                "FYCM", "FYEJ", "FYIF", "SYCM", "SYIF", "SYEJ","TYCM","TYIF","TYEJ"));
        om.setVisible(true);
        option.setVisible(false);
        entry.setVisible(false);
    }
    int glob=1;
    @FXML
    public void onNoChange()
    {
        try{
            String  str=noStud.getText();
        glob=Integer.parseInt(str);
        }catch(NumberFormatException e){System.out.println("not valid number");}
        if(glob==0)
        {
            System.out.println("Select no of Students");
            option.setVisible(false);
        }
        if(glob==1)
        {
            System.out.println("Enter specific number");
            option.setVisible(true);
            entry.setVisible(false);
        }
        if(glob>1)
        {
            System.out.println("Auto numbering on");
            option.setVisible(false);
            rollno1.setText(""+glob2);
            entry.setVisible(true);
            glob2=1;
        }

        System.out.println("in no change");
               
    }
    int glob2=1;
    @FXML
            public void specNumber()
            {
                try{
                glob=Integer.parseInt(rollno.getText());
                if(glob2>0&&glob2<51)
                    entry.setVisible(true);
                }catch(NumberFormatException e){
                e.printStackTrace();
                }
                
            om.setEditable(true);
            
            lsT.clear();
            tb1.setItems(lsT);
                rollno1.setText(""+glob);
            glob-=51;
            glob=Math.abs(glob);
            glob2=0;
            }
    Connection c;
    PreparedStatement ps;
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
      public void connect()
    { 
        
        try {
            con();
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro",username,password);
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    @FXML
    public void onAdd()
    {
        try{
        connect(); 
        StudInfo s;
        int cnt=ls.size();
        String select;
        System.out.println(glob2+"i"+glob);
        
        if(glob2>glob)
        {
            System.out.println("Specified number of entry is done");
            throw new Exception();
        }
        if(i<cnt)
        {
            System.out.println("if"+i);
            s=ls.get(i);
            try{
                s.setMarks(Integer.parseInt(om.getText()));
                lsT.add(new StudInfo(s.getName(),Integer.parseInt(om.getText())));
                i++;
                if(i==cnt){om.setText("");subL.setText("");om.setEditable(false);}
                if(i<cnt){
                    System.out.println("in 2if");
                s=ls.get(i);
                subL.setText(s.getName());
                om.setText("");
                tb1.setItems(lsT);}
                }catch(NumberFormatException e){
                        System.out.println("Enter valid integer");
                        }
        }
        else if(i==cnt)
        {
            
            int j=0,tot=0;
            int per;
            subL.setText("");
            select=ch.getSelectionModel().getSelectedItem().toString();
            Statement st=c.createStatement();
            s=ls.get(0);
            int cnt1=lsT.size();
            ResultSet rs=st.executeQuery("select * from "+select+" where roll_no="+glob+" AND sub='"+s.getName()+"'");
            if(rs.next()){ System.out.println("already entered"); throw new Exception();}
            ps=c.prepareStatement("insert into "+select+" values(?,?,?)");
            while(j<cnt1)
            {
            if(select.isEmpty()) throw new IOException();
            s=lsT.get(j);
            ps.setString(2,s.getName());
            ps.setInt(3,s.getMarks());
            ps.setInt(1,Integer.parseInt(rollno1.getText()));
            ps.executeUpdate();
            tot+=s.getMarks();
            j++;
            i++;
            
            }
            
            per=(int)((tot/(25*cnt*1.0))*100);
            lsT.add(new StudInfo("total",tot));
            lsT.add(new StudInfo("per",per));
            ps.setInt(1, Integer.parseInt(rollno1.getText()));
            ps.setString(2, "total");
            ps.setInt(3,tot);
            ps.executeUpdate();
            ps.setInt(1, Integer.parseInt(rollno1.getText()));
            ps.setString(2, "per");
            ps.setInt(3,per);
            ps.executeUpdate();
            tb1.setItems(lsT);
            glob2++;
      //------insert
        }
        else
        {
            om.setEditable(true);
            rollno1.setText(""+(Integer.parseInt(rollno1.getText())+1));
            i=0;
            s=ls.get(0);
            subL.setText(""+s.getName());
            lsT.clear();
            tb1.setItems(lsT);
        }
                
        }catch(IOException e){
        System.out.println("no value spec");
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                c.close();
            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    private Button ch_sub;
    Stage stage;
    @FXML
    public void changeSyll()
    {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/syllabus/ChSyllabus.fxml"));
            Scene sc=new Scene(root);
            stage=new Stage();
            stage.setScene(sc);
            stage.show();
            Scene cur=ch_sub.getScene();
            cur.getWindow().hide();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }@FXML
    private Button print;
    @FXML
    public void onPrint()
    {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/markSheet/FXMLDocument.fxml"));
            Scene sc=new Scene(root);
            stage=new Stage();
            stage.setScene(sc);
            stage.show();
            Scene cur=print.getScene();
            cur.getWindow().hide();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
