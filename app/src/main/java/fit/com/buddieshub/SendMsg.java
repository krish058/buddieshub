package fit.com.buddieshub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMsg extends AppCompatActivity {
    Button btnSend;
    EditText txtPhoneNo;
    EditText txtSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msg);
        btnSend=(Button) findViewById(R.id.buttonSend);
        txtPhoneNo=(EditText) findViewById(R.id.editTextPhoneNo);
        txtSMS=(EditText) findViewById(R.id.editTextSMS);

        btnSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String phoneNo = txtPhoneNo.getText().toString();
                String SMS = txtSMS.getText().toString();

                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, SMS, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sent!...", Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "SMS faild, please try again later!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
