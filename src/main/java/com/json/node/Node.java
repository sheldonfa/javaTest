package com.json.node;

import com.json.condition.Condition;
import com.json.flow.FlowEntity;
import com.json.flow.FlowJson;
import com.json.line.Line;
import com.json.line.LineJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 节点
 * Created by lingban on 2017/6/5.
 */
public abstract class Node {
    protected String key;
    private String name;
    private String type;
    private String script;
    // 上级line
    private Line fromLine;
    // 下级lines
    private List<Line> toLines = new ArrayList<>();

    public abstract Map<String,Node> getNext(Node node, FlowEntity flowEntity);

    /**
     * 添加toLines
     */
    public void addToLines(FlowJson flowJson) {
        // 封装lines
        for(Map.Entry<String,LineJson> entry : flowJson.getLines().entrySet()){
            if(entry.getValue().getFrom().equals(this.getKey())){
                LineJson lineJson = entry.getValue();
                Line line = new Line();
                // line的key
                line.setKey(entry.getKey());
                // line的条件
                if(lineJson.getName().equals("==")){
                    line.setCondition(new Condition("equals",1));
                }
                // line的fromNode
                line.setFromNode(lineJson.getFrom());
                line.setToNode(lineJson.getTo());

                this.toLines.add(line);
            }
        }
    }

    /**
     * 添加fromLine
     */
    public void addFromLine(FlowJson flowJson) {
        // 封装lines
        // 封装lines
        for(Map.Entry<String,LineJson> entry : flowJson.getLines().entrySet()){
            if(entry.getValue().getFrom().equals(this.getKey())){
                LineJson lineJson = entry.getValue();
                Line line = new Line();
                // line的key
                line.setKey(entry.getKey());
                // line的条件
                if(lineJson.getName().equals("==")){
                    line.setCondition(new Condition("equals",1));
                }
                // line的fromNode
                line.setFromNode(lineJson.getFrom());
                line.setToNode(lineJson.getTo());
                this.fromLine = line;
            }
        }
    }

    public Line getFromLine() {
        return fromLine;
    }

    public void setFromLine(Line fromLine) {
        this.fromLine = fromLine;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public List<Line> getToLines() {
        return toLines;
    }

    public void setToLines(List<Line> toLines) {
        this.toLines = toLines;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
