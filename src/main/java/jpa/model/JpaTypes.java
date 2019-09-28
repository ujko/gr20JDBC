package jpa.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class JpaTypes {
    //wszystkie typy proste
    @Id
    private int a;

    //wszystkie wrappery
    private Integer zmienna;

    private java.sql.Date javaSqlDate;
    private java.sql.Time javaSqlTime;
    private java.sql.Timestamp javaSqlTimeStamp;

    @Temporal(TemporalType.DATE)
    private java.util.Date javaUtilDate;

    @Temporal(TemporalType.TIME)
    private java.util.Date javaUtilTime;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date javaUtilTimeStamp;

    @Transient
    private String niechciana;

    public String getNiechciana() {
        return niechciana;
    }

    public void setNiechciana(String niechciana) {
        this.niechciana = niechciana;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Integer getZmienna() {
        return zmienna;
    }

    public void setZmienna(Integer zmienna) {
        this.zmienna = zmienna;
    }

    public Date getJavaSqlDate() {
        return javaSqlDate;
    }

    public void setJavaSqlDate(Date javaSqlDate) {
        this.javaSqlDate = javaSqlDate;
    }

    public Time getJavaSqlTime() {
        return javaSqlTime;
    }

    public void setJavaSqlTime(Time javaSqlTime) {
        this.javaSqlTime = javaSqlTime;
    }

    public Timestamp getJavaSqlTimeStamp() {
        return javaSqlTimeStamp;
    }

    public void setJavaSqlTimeStamp(Timestamp javaSqlTimeStamp) {
        this.javaSqlTimeStamp = javaSqlTimeStamp;
    }

    public java.util.Date getJavaUtilDate() {
        return javaUtilDate;
    }

    public void setJavaUtilDate(java.util.Date javaUtilDate) {
        this.javaUtilDate = javaUtilDate;
    }

    public java.util.Date getJavaUtilTime() {
        return javaUtilTime;
    }

    public void setJavaUtilTime(java.util.Date javaUtilTime) {
        this.javaUtilTime = javaUtilTime;
    }

    public java.util.Date getJavaUtilTimeStamp() {
        return javaUtilTimeStamp;
    }

    public void setJavaUtilTimeStamp(java.util.Date javaUtilTimeStamp) {
        this.javaUtilTimeStamp = javaUtilTimeStamp;
    }
}
