package com.gbc.a2101015020;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gbc.a2101015020.db.AppDatabase;
import com.gbc.a2101015020.db.Test;

import java.util.Arrays;

public class EnterTestActivity extends Activity {

    private static final String TAG = "EnterTestActivity";

    EditText patId, bpl, bph, temperature;
    String patIdTxt, bplTxt, bphTxt, tempTxt;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_test);

        //Form Elements
        patId = findViewById(R.id.patient_id_edit);
        bpl = findViewById(R.id.bpl_edit);
        bph = findViewById(R.id.bph_edit);
        temperature = findViewById(R.id.temperature_edit);
        button = findViewById(R.id.submit_test_button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(TAG, "Enter Test: Pressed");
                patIdTxt = patId.getText().toString().trim();
                bplTxt = bpl.getText().toString().trim();
                bphTxt = bph.getText().toString().trim();
                tempTxt = temperature.getText().toString().trim();

                Boolean[] rules = new Boolean[]{
                        TextUtils.isEmpty(patIdTxt),
                        TextUtils.isEmpty(bplTxt),
                        TextUtils.isEmpty(bphTxt),
                        TextUtils.isEmpty(tempTxt)
                };

                if(Arrays.asList(rules).contains(true)) {
                    Toast.makeText(EnterTestActivity.this,
                            "Some fields are empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Test t = new Test(patIdTxt, bplTxt, bphTxt, tempTxt);
                    AppDatabase.getDatabase(getApplicationContext()).testDao().insertAll(t); // db insert
                    AppDatabase.destroyInstance();
                    Toast.makeText(EnterTestActivity.this,
                            "Test Added to Database", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(view.getContext(), MainMenuActivity.class));
                }
            }
        });

    }


}
