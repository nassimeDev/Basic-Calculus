package com.example.basiccalculus.Learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.basiccalculus.R;

import java.util.Locale;

public class SimpleDiv extends AppCompatActivity {

    TextToSpeech t;
    ImageView start, now, compare, first, nowFun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_div);

        initialise();
        start.setOnClickListener(view ->
        {
            t.speak("Let take an example: 234 ÷ 2", TextToSpeech.QUEUE_FLUSH,null,null);
        });
        first.setOnClickListener(view ->
        {
            t.speak("First of all we convert the operation as always to it vertical form:",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        now.setOnClickListener(view ->
        {
            t.speak("now start by comparing digits of the divisor and the divider,\n" +
                    "so how we do it?",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        compare.setOnClickListener(view ->
        {
            t.speak("Compare the final digit of the divisor to the divider,\n" +
                    "if it's greater or equal then we search what number to multiply in the divider in our case 1x2 = 2",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        nowFun.setOnClickListener(view ->
        {
            t.speak("now the fun part, we drop the next digit, which is 3 and we repeat the same principle",TextToSpeech.QUEUE_FLUSH,null,null);
        });
    }

    void initialise(){
        start = findViewById(R.id.start);
        now = findViewById(R.id.now);
        compare = findViewById(R.id.compare);
        first = findViewById(R.id.first);
        nowFun = findViewById(R.id.nowFun);

        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = t.setLanguage(Locale.ENGLISH);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                        Toast.makeText(SimpleDiv.this, "Try again", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SimpleDiv.this, "Try again", Toast.LENGTH_SHORT).show();
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
}