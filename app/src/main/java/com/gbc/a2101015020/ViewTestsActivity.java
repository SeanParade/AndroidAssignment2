package com.gbc.a2101015020;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.gbc.a2101015020.db.AppDatabase;
import com.gbc.a2101015020.db.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ViewTestsActivity extends Activity {

    ListView listView;
    ArrayAdapter<String> adapter;
    List<String> tests;
    AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tests);
        listView = findViewById(R.id.test_list_view);
        mDb = AppDatabase.getDatabase(getApplicationContext());
        tests = new ArrayList<>();
        fetchTests();

        adapter = new ArrayAdapter<>(this, R.layout.patient_row, tests);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Test> t = mDb.testDao().getAll();
                Intent i = new Intent(view.getContext(),TestDetailsActivity.class);
                i.putExtra("TEST_ID",String.valueOf(t.get(position).getTestId())); // Pass selected test id to the detail view
                startActivity(i);
            }
        });
    }

    private void fetchTests() {
        // populate list with test data
        List<Test> allTests = mDb.testDao().getAll();
        for (Test test : allTests){
            tests.add(String.format(Locale.getDefault()," %s \n Test ID: %d",
                    mDb.patientDao().getPatientName(test.getPatientId()), // patient full name
                    test.getTestId()));
        }
    }
}
