package com.gbc.a2101015020;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gbc.a2101015020.db.AppDatabase;

public class LoginActivity extends Activity {

    private static final String TAG = "Login Activity";
    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = AppDatabase.getDatabase(getApplicationContext());
    }

    protected void onLoginClick(View view){
        Log.d(TAG, "onLoginClick: Pressed");
        startActivity(new Intent(LoginActivity.this, MainMenuActivity.class));
    }

    @Override
    protected void onDestroy(){
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
