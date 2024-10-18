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

    EditText inputText;
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
        }
        inputText.setText(number);
    }
}