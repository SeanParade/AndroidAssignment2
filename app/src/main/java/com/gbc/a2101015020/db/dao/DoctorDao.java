package com.gbc.a2101015020.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.gbc.a2101015020.db.Doctor;


import java.util.List;

/**
 * Created on 11/17/2017.
 */
@Dao
public interface DoctorDao {
        @Query("SELECT * FROM Doctor")
        List<Doctor> getAll();

        @Insert
        void insertAll(Doctor... doctors);

        @Query("DELETE FROM doctor")
        void nukeTable();

        @Update
        void updateDoctors(Doctor... doctors);

        @Delete
        void delete(Doctor... doctors);
}
