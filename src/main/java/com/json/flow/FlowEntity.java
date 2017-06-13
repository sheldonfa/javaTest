package com.json.flow;

import com.json.Area;
import com.json.line.Line;
import com.json.node.Node;

import java.util.Map;

/**
 *
 * Created by lingban on 2017/6/5.
 */
public class FlowEntity {

    // 节点
    private Map<String,Node> nodes;

    // 线
    private Map<String,Line>  lines;

    // area
    private Map<String,Area> areas;

    public Map<String, Node> getNodes() {
        return nodes;
    }

    public void setNodes(Map<String, Node> nodes) {
        this.nodes = nodes;
    }

    public Map<String, Line> getLines() {
        return lines;
    }

    public void setLines(Map<String, Line> lines) {
        this.lines = lines;
    }

    public Map<String, Area> getAreas() {
        return areas;
    }

    public void setAreas(Map<String, Area> areas) {
        this.areas = areas;
    }
}
