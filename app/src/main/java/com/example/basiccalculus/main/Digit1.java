package com.example.basiccalculus.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.Toast;

import com.example.basiccalculus.R;
import com.example.basiccalculus.degit1.B0;
import com.example.basiccalculus.degit1.B1;
import com.example.basiccalculus.degit1.B2;
import com.example.basiccalculus.degit1.B3;
import com.example.basiccalculus.degit1.B4;
import com.example.basiccalculus.degit1.B5;
import com.example.basiccalculus.degit1.B6;
import com.example.basiccalculus.degit1.B7;
import com.example.basiccalculus.degit1.B8;
import com.example.basiccalculus.degit1.B9;

import java.util.Locale;

public class Digit1 extends AppCompatActivity {

    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int number;
    TextToSpeech t ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digit1);
        initialise();
        click_b();
    }
    void initialise()
    {
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = t.setLanguage(Locale.ENGLISH);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                        Toast.makeText(Digit1.this, "Try again", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Digit1.this, "Try again", Toast.LENGTH_SHORT).show();
                }
            }
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
    void click_b()
    {
        b0.setOnClickListener(view ->{
            t.speak(""+0 ,TextToSpeech.QUEUE_FLUSH,null,null);
            Intent i = new Intent(this, B0.class);
            startActivity(i);
        });
        b1.setOnClickListener(view ->{
            t.speak(""+1 ,TextToSpeech.QUEUE_FLUSH,null,null);
            Intent i = new Intent(this, B1.class);
            startActivity(i);
        });
        b2.setOnClickListener(view ->{
            t.speak(""+2,TextToSpeech.QUEUE_FLUSH,null,null);
            Intent i = new Intent(this, B2.class);
            startActivity(i);
        });
        b3.setOnClickListener(view ->{
            t.speak(""+3 ,TextToSpeech.QUEUE_FLUSH,null,null);
            Intent i = new Intent(this, B3.class);
            startActivity(i);
        });
        b4.setOnClickListener(view ->{
            t.speak(""+4 ,TextToSpeech.QUEUE_FLUSH,null,null);
            Intent i = new Intent(this, B4.class);
            startActivity(i);
        });
        b5.setOnClickListener(view ->{
            t.speak(""+5,TextToSpeech.QUEUE_FLUSH,null,null);
            Intent i = new Intent(this, B5.class);
            startActivity(i);
        });
        b6.setOnClickListener(view ->{
            t.speak(""+6 ,TextToSpeech.QUEUE_FLUSH,null,null);
            Intent i = new Intent(this, B6.class);
            startActivity(i);
        });
        b7.setOnClickListener(view ->{
            t.speak(""+7 ,TextToSpeech.QUEUE_FLUSH,null,null);
            Intent i = new Intent(this, B7.class);
            startActivity(i);
        });
        b8.setOnClickListener(view ->{
            t.speak(""+8 ,TextToSpeech.QUEUE_FLUSH,null,null);
            Intent i = new Intent(this, B8.class);
            startActivity(i);
        });
        b9.setOnClickListener(view ->{
            t.speak(""+9 ,TextToSpeech.QUEUE_FLUSH,null,null);
            Intent i = new Intent(this, B9.class);
            startActivity(i);
        });
    }
}