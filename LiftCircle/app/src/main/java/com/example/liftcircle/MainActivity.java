package com.example.liftcircle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View button,button2,button3;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        Log.d("LinLi", "onCreate: ");

        button = findViewById(R.id.btn);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        input = findViewById(R.id.input);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Page2.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = input.getText().toString();
                Intent intent = new Intent(MainActivity.this,Page2.class);
                intent.putExtra("name",name);
                startActivity(intent);
                //可以到page2使用getIntent
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        //Toast.makeText(this, "Again?", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LinLi", "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LinLi", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LinLi", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LinLi", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LinLi", "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LinLi", "onRestart: ");
    }
}