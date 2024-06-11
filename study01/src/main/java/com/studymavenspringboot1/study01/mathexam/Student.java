package com.studymavenspringboot1.study01.mathexam;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class Student {
    public String name; // 멤버변수(필드)는 무조건 private
    public int score; // Getter, Setter tkdyd

    @Override
    public String toString(){
        return String.format("%s", name);
    }
}
