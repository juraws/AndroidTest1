package com.example.androidtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText usernameET;
    private EditText passwordET;
    private CheckBox readedCB;
    private ImageButton loginButton;
    private ImageButton pwd;
    private boolean pwdCanSee;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (ImageButton) findViewById(R.id.ibLogin);
        usernameET = findViewById(R.id.editQQNum);
        passwordET = findViewById(R.id.editQQPassword);
        pwd = findViewById(R.id.pwd);
        pwdCanSee = false;

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                String username = usernameET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();
                readedCB = findViewById(R.id.readed);
                if (username.equals("juraws") && password.equals("123456") && readedCB.isChecked()) {
                    intent = new Intent(MainActivity.this, LoginSucceeded.class);
                    startActivity(intent);
                } else {

                }
            }
        });

        pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pwdCanSee) {
                    pwdCanSee = false;
                    pwd.setEnabled(true);
                    pwd.setBackgroundResource(R.drawable.eye_close);
                    passwordET.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else{
                    pwdCanSee = true;
                    pwd.setEnabled(true);
                    pwd.setBackgroundResource(R.drawable.eye_on);
                    passwordET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        usernameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String username = usernameET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();
                if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                    loginButton.setEnabled(true);
                    loginButton.setBackgroundResource(R.drawable.shape_circle);
                }
                else {
                    loginButton.setEnabled(true);
                    loginButton.setBackgroundResource(R.drawable.shape_circle_gray);
                }
            }
        });

        passwordET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!pwdCanSee) {
                    pwd.setEnabled(true);
                    pwd.setBackgroundResource(R.drawable.eye_close);
                    passwordET.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else {
                    pwd.setEnabled(true);
                    pwd.setBackgroundResource(R.drawable.eye_on);
                    passwordET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String username = usernameET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();
                if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                    loginButton.setEnabled(true);
                    loginButton.setBackgroundResource(R.drawable.shape_circle);
                }
                else {
                    loginButton.setEnabled(true);
                    loginButton.setBackgroundResource(R.drawable.shape_circle_gray);
                }

                if(TextUtils.isEmpty(password)) {
                    pwd.setEnabled(true);
                    pwd.setBackgroundResource(R.drawable.transparent);
                }

            }
        });


    }
}