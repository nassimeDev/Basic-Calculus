package com.example.basiccalculus.jeuPractice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.basiccalculus.playing.Operations;

import java.util.*;
public class GameView extends SurfaceView  implements Runnable{
    SurfaceHolder holder;
    public boolean isAwake = false;
    Thread thread= null, countDown ;
    public int screenX, screenY, points, life=3, number;
    Background background ;
    Player p ;
    Context context;
    float x,y ;
    public Paint textPaint, health ;
    public ArrayList<Numbers> numbers = new ArrayList<>() ;
    public char operation;
    public Operations op;
    ///////////////////////////////////////////////////////////
    public GameView(Context context,int x, int y,int n,char operation){
        super(context);
        this.context = context;
        screenX = x;
        screenY = y;
        this.number = n;
        this.operation = operation;
        holder = getHolder();
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(80);
        health = new Paint();
        health.setColor(Color.GREEN);
        health.setTextSize(70);
        background = new Background(this,getResources());
        p = new Player(this,getResources(),background);
        op = new Operations(this);

        numbers.add(new Numbers(this,getResources(),10)) ;
        numbers.add(new Numbers(this,getResources(),20)) ;
        numbers.add(new Numbers(this,getResources(),30)) ;
        numbers.add(new Numbers(this,getResources(),40)) ;
        numbers.add(new Numbers(this,getResources(),50)) ;
        numbers.add(new Numbers(this,getResources(),90)) ;

    }
    public void stopCounting(String s){
        Intent i1 = new Intent(context, Congratulation.class);
        i1.putExtra("situation",s);
        context.startActivity(i1);
        ((Activity) context).finish();
    }
    ////////////////////////////////////////////////////////////////////
    @Override
    public void run() {
        while (isAwake){
            if(!holder.getSurface().isValid()){
                continue;
            }
            update();
            draw();
        }
    }
   public void update(){
        p.updatePlayer(x+30,y+30);
        for(int i=0;i<6;i++){
            numbers.get(i).updateNumber();
        }
   }
    public void draw(){
        Canvas c = holder.lockCanvas();
        background.drawBackground(c);
        for(int i=0;i<6;i++){
            numbers.get(i).drawNumber(c);
        }
        p.drawPlayer(c);
        c.drawText("Life",screenX-200,60,health);
        c.drawRect(screenX-200,130,screenX-200+ 60*life,80,health);
        op.drawOp(c);
        holder.unlockCanvasAndPost(c);
    }
    ////////////////////////////////////////////////////////////////////////////////////
    public void pause() {
        isAwake = false;
        while(true){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            break;
        }
        thread = null;
    }
    public void resume(){
        isAwake = true ;
        thread = new Thread(this);
        thread.start();
        countDown = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<30;i++){
                    sleep(500);
                    if(operation == '+'){
                        if(points == number){ stopCounting("Congratulations"); break; }
                    }else  if(operation == '-'){
                        if(points == number-20){ stopCounting("Congratulations"); break; }
                    }else  if(operation == 'x'){
                        if(points == number*2){ stopCounting("Congratulations"); break; }
                    }else  if(operation == '/'){
                        if(points == number/2){ stopCounting("Congratulations"); break; }
                    }
                    if(i == 9){ life = 2; health.setColor(Color.YELLOW); }
                    else if(i == 19){ life = 1; health.setColor(Color.RED); }
                    else if(i == 29){ life = 0; stopCounting("Game Over"); break; }
                }
            }
        });
        countDown.start();
    }
     public void sleep(int n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    ////////////////////////////////////////////////////////////////////
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            if(touchY > 0
               && touchY < (screenY - background.ground.getHeight() - p.player.getHeight())
               && touchX > 0
               && touchX < screenX - p.player.getWidth()
            ){
                x = touchX;
                y = touchY;
            }
        }
        return true;
    }
}
