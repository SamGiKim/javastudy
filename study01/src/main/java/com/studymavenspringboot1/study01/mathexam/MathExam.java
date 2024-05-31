package com.studymavenspringboot1.study01.mathexam;

public class MathExam {
    public int subTest001(int n1, int n2) throws Exception{
        if(n1 < -50000 || n1 > 50000){
            throw new Exception("num1의 값이 -50000보다 작거나 50000보다 큽니다.");
        }
        if(n2 < -50000 || n2 > 50000){
            throw new RuntimeException("num2의 값이 -50000보다 작거나 50000보다 큽니다.");
        }
        return n1 - n2;
    }

    public int MathTest02(int n1, int n2) throws Exception{
        if(n1 < 0 || n1 > 100){
            throw new Exception("num1 값은 0~100 사이의 값 이어야 합니다.");
        }
        if(n2 < 0 || n2 > 100){
            throw new Exception("num2 값은 0~100 사이의 값 이어야 합니다.");
        }

        return n1 * n2;
    }

    public int MathTest04(int n1, int n2) throws Exception{
        if(n1 < 0 || n1 > 10000){
            throw new Exception("num1 값은 0~10000 사이의 값 이어야 합니다.");
        }
        if(n2 < 0 || n2 > 10000){
            throw new Exception("num2 값은 0~10000 사이의 값 이어야 합니다.");
        }

        if(n1 == n2){
            return 1;
        } else{
            return -1;
        }
    }
}
