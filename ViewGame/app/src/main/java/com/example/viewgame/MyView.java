package com.example.viewgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    private Bitmap ball;
    private Resources resources;
    private boolean isInit;
    private int viewW,viewH;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        resources = context.getResources();
        ball = BitmapFactory.decodeResource(resources,R.drawable.ball);


        Matrix matrix = new Matrix();





    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(isInit) init();
        canvas.drawBitmap(ball,100,100,null);
    }

    private void init() {
        viewW = getWidth();viewH = getHeight();
    }
}
