package com.geekbrains.weather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WHTimeAdapter extends RecyclerView.Adapter<WHTimeAdapter.ViewHolder> {


    private ArrayList<String> timeList = new ArrayList<>();
    private Context context;
    private CreateActionFragment.OnHeadlineSelectedListener mCallback;

    public WHTimeAdapter(Context context, ArrayList<String> timeList, CreateActionFragment.OnHeadlineSelectedListener mCallback) {
        this.timeList = timeList;
        this.mCallback = mCallback;
        this.context = context;
    }

    @NonNull
    @Override
    public WHTimeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item2, parent, false);
        WHTimeAdapter.ViewHolder viewHolder = new WHTimeAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(timeList.get(position));

    }

    @Override
    public int getItemCount() {
        return timeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview_item);
        }

    }
}
