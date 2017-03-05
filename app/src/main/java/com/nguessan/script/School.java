package com.nguessan.script;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class School extends Activity {
    CheckBox checkbox1,checkBox2;
    Button Butt1;


    @Override

//added one line of comment
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_school);



        Butt1 = (Button) findViewById(R.id.bt1);

        Butt1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {



                Intent intent = new Intent(School.this,MapsActivity.class);

                startActivity(intent);

            }

        });

    }





}
