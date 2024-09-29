package com.example.basiccalculus.degit1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basiccalculus.R;

import java.util.Locale;
import java.util.Random;

public class RandomDigits extends AppCompatActivity {

    TextToSpeech t;
    Button ok;
    TextView show;
    EditText write;
    ImageView vocal;
    Random random;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_digits);
        random = new Random();
        initialise();
        show.setText(""+number);
        write.setHint(""+number);
        vocal.setOnClickListener(view ->
        {
            t.speak(""+ number,TextToSpeech.QUEUE_FLUSH,null,null);
        });
        click();
    }
    void initialise(){
        number = random.nextInt(90)+10 ;
        ok = findViewById(R.id.ok);
        show = findViewById(R.id.show);
        write = findViewById(R.id.write);
        vocal = findViewById(R.id.vocal);
    }
    void click(){
        ok.setOnClickListener(view ->
        {
            if(write.getText().toString().isEmpty())
                Toast.makeText(this, "Please enter the number!", Toast.LENGTH_SHORT).show();
            else if(Integer.parseInt(String.valueOf(write.getText())) == number){
                Toast.makeText(this, "Bravo!", Toast.LENGTH_SHORT).show();
                t.speak(""+ "Bravo",TextToSpeech.QUEUE_FLUSH,null,null);
            }else{
                Toast.makeText(this, "Oops!", Toast.LENGTH_SHORT).show();
                t.speak(""+ "Oops",TextToSpeech.QUEUE_FLUSH,null,null);
            }

        });
        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = t.setLanguage(Locale.ENGLISH);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                        Toast.makeText(RandomDigits.this, "Try again", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RandomDigits.this, "Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}