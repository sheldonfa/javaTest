package com.json.node;

import com.json.flow.FlowEntity;
import com.json.line.Line;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lingban on 2017/6/6.
 */
public class EndNode extends Node {

    @Override
    public Map<String,Node> getNext(Node node, FlowEntity flowEntity) {
        Map<String, Node> map = new HashMap<>();
        List<Line> toLines = this.getToLines();
        for(Line line: toLines){
            Node n = flowEntity.getNodes().get(line.getToNode());
            map.put(n.getKey(),n);
        }
        return map;
    }
}
