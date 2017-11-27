package com.gbc.a2101015020;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.gbc.a2101015020.db.AppDatabase;
import com.gbc.a2101015020.db.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ViewTestsActivity extends Activity {

    ListView listView;
    ArrayAdapter<Test> adapter;
    ArrayList<String> tests;
    AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tests);

        listView = findViewById(R.id.test_list_view);
        mDb = AppDatabase.getDatabase(getApplicationContext());
        adapter = new ArrayAdapter<>(
                this, R.layout.test_row, mDb.testDao().getAll());
        TestViewAdapter tAdapter = new TestViewAdapter(this, mDb.testDao().getAll());
        listView.setAdapter(tAdapter);
    }

    private void fetchTests() {
        List<Test> allTests = mDb.testDao().getAll();
        for (Test test : allTests){
            tests.add(String.format(Locale.getDefault()," %s \n Test ID: %d",
                    mDb.patientDao().getPatientName(test.getPatientId()), // patient full name
                    test.getTestId()));
        }
    }
}
