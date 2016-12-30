package com.telephone.app.server;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.telephone.app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * 必须启动服务不然无法绑定
         */
//        Intent intent = new Intent(getApplicationContext(),TelephoneCallService.class);
//        startService(intent);
    }


}
