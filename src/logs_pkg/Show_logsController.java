/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logs_pkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jayesh
 */
public class Show_logsController implements Initializable {
    @FXML
    private Button close_btn;
    @FXML
    private Button clear_log_btn;
    @FXML
    private TextArea logs_ta;
    Connection con;
    /**
     * Initializes the controller class.
     */
    BufferedReader br;
    FileReader fr;
    String username,password;
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
        String query="select * from log";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next())
        {
            logs_ta.appendText(rs.getString(1)+" "+rs.getString(2));
            logs_ta.appendText("\n");
        }
        }catch(Exception ex){}
    }    

    @FXML
    private void onClose(ActionEvent event) {
        System.out.println("Inside close");
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    public void onClearLogs(ActionEvent event) {
        try
        {
            con1();
        String query="delete from log";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pro",username,password);
        Statement st=con.createStatement();
        st.executeUpdate(query);
        }catch(Exception ex){}
        try
        {
        Stage stage1=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/logs_pkg/logs_cleared.fxml"));
        System.out.println("Parent selected123");
        Scene scene = new Scene(root);
        System.out.println("Scene set123");
        //stage.setTitle("Logs Cleared");
        stage1.setResizable(false);
        stage1.initModality(Modality.APPLICATION_MODAL);
        //((Node)(event.getSource())).getScene().getWindow().hide();
        stage1.show();
        System.out.println("Stage showed123");
        }catch(Exception ex){}
    }
    
}
