package com.example.musicapp.recycleviews.shoppingCart;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;
import com.example.musicapp.SelectListener;
import com.example.musicapp.recycleviews.SelectListener2;


import java.util.ArrayList;


public class RecycleViewCartFragmentAdapter extends RecyclerView.Adapter<RecycleViewCartFragmentAdapter.myviewholder>{

    ArrayList<ModelCartFragment> dataholderCart;
    SelectListener2 selectListener2;

    public RecycleViewCartFragmentAdapter(ArrayList<ModelCartFragment> dataholderCart) {
        this.dataholderCart = dataholderCart;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart_fragment,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.img.setImageResource(dataholderCart.get(position).getImage());
        holder.desc.setText(dataholderCart.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return dataholderCart.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView desc;
        TextView price;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=itemView.findViewById(R.id.cartitemImg);
            desc=itemView.findViewById(R.id.cartitemName);
            price=itemView.findViewById(R.id.cartitemPrice);
            //??????
        }
    }

}