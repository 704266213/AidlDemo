package com.telephone.app.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.telephone.app.PhoneBook;
import com.telephone.app.TelephoneCallAidlServiceInterface;

import java.util.ArrayList;
import java.util.List;

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
        public List<PhoneBook> telephoneCall(String str) throws RemoteException {
            Log.e("XLog", "=======客户端传递的参数======" + str);
            List<PhoneBook> phoneBooks = new ArrayList<>();
            PhoneBook phoneBook = new PhoneBook();
            phoneBook.setName("jaty");
            phoneBook.setPhone("15527018965");
            phoneBooks.add(phoneBook);
            PhoneBook phoneBook1 = new PhoneBook();
            phoneBook1.setName("alan");
            phoneBook1.setPhone("18927018965");
            phoneBooks.add(phoneBook1);
            return phoneBooks;
        }
    }
}
