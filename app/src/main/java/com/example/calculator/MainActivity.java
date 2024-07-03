package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double firstNum, secondNum;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button num0 = findViewById(R.id.num0);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);

        Button on = findViewById(R.id.on);
        Button off = findViewById(R.id.off);
        Button ac = findViewById(R.id.ac);
        Button del = findViewById(R.id.del);
        Button div = findViewById(R.id.div);
        Button times = findViewById(R.id.times);
        Button min = findViewById(R.id.min);
        Button equal = findViewById(R.id.equal);
        Button plus = findViewById(R.id.plus);
        Button point = findViewById(R.id.point);

        TextView screen = findViewById(R.id.screen);

        ac.setOnClickListener(view -> {
            firstNum = 0;
            secondNum = 0;
            operation = "";
            screen.setText("0");
        });

        off.setOnClickListener(view -> screen.setVisibility(View.GONE));
        on.setOnClickListener(view -> {
            screen.setVisibility(View.VISIBLE);
            screen.setText("0");
        });

        View.OnClickListener numberClickListener = view -> {
            Button button = (Button) view;
            String buttonText = button.getText().toString();
            if (screen.getText().toString().equals("0") || screen.getText().toString().equals(operation)) {
                screen.setText(buttonText);
            } else {
                screen.setText(screen.getText().toString() + buttonText);
            }
        };

        num0.setOnClickListener(numberClickListener);
        num1.setOnClickListener(numberClickListener);
        num2.setOnClickListener(numberClickListener);
        num3.setOnClickListener(numberClickListener);
        num4.setOnClickListener(numberClickListener);
        num5.setOnClickListener(numberClickListener);
        num6.setOnClickListener(numberClickListener);
        num7.setOnClickListener(numberClickListener);
        num8.setOnClickListener(numberClickListener);
        num9.setOnClickListener(numberClickListener);

        View.OnClickListener operatorClickListener = view -> {
            Button button = (Button) view;
            firstNum = Double.parseDouble(screen.getText().toString());
            operation = button.getText().toString();
            screen.setText(operation);
        };

        div.setOnClickListener(operatorClickListener);
        times.setOnClickListener(operatorClickListener);
        min.setOnClickListener(operatorClickListener);
        plus.setOnClickListener(operatorClickListener);

        del.setOnClickListener(view -> {
            String num = screen.getText().toString();
            if (num.length() > 1) {
                screen.setText(num.substring(0, num.length() - 1));
            } else if (num.length() == 1 && !num.equals("0")) {
                screen.setText("0");
            }
        });

        point.setOnClickListener(view -> {
            if (!screen.getText().toString().contains(".")) {
                screen.setText(screen.getText().toString() + ".");
            }
        });

        equal.setOnClickListener(view -> {
            if (!screen.getText().toString().equals(operation)) {
                secondNum = Double.parseDouble(screen.getText().toString());
                double result = 0;

                switch (operation) {
                    case "/":
                        result = firstNum / secondNum;
                        break;
                    case "X":
                    case "*":
                        result = firstNum * secondNum;
                        break;
                    case "+":
                        result = firstNum + secondNum;
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        break;
                }

                screen.setText(String.valueOf(result));
                firstNum = result;
                secondNum = 0;
                operation = "";
            }
        });
    }
}
