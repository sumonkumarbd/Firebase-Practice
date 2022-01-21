package com.sumonkmr.firebasepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registation extends AppCompatActivity {

    EditText reg_email,reg_password;
    androidx.appcompat.widget.AppCompatButton reg_btn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registation);
        reg_email = findViewById(R.id.reg_email);
        reg_password = findViewById(R.id.reg_password);
        reg_btn = findViewById(R.id.reg_btn);
        auth = FirebaseAuth.getInstance();


        reg_btn.setOnClickListener(view -> {
            String email = reg_email.getText().toString();
            String password = reg_password.getText().toString();

            if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                Toast.makeText(Registation.this,"Please Enter an Valid Value",Toast.LENGTH_SHORT).show();
            }else {
                regM(email,password);
            }


        });

    }
    private void regM(String email, String password){


        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Registation.this, task -> {
            if (task.isSuccessful()){
            Toast.makeText(Registation.this,"Congratulation Registration Successfully ",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(Registation.this, "Something wrong...Try Again!!", Toast.LENGTH_SHORT).show();
        }
        });

    }


}