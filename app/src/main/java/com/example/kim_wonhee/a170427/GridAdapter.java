package com.example.kim_wonhee.a170427;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import static com.example.kim_wonhee.a170427.Fruit.fruitlist;
import static com.example.kim_wonhee.a170427.Fruit.imagelist;

/**
 * Created by kim_wonhee on 2017. 4. 27..
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    ArrayList<Fruit> fruits;

    public GridAdapter(Context context, ArrayList<Fruit> fruits) {
        this.context = context;
        this.fruits = fruits;
    }

    @Override
    public int getCount() {
        return fruits.size();
    }

    @Override
    public Object getItem(int position) {
        return fruits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null)
//            convertView = LayoutInflater.from(context).inflate(R.layout.griditem, null);
//
//        final TextView textView = (TextView) convertView.findViewById(R.id.text);
//        final ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
//
//
//        textView.setText(fruit.get(position).name);
//        imageView.setImageResource(R.drawable.abocado);
//
//        return convertView;

        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.griditem,null);

        Fruit fruit = fruits.get(position);

        final TextView txt_name = (TextView) convertView.findViewById(R.id.text_name);
        final TextView txt_price = (TextView) convertView.findViewById(R.id.text_price);
        final ImageView image = (ImageView) convertView.findViewById(R.id.image);

        txt_name.setText(fruit.getName());
        txt_price.setText(fruit.getPrice());
        image.setImageResource(Fruit.imagelist[fruit.getImage()]);

//        ((GridItem)convertView).setData(imagelist[position], fruitlist[position]);
        return convertView;
    }
}
