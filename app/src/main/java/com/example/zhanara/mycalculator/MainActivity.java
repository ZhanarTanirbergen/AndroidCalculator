package com.example.zhanara.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView now, str, texthist;
    Button sign, clear, history, backspace, dot, sum, sub, mult, div, equal, c1, c2, c3, c4, c5, c6, c7, c8, c9, c0;
    char operator = ' ';
    String ss = "";
    boolean dotpressed = false, hbutton = false, operpressed = false, nowtrash = false;
    double value1 = 0, value2 = 0, cash = 0;
    List<String> hist = new ArrayList<String>();

    String makeInt(double v){
        if ((int) (v) == v) {
            return (String.valueOf((int) (v)));
        } else
            return (String.valueOf((int) ((v) * 100000000) / (double) 100000000));
    }
    Double doOperation(char oper, double v1, double v2){
        if(oper == '+') {
            hist.add(makeInt(v2) + " + " + makeInt(v1) + " = " + makeInt(v1+v2));
            return v1 + v2;
        }
        if(oper == '-') {
            hist.add(makeInt(v2) + " - " + makeInt(v1) + " = " + makeInt(v2-v1));
            return v2 - v1;
        }
        if(oper == '*') {
            hist.add(makeInt(v2) + " × " + makeInt(v1) + " = " + makeInt(v1*v2));
            return v2 * v1;
        }
        if(oper == '/') {
            hist.add(makeInt(v2) + " ÷ " + makeInt(v1) + " = " + makeInt(v2/v1));
            return v2 / v1;
        }
        return 0.0;
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {

            savedInstanceState.putCharSequence("nowSave", now.getText());
        savedInstanceState.putCharSequence("strSave", str.getText());
        savedInstanceState.putCharSequence("texthistSave", texthist.getText());
        savedInstanceState.putChar("operatorSave", operator);
        savedInstanceState.putString("ssSave", ss);
        savedInstanceState.putBoolean("dotpressedSave", dotpressed);
        savedInstanceState.putBoolean("hbuttonSave", hbutton);
        savedInstanceState.putBoolean("operpressedSave", operpressed);
        savedInstanceState.putBoolean("nowtrashSave", nowtrash);
        savedInstanceState.putDouble("value1Save", value1);
        savedInstanceState.putDouble("value2Save", value2);
        savedInstanceState.putDouble("cashSave", cash);

        super.onSaveInstanceState(savedInstanceState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        now.setText(savedInstanceState.getString("nowSave"));
        str.setText(savedInstanceState.getString("strSave"));
        texthist.setText(savedInstanceState.getString("texthistSave"));
        operator = savedInstanceState.getChar("operatorSave");
        ss = savedInstanceState.getString("ssSave");
        dotpressed = savedInstanceState.getBoolean("dotpressedSave");
        hbutton = savedInstanceState.getBoolean("hbuttonSave");
        operpressed = savedInstanceState.getBoolean("operpressedSave");
        nowtrash = savedInstanceState.getBoolean("nowtrashSave");
        value1 = savedInstanceState.getDouble("value1Save");
        value2 = savedInstanceState.getDouble("value2Save");
        cash = savedInstanceState.getDouble("cashSave");

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        now = (TextView)findViewById(R.id.now);
        str = (TextView)findViewById(R.id.str);
        texthist = (TextView)findViewById(R.id.texthist);

        sum = (Button)findViewById(R.id.sum);
        sub = (Button)findViewById(R.id.sub);
        mult = (Button)findViewById(R.id.mult);
        div = (Button)findViewById(R.id.div);
        equal = (Button)findViewById(R.id.equal);

        dot = (Button)findViewById(R.id.dot);
        sign = (Button)findViewById(R.id.sign);
        backspace = (Button)findViewById(R.id.backspace);
        clear = (Button)findViewById(R.id.clear);
        history = (Button)findViewById(R.id.history);


        c0 = (Button)findViewById(R.id.c0);
        c1 = (Button)findViewById(R.id.c1);
        c2 = (Button)findViewById(R.id.c2);
        c3 = (Button)findViewById(R.id.c3);
        c4 = (Button)findViewById(R.id.c4);
        c5 = (Button)findViewById(R.id.c5);
        c6 = (Button)findViewById(R.id.c6);
        c7 = (Button)findViewById(R.id.c7);
        c8 = (Button)findViewById(R.id.c8);
        c9 = (Button)findViewById(R.id.c9);

        c0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(now.getText() != "0"){
                    if(operpressed && nowtrash){
                        now.setText("");
                        nowtrash = false;
                    }
                    if(now.getText() != "" && now.getText() != "0")
                        now.setText(now.getText() + "0");
                    else now.setText("0");
                    value1 = Double.parseDouble(now.getText().toString());
                    cash = value1;

                }
            }
        });
        c1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operpressed && nowtrash){
                    now.setText("");
                    nowtrash = false;
                }
                if(now.getText().length() <= 9)
                    now.setText(now.getText() + "1");
                value1 = Double.parseDouble(now.getText().toString());
                cash = value1;
            }
        });

        c2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operpressed && nowtrash){
                    now.setText("");
                    nowtrash = false;
                }
                if(now.getText().length() <= 9)
                    now.setText(now.getText() + "2");
                value1 = Double.parseDouble(now.getText().toString());
                cash = value1;
            }
        });
        c3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operpressed && nowtrash){
                    now.setText("");
                    nowtrash = false;
                }
                if(now.getText().length() <= 9)
                    now.setText(now.getText() + "3");
                value1 = Double.parseDouble(now.getText().toString());
                cash = value1;
            }
        });
        c4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operpressed && nowtrash){
                    now.setText("");
                    nowtrash = false;
                }
                if(now.getText().length() <= 9)
                    now.setText(now.getText() + "4");
                value1 = Double.parseDouble(now.getText().toString());
                cash = value1;
            }
        });
        c5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operpressed && nowtrash){
                    now.setText("");
                    nowtrash = false;
                }
                if(now.getText().length() <= 9)
                    now.setText(now.getText() + "5");
                value1 = Double.parseDouble(now.getText().toString());
                cash = value1;
            }
        });
        c6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operpressed && nowtrash){
                    now.setText("");
                    nowtrash = false;
                }
                if(now.getText().length() <= 9)
                    now.setText(now.getText() + "6");
                value1 = Double.parseDouble(now.getText().toString());
                cash = value1;
            }
        });
        c7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operpressed && nowtrash){
                    now.setText("");
                    nowtrash = false;
                }
                if(now.getText().length() <= 9)
                    now.setText(now.getText() + "7");
                value1 = Double.parseDouble(now.getText().toString());
                cash = value1;
            }
        });
        c8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operpressed && nowtrash){
                    now.setText("");
                    nowtrash = false;
                }
                if(now.getText().length() <= 9)
                    now.setText(now.getText() + "8");
                value1 = Double.parseDouble(now.getText().toString());
                cash = value1;
            }
        });
        c9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operpressed && nowtrash){
                    now.setText("");
                    nowtrash = false;
                }
                if(now.getText().length() <= 9)
                    now.setText(now.getText() + "9");
                value1 = Double.parseDouble(now.getText().toString());
                cash = value1;
            }

        });


        dot.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(dotpressed == false && now.getText().length() <= 9){
                    now.setText(now.getText() + ".");
                    dotpressed = true;
                }
            }
        });

        sign.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(now.getText().length() <= 9){
                    double x = Double.parseDouble(now.getText().toString());
                    now.setText(makeInt(-1*x));
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                value1 = 0;
                value2 = 0;
                now.setText("");
                str.setText("");
                dotpressed = false;
                operpressed = false;
            }
        });

        backspace.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(now.getText().length() > 0){
                    String s = "";
                    for(int i = 0; i < now.getText().length() - 1; i++){
                        s = s + now.getText().toString().charAt(i);
                    }
                    now.setText(s);
                }
            }
        });
        history.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(hbutton == false) {
                    texthist.setMovementMethod(new ScrollingMovementMethod());
                    for (int i = 0; i < hist.size(); i++)
                        ss = ss + hist.get(i) + "\n";
                    texthist.setText(ss);
                    hbutton = true;
                }
                else {
                    texthist.setText("");
                    hbutton = false;
                }
            }
        });
        sum.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                str.setText(str.getText() + " " + makeInt(value1));
                if(operpressed){
                    value2 = doOperation(operator, value1, value2);
                    now.setText(makeInt(value2));
                    nowtrash = true;
                    operator = '+';
                }
                else {
                    str.setText(now.getText());
                    now.setText("");
                    operator = '+';
                    dotpressed = false;
                    value2 = cash;
                    operpressed = true;
                }
                str.setText(str.getText() + " +");
            }
        });

        sub.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                str.setText(str.getText() + " " + makeInt(value1));
                if(operpressed){
                    value2 = doOperation(operator, value1, value2);
                    now.setText(makeInt(value2));
                    nowtrash = true;
                    operator = '-';
                }
                else {
                    str.setText(now.getText());
                    operator = '-';
                    dotpressed = false;
                    value2 = cash;
                    operpressed = true;
                    now.setText("");
                }
                str.setText(str.getText() + " -");
            }
        });
        mult.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                str.setText(str.getText() + " " + makeInt(value1));
                if(operpressed){
                    value2 = doOperation(operator, value1, value2);
                    now.setText(makeInt(value2));
                    nowtrash = true;
                    operator = '*';
                }
                else {
                    str.setText(now.getText());
                    operator = '*';
                    dotpressed = false;
                    value2 = cash;
                    operpressed = true;
                    now.setText("");
                }
                str.setText(str.getText() + " ×");
            }
        });

        div.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                str.setText(str.getText() + " " + makeInt(value1));
                if(operpressed){
                    value2 = doOperation(operator, value1, value2);
                    now.setText(makeInt(value2));
                    nowtrash = true;
                    operator = '/';
                }
                else {
                    str.setText(now.getText());
                    operator = '/';
                    dotpressed = false;
                    now.setText("");
                    value2 = cash;
                    operpressed = true;
                }
                str.setText(str.getText() + " /");
            }
        });

        equal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                str.setText("");
                value2 = doOperation(operator, value1, value2);
                if ((int) (value2) == value2) {
                    dotpressed = false;
                }
                now.setText(makeInt(value2));
                cash = value2;
                operpressed = false;
                nowtrash = false;
            }
        });

    }
}
