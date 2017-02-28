/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_form;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import uni_form.Uni_Form;

import javax.swing.JFrame;
//import javax.swing.JFrame;


/**
 *
 * @author Nitu
 */
public class FXMLDocumentController extends JFrame implements Initializable {
    
//name    
    @FXML
    private CheckBox br_cm;
    @FXML
    private CheckBox br_if;
    @FXML
    private CheckBox br_ej;
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
    @FXML
           RadioButton male,female;
    ToggleGroup tg;
    @FXML
    private Button lastb;
    @FXML
    private TextField category;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(Uni_Form.retFlag())
        {
            retrive();
        }
        first();
    }
   
    public void first()
    {
    //    e1.setVisible(false);
        //radio();
        
        System.out.println("inti");
        tg=new ToggleGroup();
        male.setToggleGroup(tg);
        female.setToggleGroup(tg);
        male.setSelected(true);
        
        
    }
//----------------------------------------------------------------------    
//perment storage imlementation
    String str="";
    Connection con;
    @FXML
    private ListView<String> expClass;
    ObservableList<String> observableList = FXCollections.observableArrayList();
   BufferedReader br1;
    FileReader fr1;
    String username,password;
    private void con1()throws Exception
    {
            fr1=new FileReader("vinpass.txt");    
             br1=new BufferedReader(fr1);
            String str=br1.readLine();
            String str1[]=str.split(" ");
            username=str1[0];
            password=str1[1];
            br1.close();
            fr1.close();
    }  
    @FXML
    private TextField religion;
    @FXML
    private DatePicker DOBDate;
    @FXML
    private TextField sscoutof_marks;
    @FXML
    private TextField ssctot;
    @FXML
    private DatePicker qyear;
   @FXML
    public void connect()
    {
        try{
            con1();
        Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro",username,password);
                                                                                                        
        PreparedStatement pr=con.prepareStatement("insert into uni values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        pr.setString(1, cand_f.getText());
        pr.setString(2, cand_fa.getText());
        pr.setString(3, cand_s.getText());
        pr.setString(4, cand_m.getText());
        pr.setString(5, dob_district.getText());
        pr.setString(6, dob_village.getText());
        pr.setString(7, dob_taluka.getText());
        pr.setString(8, dob_state.getText());
        pr.setString(9, name_father.getText());
        pr.setString(10, occupation.getText());
        pr.setString(11, relation.getText());
        pr.setString(12, land_num.getText());
        pr.setString(13, father_num.getText());
        pr.setString(14, income.getText());
        pr.setString(15, address.getText());
        pr.setString(16, mob_num.getText());
        pr.setString(17, email_id.getText());
        pr.setString(18, tot_marks.getText());
        pr.setString(19, per_marks.getText());
        pr.setString(20, qual_exam.getText());
        pr.setString(21, vocation_sub.getText());
        String trim = str.trim();
        pr.setString(22,trim);
        pr.setInt(23,0);
        int i=initi();
        if(i==0){ throw new Exception();}
           pr.setInt(24,i);
        pr.setString(25,category.getText());   
        pr.setString(26,religion.getText());
        pr.setString(27,"");
        pr.setString(28,""+DOBDate.getValue());
        pr.setString(29,tot_marks.getText());
        pr.setString(30,sscoutof_marks.getText());
        pr.setString(31,per_marks.getText());
        pr.setString(32,vocation_sub.getText());
        pr.setString(37,"");
        pr.setString(33,qomark.getText());
        pr.setString(34,qtot.getText());
        pr.setString(35,qper.getText());
        pr.setString(36,""+qyear.getValue());
        
        
        pr.execute();
                Stage stage = new Stage();
                try
                {
                    Parent par = FXMLLoader.load(getClass().getResource("/DialogsInt/stud_record_saved.fxml"));
                    Scene scene = new Scene(par);
                    stage.setScene(scene);
                }catch(Exception ex){}
                stage.setResizable(false);
                stage.setTitle("Success!");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
    
        //JOptionPane.showMessageDialog(this,"Record inserted sucessfully","sucessful",1);
        System.out.println("Record inserted sucessful");
        }catch(Exception e){
                Stage stage = new Stage();
                try
                {
                    Parent par = FXMLLoader.load(getClass().getResource("/DialogsInt/stud_record_not_saved.fxml"));
                    Scene scene = new Scene(par);
                    stage.setScene(scene);
                }catch(Exception ex){}
                stage.setResizable(false);
                stage.setTitle("Success!");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
    
            e.printStackTrace();
        //JOptionPane.showMessageDialog(this,"Record not inserted","Error",0);
        }    
        
    }
    private int initi()
    {try{
     Statement s=con.createStatement();
     ResultSet rs=s.executeQuery("Select * from uni");
     if(rs.last())
     {
        int tmp=rs.getInt(24);
        return (++tmp);
     }
     else
     {
         return (1);
     }
    }catch(Exception e){e.printStackTrace();}
    return 0;
    }
    
    String str2="";
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
    
//----------------------------------------------------------------------
     FileWriter fw;
    BufferedWriter bf;
    BufferedReader br;
    FileReader fr;
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
    
    //temporary storage
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
        connect();
        }
        catch(IOException e){}
        System.out.println("Saved");
    }
    @FXML
    public void conti()
    {
       retrive();
    }
    
    //temp ends
    
//-----------------------------------------------------------------
    /* include the validation code here take it from ashish
    
    */
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
     @FXML
     private Label cand_namel;   
     @FXML
     private Label cand_fal;   
     @FXML
     private Label cand_mnamel;
     @FXML
     private Label cand_snamel;   
     @FXML
     private Label cand_sex;   
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
     private Label stud_nativel;
     @FXML
     private Label stud_nvill;
     @FXML
     private Label stud_ntall;
     @FXML
     private Label stud_ndistl;
     @FXML
     private Label stud_nstatel;
     @FXML
     private Label cand_frnol;
     @FXML
     private Label cand_mobl;
     @FXML
     private Label cand_landlinel;

     
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
    private TextField qtot;
    @FXML
    private TextField qomark;
    @FXML
    private TextField qper;
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
}

