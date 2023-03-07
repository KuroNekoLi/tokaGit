package com.example.recycleantivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRv1;
    List<People> mDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        mRv1 = findViewById(R.id.rv_1);

        mRv1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRv1.setAdapter(new PeopleAdapter());
    }

    private void initData(){
        mDataList = new ArrayList<>();
        mDataList.add(new People("KVR",32));
        mDataList.add(new People("Lin",31));
        mDataList.add(new People("KLD",28));
        mDataList.add(new People("ORZ",40));
        mDataList.add(new People("YUO",15));
        mDataList.add(new People("KVR",32));
        mDataList.add(new People("Lin",31));
        mDataList.add(new People("KLD",28));
        mDataList.add(new People("ORZ",40));
        mDataList.add(new People("YUO",15));
        mDataList.add(new People("KVR",32));
        mDataList.add(new People("Lin",31));
        mDataList.add(new People("KLD",28));
        mDataList.add(new People("ORZ",40));
        mDataList.add(new People("YUO",15));
        mDataList.add(new People("KVR",32));
        mDataList.add(new People("Lin",31));
        mDataList.add(new People("KLD",28));
        mDataList.add(new People("ORZ",40));
        mDataList.add(new People("YUO",15));
        mDataList.add(new People("KVR",32));
        mDataList.add(new People("Lin",31));
        mDataList.add(new People("KLD",28));
        mDataList.add(new People("ORZ",40));
        mDataList.add(new People("YUO",15));
        mDataList.add(new People("KVR",32));
        mDataList.add(new People("Lin",31));
        mDataList.add(new People("KLD",28));
        mDataList.add(new People("ORZ",40));
        mDataList.add(new People("YUO",15));

    }

    class People{
        String name;
        int age;

        public People(String name,int age) {
            this.name = name;
            this.age = age;
        }
    }
    //people創建後參數設好可以alt+insert建立constructor
    class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder>{
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_in_rv,parent,false);
            return new ViewHolder(view);
        }

        @Override
        //畫面出現在上面的
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Log.d("LinLi", "onBindViewHolder: "+position);

            People people = mDataList.get(position);
            holder.textName.setText(people.name);
            holder.textAge.setText(""+people.age);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("LinLi", "onClick: "+people.name);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView textName;
            TextView textAge;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textName = itemView.findViewById(R.id.text_name);
                textAge = itemView.findViewById(R.id.text_age);
            }
        }
    }
}

//Peopleadapter 裡面 Class
// 外面繼承Reclcler view Adapter
//裡面繼承RecycleView view holder
//把尖括號填進去
//alt+enter
//接著生view生data//
//data生完後 getItemCount 改
