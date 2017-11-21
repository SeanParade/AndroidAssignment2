package com.gbc.a2101015020.db.dao;

import android.arch.persistence.room.*;

import com.gbc.a2101015020.db.Patient;
import com.gbc.a2101015020.db.Test;

import java.util.List;

/**
 * Created on 11/17/2017.
 */
@Dao
public interface TestDao {
        @Query("SELECT * FROM Test")
        List<Test> getAll();

        @Insert
        void insertAll(Test... tests);

        @Update
        void updateTests(Test... tests);

        @Delete
        void delete(Test... tests);
}
