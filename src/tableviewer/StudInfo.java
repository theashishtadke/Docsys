/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tableviewer;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Administrator
 */
public class StudInfo {
    private final SimpleStringProperty formid;
    private final SimpleStringProperty name;
    private final SimpleStringProperty enroll;
    private final SimpleStringProperty per;

    public StudInfo( String formid,String name, String enroll,String per) {
        this.formid = new SimpleStringProperty(formid);
        this.name = new SimpleStringProperty(name);
        this.enroll = new SimpleStringProperty(enroll);
        this.per = new SimpleStringProperty(per);
    }

    public String getID() {
        return formid.get();
    }
    public String getPer() {
        return per.get();
    }

    public String getName() {
        return name.get();
    }

    public String getEnroll() {
        return enroll.get();
    }
    
}
