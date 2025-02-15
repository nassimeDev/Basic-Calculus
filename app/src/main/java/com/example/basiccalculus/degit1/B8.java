package com.example.basiccalculus.degit1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.basiccalculus.R;

import java.util.Locale;

public class B8 extends AppCompatActivity {
    TextToSpeech t ;
    Button ok ;
    EditText write8;
    ImageView vocal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b8);
        initialise();
        vocal.setOnClickListener(view ->
        {
            t.speak("eight",TextToSpeech.QUEUE_FLUSH,null,null);
        });
        Verification();
    }
    void initialise()
    {
        ok = findViewById(R.id.ok);
        write8 = findViewById(R.id.write8);
        vocal = findViewById(R.id.vocal);
        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = t.setLanguage(Locale.ENGLISH);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                        Toast.makeText(B8.this, "Try again", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(B8.this, "Try again", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    void Verification()
    {
        ok.setOnClickListener(view ->
        {
            if(write8.getText().toString().isEmpty())
                Toast.makeText(this, "Please enter the number!", Toast.LENGTH_SHORT).show();
            else if(Integer.parseInt(String.valueOf(write8.getText())) == 8){
                Toast.makeText(this, "Bravo!", Toast.LENGTH_SHORT).show();
                t.speak(""+ "Bravo",TextToSpeech.QUEUE_FLUSH,null,null);
            }else{
                Toast.makeText(this, "Oops!", Toast.LENGTH_SHORT).show();
                t.speak(""+ "Oops",TextToSpeech.QUEUE_FLUSH,null,null);
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