package com.example.user.lab3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SecondActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        int data = bundle.getInt("data");

        int[] background_color =  {getResources().getColor(R.color.Aaron), getResources().getColor(R.color.Elvis), getResources().getColor(R.color.David),
                                      getResources().getColor(R.color.Edwin), getResources().getColor(R.color.Frank), getResources().getColor(R.color.Joshua),
                                      getResources().getColor(R.color.Ivan), getResources().getColor(R.color.Mark), getResources().getColor(R.color.Joseph),
                                      getResources().getColor(R.color.Phoebe)};

        String[] names = {getResources().getString(R.string.Aaron), getResources().getString(R.string.Elvis), getResources().getString(R.string.David),
                          getResources().getString(R.string.Edwin), getResources().getString(R.string.Frank), getResources().getString(R.string.Joseph),
                          getResources().getString(R.string.Ivan), getResources().getString(R.string.Mark), getResources().getString(R.string.Joseph),
                          getResources().getString(R.string.Phoebe)};

        String[] number = {getResources().getString(R.string.Aaron_number), getResources().getString(R.string.Elvis_number), getResources().getString(R.string.David_number),
                           getResources().getString(R.string.Edwin_number), getResources().getString(R.string.Frank_number), getResources().getString(R.string.Joshua_number),
                           getResources().getString(R.string.Ivan_number), getResources().getString(R.string.Mark_number), getResources().getString(R.string.Joseph_number),
                           getResources().getString(R.string.Phoebe_number)};

        String[] address = {getResources().getString(R.string.Aaron_add), getResources().getString(R.string.Elvis_add), getResources().getString(R.string.David_add),
                            getResources().getString(R.string.Edwin_add), getResources().getString(R.string.Frank_add), getResources().getString(R.string.Joseph_add),
                            getResources().getString(R.string.Ivan_add), getResources().getString(R.string.Mark_add), getResources().getString(R.string.Joseph_add),
                            getResources().getString(R.string.Phoebe_add)};

        String[] type = {getResources().getString(R.string.Aaron_type), getResources().getString(R.string.Elvis_type), getResources().getString(R.string.David_type),
                        getResources().getString(R.string.Edwin_type), getResources().getString(R.string.Frank_type), getResources().getString(R.string.Joseph_type),
                        getResources().getString(R.string.Ivan_type),getResources().getString(R.string.Mark_type), getResources().getString(R.string.Joseph_type),
                        getResources().getString(R.string.Phoebe_type)};

        RelativeLayout label = (RelativeLayout) findViewById(R.id.label);
        TextView text = (TextView) findViewById(R.id.name);
        TextView phone_number = (TextView) findViewById(R.id.phone_number);
        TextView phone = (TextView) findViewById(R.id.phone);
        TextView where = (TextView) findViewById(R.id.where);


        label.setBackgroundColor(background_color[data]);
        text.setText(names[data]);
        phone_number.setText(number[data]);
        phone.setText(type[data]);
        where.setText(address[data]);


        final Button star = (Button) findViewById(R.id.star);
        star.setOnClickListener(new View.OnClickListener(){
            int flag = 0;
            @Override
            public void onClick(View v){
                flag = ~flag;
                if(flag == 1)
                    star.setBackgroundResource(R.mipmap.full_star);
                else
                    star.setBackgroundResource(R.mipmap.empty_star);
            }
        });
        ListView listView = (ListView) findViewById(R.id.contacts_list);
        String[] name = {"编辑联系人", "分享联系人", "加入黑名单", "删除联系人"};
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name));

        Button button = (Button) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}
