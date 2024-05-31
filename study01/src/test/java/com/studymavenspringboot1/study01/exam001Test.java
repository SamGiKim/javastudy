package com.studymavenspringboot1.study01;

import com.studymavenspringboot1.study01.mathexam.MathExam;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exam001Test {
    public void substruct01() throws Exception{
        MathExam math = new MathExam();
//        int num1 = -50002;
//        int num2 = 3;
//        int expected = -1;
//        int actual = subTest001(num1, num2);

        assertThat(-1).isEqualTo(math.subTest001(2,3));
        assertThat(98).isEqualTo(math.subTest001(100,2));
        assertThat(3).isEqualTo(math.subTest001(10,7));
        assertThat(29).isLessThan(math.subTest001(100,70));

        assertThatThrownBy(() -> math.subTest001(70000,7)).isInstanceOf(Exception.class);
        Throwable throwable = assertThrows(RuntimeException.class, () -> math.subTest001(2330,50002));
    }

    @Test
    public void multiply() throws Exception{
        MathExam math = new MathExam();

        assertThat(12).isEqualTo(math.MathTest02(3,4));
        assertThat(513).isEqualTo(math.MathTest02(27,19));
        assertThatThrownBy(() -> math.MathTest02(-1,10)).isInstanceOf(Exception.class);
        assertThatThrownBy(() -> math.MathTest02(10,101)).isInstanceOf(Exception.class);
    }

    @Test
    public void comparison() throws Exception{
        MathExam math = new MathExam();

        assertThat(-1).isEqualTo(math.MathTest04(3,4));
        assertThat(1).isEqualTo(math.MathTest04(11,11));
        assertThat(-1).isEqualTo(math.MathTest04(7,99));
        assertThatThrownBy(() -> math.MathTest04(10,10001)).isInstanceOf(Exception.class);
        assertThatThrownBy(() -> math.MathTest04(-1,101)).isInstanceOf(Exception.class);
    }
}