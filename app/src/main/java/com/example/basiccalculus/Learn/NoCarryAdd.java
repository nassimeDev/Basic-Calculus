package com.example.basiccalculus.Learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.basiccalculus.R;
import com.example.basiccalculus.degit1.B0;

import java.util.Locale;

public class NoCarryAdd extends AppCompatActivity {

    TextToSpeech t;
    ImageView start, afterSetting, weAdd, first;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_carry);

        initialise();
        start.setOnClickListener(view ->
        {
            t.speak("Let take an example: 246 + 642 = ?",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        first.setOnClickListener(view ->
        {
            t.speak("First of all we convert the operation as always to a vertical form",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        weAdd.setOnClickListener(view ->
        {
            t.speak("We add numbers that are in the same line: 6+2 = 8",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        afterSetting.setOnClickListener(view ->
        {
            t.speak("After setting our operation, we start",TextToSpeech.QUEUE_FLUSH,null,null);
        });
    }
    void initialise(){
        start = findViewById(R.id.start);
        afterSetting = findViewById(R.id.afterSetting);
        weAdd = findViewById(R.id.weAdd);
        first = findViewById(R.id.first);

        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = t.setLanguage(Locale.ENGLISH);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                        Toast.makeText(NoCarryAdd.this, "Try again", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(NoCarryAdd.this, "Try again", Toast.LENGTH_SHORT).show();
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