package com.gbc.a2101015020.db;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.gbc.a2101015020.db.dao.*;


/**
 * Created on 11/17/2017.
 */
@Database(entities = {Patient.class, Test.class, Nurse.class, Doctor.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract PatientDao patientDao();
    public abstract TestDao testDao();
    public abstract NurseDao nurseDao();
    public abstract DoctorDao doctorDao();

    public static AppDatabase getDatabase(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "Assignment2DB")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }


    public static void destroyInstance(){
        INSTANCE = null;
    }
}
