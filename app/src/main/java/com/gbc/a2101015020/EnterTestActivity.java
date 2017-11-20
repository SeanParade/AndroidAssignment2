package com.gbc.a2101015020;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class EnterTestActivity extends Activity {

    EditText patientName;
    EditText bpl;
    EditText bph;
    EditText temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_test);
    }
}
