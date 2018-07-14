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

public class WHTempAdapter extends RecyclerView.Adapter<WHTempAdapter.ViewHolder> {


    private ArrayList<String> tempList = new ArrayList<>();
    private Context context;
    private CreateActionFragment.OnHeadlineSelectedListener mCallback;

    public WHTempAdapter(Context context, ArrayList<String> tempList, CreateActionFragment.OnHeadlineSelectedListener mCallback) {
        this.tempList = tempList;
        this.mCallback = mCallback;
        this.context = context;
    }

    @NonNull
    @Override
    public WHTempAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item2, parent, false);
        WHTempAdapter.ViewHolder viewHolder = new WHTempAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(tempList.get(position));
    }

    @Override
    public int getItemCount() {
        return tempList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview_item);
        }

    }
}
