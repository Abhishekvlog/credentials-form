package com.example.intentfilter1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mtvEmailId;
    private TextView mtvPassword;
    private TextView mtvForgot;
    private Button mBtnLogin;
    private String emailValid = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmailValid() && isPasswordValid()){
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);}
            }
        });
    }


    private void initViews(){
        mtvEmailId = findViewById(R.id.EmailId);
        mtvPassword = findViewById(R.id.Password);
        mtvForgot = findViewById(R.id.forgot);
        mBtnLogin = findViewById(R.id.Login);
    }
    private  boolean isEmailValid(){
        if(mtvEmailId.getText().toString().length() >=1 && mtvEmailId.getText().toString().matches(emailValid)){
            return true;
        }else {
            mtvEmailId.setError("Invalid Email");
            return false;
        }
    }
    private boolean isPasswordValid(){
        if(mtvPassword.getText().toString().length() >=6){
            return true;
        }else {
            return false;
        }
    }

}