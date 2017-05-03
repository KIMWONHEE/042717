package com.example.kim_wonhee.a170427;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    ArrayList<String> fruit = new ArrayList<String>();
//    int imglist[] = { R.drawable.abocado, R.drawable.banana, R.drawable.cherry,
//            R.drawable.cranberry, R.drawable.grape, R.drawable.kiwi, R.drawable.orange,
//            R.drawable.watermelon};

//    GridAdapter adapter;
//    GridView gridView;
//    Button addFruit;

    ArrayList<String> fruit = new ArrayList<String>();
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    GridAdapter adapter;
    Fruit dataset;

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("What is your favorite fruit?");

        gridView = (GridView) findViewById(R.id.grid);

        fruits.add(new Fruit("수박", "10000", Fruit.imagelist[0]));
        fruits.add(new Fruit("오렌지", "10000", Fruit.imagelist[1]));
        fruits.add(new Fruit("딸기", "10000", Fruit.imagelist[2]));

        adapter = new GridAdapter(MainActivity.this, fruits);

        gridView.setAdapter(adapter);

//        addFruit = (AddFruit) findViewById(R.id.b_add);
//        addFruit.setOnAddListener(new OnAddListener() {
//            @Override
//            public void onAdd(String name, int imageno) {
//
//            }
//        )
//    }
    }

}
