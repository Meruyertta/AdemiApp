package com.example.musicapp.recycleviews;

public class ModelCategoryFragment {
    String text;

    public ModelCategoryFragment(String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
