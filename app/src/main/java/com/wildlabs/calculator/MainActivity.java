package com.wildlabs.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;
    Button btn5, btn6, btn7, btn8;
    Button btn9, btn10, btn11, btn12;
    Button btn13, btn14, btn15, btn16;
    TextView mTextView;
    String num="";
    boolean operatorClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeButtons();
        mTextView = (TextView) findViewById(R.id.display);
    }

    public void initializeButtons(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
//        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);
        btn14 = findViewById(R.id.btn14);
        btn15 = findViewById(R.id.btn15);
        btn16 = findViewById(R.id.btn16);
    }

    public void perform(View v){
        switch (v.getTag().toString()){
            case "0": num+="0";mTextView.setText(num);break;
            case "1": num+="1";mTextView.setText(num);break;
            case "2": num+="2";mTextView.setText(num);break;
            case "3": num+="3";mTextView.setText(num);break;
            case "4": num+="4";mTextView.setText(num);break;
            case "5": num+="5";mTextView.setText(num);break;
            case "6": num+="6";mTextView.setText(num);break;
            case "7": num+="7";mTextView.setText(num);break;
            case "8": num+="8";mTextView.setText(num);break;
            case "9": num+="9";mTextView.setText(num);break;
        }
    }

    public void callOperators(View v){
        switch (v.getTag().toString()){
            case "+": if(operatorClicked){againClicked();}num+="+";operatorClicked=true;mTextView.setText(num);break;
            case "-": if(operatorClicked){againClicked();}num+="-";operatorClicked=true;mTextView.setText(num);break;
            case "*": if(operatorClicked){againClicked();}num+="*";operatorClicked=true;mTextView.setText(num);break;
            case "÷": if(operatorClicked){againClicked();}num+="÷";operatorClicked=true;mTextView.setText(num);break;
        }
    }

    public void clear(View v){
        num="";
        mTextView.setText("");
    }

    public void callEquals(View v){
        String op1 = "";
        String op2 = "";
        String operator = "";

        float result=0;
        for(int i=0; i<num.length(); i++){
            char c = num.charAt(i);
            breakApart(c,op1,op2,result,i);
        }
    }

    public void againClicked(){
        String op1 = "";
        String op2 = "";
        String operator = "";

        float result=0;
        for(int i=0; i<num.length(); i++){
            char c = num.charAt(i);
            breakApart(c,op1,op2,result,i);
        }
    }

    public void breakApart(char c, String op1, String op2,float result,int i){
        if(c=='+'||c=='-'||c=='*'||c=='÷'){
            try{
                op1 = num.substring(0,i);
                op2 = num.substring(i+1,num.length());
            } catch (Exception e){return;}
            System.out.println("Op1 = "+op1);
            System.out.println("Op2 = "+op2);
            performMaths(c,op1,op2,result);
        }
    }

    public void performMaths(char c, String op1, String op2, float result){
        switch (c){
            case '+':result=Float.valueOf(op1)+Float.valueOf(op2);break;
            case '-':result=Float.valueOf(op1)-Float.valueOf(op2);break;
            case '*':result=Float.valueOf(op1)*Float.valueOf(op2);break;
            case '÷':result=Float.valueOf(op1)/Float.valueOf(op2);break;
        }
        num=String.valueOf(result);
        System.out.println(String.valueOf(result));
        mTextView.setText(String.valueOf(result));
    }

}