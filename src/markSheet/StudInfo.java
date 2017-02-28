/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package markSheet;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Administrator
 */
public class StudInfo {
    private final SimpleStringProperty name;
    private final SimpleStringProperty m1;
    private final SimpleStringProperty m2;
    private final SimpleStringProperty m3;
    private final SimpleStringProperty m4;
    private final SimpleStringProperty m5;
    private final SimpleStringProperty m6;
    private final SimpleStringProperty tot;
    private final SimpleStringProperty sign;
    
    public StudInfo( String name,String m1, String m2,String m3,String m4,String m5,String m6,String tot,String sign) {
        this.name = new SimpleStringProperty(name);
        this.m1 = new SimpleStringProperty(m1);
        this.m2 = new SimpleStringProperty(m2);
        this.m3 = new SimpleStringProperty(m3);
        this.m4 = new SimpleStringProperty(m4);
        this.m5 = new SimpleStringProperty(m5);
        this.m6 = new SimpleStringProperty(m6);
        this.tot = new SimpleStringProperty(tot);
        this.sign = new SimpleStringProperty(sign);
        
    }

    public String getName() {
        return name.get();
    }

    public String getM1() {
        return m1.get();
    }
    
    public String getM2() {
        return m2.get();
    }
    
    public String getM3() {
        return m3.get();
    }
    
    public String getM4() {
        return m4.get();
    }
    
    public String getM5() {
        return m5.get();
    }
    
    public String getM6() {
        return m6.get();
    }

    public String getSign() {
        return sign.get();
    }
    
    public String getTot() {
        return tot.get();
    }
}
