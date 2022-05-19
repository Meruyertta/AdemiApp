package com.example.musicapp.fragments;

import static android.content.Context.UI_MODE_SERVICE;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.musicapp.R;
import com.example.musicapp.User;
import com.example.musicapp.activities.HomeActivity;
import com.example.musicapp.activities.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class ProfileFragment extends Fragment {


    private UiModeManager uiModeManager;
    Switch switch1;

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userId;



    TextView tvName;

    public ProfileFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);

//        switch1=v.findViewById(R.id.switcher);
////        uiModeManager = getActivity().getSystemService(UI_MODE_SERVICE);
//
//        switch1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean checked = ((Switch) v).isChecked();
//                if (checked){
//                    Log.d("Checked", "true");
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                  }
//                else {
//                    Log.d("Checked", "false");
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
////
//                }
//            }
//        });

        TextView tvName=v.findViewById(R.id.name);
        TextView tvEmail=v.findViewById(R.id.email);
        TextView tvLogOut=v.findViewById(R.id.logout);


        FirebaseAuth auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("users");

        userId=user.getUid();

        reference.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user=snapshot.getValue(User.class);

                if(user!=null){
                    String name=user.name;
                    String email=user.email;

                    tvEmail.setText(email);
                    tvName.setText(name);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        tvLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("I will log out ye", "LOGGING OUT!");
                logoutUser();
            }
        });









        return v;


    }

    private void logoutUser(){
        FirebaseAuth.getInstance().signOut();
        Intent intent=new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);

    }

}