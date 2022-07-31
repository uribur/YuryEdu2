package com.example.yuryedu.ui;

import com.example.yuryedu.model.Calculator;
import com.example.yuryedu.model.Operator;

public class CalculatorPresenter {
    private CalculatorView view;
    private Calculator calculator;

    private double arg1;
    private Double arg2;

    private Operator selectedOperator;

    private boolean dotpressed = false;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDigitPressed(Integer digit) {

        if (arg2 == null) {
            arg1 = arg1 * 10 + digit;
            view.showResult(String.valueOf(arg1));
        } else {
            arg2 = arg2 * 10 + digit;
            view.showResult(String.valueOf(arg2));
        }

    }

    public void onOperatorPressed(Operator operator) {
        if (selectedOperator != null) {
            arg1 = calculator.perform(arg1, arg2, selectedOperator);
            view.showResult(String.valueOf(arg1));
        } else {

        }
        arg2 = 0.0;
        selectedOperator = operator;
        dotpressed = false;
    }

    public void OnDotPressed() {
        dotpressed = true;
    }
}
