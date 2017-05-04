package com.example.kim_wonhee.a170427;

import android.content.Context;
import android.support.annotation.InterpolatorRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.Menu;


public class CustomWidget extends LinearLayout implements View.OnClickListener {

    AutoCompleteTextView et_name;
    EditText et_price;
    ImageView image;
    Button b_add, b_next;
    int imageno;

    public CustomWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fruitadd, this);

        et_name = (AutoCompleteTextView) findViewById(R.id.f_name);
        et_price = (EditText) findViewById(R.id.f_price);
        image = (ImageView) findViewById(R.id.image1);
        b_next = (Button) findViewById(R.id.b_next);
        b_add = (Button) findViewById(R.id.b_add);
        b_next.setOnClickListener(this);
        b_add.setOnClickListener(this);
    }

    public void setWidget(String name, String price, int img) {
        et_name.setText(name);
        et_price.setText(price);
        imageno = img;
        image.setImageResource(Fruit.imagelist[imageno]);
    }

    @Override
    public void onClick(View v) {
        if (v == b_add) {
            if (b_add.getText() == "add") {
                onAddListener.onAdd(et_name.getText().toString(), et_price.getText().toString(), imageno);
                et_name.setText(null);
                et_price.setText(null);
            } else if (b_add.getText() == "M") {
                onModifyListener.onModify(et_name.getText().toString(), et_price.getText().toString(), imageno);
                b_add.setText("add");
                et_name.setText(null);
                et_price.setText(null);
            }

        } else if (v == b_next) {
            imageno++;
            if (imageno > 7) {
                imageno = 0;
            }
            image.setImageResource(Fruit.imagelist[imageno]);
        }


    }

    interface OnAddListener {
        void onAdd(String name, String price, int imageno);
    }

    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener) {
        this.onAddListener = onAddListener;
    }

    interface OnModifyListener {
        void onModify(String name, String price, int imageno);
    }

    public OnModifyListener onModifyListener;

    public void setOnModifyListener(OnModifyListener onModifyListener) {
        this.onModifyListener = onModifyListener;
    }

    public void setSelected(Fruit one) {
        et_name.setText(one.getName());
        et_price.setText(one.getPrice());
        image.setImageResource(Fruit.imagelist[one.getImage()]);
        imageno = one.getImage();
        b_add.setText("M");
    }


}
