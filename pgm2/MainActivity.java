package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText input1, input2;
    private TextView result;
    private Button add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addition(View view) {
        input1 = findViewById(R.id.number1);
        input2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);

        float ans = (Float.parseFloat(input1.getText().toString())) + (Float.parseFloat(input2.getText().toString()));
        result.setText("" + ans);
    }

    public void subtraction(View view) {
        input1 = findViewById(R.id.number1);
        input2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);

        float ans = (Float.parseFloat(input1.getText().toString())) - (Float.parseFloat(input2.getText().toString()));
        result.setText("" + ans);
    }

    public void multiplication(View view) {
        input1 = findViewById(R.id.number1);
        input2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);

        float ans = (Float.parseFloat(input1.getText().toString())) * (Float.parseFloat(input2.getText().toString()));
        result.setText("" + ans);
    }

    public void division(View view) {
        input1 = findViewById(R.id.number1);
        input2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);

        float secondNumber = (Float.parseFloat(input2.getText().toString()));
        if(secondNumber != 0) {
            float ans = (Float.parseFloat(input1.getText().toString())) / (Float.parseFloat(input2.getText().toString()));
            result.setText("" + ans);
        } else {
            Toast.makeText(this, "Denominator is zero", Toast.LENGTH_SHORT).show();
        }
    }
}