package com.example.kim_wonhee.a170427;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by kim_wonhee on 2017. 4. 27..
 */

public class GridItem extends LinearLayout {

    TextView txt_name, txt_price;
    ImageView imageView;

    public GridItem(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.griditem, null);

        txt_name = (TextView) view.findViewById(R.id.text_name);
        txt_price = (TextView) view.findViewById(R.id.text_price);
        imageView = (ImageView) view.findViewById(R.id.image);
    }

//    public void setData(String name, String price, int image) {
//        txt_name.setText(name);
//        txt_price.setText(price);
//        imageView.setImageResource(image);
//    }



//    public GirdItem(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public GirdItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    public GirdItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }
}
