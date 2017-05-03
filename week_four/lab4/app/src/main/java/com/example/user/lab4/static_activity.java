package com.example.user.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class static_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.static_activity);


        final List<Map<String, Object>> data = new ArrayList<>();
        final int[] num = {R.mipmap.apple, R.mipmap.banana, R.mipmap.cherry,
                            R.mipmap.coco, R.mipmap.kiwi, R.mipmap.orange, R.mipmap.pear,
                            R.mipmap.strawberry, R.mipmap.watermelon};
        final String[] name = {"Apple", "Banana", "Cherry", "Coco", "kiwi",  "Orange",
                        "Pear", "Strawberry", "Watermelon"};
        for(int i = 0; i < 9; i++){
            Map<String, Object> temp = new LinkedHashMap<>();
            temp.put("num", num[i]);
            temp.put("name", name[i]);
            data.add(temp);
        }
        final ListView listview = (ListView) findViewById(R.id.list_view);
        final SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.item,
                new String[]{"num", "name"}, new int[]{R.id.num, R.id.name});
        listview.setAdapter(simpleAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private static final String STATICATION = "com.example.user.lab4.static_receiver";
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(STATICATION);
                Bundle bundle = new Bundle();
                bundle.putString("name", name[position]);
                bundle.putInt("image", num[position]);
                intent.putExtras(bundle);
                sendBroadcast(intent);
            }
        });
    }
}
