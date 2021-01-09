package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Boolean isRepeat = false;
    Button btn00;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnPoint;
    Button btnEqual;
    Button btnPlus;
    Button btnMul;
    Button btnDiv;
    Button btnMinus;
    Button btnMod;
    Button btnClear;
    Button btnDelete;
    static TextView txtResult;
    static TextView txtFirst;
    public static String numText = "";
    public static double result;
    public static char btn;
    public static String numDelete = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txtResult);
        txtFirst = findViewById(R.id.txtFirst);
        btn00 = findViewById(R.id.btn00);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnEqual = findViewById(R.id.btnEqeual);
        btnPlus = findViewById(R.id.btnPlus);
        btnDiv = findViewById(R.id.btnDiv);
        btnMinus = findViewById(R.id.btnMinus);
        btnMul = findViewById(R.id.btnMul);
        btnMod = findViewById(R.id.btnMod);
        btnPoint = findViewById(R.id.btnPoint);
        btnClear = findViewById(R.id.btnClear);
        btnDelete = findViewById(R.id.btnDelete);
        numBtn(btn00);
        numBtn(btn0);
        numBtn(btn1);
        numBtn(btn2);
        numBtn(btn3);
        numBtn(btn4);
        numBtn(btn5);
        numBtn(btn6);
        numBtn(btn7);
        numBtn(btn8);
        numBtn(btn9);
        notRepeat(btnPoint);
        getResult(btnPlus);
        getResult(btnDiv);
        getResult(btnMinus);
        getResult(btnMul);
        getResult(btnMod);
        getResult(btnEqual);
        getResult(btnClear);
        getResult(btnDelete);
    }

    public void numBtn(Button num)
    {


        num.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numText += num.getText();
                txtResult.setText(numText);
                isRepeat = false;
            }
        });
    }

    public void notRepeat(Button button)
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (!isRepeat)
                {
                    numText += button.getText();
                    txtResult.setText(numText);
                    isRepeat = true;
                }
            }
        });
    }

    public void getResult(Button button)
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                switch (button.getText().charAt(0))
                {
                    case '+': {
                        result += Double.parseDouble(txtResult.getText().toString());
                        btn = '+';
                        txtFirst.setText(Double.toString(result));
                        MainActivity.numText = "";
                        txtResult.setText("0");

                    }
                        break;
                    case '-': {
                        if (result == 0) {
                            result = 0;
                            result = Double.parseDouble(txtResult.getText().toString()) - result;
                        }
                        else
                            result -= Double.parseDouble(txtResult.getText().toString());
                        btn = '-';
                        txtFirst.setText(Double.toString(result));
                        MainActivity.numText = "";
                        txtResult.setText("0");
                    }
                        break;
                    case '*': {
                        if (result == 0)
                            result = 1;
                        result = Double.parseDouble(txtResult.getText().toString()) * result;
                        btn = '*';
                        txtFirst.setText(Double.toString(result));
                        MainActivity.numText = "";
                        txtResult.setText("0");
                    }
                        break;
                    case '/': {
                        if (result == 0) {
                            result = 1;
                            result = Double.parseDouble(txtResult.getText().toString()) / result;
                        }
                        else
                            result /= Double.parseDouble(txtResult.getText().toString());
                        btn = '/';
                        txtFirst.setText(Double.toString(result));
                        MainActivity.numText = "";
                        txtResult.setText("0");
                    }
                    break;
                    case '%': {
                        result %= Double.parseDouble(txtResult.getText().toString());
                        btn = '%';
                        txtFirst.setText(Double.toString(result));
                        MainActivity.numText = "";
                        txtResult.setText("0");
                    }
                        break;
                    case 'C':
                    {
                        MainActivity.numText = "";
                        txtResult.setText("0");
                        result = 0;
                        txtFirst.setText(Double.toString(result));
                    }
                    break;
                    case 'D':
                    {
                        if ((numText != null) && (numText.length() > 0))
                        {
                            numDelete = numText.substring(0, numText.length() - 1);
                            numText = numDelete;
                            txtResult.setText(numText);
                        }

                    }
                    break;
                    case '=':
                        switch (btn) {
                            case '+': {
                                result += Double.parseDouble(txtResult.getText().toString());
                                txtFirst.setText(Double.toString(result));
                                MainActivity.numText = "";
                                txtResult.setText("0");
                                result = 0;
                                btn =' ';
                            }
                                break;
                            case '-':{
                                if (result == 0) {
                                    result = 0;
                                    result = Double.parseDouble(txtResult.getText().toString()) - result;
                                }
                                else
                                    result -= Double.parseDouble(txtResult.getText().toString());
                                txtFirst.setText(Double.toString(result));
                                MainActivity.numText = "";
                                txtResult.setText("0");
                                result = 0;
                                btn = ' ';
                            }
                                break;
                            case '*': {
                                if (result == 0)
                                    result = 1;
                                result = Double.parseDouble(txtResult.getText().toString()) * result;
                                txtFirst.setText(Double.toString(result));
                                MainActivity.numText = "";
                                txtResult.setText("0");
                                result = 1;
                                btn = ' ';
                            }
                                break;
                            case '/': {
                                if (result == 0) {
                                    result = 1;
                                    result = Double.parseDouble(txtResult.getText().toString()) / result;
                                }
                                else
                                    result /= Double.parseDouble(txtResult.getText().toString());
                                txtFirst.setText(Double.toString(result));
                                MainActivity.numText = "";
                                txtResult.setText("0");
                                result = 1;
                                btn = ' ';
                            }
                                break;
                            case '%': {
                                result %= Double.parseDouble(txtResult.getText().toString());
                                txtFirst.setText(Double.toString(result));
                                MainActivity.numText = "";
                                txtResult.setText("0");
                                result = 0;
                                btn = ' ';
                            }
                                break;
                            default:
                                break;
                        }

                    default:
                        break;
                }
            }
        });
    }

}