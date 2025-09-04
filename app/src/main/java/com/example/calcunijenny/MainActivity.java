package com.example.calcunijenny;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputFirstNumber, inputSecondNumber;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // your XML layout filename


        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        btnAdd = findViewById(R.id.btnAddition);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        textResult = findViewById(R.id.textResult);


        btnAdd.setOnClickListener(v -> calculate('+'));
        btnSubtract.setOnClickListener(v -> calculate('-'));
        btnMultiply.setOnClickListener(v -> calculate('*'));
        btnDivide.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {
        String firstStr = inputFirstNumber.getText().toString().trim();
        String secondStr = inputSecondNumber.getText().toString().trim();

        if (TextUtils.isEmpty(firstStr) || TextUtils.isEmpty(secondStr)) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1, num2;

        try {
            num1 = Double.parseDouble(firstStr);
            num2 = Double.parseDouble(secondStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number format", Toast.LENGTH_SHORT).show();
            return;
        }

        double result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                if (num2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                break;

            default:
                return;
        }


        if (result == (long) result) {
            textResult.setText(String.format("Result: %d", (long) result));
        } else {
            textResult.setText(String.format("Result: %.4f", result));
        }
    }
}