package com.example.basiccalculus.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.example.basiccalculus.R;
import com.example.basiccalculus.playing.playAddition;
import com.example.basiccalculus.playing.playDivision;
import com.example.basiccalculus.playing.playMultiplaction;
import com.example.basiccalculus.playing.playSubtraction;

import java.util.Objects;

public class Practice extends AppCompatActivity {
    Button add, sub, mul, div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        initialise();
        clickHandler();
    }
    void initialise(){
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        div = findViewById(R.id.div);
        mul = findViewById(R.id.mul);
    }
    public void movement(String type){
        Intent i = null;
        if(Objects.equals(type, "add")) {
            i = new Intent(this, playAddition.class);
        }
        if(Objects.equals(type, "sub")) {
            i = new Intent(this, playSubtraction.class);
        }
        if(Objects.equals(type, "mul")) {
            i = new Intent(this, playMultiplaction.class);
        }
        if(Objects.equals(type, "div")) {
            i = new Intent(this, playDivision.class);
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