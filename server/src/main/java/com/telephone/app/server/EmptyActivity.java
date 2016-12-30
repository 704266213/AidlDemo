package com.telephone.app.server;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.telephone.app.R;

public class EmptyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        Intent intent = new Intent(getApplicationContext(),TelephoneCallService.class);
        startService(intent);
    }
}
