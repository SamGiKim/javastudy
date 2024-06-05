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

    @Test
    public void exam120585() throws Exception{
        System.out.println("exam120585");
        MathExam math = new MathExam();

        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120585(new int[] {}, 150));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120585(new int[] {150, 201}, 130));
        System.out.println(ex2.toString());
        Throwable ex3 = assertThrows(Exception.class, () -> math.exam120585(new int[] {150, 180}, 201));
        System.out.println(ex3.toString());

        assertThat(math.exam120585(new int[] {149, 180, 192, 170}, 167)).isEqualTo(3);
        assertThat(math.exam120585(new int[] {180, 128, 140}, 198)).isEqualTo(0);

    }

    @Test
    public void exam120818() throws Exception{
        MathExam math = new MathExam();

        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120818(9));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120818(1000001));
        System.out.println(ex2.toString());

        assertThat(math.exam120818(150000)).isEqualTo(142500);
        assertThat(math.exam120818(580000)).isEqualTo(464000);
    }

    @Test
    public void exam120837() throws Exception{
        System.out.println("exam120837");
        MathExam math = new MathExam();

        //이 부분은 Exception 확인 부분
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120837(-1));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120837(1001));
        System.out.println(ex2.toString());

        //이 부분은 실제 값과 예상값이 같냐
        assertThat(math.exam120837(23)).isEqualTo(5);
        assertThat(math.exam120837(24)).isEqualTo(6);
        assertThat(math.exam120837(999)).isEqualTo(201);
    }

    @Test
    public void exam120839() throws Exception{
        MathExam math = new MathExam();

        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120839(null));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120839(""));
        System.out.println(ex2.toString());
        Throwable ex3 = assertThrows(Exception.class, () -> math.exam120839("245"));
        System.out.println(ex3.toString());

        assertThat(math.exam120839("2")).isEqualTo("0");
        assertThat(math.exam120839("205")).isEqualTo("052");
    }

    @Test
    public void exam120824() throws Exception{
        MathExam math = new MathExam();

        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120824(null));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120824(new int[] {}));
        System.out.println(ex2.toString());

        assertThat(math.exam120824(new int[] {1, 2, 3, 4, 5})).isEqualTo(new int[] {2,3});
        assertThat(math.exam120824(new int[] {1, 3, 5, 7})).isEqualTo(new int[] {0,4});
    }

    @Test
    public void exam120899() throws Exception{
        MathExam math = new MathExam();

        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120899(null));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120899(new int[] {1,2,1001}));
        System.out.println(ex2.toString());

        assertThat(math.exam120899(new int[] {1, 8, 3})).isEqualTo(new int[] {8,1});
        assertThat(math.exam120899(new int[] {9, 10, 11, 8})).isEqualTo(new int[] {11,2});
    }

    @Test
    public void exam120805() throws Exception{
        MathExam math = new MathExam();

        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120805(-1,1));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120805(1,101));
        System.out.println(ex2.toString());

        assertThat(math.exam120805(10,5)).isEqualTo(2);
        assertThat(math.exam120805(7,2)).isEqualTo(3);

    }

    @Test
    public void exam120810() throws Exception{
        MathExam math = new MathExam();

        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120810(-1,1));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120810(1,101));
        System.out.println(ex2.toString());

        assertThat(math.exam120810(3,2)).isEqualTo(1);
        assertThat(math.exam120810(10,5)).isEqualTo(0);

    }
}