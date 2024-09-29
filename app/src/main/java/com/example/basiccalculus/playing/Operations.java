package com.example.basiccalculus.playing;

import android.graphics.Canvas;

import com.example.basiccalculus.jeuPractice.GameView;

public class Operations {

    GameView gv;
    public Operations(GameView gv){
        this.gv = gv;
    }
    public void drawOp(Canvas c){
        c.drawText("Op:"+gv.operation,gv.screenX-200,205,gv.textPaint);
        if(gv.operation == '+'){
            c.drawText(gv.number+"/"+gv.points,20,90,gv.textPaint);
        }else if(gv.operation == '-'){
            c.drawText(gv.number+"-20/"+gv.points,20,90,gv.textPaint);
        }else if(gv.operation == 'x'){
            c.drawText(gv.number+"x2/"+gv.points,20,90,gv.textPaint);
        }else if(gv.operation == '/'){
            c.drawText(gv.number+"÷2/"+gv.points,20,90,gv.textPaint);
        }
    }
}
