package com.nguessan.script;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class SignupActivity extends Activity {

    Firebase ref;
    Firebase newRef;
    DatabaseHelper helper = new DatabaseHelper(this);
    protected Context context;
    protected String latitude, longitude;
    Button button4;
    GPSTracker gps;
    EditText username,email,pass1,pass2;
    String usernamestr,emailstr,pass1str,pass2str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_signup);
        ref = new Firebase(Config.FIREBASE_URL);

        gps = new GPSTracker(SignupActivity.this);

        // check if GPS enabled
        if (gps.canGetLocation()) {


            latitude = String.valueOf(gps.getLatitude());
            longitude = String.valueOf(gps.getLongitude());


//            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
            button4 = (Button) findViewById(R.id.button4);
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    signUP();
                }
            });

        }
        else {

        }



    }

    private void signUP()
    {
        username = (EditText) findViewById(R.id.editTextUsername);
        email = (EditText) findViewById(R.id.editTextEmail);
        pass1 = (EditText) findViewById(R.id.editTextPassword);
        pass2 = (EditText) findViewById(R.id.editTextcp);

        usernamestr = username.getText().toString();
        emailstr = email.getText().toString();
        pass1str = pass1.getText().toString();
        pass2str = pass2.getText().toString();


        if (!pass1str.equals(pass2str))
            Toast.makeText(SignupActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();

        else if (usernamestr==null||emailstr==null)
            Toast.makeText(SignupActivity.this, "Please Fill Complete Information", Toast.LENGTH_SHORT).show();


        else if (longitude==null||latitude==null)
            Toast.makeText(SignupActivity.this, "Please enable your GPS", Toast.LENGTH_SHORT).show();

        else
        {
            Contacts c = new Contacts();
            c.setUsername(usernamestr);
            c.setEmail(emailstr);
            c.setPassword(pass1str);
            c.setLatitude(latitude);
            c.setLongitude(longitude);

            newRef = ref.child("Contacts").push();
            newRef.setValue(c);
            helper.insertContacts(c);

            Toast.makeText(SignupActivity.this, "Signup Sucessfully !", Toast.LENGTH_SHORT).show();
            final Intent i = new Intent(SignupActivity.this, LoginActivity.class);

            Thread thread = new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        startActivity(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }

}
