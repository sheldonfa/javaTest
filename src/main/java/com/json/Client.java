package com.json;

import com.json.flow.FlowManager;
import com.json.flow.FlowEntity;
import com.json.node.Node;
import com.json.flow.FlowJson;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by lingban on 2017/6/13.
 */
public class Client {
    /**
     * 转换json为Json对象
     */
    @Test
    public void test1() throws IOException {
        FlowJson flowJson = getFlowJson();
        System.out.println(flowJson);
    }

    /**
     * 转换Json对象为 FlowEntity对象
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        FlowEntity flowEntity = getEntity();
        System.out.println(flowEntity);
    }

    /**
     * 遍历entity对象，获取所有路径
     */
    @Test
    public void test3() throws IOException {
        FlowEntity flowEntity = getEntity();
        System.out.println(flowEntity);
        // 2、获取开始节点
        Map<String, Node> nodes = flowEntity.getNodes();
        Node startNode = nodes.get("flow-content_node_1");
        // 3、获取所有路径
        FlowManager manager = new FlowManager();
        List<String> allPath = manager.getAllPath(startNode,flowEntity);
        // 打印
        for(String str: allPath){
            System.out.println(str);
        }
    }




    private FlowJson getFlowJson() throws IOException {
        String json = FlowManager.getJson();
        FlowManager flow = new FlowManager();
        // 1、转换成实体
        return flow.toFlowJson(json);
    }

    private FlowEntity getEntity() throws IOException {
        String json = FlowManager.getJson();
        FlowManager flow = new FlowManager();
        FlowJson flowJson = flow.toFlowJson(json);
        return flow.toFlowEntity(flowJson);
    }

}
