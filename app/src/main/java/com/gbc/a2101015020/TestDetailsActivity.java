package com.gbc.a2101015020;

import android.app.Activity;
import android.arch.persistence.room.Database;
import android.os.Bundle;
import android.widget.TextView;

import com.gbc.a2101015020.db.AppDatabase;
import com.gbc.a2101015020.db.Test;

public class TestDetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_details);
        AppDatabase mDb = AppDatabase.getDatabase(getApplicationContext());

        Test test = mDb
                .testDao().getTestById(
                        Integer.parseInt(getIntent().getStringExtra("TEST_ID")));
        TextView id = findViewById(R.id.test_id_dt);
        TextView pat = findViewById(R.id.pname_pid_dt);
        TextView bph = findViewById(R.id.bph_dt);
        TextView bpl = findViewById(R.id.bpl_dt);
        TextView temp = findViewById(R.id.temp_dt);

        id.setText(String.valueOf(test.getTestId()));
        String patTxt = "ID: " + String.valueOf(test.getPatientId()) + "\n"
                + mDb.patientDao().getPatientName(test.getPatientId());
        pat.setText(patTxt);
        bph.setText(String.valueOf(test.getBph()));
        bpl.setText(String.valueOf(test.getBpl()));
        temp.setText(String.valueOf(test.getTemperature()));

    }
}
