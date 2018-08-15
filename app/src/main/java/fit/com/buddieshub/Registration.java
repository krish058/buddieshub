package fit.com.buddieshub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    Button registor_button;
    EditText mobilenumber_r,password_r;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registor_button = (Button) findViewById(R.id.registor_button);
        mobilenumber_r = (EditText)findViewById(R.id.mobilenumber_r);
        password_r = (EditText)findViewById(R.id.password_r);
        db = new DatabaseHandler(this);

        registor_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shopper s = new Shopper();
                s.setMobile(mobilenumber_r.getText().toString());
                s.setPassword(password_r.getText().toString());

                if(db.addShopper(s)) {
                    Toast.makeText(getApplicationContext(), "Successfully Registred", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Problem in Registration", Toast.LENGTH_SHORT).show();

                }



            }
        });



    }


}
