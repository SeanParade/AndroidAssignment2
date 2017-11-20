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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    protected void onVTestsClick(View view){
        Log.d(TAG, "View Tests: Pressed");
        startActivity(new Intent(view.getContext(), ViewTestsActivity.class));
    }
    protected void onVPatientClick(View view){
        Log.d(TAG, "View Patient: Pressed");
        startActivity(new Intent(view.getContext(), ViewPatientActivity.class));
    }
    protected void onEnterTestClick(View view){
        Log.d(TAG, "Enter Tests: Pressed");
        startActivity(new Intent(view.getContext(), EnterTestActivity.class));
    }
    protected void onLogoutClick(View view){
            Log.d(TAG, "Logout: Pressed");
            //AppDatabase.destroyInstance();
            startActivity(new Intent(view.getContext(), LoginActivity.class));
    }
}
