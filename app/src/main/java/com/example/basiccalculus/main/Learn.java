package com.example.basiccalculus.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.basiccalculus.Learn.LearnAddition;
import com.example.basiccalculus.Learn.LearnDivision;
import com.example.basiccalculus.Learn.LearnMultiplication;
import com.example.basiccalculus.Learn.LearnSubtraction;
import com.example.basiccalculus.R;
import com.example.basiccalculus.baseDonnes.User;

public class Learn extends AppCompatActivity {
    Button add, sub, mul, div, userLev, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        initialise();
        userLev.setText("Level "+ User.level);
        username.setText("User "+User.username);
        clickHandler();
    }
    public void initialise(){
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        userLev = findViewById(R.id.lev);
        userLev.setEnabled(false);
        username = findViewById(R.id.user);
        username.setEnabled(false);
    }
    public void movement(String type){
        Intent i = null;
        if(type == "add") {
            i = new Intent(this, LearnAddition.class);
        }
        if(type == "sub") {
            i = new Intent(this, LearnSubtraction.class);
        }
        if(type == "mul") {
            i = new Intent(this, LearnMultiplication.class);
        }
        if(type == "div") {
            i = new Intent(this, LearnDivision.class);
        }
        startActivity(i);
    }

    public void clickHandler(){
        add.setOnClickListener(view ->{
            movement("add");
        });
        sub.setOnClickListener(view ->{
            movement("sub");
        });
        mul.setOnClickListener(view ->{
            movement("mul");
        });
        div.setOnClickListener(view ->{
            movement("div");
        });
    }

}