package com.example.musicapp.recycleviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;

import java.util.ArrayList;


public class RecycleViewHomeTagsAdapter extends RecyclerView.Adapter<RecycleViewHomeTagsAdapter.myviewholder>{

    ArrayList<ModelTag> dataholderTag;

    public RecycleViewHomeTagsAdapter(ArrayList<ModelTag> dataholderTag) {
        this.dataholderTag = dataholderTag;
    }
    @NonNull
    @Override
    public RecycleViewHomeTagsAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_tags_small,parent,false);
        return new RecycleViewHomeTagsAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHomeTagsAdapter.myviewholder holder, int position)
    {
        holder.desc.setText(dataholderTag.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return dataholderTag.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView desc;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            desc=itemView.findViewById(R.id.itemNameTag);
        }
    }

}
