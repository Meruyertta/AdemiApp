package com.example.musicapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.musicapp.R;
import com.example.musicapp.recycleviews.ModelProduct;
import com.example.musicapp.recycleviews.productdetails.ProductDetailsViewPagerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProductDetailActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private Button addBtn;
    String productId = "2";
    ModelProduct product = new ModelProduct(R.drawable.womanc,"Ankle-length Pants", "$ 29.99");
    ViewPager mViewPager;
    int[] images = {R.drawable.details_main_logo, R.drawable.details_product};

    ProductDetailsViewPagerAdapter productDetailsViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        addBtn = findViewById(R.id.addToCard);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Favorites");

        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);
        productDetailsViewPagerAdapter = new ProductDetailsViewPagerAdapter(ProductDetailActivity.this, images);

        mViewPager.setAdapter(productDetailsViewPagerAdapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(productId).setValue(product);
                        Toast.makeText(ProductDetailActivity.this, "Added Successfully...", Toast.LENGTH_SHORT).show();
                        Log.d("Database Works", "Added Successfully...");
//                        startActivity(new Intent());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(ProductDetailActivity.this, "Error...", Toast.LENGTH_SHORT).show();
                        Log.d("Database Error", String.valueOf(error));
                    }
                });
            }
        });
    }

    public void backtohome(View view) {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}