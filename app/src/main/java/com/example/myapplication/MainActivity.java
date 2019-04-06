package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn0, btn4, btn5, btn6, btn7, btn8, btn9, btnMul, btnSub, btnDiv, btnAdd;
    TextView txtPerform;
    String num = "", num2 = "";
    boolean ifOperatorClicked=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);

        txtPerform = findViewById(R.id.txtPerform);
    }


    public void calCheck(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                num += btn0.getText().toString();
                txtPerform.setText(num);
                break;
            case R.id.btn1:
                num += btn1.getText().toString();
                txtPerform.setText(num);
                break;
            case R.id.btn2:
                num += btn2.getText().toString();
                txtPerform.setText(num);
                break;
            case R.id.btn3:
                num += btn3.getText().toString();
                txtPerform.setText(num);
                break;
            case R.id.btn4:
                num += btn4.getText().toString();
                txtPerform.setText(num);
                break;
            case R.id.btn5:
                num += btn5.getText().toString();
                txtPerform.setText(num);
                break;
            case R.id.btn6:
                num += btn6.getText().toString();
                txtPerform.setText(num);
                break;
            case R.id.btn7:
                num += btn7.getText().toString();
                txtPerform.setText(num);
                break;
            case R.id.btn8:
                num += btn8.getText().toString();
                txtPerform.setText(num);
                break;
            case R.id.btn9:
                num += btn9.getText().toString();
                txtPerform.setText(num);
                break;
        }
    }

    public void calFun (View v){
        switch (v.getId()) {
            case R.id.btnMul:
                if(ifOperatorClicked){calEqual(btn0);}
                num = num + " * ";
                txtPerform.setText(num);
                ifOperatorClicked = true;
                break;

            case R.id.btnAdd:
                if(ifOperatorClicked){calEqual(btn0);}
                num = num + " + ";
                txtPerform.setText(num);
                ifOperatorClicked = true;
                break;
            case R.id.btnSub:
                if(ifOperatorClicked){calEqual(btn0);}
                num = num + " - ";
                txtPerform.setText(num);
                ifOperatorClicked = true;
                break;

            case R.id.btnDiv:
                if(ifOperatorClicked){calEqual(btn0);}
                num = num + " / ";
                txtPerform.setText(num);
                ifOperatorClicked = true;
                break;
        }
    }

    public void calEqual (View v){
        int myRes = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            breakApart(c,i,myRes);
        }
    }

    public void breakApart(char c,int i, int myRes){
        String one = "";
        String two = "";
        String myOperator = "";
        if (c == '*' || c == '+' || c == '/' || c == '-') {
            myOperator = String.valueOf(c);
            one = num.substring(0, i);
            two = num.substring(i + 2, num.length());
            System.out.println("One ="+one+", two ="+two);
            performMaths(myOperator,one,two,myRes);
        }
    }

    public void performMaths(String myOperator, String one, String two, int myRes){
        switch (myOperator) {
            case "*": myRes = Integer.parseInt(one.trim()) * Integer.parseInt(two.trim());break;
            case "-": myRes = Integer.parseInt(one.trim()) - Integer.parseInt(two.trim());break;
            case "+": myRes = Integer.parseInt(one.trim()) + Integer.parseInt(two.trim());break;
            case "/": myRes = Integer.parseInt(one.trim()) / Integer.parseInt(two.trim());break;
        }
        num = String.valueOf(myRes);
        txtPerform.setText(num);
    }

    public void calClear (View v){
        num = "";
        txtPerform.setText("");
    }
}