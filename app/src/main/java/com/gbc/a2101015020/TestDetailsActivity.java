package com.gbc.a2101015020;

import android.app.Activity;
import android.arch.persistence.room.Database;
import android.os.Bundle;

import com.gbc.a2101015020.db.AppDatabase;
import com.gbc.a2101015020.db.Test;

public class TestDetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_details);
        //Test test = AppDatabase.getDatabase(getApplicationContext()).testDao().getTestById();

    }
}
