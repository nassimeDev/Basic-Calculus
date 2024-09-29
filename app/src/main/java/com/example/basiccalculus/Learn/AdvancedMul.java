package com.example.basiccalculus.Learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.basiccalculus.R;

import java.util.Locale;

public class AdvancedMul extends AppCompatActivity {

    TextToSpeech t;
    ImageView start, first, now, after, space;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_mul);

        initialise();
        start.setOnClickListener(view ->
        {
            t.speak("Let take an example: 246 x 467", TextToSpeech.QUEUE_FLUSH,null,null);
        });
        first.setOnClickListener(view ->
        {
            t.speak("First of all we convert the operation as always to it vertical form:",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        now.setOnClickListener(view ->
        {
            t.speak("now a little bit complicated, as we all know the first roe\n" +
                    "is the result of 7x246, so we right it, then the second row is for 6x246, but what do the ' . ' stands for?",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        after.setOnClickListener(view ->
        {
            t.speak("after we multiply all rows 7x246, 6x246 and 4x246 we add them to each other",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        space.setOnClickListener(view ->
        {
            t.speak("the ' . ' is the space that separate the units from the tens and the hundreds we take it as a 0",TextToSpeech.QUEUE_FLUSH,null,null);
        });
    }
    void initialise(){
        start = findViewById(R.id.start);
        now = findViewById(R.id.now);
        after = findViewById(R.id.after);
        first = findViewById(R.id.first);
        space = findViewById(R.id.space);

        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = t.setLanguage(Locale.ENGLISH);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                        Toast.makeText(AdvancedMul.this, "Try again", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AdvancedMul.this, "Try again", Toast.LENGTH_SHORT).show();
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