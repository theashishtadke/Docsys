/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edit_uni;

import static edit_uni.EditController.getFormid;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jayesh
 */
public class UniController implements Initializable {
    @FXML
    private TextField cand_f;
    @FXML
    private Label cand_namel;
    @FXML
    private TextField cand_fa;
    @FXML
    private Label cand_fal;
    @FXML
    private TextField cand_m;
    @FXML
    private Label cand_mnamel;
    @FXML
    private TextField cand_s;
    @FXML
    private Label cand_snamel;
    @FXML
    private Label cand_sex;
    @FXML
    private Label cand_bpl1;
    @FXML
    private Label cand_bpl;
    @FXML
    private Label cand_vil;
    @FXML
    private Label cand_tall;
    @FXML
    private Label cand_distl;
    @FXML
    private Label cand_statel;
    @FXML
    private Label cand_fnamel;
    @FXML
    private Label cand_foccl;
    @FXML
    private Label cand_frelnl;
    @FXML
    private Label cand_landlinel;
    @FXML
    private Label cand_frnol;
    @FXML
    private Label cand_mobl;
    @FXML
    private TextField stud_native;
    @FXML
    private Label stud_nativel;
    @FXML
    private TextField stud_nvil;
    @FXML
    private Label stud_nvill;
    @FXML
    private TextField stud_ntal;
    @FXML
    private Label stud_ntall;
    @FXML
    private TextField stud_ndist;
    @FXML
    private Label stud_ndistl;
    @FXML
    private TextField stud_nstate;
    @FXML
    private Label stud_nstatel;
    @FXML
    private Button submit;
    @FXML
    private Button update_btn;
    @FXML
    private Button lastb;
    String formid;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private TextField dob_place;
    @FXML
    private TextField dob_village;
    @FXML
    private TextField dob_taluka;
    @FXML
    private TextField dob_district;
    @FXML
    private TextField dob_state;
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
    @FXML
    private TextField income;
    @FXML
    private TextArea address;
    @FXML
    private TextField mob_num;
    @FXML
    private TextField email_id;
    @FXML
    private TextField tot_marks;
    @FXML
    private TextField per_marks;
    @FXML
    private ChoiceBox<?> qualexam;
    @FXML
    private TextField qual_exam;
    @FXML
    private TextField vocation_sub;
    /**
     * Initializes the controller class.
     */BufferedReader br;
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
    String str="";
    @FXML
    private ListView<String> expClass;
    ObservableList<String> observableList = FXCollections.observableArrayList();
    boolean fC=true,fI=true,fE=true;
    public void onCM()
    {
        if(fC)
        {
            
            System.out.print(" t1 ");
            observableList.add("Computer Tech");
            System.out.print(" t2 ");
            str+="C";
            System.out.print("\n t3 "+str);
            fC=false;
            System.out.print(" t4 ");
           // expClass.setCellFactory(ComboBoxListCell.forListView(observableList));
            
            expClass.setItems(observableList);
             System.out.print(" fc= "+fC);
            
        }
        else
        {    
            System.out.print(" f1 ");
            str=str.replace('C','\0');
            System.out.print(" f2 ");
            observableList.remove("Computer Tech");
            
            System.out.print("\n f3 "+str);
            
            fC=true;
            System.out.print(" f4 ");
            expClass.setItems(observableList);
            System.out.print(" f5 ");
            System.out.print(" fc= "+fC);
        }
    }
    public void onIF()
    {
        if(fI)
        {
        observableList.add("Information Tech\n");
        str+="I";
        expClass.setItems(observableList);
        fI=false;
        System.out.print("\n t3 "+str);
        }
        else
        {    
            str=str.replace('I','\0');
            observableList.remove("Information Tech\n");
            fI=true;
            expClass.setItems(observableList);
            System.out.print("\n t3 "+str);
        }
        
    }
    
    public void onEJ()
    {
        System.out.print("in EJ");
        if(fE)
        {
        System.out.print("in if EJ");    
        
        observableList.add("Electronics\n");
        str+="E";
        fE=false;
        System.out.print("\n t3 "+str);
        
        }
        else
        {    
            System.out.print("in else EJ\n");
            str=str.replace('E','\0');
           System.out.print("\n t3 "+str);
            observableList.remove("Electronics\n");
            fE=true;

        }
    }
    @FXML
    private TextField qtot;
    @FXML
    private TextField qomark;
    @FXML
    private TextField qper;
    @FXML
    private TextField category;
        ToggleGroup tg;
    public void calq()
    {
        try
        {
        int marks=Integer.parseInt(qomark.getText());
        int totmarks=Integer.parseInt(qtot.getText());
        System.out.println("marks"+marks);
        float per=(float)(marks/(totmarks*1.0))*100;
        if(totmarks>marks)
        qper.setText(""+per);
        else
            qper.setText("");
        }catch(NumberFormatException e){
            System.out.println("not a number");
            qper.setText("");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try{
        formid=""+Integer.parseInt(getFormid());
        }catch(NumberFormatException e){
        
            Stage s = new Stage();
        try
        {
            formid=""+130;
            Parent par = FXMLLoader.load(getClass().getResource("/DialogsInt/formid_not_selected.fxml"));
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
        }//formid=""+125;
        System.out.println("Form id:"+formid);
        try
        {
        
            tg=new ToggleGroup();
            male.setToggleGroup(tg);
            female.setToggleGroup(tg);
            System.out.println("Inside try");
            Class.forName("com.mysql.jdbc.Driver");
            con();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/pro",username,password);
            String query="select * from uni where formid=?";
            PreparedStatement ps = con.prepareStatement(query);
            //ps.setInt(1,Integer.parseInt(formid));
            ps.setString(1,""+130);
            ResultSet rs=ps.executeQuery();
            System.out.println("Above if");
            if(rs.next())
            {
                System.out.println("Inside if");
            cand_f.setText(rs.getString("cand_f"));
            System.out.println("Candf"+rs.getString("cand_f"));
            cand_fa.setText(rs.getString("cand_fa"));
         cand_m.setText(rs.getString("cand_m"));
         cand_s.setText(rs.getString("cand_s"));
         //date
         //dob_place.setText(rs.getString("dob_place"));
         dob_village.setText(rs.getString("dob_village"));
         dob_taluka.setText(rs.getString("dob_taluka"));
         dob_district.setText(rs.getString("dob_district"));
         dob_state.setText(rs.getString("dob_state"));
         //
         name_father.setText(rs.getString("name_father"));
         occupation.setText(rs.getString("occupation"));
         relation.setText(rs.getString("relation"));
         land_num.setText(rs.getString("land_num"));
         father_num.setText(rs.getString("father_num"));
//---------------------------------------------       
         income.setText(rs.getString("income"));
         address.setText(rs.getString("address"));
         mob_num.setText(rs.getString("mob_num"));
         email_id.setText(rs.getString("email_id"));
         tot_marks.setText(rs.getString("tot_marks"));
        per_marks.setText(rs.getString("per_marks"));
        qual_exam.setText(rs.getString("qual_exam"));
        vocation_sub.setText(rs.getString("vacation_sub"));
        qual_exam.setText(rs.getString("class"));
        qual_exam.setText(rs.getString("id"));
        category.setText(rs.getString("cast"));
        religion.setText(rs.getString("religion"));
        
        if(rs.getString("gender").equals("male"))
        {
            male.setSelected(true);
        }else
            female.setSelected(true);
        
            }else
            {
                System.out.println("no rs.next()");
            }
        }catch(Exception ex){ex.printStackTrace();}        
    }    

    @FXML
     public void uniValidNum(String s,Label l)
    {
       if((s.length()==0) || (s.length()>13) || (s.length()<9) || s.equals(null))
        {
          l.setVisible(true);
           
        }
        char[] sarr=s.toCharArray();
        for(int i=0;i<s.length();i++)
        {
            if(!Character.isDigit(sarr[i]))
            {
                l.setVisible(true);
                break;
            }
            else if(Character.isWhitespace(sarr[i]))
            {
                l.setVisible(true);
                break;
            }
           else if(Character.isSpaceChar(sarr[i]))
            {
                l.setVisible(true);
                
                break;
            }
            else
           {
               l.setVisible(false);
           }
        }
    }
     @FXML
     public void uniValidStr(String s,Label l)
    {
       
        char[] sarr =  s.toCharArray();
        if((s.length()==0) || (s.length()<3) || s == null)
        {
            l.setVisible(true);
          
        }
        
        for(int i=0;i<s.length();i++)
        {
            if(!Character.isLetter(sarr[i]))
            {
                l.setVisible(true);
            
                break;
            }
            else if(Character.isWhitespace(sarr[i]))
            {
               l.setVisible(true);
                
                break;
            }
            else if(Character.isSpaceChar(sarr[i]))
            {
                l.setVisible(true);
               
                break;
            }
            else 
            {
                l.setVisible(false);
            }
        }  
    }   

     
    public void valid()
    {String s=cand_f.getText();
    //length checking
        
        uniValidStr(s,cand_namel);
    }
    public void valid1()
    {  
        String s=cand_fa.getText();
     
            uniValidStr(s,cand_fal);
    }
    public void valid2()
    {
        String s=cand_m.getText();
       uniValidStr(s,cand_mnamel);
    }
     public void valid3()
     {String s=cand_s.getText();
        
            uniValidStr(s,cand_snamel);
         
     }
     public void gender(){
                 if(male.isSelected()==false||female.isSelected()==false)
         {
             cand_sex.setVisible(true);
         }
                 else
                    cand_sex.setVisible(false);
             }
     public void bpvalid(){
         String s=dob_place.getText();
         uniValidStr(s,cand_bpl);
     }
     public void vilvalid(){
         String s=dob_village.getText();
         uniValidStr(s,cand_vil);
             
               
     }
     public void talvalid()
     {String s=dob_taluka.getText();
         uniValidStr(s,cand_tall);
         
     }
     public void distvalid()
     {String s=dob_district.getText();
         uniValidStr(s,cand_distl);
         
     }
     public void statevalid()
     {String s=dob_state.getText();
         uniValidStr(s,cand_statel);
     }
     public void fnamevalid()
     {String s=name_father.getText();
         uniValidStr(s,cand_fnamel);
     }
     public void foccvalid()
     {String s=occupation.getText();
        uniValidStr(s,cand_foccl);
     }
     public void frelnvalid()
     {String s=income.getText();
         uniValidStr(s,cand_frelnl);
         
     }
    public void fathernoValid()
    {
       // String s=cand_frno.getText();
        //uniValidNum(s,cand_frnol);
        
    }
    public void candMobileValid()
    {
        
        String s=father_num.getText();
        uniValidNum(s,cand_mobl);
   }
    public void candLandline()
    {
        String s=land_num.getText();
        uniValidNum(s,cand_landlinel);
    }
    
    

//-----------------------------------------------------------------
    //calculating marks
    public void cal()
    {
        try
        {
        int marks=Integer.parseInt(tot_marks.getText());
        System.out.println("marks"+marks);
        float per=(float)(marks/500.0)*100;
        if(marks<500)
        per_marks.setText(""+per);
        else
        per_marks.setText("");    
        }catch(NumberFormatException e){
            System.out.println("not a number");
            per_marks.setText("");
        }
    }
    @FXML
    private TextField religion;
    @FXML
    private DatePicker DOBDate;
    @FXML
    private DatePicker qyear;
    
    @FXML
    private TextField sscoutof_marks;
    
    @FXML
    private void onClickUpdate(ActionEvent event) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/pro","root","vinay");
            String query="update uni set cand_f=? where formid=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cand_f.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set cand_fa=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, cand_fa.getText());
            //ps.setString(2, cand_fa.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set cand_m=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, cand_m.getText());
            //ps.setString(2, cand_m.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set cand_s=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, cand_s.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set dob_village=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, dob_village.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set dob_taluka=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, dob_taluka.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set dob_district=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, dob_district.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set  dob_state=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, dob_state.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set  name_father=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, name_father.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set occupation=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, occupation.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set relation=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, relation.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set  land_num=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, land_num.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set  father_num=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, father_num.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set  income=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, income.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set address=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, address.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set mob_num=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, mob_num.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set email_id=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, email_id.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set tot_marks=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, tot_marks.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set per_marks=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, per_marks.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set qual_exam=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, qual_exam.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set father_num=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, father_num.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            
            query="update uni set vacation_sub=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1,vocation_sub.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set religion=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, religion.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set DOBDate=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, ""+DOBDate.getValue());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set ssctot=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, tot_marks.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            query="update uni set sscoutof_marks=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, sscoutof_marks.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set sscper=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, per_marks.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set vocationexam=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, qual_exam.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            
            query="update uni set qoexam=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, qomark.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set qmarks=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, qtot.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set qper=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, qper.getText());
            ps.setString(2,formid);
            ps.executeUpdate();
            
            query="update uni set qyear=? where formid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, ""+qyear.getValue());
            ps.setString(2,formid);
            ps.executeUpdate();
            
        }catch(Exception ex){ex.printStackTrace();}
        
        try
        {
            Stage stage = new Stage();
            Parent par = FXMLLoader.load(getClass().getResource("success.fxml"));
            Scene scene = new Scene(par);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }catch(Exception ex){ex.printStackTrace();}
    }

    @FXML
    private void conti(ActionEvent event) {
    }
    
}
