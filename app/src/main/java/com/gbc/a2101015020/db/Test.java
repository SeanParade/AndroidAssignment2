package com.gbc.a2101015020.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created on 11/17/2017.
 */
@Entity(foreignKeys = @ForeignKey(entity = Patient.class,
                                  parentColumns = "patientId",
                                   childColumns = "patient_id"))
public class Test {

    @PrimaryKey(autoGenerate = true)
    private int testId  = 0;

    @ColumnInfo(name="patient_id")
    private int patientId;

    @ColumnInfo(name="bpl")
    private int bpl;

    @ColumnInfo(name="bph")
    private int bph;

    @ColumnInfo(name="temperature")
    private double temperature;

    public Test() { }

    public Test(String patientId, String bpl, String bph, String temperature) {
        this.patientId = Integer.parseInt(patientId);
        this.bpl = Integer.parseInt(bpl);
        this.bph = Integer.parseInt(bph);
        this.temperature = Double.parseDouble(temperature);
    }

    public Test(int patientId, int bpl, int bph, double temperature) {
        this.patientId = patientId;
        this.bph = bph;
        this.bpl = bpl;
        this.temperature = temperature;
    }

    public Test(int testId, int patientId, int bpl, int bph, double temperature) {
        this.testId = testId;
        this.patientId = patientId;
        this.bpl = bpl;
        this.bph = bph;
        this.temperature = temperature;
    }

    public Test(int testId, int patientId, int bpl, int bph) {
        this.testId = testId;
        this.patientId = patientId;
        this.bpl = bpl;
        this.bph = bph;
    }

    public Test(int testId, int patientId, double temperature) {
        this.testId = testId;
        this.patientId = patientId;
        this.temperature = temperature;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getBpl() {
        return bpl;
    }

    public void setBpl(int bpl) {
        this.bpl = bpl;
    }

    public int getBph() {
        return bph;
    }

    public void setBph(int bph) {
        this.bph = bph;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
