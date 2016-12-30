package com.telephone.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private EditText editText;
    private Button btnStart, btnBind, btnUnBind, btnSync;
    private TextView serviceData;
    private Intent serviceIntent;
    private TelephoneCallAidlServiceInterface telephoneCallAidlServiceInterface = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = (EditText) findViewById(R.id.edittext);
        serviceData = (TextView) findViewById(R.id.serviceData);
        btnStart = (Button) findViewById(R.id.start);
        btnBind = (Button) findViewById(R.id.bind);
        btnUnBind = (Button) findViewById(R.id.unbind);
        btnSync = (Button) findViewById(R.id.sync);
        btnStart.setOnClickListener(this);
        btnBind.setOnClickListener(this);
        btnUnBind.setOnClickListener(this);
        btnSync.setOnClickListener(this);


        /*
         * 连接服务器端的service
         */
        serviceIntent = new Intent();
        //5.0以上必须显示调用,第一个参数服务器的包名，第二个参数服务器的Service的名称
        ComponentName componentName = new ComponentName("com.telephone.app.server", "com.telephone.app.server.TelephoneCallService");
        serviceIntent.setComponent(componentName);


    }

    private void sendBroadcast() {
        Intent broadcast = new Intent();
        broadcast.setAction("com.telephone.app.telephone.call");
        sendBroadcast(broadcast);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                sendBroadcast();
//                startService(serviceIntent);
                break;
            case R.id.bind:
                bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(this);
                telephoneCallAidlServiceInterface = null;
                break;
            case R.id.sync:
                if (telephoneCallAidlServiceInterface != null) {
                    try {
                        String str = telephoneCallAidlServiceInterface.telephoneCall();
                        Log.e("XLog", "=========data===============" + str);
                        serviceData.setText(str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }


    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.e("XLog", "===========绑定服务器成功======================");
        telephoneCallAidlServiceInterface = TelephoneCallAidlServiceInterface.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.e("XLog", "===========绑定服务器失败======================");
    }
}
