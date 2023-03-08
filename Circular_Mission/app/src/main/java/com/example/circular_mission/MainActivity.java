package com.example.circular_mission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Timer timer;
    private Task1 task1;
    private TextView mesg;
    private int counter;
    private UIHandler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mesg = findViewById(R.id.mesg);
        handler = new UIHandler();
    }

    public void test1(View view) {
        Log.d("LinLi", "start: ");
        timer.schedule(new Task1(),3*1000);
    }

    @Override
    protected void onStart() {
        super.onStart();
        timer = new Timer();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(timer != null){
            timer.cancel();
            timer.purge();
            timer = null;
        }
    }

    public void test2(View view) {


        //這邊Task1是區域變數，要在test3用它要去activity宣告
        //timer.schedule(new Task1(),1*1000,3*1000);

        task1 = new Task1();
        timer.schedule(task1,1*1000,1*1000);
        Log.d("LinLi", "test2: ");
    }

    public void test3(View view) {
        if(task1 != null){
            task1.cancel();
            task1 = null;
        }
        Log.d("LinLi", "test3: ");
    }

    public void test4(View view) {
        Intent intent = new Intent(this,Page2Activity.class);
        startActivity(intent);
    }

    private class Task1 extends TimerTask{
        @Override
        public void run() {
            //Log.d("LinLi", "run: ");
            counter++;

//            Message message = new Message();
//            Bundle data = new Bundle();
//            data.putInt("counter",counter);
//            message.setData(data);
//            handler.sendMessage(message);

            handler.sendEmptyMessage(0);

        }
    }

    //之所以需要這個是因為如果沒有這個會出現Only the original thread that created a view hierarchy can touch its views.
    //也就是說，task是獨立於UI在運作的，它不能直接改變UI，而是要透過一個handle的機制
    private  class UIHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 0){
                mesg.setText(""+counter);
            }
//            int dataInt = msg.getData().getInt("counter");
//            mesg.setText(""+dataInt);
        }
    }

}
