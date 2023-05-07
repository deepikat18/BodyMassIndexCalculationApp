package com.example.bestbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bestbmi.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editWeight, editHeightFt, editHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;
        editWeight = findViewById(R.id.editWeight);
        editHeightFt = findViewById(R.id.editHeightFt);
        editHeightIn= findViewById(R.id.editHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(editWeight.getText().toString());
                int ft = Integer.parseInt(editHeightFt.getText().toString());
                int in = Integer.parseInt(editHeightIn.getText().toString());
                int totalIn = ft*12+in;

                double totalCm = totalIn*2.54;

                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);
                if(bmi >25){
                    txtResult.setText("you are over weight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                }
                else if (bmi < 18){
                    txtResult.setText("You are under wait");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }
                else{
                    txtResult.setText("Your very healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }

            }
        });

    }
}