package com.nguessan.script;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;



public class SurveyActivity extends Activity {

    boolean surveyResult[] = new boolean[19];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //calls the act_survey.xml for viewing
        setContentView(R.layout.activity_survey);

        //findViewById(R.id.bt1) creates a new object instance .setOnClickListener wait for the input touch
        findViewById(R.id.submitButton).setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                //change activity display to the map activity
                startActivity(new Intent(SurveyActivity.this,MapsActivity.class));
            }

        });

    }//end onCreate method

    ///
    //Each Button in the survey has a corresponding onClick'x' method that is called
    //Each method toggles the state of the survey in a boolean array
    //TODO: send boolean array to database
    //
    public void onClick1(View view){
        surveyResult[0] = !surveyResult[0];
    }//end
    public void onClick2(View v){
        surveyResult[1] = !surveyResult[1];
    }//end
    public void onClick3(View v){
        surveyResult[2] = !surveyResult[2];
    }//end
    public void onClick4(View v){
        surveyResult[3] = !surveyResult[3];
    }//end
    public void onClick5(View v){
        surveyResult[4] = !surveyResult[4];
    }//end
    public void onClick6(View v){
        surveyResult[5] = !surveyResult[5];
    }//end
    public void onClick7(View v){
        surveyResult[6] = !surveyResult[6];
    }//end
    public void onClick8(View v){
        surveyResult[7] = !surveyResult[7];
    }//end
    public void onClick9(View v){
        surveyResult[8] = !surveyResult[8];
    }//end
    public void onClick10(View v){
        surveyResult[9] = !surveyResult[9];
    }//end
    public void onClick11(View v){
        surveyResult[10] = !surveyResult[10];
    }//end
    public void onClick11_5(View v){
        surveyResult[11] = !surveyResult[11];
    }//end
    public void onClick12(View v){
        surveyResult[12] = !surveyResult[12];
    }//end
    public void onClick13(View v){
        surveyResult[13] = !surveyResult[13];
    }//end
    public void onClick14(View v){
        surveyResult[14] = !surveyResult[14];
    }//end
    public void onClick15(View v){
        surveyResult[15] = !surveyResult[15];
    }//end
    public void onClick16(View v){
        surveyResult[16] = !surveyResult[16];
    }//end
    public void onClick17(View v){
        surveyResult[17] = !surveyResult[17];
    }//end
    public void onClick18(View v){
        surveyResult[18] = !surveyResult[18];
    }//end
    public void onClick19(View v){
        surveyResult[19] = !surveyResult[19];
    }//end

}//end SurveyActivity class
