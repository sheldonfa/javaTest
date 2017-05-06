package Java基础.c16_IO流.demo4_深度克隆;

import java.io.Serializable;

/**
 * @author fangxin
 * @date 2017/5/5.
 */
public class Person implements Serializable{
    private int id;
    private String name;
    private Head head;

    public Person(int id, String name,Head head) {
        this.id = id;
        this.name = name;
        this.head = head;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }
}
