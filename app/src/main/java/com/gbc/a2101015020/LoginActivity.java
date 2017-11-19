package com.gbc.a2101015020;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.os.Bundle;

import com.gbc.a2101015020.db.AppDatabase;

public class LoginActivity extends Activity {

    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = AppDatabase.getDatabase(getApplicationContext());
    }



    @Override
    protected void onDestroy(){
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
