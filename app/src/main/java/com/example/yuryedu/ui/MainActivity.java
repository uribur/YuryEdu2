package com.example.yuryedu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.yuryedu.R;
import com.example.yuryedu.model.CalculatorImp;
import com.example.yuryedu.model.Operator;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements CalculatorView {

    private TextView resultTxt;

    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_main);

        resultTxt = findViewById(R.id.resultcalc);

        presenter = new CalculatorPresenter(this, new CalculatorImp());

        this.showResult("0.0");

        Map <Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.key_0,0);
        digits.put(R.id.key_1,1);
        digits.put(R.id.key_2,2);
        digits.put(R.id.key_3,3);
        digits.put(R.id.key_4,4);
        digits.put(R.id.key_5,5);
        digits.put(R.id.key_6,6);
        digits.put(R.id.key_7,7);
        digits.put(R.id.key_8,8);
        digits.put(R.id.key_9,9);


        View.OnClickListener digitCliclListener = view -> presenter.onDigitPressed(digits.get(view.getId()));

        findViewById(R.id.key_0).setOnClickListener(digitCliclListener);
        findViewById(R.id.key_1).setOnClickListener(digitCliclListener);
        findViewById(R.id.key_2).setOnClickListener(digitCliclListener);
        findViewById(R.id.key_3).setOnClickListener(digitCliclListener);
        findViewById(R.id.key_4).setOnClickListener(digitCliclListener);
        findViewById(R.id.key_5).setOnClickListener(digitCliclListener);
        findViewById(R.id.key_6).setOnClickListener(digitCliclListener);
        findViewById(R.id.key_7).setOnClickListener(digitCliclListener);
        findViewById(R.id.key_8).setOnClickListener(digitCliclListener);
        findViewById(R.id.key_9).setOnClickListener(digitCliclListener);



        Map <Integer, Operator> operators = new HashMap<>();
        operators.put(R.id.key_plus, Operator.ADD);
        operators.put(R.id.key_minus,Operator.SUB);
        operators.put(R.id.key_multiply,Operator.MULT);
        operators.put(R.id.key_delete,Operator.DIV);

        View.OnClickListener operatorClicklListener = view -> presenter.onOperatorPressed(operators.get(view.getId()));

        findViewById(R.id.key_plus).setOnClickListener(operatorClicklListener);
        findViewById(R.id.key_minus).setOnClickListener(operatorClicklListener);
        findViewById(R.id.key_multiply).setOnClickListener(operatorClicklListener);
        findViewById(R.id.key_delete).setOnClickListener(operatorClicklListener);


        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.OnDotPressed();
            }
        });


    }


    public void showResult(String result){
        resultTxt.setText(result);
    }


}