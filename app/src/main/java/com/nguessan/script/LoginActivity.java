package com.nguessan.script;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);
    LoginButton loginButton;
    CallbackManager callbackManager;
    GPSTracker gps;
    Button Register;
    int REQUEST_ID_MULTIPLE_PERMISSIONS = 0;


    String[] permissions = new String[]{
            android.Manifest.permission.GET_ACCOUNTS,android.Manifest.permission.READ_CONTACTS,
            android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.CAMERA,
            android.Manifest.permission.ACCESS_FINE_LOCATION
    };
    @Override
    protected void onCreate  (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        if (checkPermissions())
        {
        }
        else{

        }




        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        Register=(Button) findViewById(R.id.button3);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Android Insomnia Regular.ttf");
        loginButton = (LoginButton) findViewById(R.id.button5);
        gps = new GPSTracker(LoginActivity.this);
        TextView myTextView = (TextView) findViewById(R.id.textView);
        myTextView.setTypeface(myTypeface);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("LOGIN_SUCCESS", "Success");
                loginButton.setVisibility(View.INVISIBLE); //<- IMPORTANT
                Intent intent = new Intent(LoginActivity.this,SurveyActivity.class);
                startActivity(intent);
                finish();//<- IMPORTANT

            }

            @Override
            public void onCancel() {
                Log.d("LOGIN_CANCEL", "Cancel");

            }

            @Override
            public void onError(FacebookException error) {
                Log.d("LOGIN_ERROR", "Error");

            }
        });

        if(gps.canGetLocation())
        {

        }
        else {
            gps.showSettingsAlert();
        }
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });

    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode,Intent data){
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }


    public void onButtonClick (View view) {
        if (view.getId() == R.id.btnlogin) {

            EditText b = (EditText) findViewById(R.id.editTextp);
            String pass = b.getText().toString();
            EditText a = (EditText) findViewById(R.id.editTextu);
            String str = a.getText().toString();

            String password = helper.searchPass(str);



            if (pass.equals(password)) {
                Intent i = new Intent(LoginActivity.this, SurveyActivity.class);
                startActivity(i);
            } else {
                Toast temp = Toast.makeText(LoginActivity.this, "Username and Password don't match", Toast.LENGTH_SHORT);
                temp.show();
            }

        }
    }

    public void onForgotClick (View v){
        if (v.getId() == R.id.button2){
            Intent intent = new Intent(LoginActivity.this,ForgotPasswordActivity.class);
            startActivity(intent);
        }
    }

    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissions) {
            result = ContextCompat.checkSelfPermission(LoginActivity.this, p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }
}
