package com.example.user.lab4;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dynamic_activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamiic_activity);

        final TextView text = (TextView) findViewById(R.id.edit_text);
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);



        button1.setOnClickListener(new View.OnClickListener(){
            int i = 1;
            private static final String DYNAMICATION = "com.example.user.lab4.dynamicreceiver";
            final BroadcastReceiver br = new dynamic_receiver();
            @Override
            public void onClick(View v) {

                if(i == 1){
                    i = 0;
                    button1.setText(getResources().getString(R.string.UnregisterBroadcast));

                    IntentFilter dynamic_filter = new IntentFilter();
                    dynamic_filter.addAction(DYNAMICATION);
                    registerReceiver(br, dynamic_filter);
                }
                else{
                    i = 1;
                    button1.setText(getResources().getString(R.string.RegisterBroadcast));
                    unregisterReceiver(br);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            private static final String DYNAMICATION = "com.example.user.lab4.dynamicreceiver";
            @Override
            public void onClick(View v){
                if(button1.getText().toString().equals("Unregister Broadcast")) {
                    Intent intent = new Intent(DYNAMICATION);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", text.getText().toString());
                    intent.putExtras(bundle);
                    sendBroadcast(intent);
                }
            }
        });
    }
}
