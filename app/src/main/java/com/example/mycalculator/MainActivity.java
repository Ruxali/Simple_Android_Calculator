package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumber = "";
    String newNumber = "";
    String displayNumber = "";
    String op ="";
    boolean isNewOpt = true;
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ed1);
    }

    public void numberEvent(View view) {
        if(isNewOpt)
            ed1.setText("");
        isNewOpt = false;

        String number = ed1.getText().toString().trim();

        switch(view.getId()){
            case R.id.oneBtn:
                number += "1";
                break;

            case R.id.twoBtn:
                number += "2";
                break;

            case R.id.threeBtn:
                number += "3";
                break;

            case R.id.fourBtn:
                number += "4";
                break;

            case R.id.fiveBtn:
                number += "5";
                break;

            case R.id.sixBtn:
                number += "6";
                break;

            case R.id.sevenBtn:
                number += "7";
                break;

            case R.id.eightBtn:
                number += "8";
                break;

            case R.id.nineBtn:
                number += "9";
                break;

            case R.id.zeroBtn:
                number += "0";
                break;

            case R.id.dotBtn:
                number += ".";
                break;

            case R.id.plusMinusBtn:
                number = "-" + number;
                break;
        }

        ed1.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOpt= true;
        oldNumber = ed1.getText().toString().trim();

        switch (view.getId()){
            case R.id.addBtn:
                op="+";
                break;

            case R.id.subtractBtn:
                op="-";
                break;

            case R.id.multiplyBtn:
                op="×";
                break;

            case R.id.divideBtn:
                op="÷";
                break;

        }
        ed1.setText(op);
    }

    public void equalsEvent(View view) {
         newNumber = ed1.getText().toString().trim();
         double result = 0.0;

         switch (op){
             case "+":
                 result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                 break;

             case "-":
                 result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                 break;

             case "×":
                 result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                 break;

             case "÷":
                 result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                 break;
         }

         ed1.setText(result + "");
    }

    public void clearEvent(View view) {
        ed1.setText("0");
        isNewOpt = true;
    }

    public void percentEvent(View view) {
        double percentNum = Double.parseDouble(ed1.getText().toString().trim())/100;
        ed1.setText(percentNum + "");
        isNewOpt = true;
    }

    public void deleteEvent(View view) {
        displayNumber = ed1.getText().toString().trim();
        int length = displayNumber.length();
        if(length>0){
            displayNumber = displayNumber.substring(0,length-1);
            ed1.setText(displayNumber);
        }
    }
}