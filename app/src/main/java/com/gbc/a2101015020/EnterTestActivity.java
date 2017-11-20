package com.gbc.a2101015020;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterTestActivity extends Activity {

    private static final String TAG = "EnterTestActivity";

    EditText firstName;
    EditText lastName;
    EditText bpl;
    EditText bph;
    EditText temperature;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_test);

        firstName = findViewById(R.id.first_name_edit);
        lastName = findViewById(R.id.last_name_edit);
        bpl = findViewById(R.id.bpl_edit);
        bph = findViewById(R.id.bph_edit);
        temperature = findViewById(R.id.temperature_edit);
        button = findViewById(R.id.submit_test_button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // TODO: 20/11/2017 Save data to database
                Log.d(TAG, "Enter Test: Pressed");
                //AppDatabase.destroyInstance();
                startActivity(new Intent(view.getContext(), MainMenuActivity.class));
            }
        });

    }


}
