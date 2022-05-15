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


public class RecycleViewHomeProductAdapter extends RecyclerView.Adapter<RecycleViewHomeProductAdapter.myviewholder>{

    ArrayList<ModelProduct> dataholderProduct;

    public RecycleViewHomeProductAdapter(ArrayList<ModelProduct> dataholderProduct) {
        this.dataholderProduct = dataholderProduct;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_product,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
        holder.img.setImageResource(dataholderProduct.get(position).getImage());
        holder.desc.setText(dataholderProduct.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataholderProduct.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView desc;
        TextView price;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=itemView.findViewById(R.id.itemImg);
            desc=itemView.findViewById(R.id.itemName);
            price=itemView.findViewById(R.id.itemPrice);
        }
    }

}