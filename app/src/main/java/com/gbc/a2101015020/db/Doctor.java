package com.gbc.a2101015020.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created on 11/17/2017.
 */
@Entity
public class Doctor {

    @PrimaryKey(autoGenerate = true)
    private int doctorId = 0;

    @ColumnInfo(name = "firstname")
    private String firstName;

    @ColumnInfo(name = "lastname")
    private String lastName;

    @ColumnInfo(name = "department")
    private String department;

    public Doctor(int doctorId, String firstName, String lastName, String department) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public Doctor(){ }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
