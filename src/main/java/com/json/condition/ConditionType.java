package com.json.condition;

/**
 * 流程条件
 * Created by lingban on 2017/6/13.
 */
public enum ConditionType {
    EQUALS(1,"equals");

    private Integer code;
    private String value;

    ConditionType(Integer code, String value){
        this.code = code;
        this.value = value;
    }

    public Integer getCode(){
        return this.code;
    }

    public static Integer getCode(String value){
        for(ConditionType type: ConditionType.values()){
            if(type.value.equals(value)){
                return type.code;
            }
        }
        return null;
    }
    public static String getValue(Integer code){
        for(ConditionType type: ConditionType.values()){
            if(type.code.equals(code)){
                return type.value;
            }
        }
        return null;
    }
}
