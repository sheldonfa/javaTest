package com.json.line;

/**
 * line统计
 * Created by lingban on 2017/6/13.
 */
public class LineStats {

    private Line line;
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public void addCount(){
        count++;
    }
}
