package com.studymavenspringboot1.study01;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class exam001Test {
    @Test
    public void substruct01() throws Exception{
//        int num1 = -50002;
//        int num2 = 3;
//        int expected = -1;

//        int actual = subTest001(num1, num2);

        assertThat(-1).isEqualTo(subTest001(2,3));
        assertThat(98).isEqualTo(subTest001(100,2));
        assertThat(3).isEqualTo(subTest001(10,7));
        assertThat(29).isLessThan(subTest001(100,70));

    }
    int subTest001(int n1, int n2) throws Exception{
        if(n1 < -50000 || n1 > 50000){
            throw new Exception("num1의 값이 -50000보다 작거나 50000보다 큽니다.");
        }
        if(n2 < -50000 || n2 > 50000){
            throw new Exception("num2의 값이 -50000보다 작거나 50000보다 큽니다.");
        }

        return n1 - n2;
    }
}
