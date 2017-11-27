package com.gbc.a2101015020;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.gbc.a2101015020.db.AppDatabase;
import com.gbc.a2101015020.db.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        adapter = new RecViewAdapter(tests, new RecViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String dataItem) {
                String testID = dataItem.substring(dataItem.length()-7,dataItem.length()-1);
                Toast.makeText(ViewTestsActivity.this, "item clicked" + testID, Toast.LENGTH_SHORT).show();
            }
        });
        recView.setAdapter(adapter);
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
