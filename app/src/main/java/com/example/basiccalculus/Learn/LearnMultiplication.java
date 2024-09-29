package com.example.basiccalculus.Learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.basiccalculus.R;
import com.example.basiccalculus.baseDonnes.User;

public class LearnMultiplication extends AppCompatActivity {
    Button simple, advanced, userLev, username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_multiplication);
        initialise();
        userLev.setText("Level "+ User.level);
        username.setText("User "+User.username);
        clickHandler();
    }
    public void initialise(){
        simple = findViewById(R.id.simple);
        advanced = findViewById(R.id.advanced);
        userLev = findViewById(R.id.lev);
        userLev.setEnabled(false);
        username = findViewById(R.id.user);
        username.setEnabled(false);
    }
    public void movement(String type){
        Intent i = null;
        if(type == "simple") {
            i = new Intent(this, SimpleMul.class);
        }
        if(type == "advanced") {
            i = new Intent(this, AdvancedMul.class);
        }
        startActivity(i);
    }
    void clickHandler()
    {
        simple.setOnClickListener(view ->
        {
            movement("simple");
        });
        advanced.setOnClickListener(view ->
        {
            movement("advanced");
        });
    }
}