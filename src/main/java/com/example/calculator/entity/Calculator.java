package com.example.calculator.entity;

import com.example.calculator.entity.RomanNumbers;


public class Calculator {
  private class Operand {
    private int value;
    private boolean type;

    public Operand(String number) {
      try {
        value = Integer.parseInt(number);
        type = true;
      } catch(NumberFormatException e) {
        value = RomanNumbers.toArabic(number);
        type = false;
      }
    }

    public int getValue() {
      return value;
    }

    public boolean getType() {
      return type;
    }
  }

  private Operand operand1;
  private Operand operand2;
  private String operation;

  public Calculator() {}

  public void setOperand1(String value) {
    operand1 = new Operand(value);
  }

  public void setOperand2(String value) {
    operand2 = new Operand(value);
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getResult() {
    int result = 0;

    if(operand1.getType() == operand2.getType()) {
      switch(operation) {
        case "*": result = operand1.getValue() * operand2.getValue(); break;
        case "/": result = operand1.getValue() / operand2.getValue(); break;
        case "+": result = operand1.getValue() + operand2.getValue(); break;
        case "-": result = operand1.getValue() - operand2.getValue(); break;
      }
    } else throw new IllegalArgumentException("The types of the arguments are not equal");

    return operand1.getType() ? String.valueOf(result) : RomanNumbers.toRoman(result);
  }
}
