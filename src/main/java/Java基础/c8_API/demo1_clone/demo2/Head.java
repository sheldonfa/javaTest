package Java基础.c8_API.demo1_clone.demo2;

/**
 * @author fangxin
 * @date 2017/5/5.
 */
public class Head implements Cloneable{

    private Face face;

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    @Override
    protected Head clone() throws CloneNotSupportedException {
        return (Head) super.clone();
    }
}
