package com.gbc.a2101015020.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created on 11/17/2017.
 */

@Entity(foreignKeys = @ForeignKey(entity = Doctor.class,
                                  parentColumns = "doctorId",
                                  childColumns = "doctor_id"))
public class Patient {
    @PrimaryKey(autoGenerate = true)
    private int patientId = 0;

    @ColumnInfo(name = "firstname")
    private String firstName;

    @ColumnInfo(name = "lastname")
    private String lastName;

    @ColumnInfo(name = "department")
    private String department;

    @ColumnInfo(name = "doctor_id")
    private int doctorId;

    @ColumnInfo(name = "room")
    private String room;

    public Patient(){ }

    public Patient(int patientId, String firstName, String lastName, String department, int doctorId, String room) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.doctorId = doctorId;
        this.room = room;
    }

    public Patient(int patientId, String firstName, String lastName) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Patient(int patientId, String firstName, String lastName, String department, int doctorId) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
