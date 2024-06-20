package com.studymavenspringboot1.exampratice;



import java.util.ArrayList;
import java.util.List;

public class AccountService {
    /**
     * 계좌 배열 인스턴스 변수 (객체 프로퍼티, 인스턴스 필드)
     */
    private List<Account> acntList = new ArrayList<>();

    /**
     * 계좌 배열 길이를 int 형으로 리턴한다.
     * return Accounts array size (int)
     * @return : Accounts array size (int)
     */
    public int size() {
        return this.acntList.size();
    }

    /**
     * 계좌 목록을 전체 삭제하고 Clear 한다.
     * clear Accounts all array elements. size will be 0.
     */
    public void clear() {
        this.acntList.clear();
    }

    /**
     * 계좌(Account) 배열에 계좌정보(Account) 를 추가한다.
     * @param name : 계좌대표이름
     * @param bankAccount : 계좌번호
     * @param money : 초기금액
     * @return : true or false
     */
    public boolean addAccount(String name, String bankAccount, int money) {
        return this.acntList.add(new Account(name, bankAccount, money));
    }

    /**
     * 계좌(Account) 배열에 계좌정보(Account) 를 추가한다.
     * @param account : 계좌정보 Account 객체
     * @return : true or false
     */
    public boolean addAccount(Account account) {
        return this.acntList.add(account);
    }

    /**
     * 계좌 배열을 리턴한다.
     * return Accounts Array List
     * @return
     */
    public List<Account> getAllAccount() {
        return this.acntList;
    }

    /**
     * 계좌번호로 찾은 계좌에 예금을 한다.
     * @param bankAccount : 계좌번호
     * @param money : 예금액
     * @return : 성공일때 true, 실패하면 false
     */
    public boolean deposit(String bankAccount, int money) {
        Account account = this.findAccountByNumber(bankAccount);
        if ( account == null ) {
            return false;
        }
        if( money > 0) {
            account.setCurt(account.getCurt() + money);
            return true;
        }
        else {
            System.out.println("입금 금액은 0원보다 커야 합니다.");
            return false;
        }
    }

    /**
     * 계좌번호로 찾은 계좌에 출금을 한다. 현재금액보다 출금액은 커야 한다.
     * @param bankAccount : 계좌번호
     * @param money : 출금액
     * @return : 성공일때 true, 실패하면 false
     */
    public boolean withdraw(String bankAccount, int money) {
        Account account = this.findAccountByNumber(bankAccount);
        if ( account == null ) {
            return false;
        }
        if ( account.getCurt() >= money ) {
            account.setCurt(account.getCurt() - money);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 계좌번호로 계좌(Account)를 찾아서 리턴한다. 계좌번호가 없으면 null 을 리턴한다.
     * @param bankAccount : 찾을 계좌번호
     * @return : Account 객체, 찾지 못하면 null
     */
    public Account findAccountByNumber( String bankAccount ) {
        if ( bankAccount == null || bankAccount.isEmpty() ) {
            return null;
        }
        for ( Account account : acntList) {
            if ( bankAccount.equals(account.getBankNumber()) ) {
                return account;
            }
        }
        return null;
    }
}
