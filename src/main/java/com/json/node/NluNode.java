package com.json.node;

import com.json.line.Line;
import com.json.flow.FlowEntity;
import com.json.line.LineStats;
import com.json.node.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 理解结果节点
 * Created by lingban on 2017/6/6.
 */
public class NluNode extends Node {

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
