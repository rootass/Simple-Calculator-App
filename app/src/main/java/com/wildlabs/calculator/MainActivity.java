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
    List<String> mDisplayList;
    String lastElement;
    List<Integer> operands;
    List<String> operators;
    boolean isLastInputANumber = false;
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeButtons();
        operands = new ArrayList<>();
        operators = new ArrayList<>();
        mTextView = findViewById(R.id.display);
        mDisplayList = new ArrayList<>();
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
        mTextView.setText("");
        switch (v.getTag().toString()){
            case "0": lastElement = "0";
            combineNumbers("0");
            break;
            case "1": lastElement="1";combineNumbers("1");break;
            case "2": lastElement="2";combineNumbers("2");break;
            case "3": lastElement="3";combineNumbers("3");break;
            case "4": lastElement="4";combineNumbers("4");break;
            case "5": lastElement="5";combineNumbers("5");break;
            case "6": lastElement="6";combineNumbers("6");break;
            case "7": lastElement="7";combineNumbers("7");break;
            case "8": lastElement="8";combineNumbers("8");break;
            case "9": lastElement="9";combineNumbers("9");break;
//            case ".": lastElement=".";combineNumbers(".");break;
            case "+": operands.add(Integer.valueOf(temp));isLastInputANumber=false;printLogs();mDisplayList.add("+");lastElement="+";operators.add("+");break;
            case "-": operands.add(Integer.valueOf(temp));isLastInputANumber=false;printLogs();mDisplayList.add("-");lastElement="-";operators.add("-");break;
            case "x": operands.add(Integer.valueOf(temp));isLastInputANumber=false;printLogs();mDisplayList.add("x");lastElement="x";operators.add("x");break;
            case "÷": operands.add(Integer.valueOf(temp));isLastInputANumber=false;printLogs();mDisplayList.add("÷");lastElement="÷";operators.add("÷");break;
            case "=": calculate();break;
            case "d" : removeLastElement();break;
            case "c" : mDisplayList.clear();operands.clear();operators.clear();temp="";lastElement="";break;
        }
        for(String s: mDisplayList){
            mTextView.append(s);
        }
    }

    public void removeLastElement(){
        mDisplayList.remove(lastElement);
        if(operators.contains(lastElement)){
            System.out.println("was operator");
            operators.remove(lastElement);
        } else{
            System.out.println("was operand");
            operands.remove(Integer.valueOf(lastElement));
        }
        printLogs();
    }

    public void calculate(){
        operands.add(Integer.valueOf(temp));
        if(operators.size()<operands.size()){
            float a = operands.get(0);
            float b = operands.get(1);
            float c=0;
            switch (operators.get(0)){
                case "+": c=a+b;break;
                case "-": c=a-b;break;
                case "x": c=a*b;break;
                case "÷": c=a/b;break;
            }
            lastElement = String.valueOf(c);
            temp = lastElement;
            mDisplayList.clear();
            operands.clear();
            operators.clear();
            mDisplayList.add(String.valueOf(c));
            printLogs();
        } else {
            Toast.makeText(this,"Invalid Operation",Toast.LENGTH_SHORT).show();
        }
    }

    private void printLogs(){
        System.out.println("\n\nOn type, Calculator's Display = "+mDisplayList);
        System.out.println("On type, Temp = "+temp);
        System.out.println("On type, Last Element = "+lastElement);
        System.out.println("On type, Operands = "+operands);
        System.out.println("On type, operators = "+operators+"\n\n");
    }

    private void combineNumbers(String s){

        mDisplayList.add(s);
        if(isLastInputANumber){
            temp = temp+s;
//            operands.add(Integer.valueOf(result));
        } else {
            temp = s;
        }
        isLastInputANumber = true;
        printLogs();
    }

}
