package com.example.basiccalculus.jeuPractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.basiccalculus.R;
import com.example.basiccalculus.baseDonnes.DbHandler;
import com.example.basiccalculus.baseDonnes.User;
import com.example.basiccalculus.playing.playAddition;

public class Congratulation extends AppCompatActivity {
    DbHandler db = new DbHandler(this);
    ImageButton exit, restart;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);
        exit =  findViewById(R.id.exit);
        restart = findViewById(R.id.restart);
        text = findViewById(R.id.textS);
        String sit = getIntent().getExtras().getString("situation");
        if(sit.equals("Congratulations") && User.level<4){
            db.setLevel(User.username,User.password);
            User.level++;
        }
        text.setText(sit);
        exit.setOnClickListener(view ->
        {
            this.finishAffinity();
        });
        restart.setOnClickListener(view ->
        {
            startActivity(new Intent(this, playAddition.class));
            finish();
        });
    }
}