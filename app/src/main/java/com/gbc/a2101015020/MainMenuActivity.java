package com.gbc.a2101015020;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.gbc.a2101015020.db.AppDatabase;

public class MainMenuActivity extends Activity {
    private static final String TAG = "MainMenuActivity";

    ImageButton enterTest;
    ImageButton displayTests;
    ImageButton displayPatient;
    ImageButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        enterTest = findViewById(R.id.enter_test);
        displayTests = findViewById(R.id.display_tests);
        displayPatient = findViewById(R.id.display_patient);
        logout = findViewById(R.id.logout);
    }

    protected void onLogoutClick(View view){
            Log.d(TAG, "onLoginClick: Pressed");
            //AppDatabase.destroyInstance();
            startActivity(new Intent(MainMenuActivity.this, LoginActivity.class));

    }


}
