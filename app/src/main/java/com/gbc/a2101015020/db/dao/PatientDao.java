package com.gbc.a2101015020.db.dao;

import android.arch.persistence.room.*;

import com.gbc.a2101015020.db.Patient;

import java.util.List;


/**
 * Created on 11/17/2017.
 */
@Dao
public interface PatientDao {
        @Query("SELECT * FROM Patient")
        List<Patient> getAll();

        @Query("SELECT firstname || ' ' || lastname AS `whole_name` FROM `Patient` WHERE `patientId` == :patientId")
        String getPatientName(int patientId);

        @Insert
        void insertAll(Patient... patients);

        @Query("DELETE FROM patient")
        void nukeTable();

        @Update
        void updatePatients(Patient... patients);

        @Delete
        void delete(Patient... patients);
}
