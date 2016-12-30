package com.telephone.app.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.telephone.app.TelephoneCallAidlServiceInterface;

public class TelephoneCallService extends Service {

    public TelephoneCallService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new TelephoneCallAidlService();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public class TelephoneCallAidlService extends TelephoneCallAidlServiceInterface.Stub {

        @Override
        public String telephoneCall() throws RemoteException {
            return "连接服务端成功";
        }
    }
}
