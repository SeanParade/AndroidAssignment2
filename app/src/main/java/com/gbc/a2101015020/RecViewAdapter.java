package com.gbc.a2101015020;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created on 11/20/2017.
 */

class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder>{

    ArrayList<String> data;

    public RecViewAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cell.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cell;
        public ViewHolder(View itemView) {
            super(itemView);
            cell = itemView.findViewById(R.id.rec_cell);
        }
    }
}
