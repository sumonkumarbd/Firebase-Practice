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

public class Login extends AppCompatActivity {

    EditText log_email,log_password;
    androidx.appcompat.widget.AppCompatButton log_btn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        log_email = findViewById(R.id.log_email);
        log_password = findViewById(R.id.log_password);
        log_btn = findViewById(R.id.log_btn);
        auth = FirebaseAuth.getInstance();


        log_btn.setOnClickListener(view -> {
            String email = log_email.getText().toString();
            String password = log_password.getText().toString();
            if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                Toast.makeText(Login.this,"Please Enter an Valid Value",Toast.LENGTH_SHORT).show();
            }else {
                logM(email,password);
            }

        });


    }
    private void logM(String email, String password){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(Login.this, task -> {
           if (task.isSuccessful()){
               Toast.makeText(Login.this, "Login Successfully!!", Toast.LENGTH_SHORT).show();
           }else {
               Toast.makeText(Login.this, "Try Again!!", Toast.LENGTH_SHORT).show();
           }
        });
    }


}