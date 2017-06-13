package com.json.flow;

import com.alibaba.fastjson.JSON;
import com.json.node.NluNode;
import com.json.node.*;
import com.json.node.json.NodeJson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * Created by lingban on 2017/6/5.
 */
public class FlowManager {


    /**
     * 转换成FlowEntity对象
     * @param json
     * @return
     */
    public FlowJson toFlowJson(String json){
        return JSON.parseObject(json, FlowJson.class);
    }

    /**
     * 根据开始节点，获取所有路径
     * @throws IOException
     */
    public List<String> getAllPath(Node startNode, FlowEntity flowEntity){

        return getPath(startNode,flowEntity);
    }

    /**
     * 根据节点获取路径
     * @return
     */
    private List<String> getPath(Node node, FlowEntity flowEntity) {
        // 获取next节点
        Map<String, Node> nextMap = node.getNext(node,flowEntity);
        List<String> roads = new ArrayList<>();
        // 没有子节点，终止返回
        if(nextMap.size()==0){
            return roads;
        }
        // 扩展路径
        for(Map.Entry<String,Node> c: nextMap.entrySet()){
            List<String> path = getPath(c.getValue(), flowEntity);
            if(path.size() ==0){
                String newPath = node.getName() + "-->"+c.getValue().getName();
                roads.add(newPath);
                return roads;
            }
            for(String s:path){
                String newPath = node.getName() + "-->" + s;
                roads.add(newPath);
            }
        }
        return roads;
    }

    public static String getJson() throws IOException {
        String filename = "F:\\1工作\\3项目\\4测试项目\\javaTest2\\src\\main\\java\\com\\json\\用钱宝.json";

        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        String line;
        while((line=br.readLine())!=null){
            sb.append(line);
        }
        return sb.toString();
    }

    public FlowEntity toFlowEntity(FlowJson flowJson) {
        FlowEntity flowEntity = new FlowEntity();
        Map<String,Node> nodes = convertNodes(flowJson);
        flowEntity.setNodes(nodes);
        return flowEntity;
    }

    private Map<String, Node> convertNodes(FlowJson flowJson) {
        Map<String,Node> map = new HashMap<>();
        for(Map.Entry<String,NodeJson> entry: flowJson.getNodes().entrySet()){
            switch(entry.getValue().getType()){
                case "start":
                    StartNode startNode = new StartNode();
                    startNode.setKey(entry.getKey());
                    startNode.setName(entry.getValue().getName());
                    startNode.setType(entry.getValue().getType());
                    startNode.addToLines(flowJson);
                    startNode.addFromLine(flowJson);
                    map.put(entry.getKey(),startNode);
                    break;
                case "end":
                    EndNode endNode = new EndNode();
                    endNode.setKey(entry.getKey());
                    endNode.setName(entry.getValue().getName());
                    endNode.setType(entry.getValue().getType());
                    endNode.addFromLine(flowJson);
                    endNode.addToLines(flowJson);
                    map.put(entry.getKey(),endNode);
                    break;
                case "speak":
                    SpeakNode speakNode = new SpeakNode();
                    speakNode.setKey(entry.getKey());
                    speakNode.setName(entry.getValue().getName());
                    speakNode.setType(entry.getValue().getType());
                    speakNode.addFromLine(flowJson);
                    speakNode.addToLines(flowJson);
                    map.put(entry.getKey(),speakNode);
                    break;
                case "nlu":
                    NluNode nluNode = new NluNode();
                    nluNode.setKey(entry.getKey());
                    nluNode.setName(entry.getValue().getName());
                    nluNode.setType(entry.getValue().getType());
                    nluNode.addFromLine(flowJson);
                    nluNode.addToLines(flowJson);
                    map.put(entry.getKey(),nluNode);
                    break;
                case "listen":
                    ListenNode listenNode = new ListenNode();
                    listenNode.setKey(entry.getKey());
                    listenNode.setName(entry.getValue().getName());
                    listenNode.setType(entry.getValue().getType());
                    listenNode.addFromLine(flowJson);
                    listenNode.addToLines(flowJson);
                    map.put(entry.getKey(),listenNode);
                    break;
                case "judge":
                    JudgeNode judgeNode = new JudgeNode();
                    judgeNode.setKey(entry.getKey());
                    judgeNode.setName(entry.getValue().getName());
                    judgeNode.setType(entry.getValue().getType());
                    judgeNode.addFromLine(flowJson);
                    judgeNode.addToLines(flowJson);
                    map.put(entry.getKey(),judgeNode);
                    break;
                case "operation":
                    OperaNode operaNode = new OperaNode();
                    operaNode.setKey(entry.getKey());
                    operaNode.setName(entry.getValue().getName());
                    operaNode.setType(entry.getValue().getType());
                    operaNode.addFromLine(flowJson);
                    operaNode.addToLines(flowJson);
                    map.put(entry.getKey(),operaNode);
                    break;
            }
        }
        return map;
    }
}
