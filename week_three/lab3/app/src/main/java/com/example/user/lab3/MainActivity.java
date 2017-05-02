package com.example.user.lab3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final List<Map<String, Object>> data = new ArrayList<>();
        String[] num = {"A", "E", "D", "E", "F", "J", "I",
                "M", "J", "P"};
        final String[] name = {"Aaron", "Elvis", "David", "Edwin", "Frank",
                "Joshua", "Ivan", "Mark", "Joseph", "Phoebe"};
        for(int i = 0; i < 10; i++){
            Map<String, Object> temp = new LinkedHashMap<>();
            temp.put("num", num[i]);
            temp.put("name", name[i]);
            data.add(temp);
        }
        final ListView listview = (ListView) findViewById(R.id.contacts_list);
        final SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.item,
                new String[]{"num", "name"}, new int[]{R.id.num, R.id.name});
        listview.setAdapter(simpleAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("data", position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int positioin, long id) {
                AlertDialog alertDialog1 = alertDialog.setTitle("删除联系人").setMessage("确定删除联系人" + data.get(positioin).get("name") + "?"
                ).setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "对话框“确定”按钮被点击", Toast.LENGTH_SHORT).show();
                                data.remove(positioin);
                                simpleAdapter.notifyDataSetChanged();
                            }
                        }).setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "对话框“取消”按钮被点击", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                alertDialog.show();
                return true;
            }
        });

    }
}
