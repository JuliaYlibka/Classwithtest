package org.example;
import org.apache.commons.lang3.StringUtils;
import org.example.Account.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringUtils.upperCase("Hello and welcome!"));
        Scanner in = new Scanner(System.in);
        Account[] accounts = new Account[10]; // создаем массив для 10 аккаунтов

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i + 1, 10000);
        }

        Account account = new Account(1155, 300000);
        account.setAnnualInterestRate(650);
        account.withdraw(16500);
        account.deposit(50000);
        System.out.println("===================================================");
        System.out.println("Номер счета : " + account.getId());
        System.out.println("Баланс : " + account.getBalance());
        System.out.println("Месячная ставка : " + account.getMonthlyInterest());
        System.out.println("Дата создания : " + account.getDateCreated());

        System.out.println("===================================================");

        Process();


    }
    public static void Process(){
        System.out.println("Запущена имитация работы банковской системы!\n");
        Scanner in = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("Введите ID счета: ");
                int id;
                id = in.nextInt();
                Account currentAccount = Account.findAccountById(Account.getAccounts(), id);

                // Show the main menu
                boolean exitMenu = false;
                while (!exitMenu) {
                    System.out.println("Основное меню\n1: Проверить баланс счета\n2: Снять со счета\n3: Положить на счет\n4: посмотреть транзакции по счету\n5: Выйти");
                    int choice = in.nextInt();

                    switch (choice) {
                        case 1: // Проверка баланса
                            System.out.printf("Баланс счета %d: %.2f\n", id, currentAccount.getBalance());
                            break;
                        case 2: // Снятие со счета
                            System.out.println("Введите сумму для снятия:");
                            double amountWithdraw = in.nextDouble();
                            currentAccount.withdraw(amountWithdraw);
                            break;
                        case 3: // Пополнение счета
                            System.out.println("Введите сумму для пополнения:");
                            double amountDeposit = in.nextDouble();
                            currentAccount.deposit(amountDeposit);
                            break;
                        case 4://сводка по транзакциям
                            try {
                                for (Transaction transaction : currentAccount.getTransactions()) {
                                    System.out.println(transaction);
                                }
                            }
                            catch (NullPointerException e){
                                System.out.println("Нет доступных к чтению транзакций!");
                            }

                            break;
                        case 5: // Выход из меню
                            exitMenu = true;
                            break;
                        default:
                            System.out.println("Неверная команда! Пожалуйста, выберите 1, 2, 3, 4 или 5.");
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Попробуйте еще раз.");
            } catch (java.util.InputMismatchException e) {
                System.out.println("Введите корректный ID!");
                in.next();
            }
        }
    }

}