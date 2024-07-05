package com.example.phoneb;

public enum ECategory {
    Friends(0),
    Families(1),
    Schools(2),
    Jobs(3),
    Hobbies(4);

    private final Integer val;
    ECategory(Integer val){
        this.val=val;
    }
    public Integer getVal(){
        return this.val;
    }

    private static final ECategory[] ECategoryArray = ECategory.values();
    public static ECategory integerOf(Integer val){
        for(ECategory item : ECategoryArray){
            if(item.getVal() == val){
                return item;
            }
        }
        throw new IllegalArgumentException("ECategory value : " + val);
    }
}
