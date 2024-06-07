package com.studymavenspringboot1.study01.mathexam;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
           //exam1566();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void exam1566() throws Exception{
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();

        BigInteger bigX = BigInteger.valueOf(x);
        BigInteger result = bigX.pow((int) y);
        System.out.println(result);
    }

    public static void exam1166() {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();

        if(x%400 == 0 || (x%4==0 && x%100 !=0)){
            System.out.println("Leap");
        } else{
            System.out.println("Normal");
        }
    }
}
