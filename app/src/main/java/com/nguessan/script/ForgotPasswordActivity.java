package com.nguessan.script;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//
//
//This activity (and it's associated XML) is not yet implemented
//
//
public class ForgotPasswordActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Android Insomnia Regular.ttf");
        TextView myTextView = (TextView) findViewById(R.id.textViewhomepage);
        myTextView.setTypeface(myTypeface);
    }

    public void onForgotpasswordClick (View view) {
        if (view.getId() == R.id.buttonsubmit) {

            EditText b = (EditText) findViewById(R.id.editTextET);
            String emai = b.getText().toString();
            EditText a = (EditText) findViewById(R.id.editTextUS);
            String str = a.getText().toString();

            String emai1 = helper.searchEmai(str);

            if (emai.equals(emai1) ) {
                Intent i = new Intent(ForgotPasswordActivity.this,NewPasswordActivity.class);
                i.putExtra("username", str);
                startActivity(i);
            }
            else {
                Toast.makeText(ForgotPasswordActivity.this, "Username and Email don't match", Toast.LENGTH_LONG).show();
            }

        }


    }

}
