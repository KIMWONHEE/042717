package com.example.kim_wonhee.a170427;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> fruit = new ArrayList<String>();
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    ArrayList<Fruit> cart = new ArrayList<Fruit>();
    ArrayList<String> name = new ArrayList<String>();

    ArrayAdapter<String> name_adapter;
    Fruit dataset;

    GridView gridView;
    GridAdapter adapter;
    CustomWidget bottom_widget;
    Custom2Widget top_widget;

    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("What is your favorite fruit?");

        name.add("abocado");
        name.add("banana");
        name.add("cherry");
        name.add("cranberry");
        name.add("grape");
        name.add("kiwi");
        name.add("orange");
        name.add("watermelon");

        gridView = (GridView) findViewById(R.id.grid);
        bottom_widget = (CustomWidget) findViewById(R.id.custom);
        top_widget = (Custom2Widget) findViewById(R.id.custom2);

        fruits.add(new Fruit("banana", "2000", 1));
        fruits.add(new Fruit("cranberry", "4000", 3));
        fruits.add(new Fruit("grape", "5000", 4));
        fruits.add(new Fruit("orange", "7000", 6));
        fruits.add(new Fruit("watermelon", "8000", 7));

        // 자동완성 텍스트 뷰
        for (int i = 0; i < fruits.size(); i++)
            fruit.add(fruits.get(i).getName());

        bottom_widget.et_name.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, name));

        adapter = new GridAdapter(MainActivity.this, fruits);
        gridView.setAdapter(adapter);

        //GridView 클릭 시
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit one = fruits.get(position);
                bottom_widget.setSelected(one);
                pos = position;
                cart.add(new Fruit(one.getName(), one.getPrice(), one.getImage()));
                Toast.makeText(getApplicationContext(), one.getName() + "가 카트에 담겼습니다", Toast.LENGTH_SHORT).show();
            }
        });

        top_widget.setOnCheckListener(new Custom2Widget.OnCheckListener() {
            @Override
            public void onChecked(Boolean ischecked) {
                adapter.setChecked(ischecked);
            }
        });

        top_widget.setOnButtonListener(new Custom2Widget.OnButtonListener() {
            @Override
            public void onToast() {
                String cartmsg = "";
                for (int i = 0; i < cart.size(); i++)
                    cartmsg += cart.get(i).getName()+", ";
                Toast.makeText(getApplicationContext(), "카트에 " + cartmsg + "가 담겨있습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        bottom_widget.setOnAddListener(new CustomWidget.OnAddListener() {
            @Override
            public void onAdd(String name, String price, int imageno) {
                fruits.add(new Fruit(name, price, imageno));
                Toast.makeText(MainActivity.this, "추가되었습니다. ", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }
        });

        bottom_widget.setOnModifyListener(new CustomWidget.OnModifyListener() {
            @Override
            public void onModify(String name, String price, int imageno) {
                fruits.get(pos).setName(name);
                fruits.get(pos).setPrice(price);
                fruits.get(pos).setImage(imageno);
                Toast.makeText(getApplicationContext(), "수정되었습니다.", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }
        });

    }

}
