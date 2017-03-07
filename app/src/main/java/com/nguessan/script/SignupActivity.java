package com.nguessan.script;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }

    public void onSignupClick(View v){
        if (v.getId()== R.id.button4){
            EditText username = (EditText)findViewById(R.id.editTextUsername);
            EditText email = (EditText)findViewById(R.id.editTextEmail);
            EditText pass1 = (EditText)findViewById(R.id.editTextPassword);
            EditText pass2 = (EditText)findViewById(R.id.editTextcp);

            String usernamestr =username.getText().toString();
            String emailstr = email.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if (!pass1str.equals(pass2str)){
                Toast pass = Toast.makeText(SignupActivity.this, "Passwords don't match", Toast.LENGTH_SHORT);pass.show();
            }
            else {
                Contacts c = new Contacts();
                c.setUsername(usernamestr);
                c.setEmail(emailstr);
                c.setPassword(pass1str);

                helper.insertContacts(c);

                Toast.makeText(SignupActivity.this,"You are in FAM !!", Toast.LENGTH_SHORT).show();

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


}
