package com.example.gamabubakar.floatbuttonandsnackbar;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 AppCompatEditText username;
    AppCompatEditText password;
    TextInputLayout userlayout;
    TextInputLayout passwordlayout;
    RelativeLayout rl;
AppCompatButton Raised;
    AppCompatButton Flat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        userlayout = findViewById(R.id.username_inputtextlayout);
        passwordlayout = findViewById(R.id.password_inputtextlayout);


        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(password.hasFocus()==false)
                    passwordlayout.setErrorEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (username.getText().toString().isEmpty()) {
                    userlayout.setErrorEnabled(true);
                    userlayout.setError("Please Enter user name");
                } else {
                    userlayout.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passwordlayout.setCounterEnabled(true);
        passwordlayout.setCounterMaxLength(8);

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(username.hasFocus()==false)
                    userlayout.setErrorEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (password.getText().toString().isEmpty()) {

                    passwordlayout.setErrorEnabled(true);
                    passwordlayout.setError("Please Enter password");
                } else {
                    passwordlayout.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ///////////////////////////////////////////////////////////////////////////////
        rl = findViewById(R.id.RL);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.hasFocus()==false)
                userlayout.setErrorEnabled(false);
                if(password.hasFocus()==false)
                passwordlayout.setErrorEnabled(false);
            }
        });  //click empty screen to disable focus
///////////////////////////////////////////////////////////////////////////////////////////


        Raised = findViewById(R.id.raised);

        Raised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), username.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Flat = findViewById(R.id.flat);
        Flat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), password.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
