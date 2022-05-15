package com.example.musicapp.recycleviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.musicapp.R;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myviewholder>{

    ArrayList<Model> dataholder;

    public RecyclerViewAdapter(ArrayList<Model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_categories_big,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
        holder.img.setImageResource(dataholder.get(position).getImage());
        holder.desc.setText(dataholder.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView desc;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=itemView.findViewById(R.id.itemImg);
            desc=itemView.findViewById(R.id.itemName);
        }
    }

}
