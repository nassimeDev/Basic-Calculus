package com.example.basiccalculus.Learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.basiccalculus.R;

import java.util.Locale;

public class SimpleSub extends AppCompatActivity {
    TextToSpeech t;
    ImageView start, first, thisTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_sub);

        initialise();
        start.setOnClickListener(view ->
        {
            t.speak(" Let take an example: 246 minus 134 = ? ",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        first.setOnClickListener(view ->
        {
            t.speak("First of all we convert the operation as always to it vertical form:",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        thisTime.setOnClickListener(view ->
        {
            t.speak(" this time subtract the numbers that are in the same lines, the first minus the second: means 6 minus 4 = 2",TextToSpeech.QUEUE_FLUSH,null,null);
        });
    }
    void initialise(){
        start = findViewById(R.id.start);
        thisTime = findViewById(R.id.thisTime);
        first = findViewById(R.id.first);

        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = t.setLanguage(Locale.ENGLISH);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                        Toast.makeText(SimpleSub.this, "Try again", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SimpleSub.this, "Try again", Toast.LENGTH_SHORT).show();
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