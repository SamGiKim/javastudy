package com.studymavenspringboot1.exampratice;

import java.util.Scanner;

public class BankApplicationNew {
    private AccountService accountService = new AccountService();

    private void mainHeader() {
        System.out.println("======================================");
        System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
        System.out.println("======================================");
    }

    private int getSelect(Scanner input) throws Exception {
        System.out.print("선택 > ");
        String a = input.nextLine();
        return Integer.parseInt(a);
    }

    private void accountProduction(Scanner input) throws Exception {
        System.out.println("---------");
        System.out.println(" 계좌생성 ");
        System.out.println("---------");

        System.out.print("계좌번호:");
        String bankNumber = input.nextLine();
        System.out.print("계좌주:");
        String name = input.nextLine();
        System.out.print("초기입금액:");
        String current = input.nextLine();
        int money = Integer.parseInt(current);

        this.accountService.addAccount(new Account(name, bankNumber, money));
    }

    private void accountInventory() {
        for ( Account account : this.accountService.getAllAccount() ) {
            System.out.println(account.toString());
        }
    }

    private void saving(Scanner input) throws Exception {
        Account result = inputConsole(input, "예금");
        if ( result == null ) {
            System.out.println("에러: 계좌가 존재하지 않습니다.");
            return;
        }
        if ( this.accountService.deposit(result.getBankNumber(), result.getCurt()) ) {
            System.out.println("결과: 예금이 성공되었습니다.");
        }
    }

    private void withdraw(Scanner input) throws Exception {
        Account result = inputConsole(input, "출금");
        if ( result == null ) {
            System.out.println("에러: 계좌가 존재하지 않습니다.");
            return;
        }
        if ( this.accountService.withdraw(result.getBankNumber(), result.getCurt()) ) {
            System.out.println("결과: 출금이 성공되었습니다.");
        } else {
            System.out.println("에러: 출금이 안되었습니다.");
        }
    }

    private Account inputConsole(Scanner input, String title) {
        System.out.println("---------");
        System.out.println(title);
        System.out.println("---------");

        System.out.print("계좌번호:");
        String bankNumber = input.nextLine();
        Account account = this.accountService.findAccountByNumber(bankNumber);
        if ( account == null ) {
            return null;
        }
        System.out.print(title + "액:");
        String current = input.nextLine();
        int money = Integer.parseInt(current);

        return new Account("임시명", bankNumber, money);
    }



    public static void main(String[] args) {
        try {
            BankApplicationNew bapp = new BankApplicationNew();
            Scanner input = new Scanner(System.in);
            boolean run = true;
            while(run) {
                bapp.mainHeader();
                int choice = bapp.getSelect(input);
                switch (choice) {
                    case 1:
                        bapp.accountProduction(input);
                        break;
                    case 2:
                        bapp.accountInventory();
                        break;
                    case 3:
                        bapp.saving(input);
                        break;
                    case 4:
                        bapp.withdraw(input);
                        break;
                    case 5:
                        run = false;
                        break;
                    default:
                        System.out.println("!!! 잘못된 입력입니다. !!!");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
