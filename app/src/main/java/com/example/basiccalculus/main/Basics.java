package com.example.basiccalculus.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.basiccalculus.R;
import com.example.basiccalculus.degit1.RandomDigits;
import com.example.basiccalculus.baseDonnes.User;

public class Basics extends AppCompatActivity {
    Button digit1, learnMore,userLev, username ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics);
        initialise();
        userLev.setText("Level "+ User.level);
        username.setText("User "+User.username);
        click();
    }
    void initialise()
    {
        digit1 = findViewById(R.id.digit1);
        learnMore = findViewById(R.id.moreDigits);
        userLev = findViewById(R.id.lev);
        userLev.setEnabled(false);
        username = findViewById(R.id.user);
        username.setEnabled(false);
    }
    void click()
    {
        digit1.setOnClickListener(view ->
        {
            Intent i = new Intent(Basics.this, Digit1.class);
            startActivity(i);
        });
        learnMore.setOnClickListener(view ->
        {
            Intent i = new Intent(Basics.this, RandomDigits.class);
            startActivity(i);
        });
    }
}