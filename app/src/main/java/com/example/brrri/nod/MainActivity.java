package com.example.brrri.nod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.content.Intent;
import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String KEY_NUM1 = "NUM1";
    private static final String KEY_NUM2 = "NUM2";
    int num1,num2,nod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "Экранчик перевернули, но значения переменных мы сохраним");
        Log.d(TAG, "num1 = "+ num1);
        outState.putInt(KEY_NUM1, num1);
        Log.d(TAG, "num2 = " + num2);
        outState.putInt(KEY_NUM2, num2);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText el1 = (EditText)findViewById(R.id.Num1);
        EditText el2 = (EditText)findViewById(R.id.Num2);
        NOD res = new NOD();

        if( el1.getText().toString().equals("") || el2.getText().toString().equals("") ) {
             Log.d(TAG, "Данные не ввели, ну значит НОД = 0");
            intent.putExtra(EXTRA_MESSAGE, "NOD = "+0);
            startActivity(intent);
        }

        else {
            num1 = Integer.parseInt(el1.getText().toString());
            num2 = Integer.parseInt(el2.getText().toString());
            Log.d(TAG, "Найдём НОД чисел "+num1+" "+num2);
            nod = res.resNod(num1,num2);
            Log.d(TAG, "НОД = "+nod);
            intent.putExtra(EXTRA_MESSAGE, "NOD = "+nod);
            startActivity(intent);
        }
        res.showList();


    }
    public class NOD {
        private LinkedList <Integer> nodList = new LinkedList <Integer>();

        public int resNod (int num1,int num2){
            nodList.add(num1);
            nodList.add(num2);
            while (num2 !=0) {
                int tmp = num1%num2;
                num1 = num2;
                num2 = tmp;
            }
            nodList.add(num1);
            return num1;
        }

        public void showList(){
            System.out.println(nodList);
        }

        public void clearList(){
            nodList.clear();
        }
    }
    }
