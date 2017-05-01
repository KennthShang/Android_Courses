package com.example.kenneth.lab1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("提示").setMessage("登录成功"
        ).setPositiveButton("确定",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Toast.makeText(getApplicationContext(),"对话框“确定”按钮被点击",Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"对话框“取消”按钮被点击",Toast.LENGTH_SHORT).show();
                    }
                }).create();

        final AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(this);
        alertDialog1.setTitle("提示").setMessage("登录失败"
        ).setPositiveButton("确定",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Toast.makeText(getApplicationContext(),"对话框“确定”按钮被点击",Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"对话框“取消”按钮被点击",Toast.LENGTH_SHORT).show();
                    }
                }).create();

        Button Deng = (Button) findViewById(R.id.denglu);
        final EditText username = (EditText) findViewById(R.id.name);
        final EditText password = (EditText) findViewById(R.id.key);
        Deng.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(TextUtils.isEmpty(username.getText().toString())){
                    Toast.makeText(MainActivity.this, "用户名为空",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(MainActivity.this, "密码为空",Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.equals(username.getText().toString(), "Android")) {
                    if (TextUtils.equals(password.getText().toString(), "123456"))
                        alertDialog.show();
                    else
                        alertDialog1.show();
                }
                else
                    alertDialog1.show();

            }
        });

        /*Button Deng = (Button) findViewById(R.id.zhuce);
        RadioGroup radiogroup = (RadioGroup) findViewById(R.id.id0)
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton radiobutton = (RadioButton)findViewById(group.getCheckedRadioButtonId());
                Toast.makeText(getApplicationContext(),radiobutton.getText().toString()+"身份被选中",Toast.LENGTH_LONG).show();
            }
        });*/

        final RadioButton radiobutton1 = (RadioButton)findViewById(R.id.id1);
        radiobutton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplication(),radiobutton1.getText().toString()+"身份被选中",Toast.LENGTH_LONG).show();
            }
        });

        final RadioButton radiobutton2 = (RadioButton)findViewById(R.id.id2);
        radiobutton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplication(),radiobutton2.getText().toString()+"身份被选中",Toast.LENGTH_LONG).show();
            }
        });

        final RadioButton radiobutton3 = (RadioButton)findViewById(R.id.id3);
        radiobutton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplication(),radiobutton3.getText().toString()+"身份被选中",Toast.LENGTH_LONG).show();
            }
        });

        final RadioButton radiobutton4 = (RadioButton)findViewById(R.id.id4);
        radiobutton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplication(),radiobutton4.getText().toString()+"身份被选中",Toast.LENGTH_LONG).show();
            }
        });

        Button zhuce = (Button) findViewById(R.id.zhuce);
        zhuce.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(radiobutton1.isChecked()){
                    Toast.makeText(getApplication(),radiobutton1.getText().toString()+"身份注册功能未开通",Toast.LENGTH_LONG).show();
                }
                if(radiobutton2.isChecked()){
                    Toast.makeText(getApplication(),radiobutton2.getText().toString()+"身份注册功能未开通",Toast.LENGTH_LONG).show();
                }
                if(radiobutton3.isChecked()){
                    Toast.makeText(getApplication(),radiobutton3.getText().toString()+"身份注册功能未开通",Toast.LENGTH_LONG).show();
                }
                if(radiobutton4.isChecked()){
                    Toast.makeText(getApplication(),radiobutton4.getText().toString()+"身份注册功能未开通",Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
