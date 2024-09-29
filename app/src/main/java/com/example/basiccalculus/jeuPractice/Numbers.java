package com.example.basiccalculus.jeuPractice;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basiccalculus.R;

import java.util.* ;
public class Numbers {
    Random random;
    float numberX, numberY, numberSpeed ;
    GameView gv;
    int size = 120, n;
    Bitmap img;
    Resources res;
    TextToSpeech t;
    public Numbers(GameView gv, Resources res,int n){
        this.gv = gv;
        random = new Random();
        resetPos();
        this.res = res;
        this.n = n;
        initialise(n);
    }
    public void drawNumber(Canvas c){
        c.drawBitmap(img,numberX,numberY,null);
        if(     numberX + size >= gv.p.playerX
                && numberX  <= gv.p.playerX + gv.p.player.getWidth()
                && numberY + size >= gv.p.playerY
                && numberY + size <= gv.p.playerY + gv.p.player.getHeight()
        ){
            gv.points += n;
            resetPos();
        }
    }
    public void updateNumber(){
        if(numberY < gv.screenY - gv.background.ground.getHeight())
            numberY += numberSpeed;
        else
            resetPos();
    }
    public void resetPos(){
        numberX = random.nextInt(gv.screenX - 120);
        numberY = -200 + random.nextInt(600)*(-5);
        numberSpeed = 4 + random.nextInt(10) ;
    }
    void initialise(int n){
        if(n == 10){
            img = BitmapFactory.decodeResource(res, R.drawable.n10);
            img = Bitmap.createScaledBitmap(img,img.getWidth()-870,img.getHeight()-870,false);
        }else if(n == 20){
            img = BitmapFactory.decodeResource(res, R.drawable.n20);
            img = Bitmap.createScaledBitmap(img,img.getWidth()-870,img.getHeight()-870,false);
        }else if(n == 30){
            img = BitmapFactory.decodeResource(res, R.drawable.n30);
            img = Bitmap.createScaledBitmap(img,img.getWidth()-870,img.getHeight()-870,false);
        }else if(n == 40){
            img = BitmapFactory.decodeResource(res, R.drawable.n40);
            img = Bitmap.createScaledBitmap(img,img.getWidth()-870,img.getHeight()-870,false);
        }else if(n == 50){
            img = BitmapFactory.decodeResource(res, R.drawable.n50);
            img = Bitmap.createScaledBitmap(img,img.getWidth()-870,img.getHeight()-870,false);
        }else if(n == 90){
            img = BitmapFactory.decodeResource(res, R.drawable.n90);
            img = Bitmap.createScaledBitmap(img,img.getWidth()-870,img.getHeight()-870,false);
        }
    }

}
