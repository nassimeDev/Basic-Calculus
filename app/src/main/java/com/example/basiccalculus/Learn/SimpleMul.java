package com.example.basiccalculus.Learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.basiccalculus.R;

import java.util.Locale;

public class SimpleMul extends AppCompatActivity {

    TextToSpeech t;
    ImageView start, first, repeat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_mul);

        initialise();
        start.setOnClickListener(view ->
        {
            t.speak("Let take an example: 234 x 2 ", TextToSpeech.QUEUE_FLUSH,null,null);
        });
        first.setOnClickListener(view ->
        {
            t.speak("First of all we convert the operation as always to it vertical form:",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        repeat.setOnClickListener(view ->
        {
            t.speak("we repeat the same principles we learnt, just in this case\n" +
                    "we multiply our numbers to the whole row, 2x4, 2x3 and 2x2",TextToSpeech.QUEUE_FLUSH,null,null);
        });
    }
    void initialise(){
        start = findViewById(R.id.start);
        first = findViewById(R.id.first);
        repeat = findViewById(R.id.repeat);

        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = t.setLanguage(Locale.ENGLISH);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                        Toast.makeText(SimpleMul.this, "Try again", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SimpleMul.this, "Try again", Toast.LENGTH_SHORT).show();
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