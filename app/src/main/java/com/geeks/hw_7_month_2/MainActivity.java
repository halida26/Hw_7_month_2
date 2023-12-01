package com.geeks.hw_7_month_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.geeks.hw_7_month_2.R;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int x, y, result;
    private boolean isOperationClick;
    private String operation;
    View nextMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_text);
//        nextMenu = findViewById(R.id.next_menu);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        nextMenu.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//            String result = ((TextView) findViewById(R.id.text_view)).getText().toString();
//            intent.putExtra("result", result);
//            startActivity(intent);
//        });
//    }

    public void onNumberClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_one) {
            appendNumber("1");
        } else if (id == R.id.btn_two) {
            appendNumber("2");
        } else if (id == R.id.btn_three) {
            appendNumber("3");
        } else if (id == R.id.btn_four) {
            appendNumber("4");
        } else if (id == R.id.btn_five) {
            appendNumber("5");
        } else if (id == R.id.btn_six) {
            appendNumber("6");
        } else if (id == R.id.btn_seven) {
            appendNumber("7");
        } else if (id == R.id.btn_eight) {
            appendNumber("8");
        } else if (id == R.id.btn_nine) {
            appendNumber("9");
        } else if (id == R.id.btn_zero) {
            appendNumber("0");
        } else if (id == R.id.btn_ac) {
            clearTextView();
        } else if (id == R.id.btn_dot) {
            appendNumber(".");
        }
        isOperationClick = false;
    }

    private void appendNumber(String number) {
        nextMenu.setVisibility(View.INVISIBLE);
        if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(number);
        } else {
            textView.append(number);
        }
    }


    private void clearTextView() {
        textView.setText("0");
    }


    public void onOperationClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_plus) {
            x = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "+";
        } else if (id == R.id.btn_minus) {
            x = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "-";
        } else if (id == R.id.btn_With) {
            x = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "x";
        } else if (id == R.id.btn_division) {
            x = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "/";
        } else if (id == R.id.btn_procent) {
            x = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "%";


            x = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "+/-";
        } else if (id == R.id.btn_plus_minus) {
            x = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "+/-";
        } else if (id == R.id.btn_equals) {
            if (isOperationClick) {
                y = Integer.valueOf(textView.getText().toString());

                switch (operation) {
                    case "+/-":
                        result = x ^ y;
                        break;

                    case "%":
                        result = x % y;
                        break;

                    case "+":
                        result = x + y;
                        break;

                    case "-":
                        result = x - y;
                        break;

                    case "*":
                        result = x * y;
                        break;

                    case "/":
                        result = x / y;
                        break;

                    default:
                        result = 0;
                        break;
                }
                nextMenu.setVisibility(view.getVisibility());


            }
            isOperationClick = true;
        }
    }
}

