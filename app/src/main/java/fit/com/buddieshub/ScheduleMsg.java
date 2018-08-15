package fit.com.buddieshub;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ScheduleMsg extends AppCompatActivity {
    Button btnSend;
    EditText txtPhoneNo;
    EditText txtSMS;
    EditText timee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_msg);
        btnSend=(Button) findViewById(R.id.buttonSend);
        txtPhoneNo=(EditText) findViewById(R.id.editTextPhoneNo);
        txtSMS=(EditText) findViewById(R.id.editTextSMS);
        timee = (EditText)findViewById(R.id.time);
        btnSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String phoneNo = txtPhoneNo.getText().toString();
                String SMS = txtSMS.getText().toString();
                String minut = timee.getText().toString();
                int i = Integer.parseInt(timee.getText().toString());
                Intent intent = new Intent(getApplicationContext(), MyBroadcastReceiver.class);
                intent.putExtra("ph",phoneNo);
                intent.putExtra("sms",SMS);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        getApplicationContext(), 234324243, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                        + (i * 1000*60), pendingIntent);
                Toast.makeText(getApplicationContext(), "Msg  set in " + i + " minutes",Toast.LENGTH_LONG).show();

            }
        });
    }
}
