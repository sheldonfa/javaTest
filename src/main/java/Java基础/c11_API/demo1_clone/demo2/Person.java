package Java基础.c11_API.demo1_clone.demo2;

/**
 * @author fangxin
 * @date 2017/5/5.
 */
public class Person implements Cloneable{
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

    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.head = head.clone();
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", head=" + head +
                '}';
    }
}
