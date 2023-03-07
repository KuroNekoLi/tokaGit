package com.example.lesson0303;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Page2Activity extends AppCompatActivity {

    TextView mTextView;
    public final static String PARAM_NAME= "PARAM_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        //Log.d("LinL2", "onCreate: ");
        mTextView = findViewById(R.id.textview);
        mTextView.setText(getString(R.string.text_defalt_name,"王小明"));}

//        Intent intent = getIntent();
//        if (intent != null){
//            String extraName = intent.getStringExtra(PARAM_NAME);
//            //Log.d("LinLi2", "1 ");
//            mTextView.setText("extraName = " +extraName);
//            //Log.d("LinL2", "onCreate: extraname"+extraName);
//            int length = extraName.length();//字串長度 //alt+enter補完 int length
//            String result = extraName + ", length ="+length;
//            //Log.d("LinLi2", "2");
//            //hwelkg //按下f2可以跳到錯的地方
//            //ctrl+alt+l 符合coding style
//
//            mTextView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent resultIntent = new Intent();
//                    resultIntent.putExtra("result",result); //將商品寄到地址
//                    setResult(Activity.RESULT_OK,resultIntent); //寄給買家地址(以此例來說就是把商品丟到-1)
//                    finish();
//                }
//            });

        }

//    protected void onStart() {
//        super.onStart();
//        Log.d("LinLi2", "onStart: ");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d("LinLi2", "onResume: ");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d("LinLi2", "onPause: ");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d("LinLi2", "onStop: ");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("LinLi2", "onDestroy: ");
//    }

//ctrl+shift+ -縮 展 function