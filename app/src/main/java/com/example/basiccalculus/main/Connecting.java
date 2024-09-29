package com.example.basiccalculus.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basiccalculus.R;

import com.example.basiccalculus.baseDonnes.DbHandler;
import com.example.basiccalculus.baseDonnes.User;
import com.example.basiccalculus.degit1.B0;

import java.util.Locale;

public class Connecting extends AppCompatActivity {
    DbHandler dbHandler = new DbHandler(Connecting.this);
    EditText username, password;
    Button connect ;
    User user;
    TextToSpeech t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        initialise();
        connect();

    }
    void initialise()
    {
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);
        connect = findViewById(R.id.connect);
        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = t.setLanguage(Locale.ENGLISH);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                        Toast.makeText(Connecting.this, "Try again", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Connecting.this, "Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void connect()
    {
        connect.setOnClickListener(view -> {
            String u = username.getText().toString();
            String p = password.getText().toString();

            if(u.isEmpty() || p.isEmpty()){
                Toast.makeText(this, "please enter all the information ", Toast.LENGTH_SHORT).show();
            } else {
                if (!dbHandler.existUsername(u)) {
                    if(dbHandler.AddUser(u,p,0)){
                        Intent i = new Intent(Connecting.this, w.class);
                        t.speak("Hello"+u+",welcome to basic calculus",TextToSpeech.QUEUE_FLUSH,null,null);
                        startActivity(i);
                        Toast.makeText(this, u+" has been Add", Toast.LENGTH_SHORT).show();
                        user = new User(u,p,0);
                    }else {
                        Toast.makeText(this, u+" Something went wrong, retry please!!", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    if (dbHandler.existPassword(p)){
                        Intent i = new Intent(Connecting.this,w.class);
                        t.speak("Hello"+u+",welcome back",TextToSpeech.QUEUE_FLUSH,null,null);
                        startActivity(i);
                        Toast.makeText(this, u+" Connected, with level = "+dbHandler.getLevel(u), Toast.LENGTH_SHORT).show();
                        user = new User(u,p,dbHandler.getLevel(u));
                    }else{
                        Toast.makeText(this, u+"is already exist", Toast.LENGTH_SHORT).show();
                    }
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