package com.gbc.a2101015020;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.gbc.a2101015020.db.Test;
import java.util.List;

/**
 * Created on 11/20/2017.
 */

public class TestViewAdapter extends ArrayAdapter<Test>{
    public TestViewAdapter(@NonNull Context context, List<Test> tests) {
        super(context, 0, tests);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent){
        Test test = getItem(pos);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.test_row, parent, false);
        }

        TextView testIdCell =  convertView.findViewById(R.id.test_id_cell);
        TextView patientNameCell = convertView.findViewById(R.id.patient_cell);
        TextView bphCell = convertView.findViewById(R.id.bph_cell);
        TextView bplCell = convertView.findViewById(R.id.bpl_cell);
        TextView tempCell = convertView.findViewById(R.id.temp_cell);

        testIdCell.setText(String.valueOf(test.getTestId()));
        patientNameCell.setText(String.valueOf(test.getPatientId()));
        bphCell.setText(String.valueOf(test.getBph()));
        bplCell.setText(String.valueOf(test.getBpl()));
        tempCell.setText(String.valueOf(test.getTemperature()));

        return convertView;

    }
}



