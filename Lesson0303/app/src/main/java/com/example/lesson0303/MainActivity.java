package com.example.lesson0303;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView mTextview;
    EditText mEdittext;
    Button mButton;
    static final int REQUEST_CODE = 123;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("LinLi", "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextview = findViewById(R.id.test);
        mEdittext = findViewById(R.id.edit);
        mButton = findViewById(R.id.button);
        //R.color.black;
        //R.string.text_defalt_name
        
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Page2Activity.class);
                intent.putExtra(Page2Activity.PARAM_NAME,mEdittext.getText().toString());

                //Bundle bundle = new Bundle(); 可以拿很多

                //startActivity(intent); //按下跑到第二頁
                //finish();
                startActivityForResult(intent,REQUEST_CODE);
                //下單寄到REQUEST_CODE地址
            }
        });

        mEdittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            
            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("LinLi", "afterTextChanged: "+editable);
                if(editable.length()<3){
                    mButton.setEnabled(false);
                }
                else{
                    mButton.setEnabled(true);
                }
            }
        });
    }

    @Override
    //從startActivityForResult
    //onActivityResult 就是收貨開箱
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("LinLi", "onActivityResult: requestCode=" + requestCode + "resultCode" + resultCode);

        switch (requestCode) {
            case REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    String result = data.getStringExtra("result");
                    Log.d("LinLi", "onActivityResult: result = "+result);
                } else if (resultCode == Activity.RESULT_CANCELED) {

                }
                break;

        }
    }
}

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("LinLi", "onStart: ");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d("LinLi", "onResume: ");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d("LinLi", "onPause: ");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d("LinLi", "onStop: ");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("LinLi", "onDestroy: ");
//    }