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


public class RecycleViewCategoryFragmentAdapter extends RecyclerView.Adapter<RecycleViewCategoryFragmentAdapter.myviewholder>{

    ArrayList<ModelCategoryFragment> dataholderProduct;

    public RecycleViewCategoryFragmentAdapter(ArrayList<ModelCategoryFragment> dataholderProduct) {
        this.dataholderProduct = dataholderProduct;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_fragment,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
        holder.desc.setText(dataholderProduct.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return dataholderProduct.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView desc;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            desc=itemView.findViewById(R.id.itemCatName);
        }
    }

}