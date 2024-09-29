package com.example.basiccalculus.jeuPractice;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.basiccalculus.R;
public class Background {
    GameView gv;
    Bitmap b , ground ;
    int x = 0 , y=0;
    public Background(GameView gv, Resources res){
        this.gv = gv;
        b = BitmapFactory.decodeResource(res, R.drawable.back1);
        ground = BitmapFactory.decodeResource(res,R.drawable.sand_mid);
    }
    public void drawBackground(Canvas c){
        c.drawBitmap(b,0,0, null);
        c.drawBitmap(ground,0  , gv.screenY - ground.getHeight() , null);
        c.drawBitmap(ground, ground.getWidth() , gv.screenY - ground.getHeight() , null);
        c.drawBitmap(ground, 2*ground.getWidth() , gv.screenY - ground.getHeight() , null);
        c.drawBitmap(ground, 3*ground.getWidth() , gv.screenY - ground.getHeight() , null);
        c.drawBitmap(ground, 4*ground.getWidth() , gv.screenY - ground.getHeight() , null);
        c.drawBitmap(ground, 5*ground.getWidth() , gv.screenY - ground.getHeight() , null);
    }
}
