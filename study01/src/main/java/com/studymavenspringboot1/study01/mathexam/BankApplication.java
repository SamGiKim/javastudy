package com.studymavenspringboot1.study01.mathexam;

import java.util.Scanner;

public class BankApplication {
    String Account[] = new String[100];
    String AccountName[] = new String[100];
    int Money[] = new int[100];
    int i = 0;

    public BankApplication() {

    }
    public void makeAccount( String account, String accountName, int money ) {
        this.Account[i] = account;
        this.AccountName[i] = accountName;
        this.Money[i] = money;
        i++;
        System.out.println("결과 : 계좌가 생성되었습니다.");
    }
    public void checkAccount() {

        for (int j = 0; j < i; j++) {
            System.out.println(Account[j] + " " + AccountName[j] + " " + Money[j]);
        }
    }
    public void plusMoney( String account, int plusMoney ){
        for ( int k = 0; k < i; k++){
            if( Account[k].equals(account)) {
                Money[k] += plusMoney;
            }
        }
    }
    public void minusMoney( String account, int minusMoney) {
        for ( int k = 0; k < i; k++){
            if( Account[k].equals(account)) {
                Money[k] -= minusMoney;
            }
        }
        System.out.println("결과: 출금이 성공되었습니다.");
    }
    public static void main(String args[]) {
        Scanner x = new Scanner(System.in);
        boolean a = true;
        BankApplication b = new BankApplication();
        while (a) {
            System.out.println("---------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("---------------------------------------------");
            System.out.print("선택> ");
            int input = x.nextInt();
            System.out.println("--------");
            switch (input) {
                case 1:
                    System.out.println("계좌생성");
                    System.out.println("--------");
                    String str = x.nextLine();
                    System.out.print("계좌번호: ");
                    String account = x.nextLine();
                    System.out.print("계좌주: ");
                    String accountName = x.nextLine();
                    System.out.print("초기입금액: ");
                    int money = x.nextInt();
                    b.makeAccount(account, accountName, money);
                    break;
                case 2:
                    b.checkAccount();
                    break;
                case 3:
                    System.out.println("예금");
                    System.out.println("--------");
                    str = x.nextLine();
                    System.out.print("계좌번호: ");
                    account = x.nextLine();
                    System.out.print("예금액: ");
                    int plusMoney = x.nextInt();
                    b.plusMoney(account, plusMoney);
                    break;
                case 4:
                    System.out.println("출금");
                    System.out.println("--------");
                    str = x.nextLine();
                    System.out.print("계좌번호: ");
                    account = x.nextLine();
                    System.out.print("출금액: ");
                    int minusMoney = x.nextInt();
                    b.minusMoney(account, minusMoney);
                    break;
                case 5:
                    a = false;
                    System.out.println("프로그램 종료");
                    break;
            }
        }


    }
}