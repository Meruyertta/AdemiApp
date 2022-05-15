package com.example.musicapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.musicapp.R;
import com.example.musicapp.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth= FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){
            finish();
        }

        Button btnRegister = findViewById(R.id.sign_up);
        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });


    }

    private void registerUser(){
        EditText registerName=findViewById(R.id.name_reg);
        EditText registerEmail=findViewById(R.id.email_reg);
        EditText registerPassword=findViewById(R.id.password_reg);


        String name=registerName.getText().toString();
        String email=registerEmail.getText().toString();
        String password=registerPassword.getText().toString();

        if(name.isEmpty() ||email.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "Please fill all the fields",Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(name,email);
                            FirebaseDatabase.getInstance().getReference("users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
//                                    Toast.makeText(RegisterActivity.this, "Authentication success",
//                                            Toast.LENGTH_SHORT).show();
                                    showLoginActivity();
                                }
                            });
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Success", "createUserWithEmail:success");
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Failed", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });

    }


//    public void gotohome(View view) {
//        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//        startActivity(intent);
//    }

    private void showLoginActivity() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }



}