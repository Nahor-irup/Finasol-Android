package com.example.finasol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finasol.Dashboard.DashboardActivity;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText txtBoxUsername,txtBoxPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        txtBoxUsername = findViewById(R.id.txtBoxUsername);
        txtBoxPassword = findViewById(R.id.txtBoxPassword);

        //login button click action
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtBoxUsername.getText().toString().trim();
                String password = txtBoxPassword.getText().toString().trim();

//                if(!username.isEmpty()&&!password.isEmpty()){
//                    Toast.makeText(LoginActivity.this, "Login Success.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
//                }else{
//                    Toast.makeText(LoginActivity.this, "Invalid Credential!!", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}