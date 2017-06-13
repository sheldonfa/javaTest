package com.json.node;

import com.json.flow.FlowEntity;
import com.json.line.Line;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fangxin
 * @date 2017/6/6.
 */
public class JudgeNode extends Node {

    // 上级line
    private Line fromLine;
    // 下级lines
    private List<Line> toLines;

    public Map<String,Node> getNext(Node node, FlowEntity flowEntity) {
        Map<String, Node> map = new HashMap<>();
        List<Line> toLines = this.getToLines();
        Line fromLine = this.getFromLine();
        OperaNode fromNode = (OperaNode) flowEntity.getNodes().get(fromLine.getFromNode());
        Integer count = fromNode.getCount();
        for(Line line: toLines){
            // 判断符合判断的路径
            if(line.getCondition().getValue().equals(count)){
                map.put(line.getToNode(), flowEntity.getNodes().get(line.getToNode()));
            }
        }
        return map;
    }
}
