package com.example.basiccalculus.playing;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;

import com.example.basiccalculus.jeuPractice.GameView;

public class gameManager extends AppCompatActivity {
    GameView g;
    Point size;
    int number;
    char operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        number = getIntent().getExtras().getInt("game");
        operation = getIntent().getExtras().getChar("operation");
        g = new GameView(gameManager.this, size.x, size.y,number,operation);
        setContentView(g);
    }
    @Override
    protected void onPause() {
        super.onPause();
        g.pause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        g.resume();
    }
}