package com.example.musicapp.recycleviews.drawer;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.musicapp.R;

public class DrawerModel extends DrawerItem<DrawerModel.ViewHolder>{

    private int selectedItemIconTint;
    private int selectedItemTitleTint;

    private int normalItemIconTint;
    private int normalItemTitleTint;

    private Drawable icon;
    private String title;

    public DrawerModel(Drawable icon, String title){
        this.icon = icon;
        this.title = title;
    }



    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_drawer_rv, parent, false);
        return new ViewHolder(v);
    }



    @Override
    public void bindViewHolder(ViewHolder holder) {
        holder.title.setText(title);
        holder.icon.setImageDrawable(icon);

        holder.title.setText(isChecked ? selectedItemTitleTint : normalItemTitleTint);
        holder.icon.setColorFilter(isChecked ? selectedItemIconTint : normalItemIconTint);
    }

    public DrawerModel withSelectedIconTint(int SelectedItemIconTint){
        this.selectedItemIconTint = selectedItemTitleTint;
        return this;
    }

    public DrawerModel withSelectedTitleTint(int selectedItemTitleTint){
        this.selectedItemTitleTint = selectedItemTitleTint;
        return this;
    }

    public DrawerModel withIconTint(int normalItemIconTint){
        this.normalItemIconTint = normalItemIconTint;
        return this;
    }

    public DrawerModel withTitleTint(int normalItemTitleTint){
        this.normalItemTitleTint = normalItemTitleTint;
        return this;
    }

    static class ViewHolder extends DrawerRecycleViewAdapter.ViewHolder{
        private ImageView icon;
        private TextView title;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            icon = itemView.findViewById(R.id.drawer_icon);
            title = itemView.findViewById(R.id.drawer_title);
        }
    }
}
