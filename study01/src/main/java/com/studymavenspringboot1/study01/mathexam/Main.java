package com.studymavenspringboot1.study01.mathexam;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
           //exam1566();
            exam1173();
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

    public static void exam1165(){
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int twoban = sc.nextInt();

        for(int i = time; i<90; i+=5){
            twoban++;
        }
        System.out.println(twoban);
    }

    public static void exam1173() throws Exception{
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int mins = sc.nextInt();

        if(hour<0 || hour >= 24){
            throw new Exception(String.format("시간(%d)은 0~24 이어야 합니다.", hour));
        } else if(mins<0 || mins >= 60){
            throw new Exception(String.format("시간(%d)은 0~59 이어야 합니다.", mins));
        }

        mins -= 30;
        if(mins<0){
            if(hour <= 0){
                hour = 23;
            } else {
                hour --;
            }
            mins += 60;
        }
        System.out.println(hour + " " + mins);
    }

    public static void exam1180(){
        Scanner sc = new Scanner(System.in);
        int trash = sc.nextInt();
        int num1 = trash / 10;
        int num2 = trash % 10;
        int result = (num2*10 + num1) * 2;

        if(result >= 100){
            result -= 100;
        }

        System.out.println(result);
        if(result <= 50){
            System.out.println("GOOD");
        } else {
            System.out.println("OH MY GOD");
        }
    }
}
