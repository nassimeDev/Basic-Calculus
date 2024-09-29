package com.example.basiccalculus.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.Toast;

import com.example.basiccalculus.R;
import com.example.basiccalculus.baseDonnes.User;
import com.example.basiccalculus.degit1.B0;

import java.util.Locale;

public class w extends AppCompatActivity {
    Button basics, practice, learn, userLev, username;
    TextToSpeech t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w);
        initialise();
        t.speak("Hello"+User.username+",welcome to basic calculus",TextToSpeech.QUEUE_FLUSH,null,null);
        userLev.setText("Level "+User.level);
        username.setText("User "+User.username);
        clickHandler();

    }
    void initialise()
    {
        basics = findViewById(R.id.basics);
        practice = findViewById(R.id.Practice);
        learn = findViewById(R.id.Learn);
        userLev = findViewById(R.id.lev);
        userLev.setEnabled(false);
        username = findViewById(R.id.user);
        username.setEnabled(false);

        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = t.setLanguage(Locale.ENGLISH);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                        Toast.makeText(w.this, "Try again", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(w.this, "Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void movement(String type){
        Intent i = null;
        if(type == "basics") {
            i = new Intent(this, Basics.class);
        }
        if(type == "practice") {
            i = new Intent(w.this, Practice.class);
        }
        if(type == "learn") {
            i = new Intent(w.this, Learn.class);
        }
        startActivity(i);
    }
    void clickHandler()
    {
        basics.setOnClickListener(view ->
        {
            movement("basics");
        });
        practice.setOnClickListener(view ->
        {
            movement("practice");
        });
        learn.setOnClickListener(view ->
        {
            movement("learn");
        });
    }

    @Override
    protected void onDestroy() {
        if (t != null) {
            t.stop();
            t.shutdown();
        }
        super.onDestroy();
    }
}