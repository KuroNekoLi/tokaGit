package com.example.self_determine_view;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.LinkedList;

public class MyView extends View {
    //private LinkedList<HashMap<String,Float>> line; //線的資料結構
    private LinkedList<LinkedList<HashMap<String,Float>>> lines;
    private Paint paint;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setBackgroundColor(Color.GREEN);

        lines = new LinkedList<>();
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(4);
//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("LinLi", "onClick: ");
//            }
//        });
    }

    @Override
    //事件發生即觸發
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(LinkedList<HashMap<String,Float>> line : lines){
            for(int i=1;i<line.size();i++){
                HashMap<String,Float> p0 = line.get(i-1);
                HashMap<String,Float> p1 = line.get(i);
                //接著要宣告畫筆
                canvas.drawLine(p0.get("x"),p0.get("y"),p1.get("x"),p1.get("y"),paint);
            }

        }

    }

    public void clear(){
        lines.clear();
        invalidate();
    }

    public void undo(){
        if(lines.size()>0){
            lines.removeLast();
            invalidate();
        }
    }
    //事件發生即觸發
    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        float ex = event.getX(),ey = event.getY();
//        Log.d("LinLi", "x= "+ex+"; y="+ey);

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Log.d("LinLi", "onTouchEvent: down");
            setFirstPoint(event);
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            Log.d("LinLi", "onTouchEvent: up");

        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            Log.d("LinLi", "onTouchEvent: move");
            setMovePoint(event);
        }

        //super.onTouchEvent(event);
        return true; //如果這邊是false那onclick不會觸發(因為click是1個up&down)
    }

    private void setFirstPoint(MotionEvent event) {
        LinkedList<HashMap<String,Float>> line = new LinkedList<>();

        float ex = event.getX(),ey = event.getY();
        HashMap<String,Float> point = new HashMap<>();
        point.put("x",ex);point.put("y",ey);
        line.add(point);

        lines.add(line);
    }

    private void setMovePoint(MotionEvent event) {
        float ex = event.getX(),ey = event.getY();
        HashMap<String,Float> point = new HashMap<>();
        point.put("x",ex);point.put("y",ey);
        lines.getLast().add(point);

        invalidate(); //繪製
    }
}

