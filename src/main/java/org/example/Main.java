package org.example;
import org.apache.commons.lang3.StringUtils;
import org.example.Account.*;


import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println(StringUtils.upperCase("Hello and welcome!"));
        String end = "exit";
Scanner in = new Scanner(System.in);
        while (!end.equals(in.nextLine().trim())) {
            Account first = new Account(1155, 300000);
            first.setAnnualInterestRate(650);
            first.withdraw(16500);
            first.deposit(50000);
            System.out.println("===================================================");
            System.out.println("Номер счета : " + first.getId());
            System.out.println("Баланс : " + first.getBalance());
            System.out.println("Месячная ставка : " + first.getMonthlyInterest());
            System.out.println("Дата создания : " + first.getDateCreated());

            System.out.println("===================================================");

        }
    }
    public static boolean IsExample(int a){
        if (a>1 && a<9)
            return true;
        else return false;
    }


}