package com.example.musicapp.recycleviews;

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

import java.util.ArrayList;


public class RecycleViewCategoryFragmentAdapter extends RecyclerView.Adapter<RecycleViewCategoryFragmentAdapter.myviewholder>{

    ArrayList<ModelCategoryFragment> dataholderProduct;
    SelectListener listener;

    public RecycleViewCategoryFragmentAdapter(ArrayList<ModelCategoryFragment> dataholderProduct, SelectListener listener) {
        this.dataholderProduct = dataholderProduct;
        this.listener=listener;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_fragment,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.desc.setText(dataholderProduct.get(position).getText());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(dataholderProduct.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataholderProduct.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView desc;
        public CardView cardView;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            desc=itemView.findViewById(R.id.itemCatName);
            cardView=itemView.findViewById(R.id.itemCardView);
        }
    }

}