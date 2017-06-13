package com.json.condition;

/**
 * 条件对象
 * Created by lingban on 2017/6/13.
 */
public class Condition {
    // 条件类型
    private String type;
    // 条件值
    private Integer value;

    public Condition(String type, Integer value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
