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

import org.w3c.dom.Text;

import java.util.ArrayList;
/**
 * Created by kim_wonhee on 2017. 4. 27..
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    ArrayList<Fruit> fruits;

    int VISIBLE = 0;

    TextView txt_name, txt_price;
    ImageView image;

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
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.griditem,null);

        Fruit fruit = fruits.get(position);

        txt_name = (TextView) convertView.findViewById(R.id.text_name);
        txt_price = (TextView) convertView.findViewById(R.id.text_price);
        image = (ImageView) convertView.findViewById(R.id.image);

        txt_name.setText(fruit.getName());
        txt_price.setText(fruit.getPrice()+"원");
        image.setImageResource(Fruit.imagelist[fruit.getImage()]);

        // setChecked
        if (VISIBLE == 0)
            txt_price.setVisibility(View.INVISIBLE);
        else
            txt_price.setVisibility(View.VISIBLE);

        return convertView;
    }

    public void setChecked(Boolean ischecked) {
        if (ischecked)
            VISIBLE = 1;
        else
            VISIBLE = 0;
        this.notifyDataSetChanged();
    }

}
