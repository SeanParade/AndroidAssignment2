package com.gbc.a2101015020;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.gbc.a2101015020.db.AppDatabase;
import com.gbc.a2101015020.db.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ViewPatientActivity extends Activity {
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> patients;
    AppDatabase mDb;
    TextView patCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient);
        listView = findViewById(R.id.patient_list_view);
        mDb = AppDatabase.getDatabase(getApplicationContext());
        patients = new ArrayList<>();
        fetchPatients();

        adapter = new ArrayAdapter<>(
                this, R.layout.patient_row, patients);

        listView.setAdapter(adapter);
    }

    private void fetchPatients() {
        // populate list with formatted string of patient data
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
