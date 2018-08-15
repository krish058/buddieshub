package fit.com.buddieshub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.gsm.SmsManager;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public MyBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            String phoneNo = intent.getStringExtra("ph").toString();
            String SMS = intent.getStringExtra("sms").toString();
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, SMS, null, null);
            Toast.makeText(context, "SMS Sent!...", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(context, "SMS faild, please try again later!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
