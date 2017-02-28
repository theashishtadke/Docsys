/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unittest;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Administrator
 */
public class StudInfo {
    private  SimpleStringProperty name;
    private  SimpleIntegerProperty marks;
    
    public StudInfo( String nam,int mark) {
        this.name = new SimpleStringProperty(nam);
        this.marks = new SimpleIntegerProperty(mark);
    }

    public String getName() {
        return name.get();
    }

    public int getMarks() {
        return marks.get();
    }
    public void setMarks(int m)
    {
        marks=new SimpleIntegerProperty(m);
    }
}
