package com.example.formbundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    Button btn_submit;
    RadioGroup get_food;
    CheckBox chk_ball, chk_olen,chk_breast,chk_tofu,chk_blood,chk_potato;
    Bundle bag = new Bundle();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_food = findViewById(R.id.ra_getfood);
        chk_ball = findViewById(R.id.chk_ball);
        chk_olen = findViewById(R.id.chk_olen);
        chk_breast = findViewById(R.id.chk_breast);
        chk_tofu = findViewById(R.id.chk_tofu);
        chk_blood = findViewById(R.id.chk_blood);
        chk_potato = findViewById(R.id.chk_potato);
        btn_submit = findViewById(R.id.btnSubmit);
        bag.putString("method","外送");
        get_food.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId)
                {
                    case R.id.ra_out: //case mRadioButton0.getId():
                        bag.putString("method","外送");
                        break;
                    case R.id.ra_out2:
                        bag.putString("method","店取");
                        break;
                }
            }
        });
        chk_ball.setOnCheckedChangeListener(this);
        chk_olen.setOnCheckedChangeListener(this);
        chk_breast.setOnCheckedChangeListener(this);
        chk_tofu.setOnCheckedChangeListener(this);
        chk_blood.setOnCheckedChangeListener(this);
        chk_potato.setOnCheckedChangeListener(this);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.putExtras(bag);
                intent.setClass(MainActivity.this,OrderListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch(buttonView.getId()){
            case R.id.chk_ball:
                if(isChecked) bag.putString("chk_ball",chk_ball.getText().toString());
                break;
            case R.id.chk_olen:
                if(isChecked) bag.putString("chk_olen",chk_olen.getText().toString());
                break;
            case R.id.chk_potato:
                if(isChecked) bag.putString("chk_potato",chk_potato.getText().toString());
                break;
            case R.id.chk_tofu:
                if(isChecked) bag.putString("chk_tofu",chk_tofu.getText().toString());
                break;
            case R.id.chk_breast:
                if(isChecked) bag.putString("chk_breast",chk_breast.getText().toString());
                break;
            case R.id.chk_blood:
                if(isChecked) bag.putString("isChecked",chk_blood.getText().toString());
                break;
        }
    }
}
