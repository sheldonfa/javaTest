package com.json.node;

import com.json.flow.FlowEntity;
import com.json.line.Line;

import java.util.*;

/**
 * Created by lingban on 2017/6/6.
 */
public class StartNode extends Node {

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
