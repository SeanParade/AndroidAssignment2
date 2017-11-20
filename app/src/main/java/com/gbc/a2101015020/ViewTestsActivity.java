package com.gbc.a2101015020;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ViewTestsActivity extends Activity {

    RecyclerView recView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tests);

        recView = findViewById(R.id.test_recycler_view);
        recView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter();
        recView.setAdapter(adapter);
    }
}
