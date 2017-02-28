/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import javafx.stage.Stage;

/**
 *
 * @author Nitu
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
     TextField uid;
    @FXML
     TextField pass;
    @FXML
            Button resetb;
    @FXML
            Button loginb;
    @FXML
    Stage stage;
    Connection c;
    Statement stat;
    ResultSet rs;
    String user,password;
    int k=0;
     public void connect()
    { 
        try{
        Class.forName("com.mysql.jdbc.Driver");
        user=uid.getText();
        password=pass.getText();
        System.out.println(++k+" iteration");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro",user,password);
        System.out.println("connection establish");
        stat=c.createStatement();
        System.out.println("stat created");
        con();
        System.out.println("writin to txt");
        int stattable=stat.executeUpdate("create table IF NOT EXISTS staff(namer varchar(20),passr varchar(20))");
        System.out.println("craeted table");
        ResultSet rs=stat.executeQuery("select * from staff ");
        System.out.println("accessing staff");
        if(rs.next())
        {
            System.out.println("in if");
            Parent root=FXMLLoader.load(getClass().getResource("/finalpro/login.fxml"));
            Scene sc=new Scene(root);
            stage=new Stage();
            stage.setScene(sc);
            stage.show();
            Scene cur=loginb.getScene();
            cur.getWindow().hide();
        }else
        {
            System.out.println("in else");
            if(System.getProperty("os.name").contains("Win"))
            importD(user,password);
            else
            importD1(user,password);    
        }
        }catch(Exception e)
        {
            try{
        
        Class.forName("com.mysql.jdbc.Driver");
        String str="jdbc:mysql://localhost:3306/?user="+user+"&password="+password;
        Connection dbinit=DriverManager.getConnection(str);
        Statement st=dbinit.createStatement();
        int status=st.executeUpdate("create database IF NOT EXISTS pro");
        if(status==1){
        System.out.println("database created");
        
        }
        else
        {
            System.out.println("problem with creating database");
        }
        }catch(Exception ex){System.out.println("not a correct password");}
        }
    }
    public void importD(String username,String password)
    {
       //String executeCmd= "mysql -u "+dbUser+" -p"+dbPass+" "+dbName +" c:\\Backup\\backup3.sql";
        try
        {
        System.out.println("importing");
        File f1=new File("imp.bat");
        FileWriter fw1=new FileWriter(f1);
        File f2=new File("finalpro.sql");
        BufferedWriter br1=new BufferedWriter(fw1);
        br1.write("mysql -u root -p pro <"+f2.getAbsolutePath());
        br1.newLine();
        br1.write("exit");
        br1.close();
        fw1.close();
        Process runtimeProcess =Runtime.getRuntime().exec(""+f1.getCanonicalPath());
           // Process runtimeProcess =Runtime.getRuntime().exec(executeCmd);
        int processComplete = runtimeProcess.waitFor();
       
        if(processComplete == 0){System.out.println("5");
        System.out.println("imported");
        }else{System.out.println("import cancle");}
        }catch(Exception e){System.out.println("7"+e.getMessage());}
        
        
    }
    
    public void importD1(String username,String password)
    {
       //String executeCmd= "mysql -u "+dbUser+" -p"+dbPass+" "+dbName +" c:\\Backup\\backup3.sql";
        try
        {
        System.out.println("importing");
        File f1=new File("imp.sh");
        FileWriter fw1=new FileWriter(f1);
        File f2=new File("finalpro.sql");
        BufferedWriter br1=new BufferedWriter(fw1);
        br1.write("mysql -u root -p pro <"+f2.getAbsolutePath());
        br1.newLine();
        br1.write("exit");
        br1.close();
        fw1.close();
        Process runtimeProcess =Runtime.getRuntime().exec("cmd /C start "+f1.getCanonicalPath());
           // Process runtimeProcess =Runtime.getRuntime().exec(executeCmd);
        int processComplete = runtimeProcess.waitFor();
       
        if(processComplete == 0){System.out.println("5");
        System.out.println("imported");
        }else{System.out.println("import cancle");}
        }catch(Exception e){System.out.println("7"+e.getMessage());}
    }
     FileWriter fw;
    BufferedWriter bf;
    private void con()throws Exception
    {
             fw=new FileWriter("vinpass.txt");    
             bf=new BufferedWriter(fw);
             bf.write(user+" "+password); 
             bf.newLine();
             bf.close();
             fw.close();
    } 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }
    
    public void resetButton()
    {
        uid.setText("");
        pass.setText("");
        
    }
        
}

