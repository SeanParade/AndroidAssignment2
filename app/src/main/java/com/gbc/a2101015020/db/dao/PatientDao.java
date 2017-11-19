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

        @Insert
        void insertAll(Patient... patients);

        @Update
        void updatePatients(Patient... patients);

        @Delete
        void delete(Patient... patients);
}
