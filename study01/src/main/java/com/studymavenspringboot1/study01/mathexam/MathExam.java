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

    public int exam120837(int hp) throws Exception{
        if(hp < 0 || hp > 1000){
            throw new Exception(String.format("hp는 0~1000이어야 합니다."));
        }

        int strongant = 5;
        int jungant = 3;
        int nomalant = 1;
        int result = 0;

        while (hp > 0) {
            if (hp >= 5) {
                hp -= strongant;
                result++;
            } else if (hp <= 4 && hp > 2) {
                hp -= jungant;
                result++;
            } else if (hp <= 2 && hp > 0) {
                hp -= nomalant;
                result++;
            }
        }
        System.out.println("최소 병력은: " + result);
        return result;
    }

    public String exam120839(String rsp) throws Exception{
        String answer = "";

        if(rsp == null){
            throw new Exception(String.format("rsp는 null이 아니어야 합니다."));
        }
        if(rsp.length() <= 0 || rsp.length() > 100){
            throw new Exception(String.format("rsp[%s}는 0~100 이어야 합니다.", rsp));
        }

        for(int i=0; i<rsp.length(); i++) {
            char ch = rsp.charAt(i);
            if (ch == '2') {
                answer += "0";
            } else if (ch == '0') {
                answer += "5";
            } else if (ch == '5') {
                answer += "2";
            } else {
                throw new Exception(String.format("rsp[%s] 문자는 2, 0, 5중에 하나입니다."));
            }
        }
        return answer;
    }

}