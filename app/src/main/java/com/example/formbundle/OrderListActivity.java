package com.example.formbundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OrderListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        TextView order_list = findViewById(R.id.order_list);
        Bundle bag = getIntent().getExtras();
        String all_food ="";
        String chk_ball = bag.getString("chk_ball");
        String chk_olen = bag.getString("chk_olen");
        String chk_potato = bag.getString("chk_potato");
        String chk_tofu = bag.getString("chk_tofu");
        String chk_breast = bag.getString("chk_breast");
        String chk_blood = bag.getString("chk_blood");
        if(chk_ball != null) all_food += chk_ball+"\n";
        if(chk_olen != null) all_food += chk_olen+"\n";
        if(chk_potato != null) all_food += chk_potato+"\n";
        if(chk_tofu != null) all_food += chk_tofu+"\n";
        if(chk_breast != null) all_food += chk_breast+"\n";
        if(chk_blood != null) all_food += chk_blood+"\n";

        String method = "取餐方式: "+bag.getString("method");
        order_list.setText(all_food+method);

    }
}
