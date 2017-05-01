package com.example.kenneth.lab1;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
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

public class Second_activaty extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_second);

        final RadioButton radiobutton1 = (RadioButton)findViewById(R.id.id1);
        radiobutton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Snackbar.make(v, radiobutton1.getText().toString()+"身份被选中", Snackbar.LENGTH_SHORT).show();
            }
        });

        final RadioButton radiobutton2 = (RadioButton)findViewById(R.id.id2);
        radiobutton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Snackbar.make(v, radiobutton2.getText().toString()+"身份被选中", Snackbar.LENGTH_SHORT).show();
        }
        });

        final RadioButton radiobutton3 = (RadioButton)findViewById(R.id.id3);
        radiobutton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Snackbar.make(v, radiobutton3.getText().toString()+"身份被选中", Snackbar.LENGTH_SHORT).show();
            }
        });

        final RadioButton radiobutton4 = (RadioButton)findViewById(R.id.id4);
        radiobutton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Snackbar.make(v, radiobutton4.getText().toString()+"身份被选中", Snackbar.LENGTH_SHORT).show();
            }
        });

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("提示").setMessage("登录成功"
        ).setPositiveButton("确定",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Snackbar.make(getWindow().getDecorView(),"对话框“确定”按钮被点击",Snackbar.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar.make(getWindow().getDecorView(),"对话框“取消”按钮被点击",Snackbar.LENGTH_SHORT).show();
                    }
                }).create();

        final AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(this);
        alertDialog1.setTitle("提示").setMessage("登录失败"
        ).setPositiveButton("确定",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Snackbar.make(getWindow().getDecorView(),"对话框“确定”按钮被点击",Snackbar.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar.make(getWindow().getDecorView(),"对话框“取消”按钮被点击",Snackbar.LENGTH_SHORT).show();
                    }
                }).create();

        final TextInputLayout usernameText = (TextInputLayout) findViewById(R.id.more_username);
        final TextInputLayout passwordText = (TextInputLayout) findViewById(R.id.more_password);


        Button Deng = (Button) findViewById(R.id.denglu);
        Deng.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(usernameText.getEditText().getText().toString().isEmpty()){
                    usernameText.setErrorEnabled(true);
                    usernameText.setError("用户名为空");
                    Snackbar.make(getWindow().getDecorView(), "用户名为空",Snackbar.LENGTH_SHORT).show();
                }
                else if(passwordText.getEditText().getText().toString().isEmpty()){
                    passwordText.setErrorEnabled(true);
                    passwordText.setError("密码为空");
                    Snackbar.make(getWindow().getDecorView(), "密码为空",Snackbar.LENGTH_SHORT).show();
                }

                else if(TextUtils.equals(usernameText.getEditText().getText().toString(), "Android")) {
                    usernameText.setErrorEnabled(false);
                    passwordText.setErrorEnabled(false);
                    if (TextUtils.equals(passwordText.getEditText().getText().toString(), "123456"))
                        alertDialog.show();
                    else
                        alertDialog1.show();
                }
                else
                    usernameText.setErrorEnabled(false);
                    passwordText.setErrorEnabled(false);
                    alertDialog1.show();
            }
        });

        Button zhuce = (Button) findViewById(R.id.zhuce);
        zhuce.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(radiobutton1.isChecked()){
                    Snackbar.make(v,radiobutton1.getText().toString()+"身份注册功能未开通",Snackbar.LENGTH_LONG).show();
                }
                if(radiobutton2.isChecked()){
                    Snackbar.make(v,radiobutton2.getText().toString()+"身份注册功能未开通",Snackbar.LENGTH_LONG).show();
                }
                if(radiobutton3.isChecked()){
                    Snackbar.make(v,radiobutton3.getText().toString()+"身份注册功能未开通",Snackbar.LENGTH_LONG).show();
                }
                if(radiobutton4.isChecked()){
                    Snackbar.make(v,radiobutton4.getText().toString()+"身份注册功能未开通",Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

}
