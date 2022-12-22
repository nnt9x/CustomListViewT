package com.example.customlistviewt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvCountry;
    private List<Country> dataSource;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCountry = findViewById(R.id.lvCountry);
        // Can du lieu
        dataSource = new ArrayList<>();
        dataSource.add(new Country(84,"Vietnam","https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/1200px-Flag_of_Vietnam.svg.png"));
        dataSource.add(new Country(1,"Japan","https://upload.wikimedia.org/wikipedia/en/thumb/9/9e/Flag_of_Japan.svg/1200px-Flag_of_Japan.svg.png"));
        dataSource.add(new Country(2, "USA","https://upload.wikimedia.org/wikipedia/en/a/a4/Flag_of_the_United_States.svg"));

        // Adapter
        myAdapter = new MyAdapter(this, dataSource);

        lvCountry.setAdapter(myAdapter);

        lvCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, dataSource.get(i).getName().toUpperCase(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}