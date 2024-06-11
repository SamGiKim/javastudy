package com.studymavenspringboot1.study01.mathexam;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
           //exam1566();
            //exam1173();
            //exam1218();
            //exam1205();
            exam3015();
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

    public static void exam1205(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result1 = a+b;
        int result2 = a-b;
        int result2_1 = b-a;
        int result3 = a*b;
        int result4 = a/b;
        int result4_2 = b/a;
        double result5 = Math.pow(a,b);
        double result5_2 = Math.pow(b,a);

        double array[] = {result1, result2, result2_1, result3, result4, result4_2, result5, result5_2 };
//        double max = array[0];
//        for(int i=0; i< array.length; i++){
//            if(max < array[i]){
//                max = array[i];
//            }
//        }
        Arrays.sort(array);
//        System.out.printf("%.6f", max);
        System.out.printf("%.6f", array[array.length-1]);
    }

    public static void exam1214(){
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int lastday = 0;

        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||  month == 10 || month == 12 ){
            lastday = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            lastday = 30;
        } else if (month == 2) {
            if(year%400 == 0 || (year%4==0 && year%100 !=0)){
                lastday = 29;
            } else{
                lastday = 28;
            }
        }
        System.out.println(lastday);
    }

    public static void exam1218() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a + b > c) {
            if (a == b && b == c) {
                System.out.println("정삼각형");
            } else if (a == b || b == c) {
                System.out.println("이등변삼각형");
            } else if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                System.out.println("직각삼각형");
            } else {
                System.out.println("삼각형");
            }
        } else {
            System.out.println("삼각형아님");
        }
    }

    public static void exam1226(){
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[7];
        int n;
        int correct = 0;
        int bonus_correct = 0;
        String s = "";

        for(int i=0;i<7;i++){
            arr[i] = scan.nextInt();
        }

        for(int i=0;i<6;i++){
            n = scan.nextInt();
            for(int j=0;j<7;j++){
                if(arr[j]==n){
                    if(j==6) bonus_correct++;
                    else correct++;
                }
            }
        }

        if(correct<=2) s = "0";
        else if(correct==3) s = "5";
        else if(correct==4) s = "4";
        else if(correct==5&&bonus_correct==0) s = "3";
        else if(correct==5&&bonus_correct==1) s = "2";
        else if(correct==6) s = "1";
        System.out.printf(s);
    }

    public static void exam3015(){
        Scanner sc = new Scanner(System.in);
        int dataCount = sc.nextInt();
        int displayCount = sc.nextInt();

        Student[] students = new Student[dataCount];
        for(int i=0; i<dataCount; i++){
            Student student = new Student();
            student.name = sc.next();
            student.score = sc.nextInt();
            students[i] = student;
        }

        for(int i=students.length -1; i>0; i--){
            for(int j =0; j<i; j++){
                if(students[j].score < students[j+1].score){
                    Student lowScore = students[j];
                    students[j] = students[j+1];
                    students[j+1] = lowScore;
                }
            }
        }
        for(int i=0; i<displayCount; i++){
            System.out.println(students[i].name);
        }
    }
}
