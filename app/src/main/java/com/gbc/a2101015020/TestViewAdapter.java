package com.gbc.a2101015020;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 11/20/2017.
 */

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder>{

    public interface OnItemClickListener {
        void onItemClick(String dataItem);
    }

    private final ArrayList<String> data;
    private final OnItemClickListener listener;

    public RecViewAdapter(ArrayList<String> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(data.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView cell;

        public ViewHolder(View itemView) {
            super(itemView);
            cell = itemView.findViewById(R.id.rec_cell);
        }

        public void bind (final String data, final OnItemClickListener listener) {
            cell.setText(data);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(data);
                }
            });
        }
    }


}
