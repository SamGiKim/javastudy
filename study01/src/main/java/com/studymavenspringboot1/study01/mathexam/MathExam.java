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

    public int exam120585(int array[], int height) throws Exception{
        if(array == null || array.length <= 0 || array.length > 100){
            throw new Exception(String.format("array는 null이 아니고, 길이가 1~100이어야 합니다."));
        }
        if(height < 1 || height > 200){
            throw new Exception(String.format("height는 [%d] 1~200 이어야 합니다.", height));
        }
        int count=0;
        for(int i=0; i<array.length; i++){
            if(array[i] <= 0 || array[i] > 200){
                throw new Exception(String.format("array[%d] = [%d] 는 1~200 이어야 합니다", i, array[i]));
            }

            if(array[i] > height){
                count++;
            }
        }

        return count;
    }

    public int exam120818(int price) throws Exception {
        int result = 0;

        if (price >= 10 && price <= 1000000) {
            if(price%10 == 0) {
                if (price >= 100000 && price <= 299999) {
                    result = (int) (price * 0.95);
                }
                if (price >= 300000 && price <= 499999) {
                    result = (int) (price * 0.9);
                }
                if (price >= 500000) {
                    result = (int) (price * 0.8);
                }
            } else{
                throw new Exception(String.format("10원 단위여야 합니다!"));
            }
        } else {
            throw new Exception(String.format("가격은 10원 ~ 1000000원 사이여야 합니다."));
        }
        System.out.println("최종가격:" + result);
        return result;
    }
}