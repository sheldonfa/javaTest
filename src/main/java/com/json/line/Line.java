package com.json.line;

import com.json.condition.Condition;
import com.json.node.Node;

/**
 * Created by lingban on 2017/6/5.
 */
public class Line {

    private String key;
    private String fromNode;
    private String toNode;
    // 条件对象
    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFromNode() {
        return fromNode;
    }

    public void setFromNode(String fromNode) {
        this.fromNode = fromNode;
    }

    public String getToNode() {
        return toNode;
    }

    public void setToNode(String toNode) {
        this.toNode = toNode;
    }
}
