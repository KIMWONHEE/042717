package com.example.kim_wonhee.a170427;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomWidget extends LinearLayout implements View.OnClickListener {

    EditText et_name, et_price;
    ImageView image;
    Button b_add, b_next;
    int imgno = 0;

    public CustomWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fruitadd, this);

        et_name = (EditText) findViewById(R.id.f_name);
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
        imgno = img;
        image.setImageResource(Fruit.imagelist[imgno]);
    }

    @Override
    public void onClick(View v) {
        if (v == b_add) {
            onAddListener.onAdd(et_name.getText().toString(), et_price.getText().toString(), imgno);
            et_name.setText(null);
            et_price.setText(null);
        } else if (v == b_next) {
            imgno++;
            if (imgno > 7)
                imgno = 0;
            image.setImageResource(Fruit.imagelist[imgno]);
        }


    }

    interface OnAddListener {
        void onAdd(String name, String price, int imageno);
    }

    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener) {
        this.onAddListener = onAddListener;
    }



}
