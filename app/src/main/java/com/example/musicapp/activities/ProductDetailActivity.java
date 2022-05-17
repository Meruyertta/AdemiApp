package com.example.musicapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.musicapp.R;
import com.example.musicapp.recycleviews.productdetails.ProductDetailsViewPagerAdapter;

public class ProductDetailActivity extends AppCompatActivity {

    ViewPager mViewPager;
    int[] images = {R.drawable.details_main_logo, R.drawable.details_product};

    ProductDetailsViewPagerAdapter productDetailsViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);
        productDetailsViewPagerAdapter = new ProductDetailsViewPagerAdapter(ProductDetailActivity.this, images);

        mViewPager.setAdapter(productDetailsViewPagerAdapter);
    }

    public void backtohome(View view) {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}