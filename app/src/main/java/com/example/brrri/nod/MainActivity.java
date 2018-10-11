package com.example.brrri.nod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText el1 = (EditText)findViewById(R.id.Num1);
        EditText el2 = (EditText)findViewById(R.id.Num2);

        int num1 = Integer.parseInt(el1.getText().toString()),
                num2 = Integer.parseInt(el2.getText().toString());
        int resNod;

        Log.d(TAG, "Найдём НОД чисел "+num1+" "+num2);
        int a = num1, b = num2;
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        resNod = a;
        Log.d(TAG, "НОД = "+resNod);
        intent.putExtra(EXTRA_MESSAGE, "NOD = "+resNod);
        startActivity(intent);
    }
    }

