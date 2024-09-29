package com.example.basiccalculus.playing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.basiccalculus.R;
import com.example.basiccalculus.baseDonnes.User;
import com.example.basiccalculus.playing.gameManager;

import java.util.Objects;

public class playSubtraction extends AppCompatActivity {
    Button lvl1, lvl2, lvl3, lvl4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_subtraction);
        initialise();
        clickHandler();
    }
    void initialise(){
        lvl1 = findViewById(R.id.lvl1);
        lvl2 = findViewById(R.id.lvl2);
        lvl2.setEnabled(false);
        lvl3 = findViewById(R.id.lvl3);
        lvl3.setEnabled(false);
        lvl4 = findViewById(R.id.lvl4);
        lvl4.setEnabled(false);
        if(User.level >0)
            lvl2.setEnabled(true);
        if(User.level >1)
            lvl3.setEnabled(true);
        if(User.level >2)
            lvl4.setEnabled(true);
    }
    public void movement(String type){
        Intent i = new Intent(this,gameManager.class);
        if(Objects.equals(type, "lvl1")) {
            i.putExtra("game",70);
        }
        if(Objects.equals(type, "lvl2")) {
            i.putExtra("game",130);
        }
        if(Objects.equals(type, "lvl3")) {
            i.putExtra("game",210);
        }
        if(Objects.equals(type, "lvl4")) {
            i.putExtra("game",320);
        }
        i.putExtra("operation",'-');
        startActivity(i);
        finish();
    }
    public void clickHandler(){
        lvl1.setOnClickListener(view ->{
            movement("lvl1");
        });
        lvl2.setOnClickListener(view ->{
            movement("lvl2");
        });
        lvl3.setOnClickListener(view ->{
            movement("lvl3");
        });
        lvl4.setOnClickListener(view ->{
            movement("lvl4");
        });
    }
}