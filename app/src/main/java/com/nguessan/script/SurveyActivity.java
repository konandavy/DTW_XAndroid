package com.nguessan.script;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SurveyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //calls the act_survey.xml for viewing
        setContentView(R.layout.activity_survey);

        //findViewById(R.id.bt1) creates a new object instance .setOnClickListener wait for the input touch
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                //change activity display to the map activity
                startActivity(new Intent(SurveyActivity.this,MapsActivity.class));
            }

        });

    }





}
