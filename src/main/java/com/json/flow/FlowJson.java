package com.json.flow;

import com.json.Area;
import com.json.line.Line;
import com.json.line.LineJson;
import com.json.node.json.NodeJson;

import java.util.Map;

/**
 *
 * Created by lingban on 2017/6/5.
 */
public class FlowJson {

    // 节点
    private Map<String,NodeJson> nodes;

    // 线
    private Map<String,LineJson>  lines;

    // area
    private Map<String,Area> areas;

    public Map<String, NodeJson> getNodes() {
        return nodes;
    }

    public void setNodes(Map<String, NodeJson> nodes) {
        this.nodes = nodes;
    }

    public Map<String, LineJson> getLines() {
        return lines;
    }

    public void setLines(Map<String, LineJson> lines) {
        this.lines = lines;
    }

    public Map<String, Area> getAreas() {
        return areas;
    }

    public void setAreas(Map<String, Area> areas) {
        this.areas = areas;
    }
}
