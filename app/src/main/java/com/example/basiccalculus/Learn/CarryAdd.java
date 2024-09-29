package com.example.basiccalculus.Learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.basiccalculus.R;

import java.util.Locale;

public class CarryAdd extends AppCompatActivity {
    TextToSpeech t;
    ImageView start, now, solution, first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carry);

        initialise();
        start.setOnClickListener(view ->
        {
            t.speak("Let take an example: 246 + 999",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        first.setOnClickListener(view ->
        {
            t.speak("First of all we convert the operation as always to it vertical form:",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        now.setOnClickListener(view ->
        {
            t.speak("Now we repeat the same principle we learnt in 'with no carry' 6+8 = 15 The difference now we have two digits, " +
                    "and we can not write them both, so what do we do?",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        solution.setOnClickListener(view ->
        {
            t.speak("the solution is we write the first digit and we carry\n" +
                    "with as the second one: means write 5 and carry 1",TextToSpeech.QUEUE_FLUSH,null,null);
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
                        Toast.makeText(CarryAdd.this, "Try again", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CarryAdd.this, "Try again", Toast.LENGTH_SHORT).show();
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