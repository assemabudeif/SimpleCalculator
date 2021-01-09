package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.TagLostException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtWeight;
    EditText edtLength;
    Button btnBMI;
    TextView txtResult;
    TextView txtStatus;
    public static double BMI = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWeight = findViewById(R.id.edtWeight);
        edtLength = findViewById(R.id.edtLength);
        btnBMI = findViewById(R.id.btnGetBMI);
        txtResult = findViewById(R.id.txtResult);
        txtStatus = findViewById(R.id.txtStatus);
        btnBMI.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                BMI = Double.parseDouble(edtWeight.getText().toString())/Double.parseDouble(edtLength.getText().toString())/Double.parseDouble(edtLength.getText().toString()) * 10000;
                txtResult.setText("Your BMI : " + Double.toString(BMI));
                if (BMI < 16)
                    txtStatus.setText("You are Severe Thinness");
                else if (BMI >= 16 && BMI <= 17)
                    txtStatus.setText("You are Moderate Thinnesss");
                else if (BMI >= 17 && BMI <= 18.5)
                    txtStatus.setText("You are Mild Thinness");
                else if (BMI >= 18.5 && BMI <= 25)
                    txtStatus.setText("You are Normal");
                else if (BMI >= 25 && BMI <= 30)
                    txtStatus.setText("You are Overweight");
                else if (BMI >= 30 && BMI <= 35)
                    txtStatus.setText("You are Obese Class I");
                else if (BMI >= 35 && BMI <= 40)
                    txtStatus.setText("You are Obese Class II");
                else if (BMI >= 40)
                    txtStatus.setText("You are Obese Class III");
            }
        });

    }
}