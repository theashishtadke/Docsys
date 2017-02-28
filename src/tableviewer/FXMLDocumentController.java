/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tableviewer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Administrator
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TableView<StudInfo> etableID;
    @FXML
    private TableColumn<StudInfo,String> ename;
    @FXML
    private TableColumn<StudInfo,String> eid;
    @FXML
    private TableColumn<StudInfo,String> eenroll;
    @FXML
    private TableColumn<StudInfo,String> eper;
    
    
    @FXML
    private TableView<StudInfo> etableID1;
    @FXML
    private TableColumn<StudInfo,String> ename1;
    @FXML
    private TableColumn<StudInfo,String> eid1;
    @FXML
    private TableColumn<StudInfo,String> eenroll1;
    @FXML
    private TableColumn<StudInfo,String> eper1;
    
    @FXML
    private TableView<StudInfo> etableID2;
    @FXML
    private TableColumn<StudInfo,String> ename2;
    @FXML
    private TableColumn<StudInfo,String> eid2;
    @FXML
    private TableColumn<StudInfo,String> eenroll2;
    @FXML
    private TableColumn<StudInfo,String> eper2;
    
    ObservableList<StudInfo> ls;
    ObservableList<StudInfo> ls1;
    ObservableList<StudInfo> ls2;
    
ObservableList<String> mailIF=FXCollections.observableArrayList(dataMail("I"));
ObservableList<String> mailEJ=FXCollections.observableArrayList(dataMail("E"));
ObservableList<String> mailCM=FXCollections.observableArrayList(dataMail("C"));
    String enroll="";
    int ap=1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        list();
        ls=FXCollections.observableArrayList(dataFill("I"));
        ls1=FXCollections.observableArrayList(dataFill("C"));
        ls2=FXCollections.observableArrayList(dataFill("E"));

        p.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
System.out.println("in initialize");
        eid.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("formid"));
        ename.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("name"));
        eenroll.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("enroll"));
        eper.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("per"));
        etableID.setItems(ls);
        System.out.println("table1 initialized");        
        
    //    onSend(mailIF);
        eid1.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("formid"));
        ename1.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("name"));
        eenroll1.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("enroll"));
        eper1.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("per"));
        etableID1.setItems(ls1);
        System.out.println("table2 initialized");                
    //    onSend(mailCM);
        eid2.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("formid"));
        ename2.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("name"));
        eenroll2.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("enroll"));
        eper2.setCellValueFactory(new PropertyValueFactory<StudInfo,String>("per"));
        etableID2.setItems(ls2);
        System.out.println("table3 initialized");        
    //    onSend(mailEJ);
    }    
    
    
    
    Connection con;
    Statement stat;
    ResultSet rs;
    Statement ps;
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
      try
        {
            con();
            String user="app" , host="jdbc:mysql://localhost:3306/pro";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(host,username,password);
             stat=con.createStatement();
             ps=con.createStatement();
             
        }

        catch(SQLException err)
        {
            System.out.println(err.getMessage());
        } catch(Exception err)
        {
            System.out.println(err.getMessage());
        } 
  }
    
public void list()
        {
        String str;
        final int max=2;
        int ic=0,ii=0,ie=0,w=0;
        try
        {
        connect();
        Statement up=con.createStatement();
        rs=stat.executeQuery("Select * from uni ORDER BY per_marks DESC");
        while(rs.next())
        {
            str=rs.getString("class");
            boolean f=true;
            while(f)
            {
                if(str.isEmpty())break;
            if(str.charAt(w)=='C')
            {
                System.out.println(str.charAt(w));
                if(ic<max)
                {
                    int fi=rs.getInt("formid");
                    int stat=up.executeUpdate("update uni set rollno='"+ic+"',class='C' where formid="+fi);
                    if(stat==1)
                    {
                        System.out.println("Edited");
                        ic++;
                        f=false;
                    }
                    else
                    {
                        System.out.println("not edited");
                    }
                }
                else
                {
                    
                    if(str.length()>w-1)
                    w++;
                    System.out.println(w);
                }
            }else if(str.charAt(w)=='I')
            {
                System.out.println(str.charAt(w));
                if(ii<max)
                {
                    int fi=rs.getInt("formid");
                    int stat=up.executeUpdate("update uni set rollno='"+ii+"',class='I' where formid="+fi);
                    if(stat==1)
                    {
                        System.out.println("Edited");
                        ii++;
                        f=false;
                    }
                    else
                    {
                        System.out.println("not edited");
                    }
                }
                else
                {if(str.length()>w)
                    w++;
                System.out.println(w);
                }
            }else if(str.charAt(w)=='E')
            {
                System.out.println(str.charAt(w));
                if(ie<max)
                {
                    int fi=rs.getInt("formid");
                    int stat=up.executeUpdate("update uni set rollno='"+ie+"',class='E' where formid="+fi);
                    if(stat==1)
                    {
                        System.out.println("Edited");
                        ie++;
                        f=false;
                    }
                    else
                    {
                        System.out.println("not edited");
                    }
                }
                else
                {if(str.length()>w)
                    w++;
                System.out.println(w);
                }
            }else
            {
                System.out.println("FULL");
                f=false;
            }
            if(w>=3)break;
            }
        w=0;
        }
            
            } catch (SQLException ex) {
            System.out.println("data is not enough");
        }
        }
public ObservableList<StudInfo> dataFill(String s)
    {   
        ObservableList<StudInfo> ls1=FXCollections.observableArrayList();
        
        String s1, s2,s3,s4;
        System.out.print("Datafill");
        System.out.print("Select * from uni ORDER BY per_marks DESC");
        int count=0;
        
        try {
            rs=stat.executeQuery("Select * from uni where class= '"+s+"' ORDER BY per_marks DESC");
            while(rs.next())
            {
                s1=""+rs.getInt("formid");
                String str1;
                str1=rs.getString(1);
                str1+=" "+rs.getString(2);
                str1+=" "+rs.getString(3);
                str1+=" "+rs.getString(4);
                count++;
                String cl="",e="";
                if(s.equals("C")){cl="Computer"; e="12011200"+ap;}
                else if(s.equals("I")){cl="Information technology"; e="12011201"+ap;}
                else if(s.equals("E")){cl="electronics"; e="12011202"+ap;}
                else
                    System.out.println("no branch");
                
                
                System.out.print(e+" "+cl);
                int stat=ps.executeUpdate("update uni set enroll='"+e+"' where formid="+rs.getInt("formid"));
                if(stat>0)System.out.println("updated");
                
                ap++;
                s4=rs.getString(19);
                System.out.println("record fetching");
                ls1.add(new StudInfo(s1,str1,e,s4));
                
                
                //send(to,cl);
            }
            
            if(ls1.isEmpty()){
                Stage stage = new Stage();
                try
                {
                    Parent par = FXMLLoader.load(getClass().getResource("/DialogsInt/data_not_filled.fxml"));
                    Scene scene = new Scene(par);
                    stage.setScene(scene);
                }catch(Exception ex){}
                stage.setResizable(false);
                stage.setTitle("Error!");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
    
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){e.printStackTrace();}
        System.out.println("record fetch complete");        
       
        ap=0;
        return ls1;
    }
    
public ObservableList<String> dataMail(String s)    
{
    ObservableList<String> mail1=FXCollections.observableArrayList();
    try
    {
        connect();
        rs=stat.executeQuery("Select * from uni where class= '"+s+"' ORDER BY per_marks DESC LIMIT 0,3");
            while(rs.next())
            {
                String to=rs.getString("email_id");
                 if(s.equals("I"))
                    mail1.add(to);
                 else if(s.equals("C"))
                    mail1.add(to);
                 else
                    mail1.add(to);
          
            }
    }catch(Exception e){
    
    }
    return(mail1);
}
    Task work;
    @FXML
    private ProgressIndicator p;
    @FXML
    private ProgressIndicator p2;
    @FXML
    private ProgressIndicator p3;
    
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    public void onIF()
    {
        
        onSend(mailIF,"Information Technology",p);
    }
    @FXML
    public void onCM()
    {
        
        onSend(mailCM,"Computer Technology",p2);
    }
    @FXML
    public void onEJ()
    {
        
        onSend(mailEJ,"Electronics",p3);
    }
    @FXML
    public void onSend(ObservableList<String> mailing,String s,ProgressIndicator p1)
    {
        System.out.println("in onsend");
        p1.setVisible(true);
        p1.setProgress(0);
        work=retTask(mailing,s);
        p1.progressProperty().unbind();
        System.out.println("binding");
        p1.progressProperty().bind(work.progressProperty());
        new Thread(work).start();
        System.out.println("outing onsend");
        //p1.setVisible(false);
        work.setOnSucceeded(new EventHandler<Event>() {
            @Override
                public void handle(Event event) {
                    Stage s = new Stage();
                try
                {
                    Parent par = FXMLLoader.load(getClass().getResource("/DialogsInt/email_sent.fxml"));
                    Scene scene = new Scene(par);
                    s.setScene(scene);
                }catch(Exception ex){}
                s.setResizable(false);
                s.setTitle("Success!");
                s.initModality(Modality.APPLICATION_MODAL);
                s.show();
                    p1.setVisible(false);}
            });
        work.setOnCancelled(new EventHandler<Event>() {
            @Override
                public void handle(Event event) {
                    
                    Stage s = new Stage();
                try
                {
                    Parent par = FXMLLoader.load(getClass().getResource("/Dialogs/email_sending_cancle.fxml"));
                    Scene scene = new Scene(par);
                    s.setScene(scene);
                }catch(Exception ex){}
                s.setResizable(false);
                s.setTitle("Warning!");
                s.initModality(Modality.APPLICATION_MODAL);
                s.show();
                    p1.setVisible(false);
                }
            });
        work.setOnFailed(new EventHandler<Event>() {
            @Override
                public void handle(Event event) {
                    Stage s = new Stage();
                    try
                    {
                    Parent par = FXMLLoader.load(getClass().getResource("/DialogsInt/email_not_sent.fxml"));
                    Scene scene = new Scene(par);
                    s.setScene(scene);
                    }catch(Exception ex){}
                    s.setResizable(false);
                    s.setTitle("Error");
                    s.initModality(Modality.APPLICATION_MODAL);
                    s.show();
                    p1.setVisible(false);}
            });
       
    }
    public Task retTask(ObservableList<String> mailing,String s)
    {
        System.out.println("in retTask");
        return new Task()
                {
                    int len=mailing.size();
                    
                     @Override
                protected Object call() throws Exception {
                    System.out.println("len"+len);
                    for (int i = 0; i < len; i++) {
                    //Thread.sleep(2000);
                    System.out.println("sending"+i);    
                    updateMessage("2000 milliseconds");
                    send(mailing.get(i),s);
                    updateProgress(i + 1,len );
                    }
                return true;
                }
                };
                
    }
    
    
public void send(String to,String cl){
    int i=0;
      System.out.println(""+(++i));
      
              //Accept useris and ppassword
        
      String from = "xyzabtemp10@gmail.com";//change accordingly
      final String username = "xyzabtemp10@gmail.com";//change accordingly
      final String password = "xyzabtemp1012345";//change accordingly
      System.out.println(""+(++i));
      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";
      System.out.println(""+(++i));
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");
      System.out.println(""+(++i));
      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
             System.out.println("in");
            return new PasswordAuthentication(username,password);
            
                }
            });
      System.out.println("out");
      try {
        // Create a default MimeMessage object.
        Message message = new MimeMessage(session);
        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from));
        System.out.println(""+(++i));
        final String coll="SHMIT";
        // Set To: header field of the header.
        message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(to));
        System.out.println(""+(++i));
        // Set Subject: header field
        message.setSubject("Testing Subject");
        System.out.println(""+(++i));
        // Now set the actual message
        message.setText("selected in "+cl+" branch in "+coll+" your enrollment No :->"+(enroll+ap));
        System.out.println(""+(++i));
        // Send message
        Transport.send(message);
        System.out.println(""+(++i));
        System.out.println("Sent message successfully....");

          } catch (MessagingException e) {
            System.out.println("excep"+(++i));throw new RuntimeException(e);
            }
   }

}
  