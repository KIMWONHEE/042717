package com.example.kim_wonhee.a170427;

import android.content.Context;
import android.support.annotation.BoolRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

public class Custom2Widget extends LinearLayout implements View.OnClickListener {

    Context context;
    CheckBox checkBox;
    Button button;

    public Custom2Widget(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.top, this);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCheckListener.onChecked(checkBox.isChecked());
            }
        });

    }

    @Override
    public void onClick(View v) {
        onButtonListener.onToast();
    }

    interface OnCheckListener {
        void onChecked(Boolean ischecked);
    }

    public OnCheckListener onCheckListener;

    public void setOnCheckListener (OnCheckListener onCheckListener) {
        this.onCheckListener = onCheckListener;
    }

    interface OnButtonListener {
        void onToast();
    }

    public OnButtonListener onButtonListener;

    public void setOnButtonListener (OnButtonListener onButtonListener) {
        this.onButtonListener = onButtonListener;
    }


}
