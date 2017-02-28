/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edit_uni;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jayesh
 */
public class EditController implements Initializable {
    @FXML
    private Label errenroll_lbl;
    @FXML
    private Label errname_lbl;
    @FXML
    private Button cancel_btn1;
    @FXML
    private Button ok_btn1;
    @FXML
    private TextField enroll_tf1;
    @FXML
    private TextField name_tf1;
    @FXML
    private Label stud_found;
    @FXML
    private Button dialogreset_btn;
    @FXML
    private TextField formid_tf;
    static String name,enroll,formid;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickCancel(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void onClickOK(ActionEvent event) {
        
        name=name_tf1.getText();
        enroll=enroll_tf1.getText();
        formid=formid_tf.getText();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        /*try
        {
            Stage stage = new Stage();
            Parent par = FXMLLoader.load(getClass().getResource("uni.fxml"));
            Scene scene = new Scene(par);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }catch(Exception ex){}
        ((Node)(event.getSource())).getScene().getWindow().hide();*/
    }

    @FXML
    private void onClickdialogreset(ActionEvent event) {
        name_tf1.clear();
        enroll_tf1.clear();
        formid_tf.clear();
    }
    
    public static String getFormid()
    {
        return formid;
    }
    public static String getEnroll()
    {
        return enroll;
    }
    public static String getName()
    {
        return name;
    }
}
