package com.json.node;

import com.json.flow.FlowEntity;
import com.json.line.Line;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作节点
 * @author fangxin
 * @date 2017/6/6.
 */
public class OperaNode extends Node {

    private Integer count = 0;

    public Integer getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }


    public Map<String,Node> getNext(Node node, FlowEntity flowEntity) {
        Map<String, Node> map = new HashMap<>();

        // operateNode在getNext的时候，自身需要运算
        String script = node.getScript();
        if(script.contains("++")){
            count++;
        }
        List<Line> toLines = this.getToLines();
        for(Line line: toLines){
            Node n = flowEntity.getNodes().get(line.getToNode());
            map.put(n.getKey(),n);
        }
        return map;
    }
}
