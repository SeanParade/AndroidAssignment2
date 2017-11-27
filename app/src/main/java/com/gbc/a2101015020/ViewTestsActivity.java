package com.gbc.a2101015020;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gbc.a2101015020.db.AppDatabase;
import com.gbc.a2101015020.db.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ViewTestsActivity extends Activity {

    RecyclerView recView;
    RecyclerView.Adapter adapter;
    ArrayList<String> tests;
    AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tests);
        recView = findViewById(R.id.test_recycler_view);
        mDb = AppDatabase.getDatabase(getApplicationContext());

        tests = new ArrayList<>();
        fetchTests(); // populate tests
        recView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecViewAdapter(tests);
        recView.setAdapter(adapter);
    }

    private void fetchTests() {
        HashMap<Integer,Test> allTests = new HashMap<>();
        for(Map.Entry<Integer, Test> test : allTests.entrySet()) {
            Integer id = test.getKey();
            Test testObj = test.getValue();
            tests.add(String.format(Locale.getDefault()," %s \n Test ID: %d",
                      mDb.patientDao().getPatientName(testObj.getPatientId()), // patient full name
                      id));
        }
    }
}
