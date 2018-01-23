package com.example.android_soleeklab.mylistview;

/**
 * Created by android-soleeklab on 1/23/2018.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<ItemModel> itemModels;
    private List<Integer> selectedId = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);


        }
    }


    public MyAdapter(List<ItemModel> itemModels) {
        this.itemModels = itemModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ItemModel itemModel = itemModels.get(position);
        holder.title.setText(itemModel.getTitle());
        if (isSelected(itemModel.getId())) holder.imageView.setVisibility(View.VISIBLE);
        else holder.imageView.setVisibility(View.INVISIBLE);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("shirt", position + "");
                int index = findIndex(itemModels.get(position).getId());
                if (index == -1) selectedId.add(itemModels.get(position).getId());
                else selectedId.remove(index);
                notifyDataSetChanged();
            }

        });
    }

    private int findIndex(int id) {
        for (int i = 0; i < selectedId.size(); i++) {
            if (selectedId.get(i) == id) return i;
        }
        return -1;
    }

    private boolean isSelected(int id) {
        for (int i = 0; i < selectedId.size(); i++) {
            if (selectedId.get(i) == id) return true;
        }
        return false;
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }
}