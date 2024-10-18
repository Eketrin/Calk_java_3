package com.example.calk_3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String oldNumber;
    String operator = "";
    EditText inputText;
    Boolean isNew = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputText = findViewById(R.id.InputText);
    }

    public void clicKNumber(View view) {
        if (isNew){
            inputText.setText("");
        }
        isNew=false;



        String number = inputText.getText().toString();
        if(view.getId() == R.id.Zero)
        {
            number += "0";
        }else if(view.getId() == R.id.One)
        {
            number += "1";
        }else if(view.getId() == R.id.Two)
        {
            number += "2";
        }else if(view.getId() == R.id.Three)
        {
            number += "3";
        }else if(view.getId() == R.id.Four)
        {
            number += "4";
        }else if(view.getId() == R.id.Five)
        {
            number += "5";
        }else if(view.getId() == R.id.Six)
        {
            number += "6";
        } else if(view.getId() == R.id.Seven)
        {
            number += "7";
        } else if (view.getId() == R.id.Eight)
        {
            number += "8";
        }else if (view.getId() == R.id.Nine)
        {
            number += "9";
        }else if (view.getId() == R.id.PlusMinus)
        {
            if(numberIsZero(number)){
                number = "0";
            }else {
                number = (Double.parseDouble(number)*(-1)) + "";
            }

        }else if (view.getId() == R.id.Point)
        {
            if(!dotIsPresent(number)){ //была ли у нас раньше точка
                number += ".";
            }
        }
        inputText.setText(number);
    }

    public boolean numberIsZero(String numder){
        if(numder.equals("0") || numder.equals("")){
            return true;
        }else {
            return  false;
        }
    }
    //была ли у нас раньше точка
    public boolean dotIsPresent(String numder){
        if(numder.indexOf(".") == -1 ){
            return false;
        }else {
            return true;}
    }
    public void Operations(View view) {
        isNew=true;
        oldNumber = inputText.getText().toString();
        if(view.getId() == R.id.Plus)
        {
            operator = "+";
        }else if(view.getId() == R.id.Minus)
        {
            operator = "-";
        }else if(view.getId() == R.id.Delenie)
        {
            operator = "/";
        }else if(view.getId() == R.id.Umnojenie)
        {
            operator = "*";
        }
    }

    public void clickResult(View view) {

        String newNumber = inputText.getText().toString();
        Double result = 0.0;
        if(operator == "+")
        {
            result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
        }else if(operator == "-")
        {
            result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
        }else if(operator == "/")
        {
            result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
        }else if(operator == "*")
        {
            result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
        }

        inputText.setText(result+"");
    }

    public void acClick(View view) {
        inputText.setText("0");
        oldNumber = "";
        isNew = true;
    }

    public void clickProcent(View view) {
        if (operator == ""){
            String number = inputText.getText().toString();
            double temp = Double.parseDouble(number)/100; //если 1 число
            number = temp+"";
            inputText.setText(number);
        }else{
            String newNumber = inputText.getText().toString();
            Double result = 0.0;
            Double Onum = Double.parseDouble(oldNumber);
            Double Nnum = Double.parseDouble(newNumber);
            if(operator == "+")
            {
                result = Onum + Nnum * Onum/100;
            }else if(operator == "-")
            {
                result = Onum - Nnum * Onum/100;
            }else if(operator == "/")
            {
                result = Onum / Nnum * 100;
            }else if(operator == "*")
            {
                result = Onum * Nnum /100;
            }
            inputText.setText(result+"");
            operator = "";
        }
    }
}