package com.example.musicapp.recycleviews.drawer;

import android.view.ViewGroup;

public abstract class DrawerItem<T extends DrawerRecycleViewAdapter.ViewHolder> {
    protected Boolean isChecked;
    public abstract T createViewHolder(ViewGroup parent);

    public abstract void bindViewHolder(T holder);

    public DrawerItem<T>setChecked(boolean isChecked){
        this.isChecked = isChecked;
        return this;
    }

    public Boolean isChecked(){
        return isChecked();
    }

    public Boolean isSelectable(){
        return true;
    }
}
