package org.example;

import java.time.Instant;
import java.util.Date;
import java.util.SplittableRandom;

public class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    Transaction(char type,double amount, double balance, String description){
        this.date=Date.from(Instant.now());
        this.amount = amount;
        this.type = type;
        this.balance = balance;
        this.description= description;
    }
    @Override
    public String toString() {
        return String.format("Транзакция: %s | Сумма: %.2f | Баланс: %.2f | Описание: %s | Дата: %s",
                type == '+' ? "Пополнение" : "Снятие", amount, balance, description, date);
    }
}
