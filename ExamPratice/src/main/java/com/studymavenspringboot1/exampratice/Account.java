package com.studymavenspringboot1.exampratice;

public class Account {
    private String name;
    private String bankNumber;
    private int curt;

    public Account() {
        this.name = getName();
        this.bankNumber = getBankNumber();
        this.curt = getCurt();
    }

    public String getName() {
        return name;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public int getCurt() {
        return curt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public void setCurt(int curt) {
        this.curt = curt;
    }

    /**
     * 계좌 (Account) 를 생성하는 사용자 정의 생성자
     *
     * @param name       : 계좌 대표명
     * @param bankNumber : 계좌번호
     * @param current    : 현재 금액
     */
    public Account(String name, String bankNumber, int current) {
        this.name = name;
        this.bankNumber = bankNumber;
        this.curt = current;
    }

    /**
     * 계좌(Account) 정보(계좌대표명, 계좌번호, 현재금액)를 String 으로 리턴한다.
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Account{name='%s', bankNumber='%s', current=%d}"
                , this.name, this.bankNumber, this.curt);
    }
}
