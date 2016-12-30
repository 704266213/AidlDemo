package com.telephone.app.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.telephone.app.server.EmptyActivity;
import com.telephone.app.server.TelephoneCallService;

public class StartTelephoneCallServiceReceiver extends BroadcastReceiver {

    public StartTelephoneCallServiceReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("XLog", "=========Action=================" + intent.getAction());
        Intent telephoneCallService = new Intent(context.getApplicationContext(),TelephoneCallService.class);
        context.startService(telephoneCallService);

//        Intent telephoneCallService = new Intent(context.getApplicationContext(), EmptyActivity.class);
//        telephoneCallService.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(telephoneCallService);
    }
}
