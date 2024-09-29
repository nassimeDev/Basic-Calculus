package com.example.basiccalculus.Learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.basiccalculus.R;
import com.example.basiccalculus.baseDonnes.User;

public class LearnAddition extends AppCompatActivity {
    Button carry, noCarry, userLev, username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_addition);
        initialise();
        userLev.setText("Level "+ User.level);
        username.setText("User "+User.username);
        clickHandler();
    }
    public void initialise(){
        carry = findViewById(R.id.carry);
        noCarry = findViewById(R.id.noCarry);
        userLev = findViewById(R.id.lev);
        userLev.setEnabled(false);
        username = findViewById(R.id.user);
        username.setEnabled(false);
    }
    public void movement(String type){
        Intent i = null;
        if(type == "carry") {
            i = new Intent(this, CarryAdd.class);
        }
        if(type == "noCarry") {
            i = new Intent(this, NoCarryAdd.class);
        }
        startActivity(i);
    }
    void clickHandler()
    {
        carry.setOnClickListener(view ->
        {
            movement("carry");
        });
        noCarry.setOnClickListener(view ->
        {
            movement("noCarry");
        });
    }
}