package com.studymavenspringboot1.study01.mathexam;

public class Parent {
    public String nation;

    public Parent(){
        this("대한민국");
        System.out.println("Parent() call");
    }

    public Parent(String nation){
        this.nation = nation;
        System.out.println("Parent(String nation) call");
    }
}
