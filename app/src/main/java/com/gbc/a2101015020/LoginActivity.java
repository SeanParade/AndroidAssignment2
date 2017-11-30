package com.gbc.a2101015020;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gbc.a2101015020.db.AppDatabase;
import com.gbc.a2101015020.db.Doctor;
import com.gbc.a2101015020.db.Nurse;
import com.gbc.a2101015020.db.Patient;
import com.gbc.a2101015020.db.Test;

import java.util.List;

public class LoginActivity extends Activity {

    private static final String TAG = "Login Activity";
    private static final Boolean DEBUG = true;
    private AppDatabase db;
    Button loginButton;
    EditText usrname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = AppDatabase.getDatabase(getApplicationContext());

        if(DEBUG) {
            db.testDao().nukeTable();
            db.patientDao().nukeTable();
            db.nurseDao().nukeTable();
            db.doctorDao().nukeTable();
            populateDatabase(db);
        }

        loginButton = findViewById(R.id.login_button);
        usrname = findViewById(R.id.usernameEditText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onLoginClick: Pressed");
                
                if(!usrname.getText().toString().isEmpty()) {
                    // Edit text field populated
                    List<Nurse> n = db.nurseDao().getAll();
                    List<Doctor> d = db.doctorDao().getAll();

                    for (Nurse nurse : n){
                        // loop through nurses in db and see if ID matches
                        if(usrname.getText().toString()
                                .equals(nurse.getNurseIdStr())){
                            startActivity(new Intent(v.getContext(), MainMenuActivity.class));
                            return;
                        }
                    }
                    for (Doctor doctor : d){
                        // loop through doctors in db and see if ID matches
                        if(usrname.getText().toString()
                                .equals(doctor.getDoctorIdStr())){
                            startActivity(new Intent(v.getContext(), MainMenuActivity.class));
                            return;
                        }
                    }
                    Toast.makeText(LoginActivity.this, "The ID entered doesn't exist", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(LoginActivity.this, "Please use a correct ID", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy(){
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    protected void populateDatabase(AppDatabase db){
        // Populate the db with generic/iterative test data
        if(db.testDao().getAll().isEmpty()){
            for (int i = 1; i < 50; i++) {
                String istr = String.valueOf(i);
                db.nurseDao().insertAll(new Nurse(i+0,"fname"+istr,"lname"+istr, "TestDepartment"));
                db.doctorDao().insertAll(new Doctor(i+0,"fname"+istr,"lname"+istr, "TestDepartment"));
                db.patientDao().insertAll(new Patient(i+0,"fname"+istr, "lname"+istr, "TestDepartment", i+200000, "Room "+istr));
                db.testDao().insertAll(new Test(i+0, i+0, 90+i, 100+i,98+(i*0.1)));
            }
        }
    }

}
