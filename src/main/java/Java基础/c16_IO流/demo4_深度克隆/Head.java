package Java基础.c16_IO流.demo4_深度克隆;

import java.io.Serializable;

/**
 * @author fangxin
 * @date 2017/5/5.
 */
public class Head implements Serializable{

    private Face face;

    public Head(Face face) {
        this.face = face;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }
}
