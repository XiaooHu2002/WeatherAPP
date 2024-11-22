package com.qianyios.weather1.Activitis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qianyios.weather1.Adapters.TommorowAdapter;
import com.qianyios.weather1.Domains.TommorowDomain;
import com.qianyios.weather1.R;

import java.util.ArrayList;

public class TommorowActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTommorow;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tommorow);
        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backBtn=findViewById(R.id.back_btn);
        backBtn.setOnClickListener(v -> startActivity(new Intent(TommorowActivity.this,MainActivity.class)));

    }

    private void initRecyclerView() {
        ArrayList<TommorowDomain>  items = new ArrayList<>();
        items.add(new TommorowDomain("Sat","storm","Storm",25,10));
        items.add(new TommorowDomain("Sun","cloudy","Rainy_sunny",24,16));
        items.add(new TommorowDomain("Mon","cloudy_3","Cloudy",29,15));
        items.add(new TommorowDomain("Tue","cloudy_sunny","Cloudy-Sunny",22,13));
        items.add(new TommorowDomain("Wen","sun","Sunny",28,11));
        items.add(new TommorowDomain("Thu","rainy","Rainy",23,12));


        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterTommorow=new TommorowAdapter(items);
        recyclerView.setAdapter(adapterTommorow);

    }

}
