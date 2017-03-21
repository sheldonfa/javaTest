package com.algorithmsforimock.c5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 二分搜索树
 * 特点：大于左子结点，小于右子节点
 */
public class BinarySearchTree {

    // 节点的结构体
    public class Node{
        int key;
        String value;
        Node left;
        Node right;

        public Node(int key,String value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int count;

    public BinarySearchTree() {
        root = null;
        count = 0;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count==0;
    }

    public void insert(int key, String value){
        root = insert(root,key,value);
    }

    // 向以node为根的二叉搜索树中，插入节点(key,value)
    // 返回插入新节点后的二叉搜索树的根
    private Node insert(Node node,int key, String value){
        if(node==null){
            count++;
            return new Node(key,value);
        }

        if(key==node.key){
            node.value = value;
        }else if(key < node.key){
            node.left = insert(node.left, key, value);
        }else if(key>node.key){
            node.right = insert(node.right,key,value);
        }
        return node;
    }

    public boolean contain(int key){
        return contain(root,key);
    }

    // 查看以node为根的二叉搜索树中是否包含键值为key的节点
    private boolean contain(Node node, int key){
        if(node==null){
            return false;
        }
        if(key==node.key){
            return true;
        }else if(key<node.key){
            return contain(node.left,key);
        }else{
            return contain(node.right,key);
        }
    }

    Node search(int key){
        return search(root, key);
    }

    Node search(Node node,int key){
        if(node==null){
            return null;
        }
        if(key==node.key){
            return node;
        }else if(key<node.key){
            return search(node.left,key);
        }else{
            return search(node.right,key);
        }
    }

    // 前序遍历：先自己，再左右
    public void preOrder(){
        preOrder(root);
    }
    // 中序遍历：左，自己，右
    public void inOrder(){
        inOrder(root);
    }
    // 后序遍历：先左右，再自己
    public void postOrder(){
        postOrder(root);
    }

    private void preOrder(Node node){
        if(node!=null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    private void inOrder(Node node){
        if(node!=null){
            preOrder(node.left);
            System.out.println(node.key);
            preOrder(node.right);
        }
    }
    private void postOrder(Node node){
        if(node!=null){
            preOrder(node.left);
            preOrder(node.right);
            System.out.println(node.key);
        }
    }

    // 层序遍历（广度优先遍历）
    public void levelOrder(){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            System.out.println(node.key);
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
        }
    }

    // 寻找最小值
    Node minimum(){
        assert(count!=0);
        return minimum(root);
    }
    Node minimum(Node node){
        if(node.left==null){
            return node;
        }
        return minimum(node.left);
    }
    // 寻找最大值
    Node maxmum(){
        assert(count!=0);
        return maxmum(root);
    }
    Node maxmum(Node node){
        if(node.right==null){
            return node;
        }
        return minimum(node.right);
    }

    // 从二叉树中删除最小值所在节点
    void removeMin(){
        if(root!=null){
            root = removeMin(root);
        }
    }
    Node removeMin(Node node){
        if(node.left==null){
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }
    // 从二叉树中删除最大值所在节点
    void removeMax(){
        if(root!=null){
            root = removeMax(root);
        }
    }
    Node removeMax(Node node){
        if(node.right==null){
            return node.left;
        }
        node.right = removeMax(node.right);
        return node;
    }
}
