package com.gbc.a2101015020;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gbc.a2101015020.db.AppDatabase;
import com.gbc.a2101015020.db.Nurse;
import java.util.Arrays;


public class AdminMenu extends Activity {

    Button submit;
    EditText first;
    String firstTxt;
    EditText last;
    String lastTxt;
    EditText dep;
    String depTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        first = findViewById(R.id.nurse_first);
        last = findViewById(R.id.nurse_last);
        dep = findViewById(R.id.nurse_dep);
        submit = findViewById(R.id.add_nurse);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstTxt = first.getText().toString().trim();
                lastTxt = last.getText().toString().trim();
                depTxt = dep.getText().toString().trim();
                Boolean[] rules = new Boolean[]{
                        TextUtils.isEmpty(firstTxt),
                        TextUtils.isEmpty(lastTxt),
                        TextUtils.isEmpty(depTxt)
                };

                if(Arrays.asList(rules).contains(false))  // if any of the rules are false
                    Toast.makeText(getApplicationContext(), "A field was left blank", Toast.LENGTH_SHORT).show();
                    else{

                        Nurse n = new Nurse(firstTxt, lastTxt, depTxt);
                        AppDatabase.getDatabase(getApplicationContext()).nurseDao().insertAll(n); // insert into db
                        AppDatabase.destroyInstance();
                        Toast.makeText(getApplicationContext(), "Nurse Added", Toast.LENGTH_SHORT).show();
                    }
            }
        });

    }

}
