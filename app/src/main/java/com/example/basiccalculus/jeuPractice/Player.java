package com.example.basiccalculus.jeuPractice;

import android.content.res.Resources;
import android.graphics.*;

import com.example.basiccalculus.R;
import com.example.basiccalculus.jeuPractice.Background;
import com.example.basiccalculus.jeuPractice.GameView;
public class Player  {
    float playerX, playerY = 300;
    Bitmap player ;
    GameView gv;
    Background background;
    public Player(GameView gv, Resources res, Background background){
        this.gv = gv;
        this.background = background;
        player = BitmapFactory.decodeResource(res, R.drawable.miaouss);
        player = Bitmap.createScaledBitmap(player,player.getWidth() - 820,player.getHeight() - 820,false);
    }
    public void drawPlayer(Canvas c){
        c.drawBitmap(player,playerX,playerY,null);
    }
    public void updatePlayer(float x, float y){
        this.playerX = x;
        this.playerY = y;
    }


}
