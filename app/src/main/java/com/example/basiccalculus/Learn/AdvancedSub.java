package com.example.basiccalculus.Learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.basiccalculus.R;

import java.util.Locale;

public class AdvancedSub extends AppCompatActivity {

    TextToSpeech t;
    ImageView start, now, solution, first;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_sub);

        initialise();
        initialise();
        start.setOnClickListener(view ->
        {
            t.speak(" Let take an example: 478 minus 399 = ? ",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        first.setOnClickListener(view ->
        {
            t.speak("First of all we convert the operation as always to it vertical form:",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        now.setOnClickListener(view ->
        {
            t.speak(" Now as we see 8 is smaller than 9, so what can ce do in this case?",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        solution.setOnClickListener(view ->
        {
            t.speak("Solution: we take a 10 from the next number in the next column and we add it to our current one means 8-9 become 18-9, after that we return that 10 as a 1 to second row on 9",TextToSpeech.QUEUE_FLUSH,null,null);
        });
    }
    void initialise(){
        start = findViewById(R.id.start);
        now = findViewById(R.id.now);
        solution = findViewById(R.id.solution);
        first = findViewById(R.id.first);

        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = t.setLanguage(Locale.ENGLISH);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                        Toast.makeText(AdvancedSub.this, "Try again", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AdvancedSub.this, "Try again", Toast.LENGTH_SHORT).show();
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