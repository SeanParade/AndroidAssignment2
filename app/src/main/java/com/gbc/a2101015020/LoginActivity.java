package com.gbc.a2101015020;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gbc.a2101015020.db.AppDatabase;

public class LoginActivity extends Activity {

    private static final String TAG = "Login Activity";
    private AppDatabase db;
    Button loginButton;
    EditText usrname;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = AppDatabase.getDatabase(getApplicationContext());
        loginButton = findViewById(R.id.login_button);
        usrname = findViewById(R.id.usernameEditText);
        pass = findViewById(R.id.passwordEditText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onLoginClick: Pressed");
                if(usrname.getText().toString().equals("admin") && pass.getText().toString().equals("admin"))
                    startActivity(new Intent(v.getContext(), AdminMenu.class));
                else
                    startActivity(new Intent(v.getContext(), MainMenuActivity.class));
            }
        });
    }

    protected void onLoginClick(View view){
        }

    @Override
    protected void onDestroy(){
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
