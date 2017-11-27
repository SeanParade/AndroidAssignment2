package com.gbc.a2101015020;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gbc.a2101015020.db.AppDatabase;
import com.gbc.a2101015020.db.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ViewPatientActivity extends Activity {
    RecyclerView recView;
    RecyclerView.Adapter adapter;
    ArrayList<String> patients;
    AppDatabase mDb;
    TextView patCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient);

        recView = findViewById(R.id.patient_recycler_view);
        mDb = AppDatabase.getDatabase(getApplicationContext());

        patients = new ArrayList<>();
        fetchTests(); // populate tests
        recView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecViewAdapter(patients, new RecViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String dataItem) {

            }
        });
        recView.setAdapter(adapter);
    }

    private void fetchTests() {
        List<Patient> allPatients = mDb.patientDao().getAll();
        for (Patient patient : allPatients) {
            patients.add(String.format(Locale.getDefault(), " Name: %s %s \n Patient ID: %d \n" +
                            " Doctor ID: %s \n Room: %s",
                    patient.getFirstName(), patient.getLastName(),
                    patient.getPatientId(), patient.getDoctorId(),
                    patient.getRoom()));
        }
    }
}
