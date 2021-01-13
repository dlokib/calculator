package com.example.calculator;

import java.util.StringTokenizer;
import java.util.Scanner;

import com.example.calculator.entity.Calculator;


public class App {
    public static void main( String[] args ) {
      Scanner scanner = new Scanner(System.in);
      Calculator calculator = new Calculator();

      while(true) {
        StringTokenizer st = new StringTokenizer(scanner.nextLine());

        if(st != null && st.hasMoreElements()) {
          calculator.setOperand1(st.nextToken());
          calculator.setOperation(st.nextToken());
          calculator.setOperand2(st.nextToken());

          System.out.println(calculator.getResult());
        } else break;
      }

      scanner.close();
    }
}
